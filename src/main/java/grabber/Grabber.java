package grabber;
/**
 * класс описывает работу с планировщиком, чтением и записью данных с сайта
 * @version 1.0
 * @author arvikv
 */

import html.SqlRuParse;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import utils.SqlRuDateTimeParser;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Grabber implements Grab {
    private final Properties cfg = new Properties();

    /**
     * метод описывает соединение чтение файла с настройками
     * @return на выходе настройки
     * @throws SQLException исключения ловим
     */
    public Store store() throws SQLException {
        return new PsqlStore(cfg);
    }

    /**
     * метод описывает планировщика
     * @return на выходе работающий планировщик
     * @throws SchedulerException исключения ловим
     */
    public Scheduler scheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        return scheduler;
    }

    /**
     * метод описывает чтение файла с настройками
     * @throws IOException ловим исключения, которые могут появиться
     */
    public void cfg() throws IOException {
        try (InputStream in = Grabber.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
    }

    /**
     * инициализаци задания
     * @param parse задание парсера сайта
     * @param store задание добавления в бд
     * @param scheduler расписание
     * @throws SchedulerException исключения ловим
     */
    @Override
    public void init(Parse parse, Store store, Scheduler scheduler) throws SchedulerException {
        JobDataMap data = new JobDataMap();
        data.put("store", store);
        data.put("parse", parse);
        JobDetail job = newJob(GrabJob.class)
                .usingJobData(data)
                .build();
        SimpleScheduleBuilder times = simpleSchedule()
                .withIntervalInSeconds(Integer.parseInt(cfg.getProperty("time")))
                .repeatForever();
        Trigger trigger = newTrigger()
                .startNow()
                .withSchedule(times)
                .build();
        scheduler.scheduleJob(job, trigger);
    }
    public static class GrabJob implements Job {
        /**
         * метод описывает выполнение самого задания
         * @param context на входе контекст
         * @throws JobExecutionException исключения ловим
         */
        @Override
        public void execute(JobExecutionContext context) {
            JobDataMap map = context.getJobDetail().getJobDataMap();
            Store store = (Store) map.get("store");
            Parse parse = (Parse) map.get("parse");
            List<Post> lstPost = null;
            try {
                lstPost = parse.list("https://www.sql.ru/forum/job-offers");
            } catch (IOException e) {
                System.out.println("AAAAAAAAAAAAAAA"); e.printStackTrace();
            }
            if (lstPost != null) {
                for (int i = 0; i < lstPost.size(); i++) {
                    store.save(lstPost.get(i));
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Grabber grab = new Grabber();
        grab.cfg();
        Scheduler scheduler = grab.scheduler();
        Store store = grab.store();
        grab.init(new SqlRuParse(new SqlRuDateTimeParser()), store, scheduler);
    }
}
