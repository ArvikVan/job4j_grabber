package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.*;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;

/**
 * класс описывает вывод в консоль сообщение раз в 10 секунд
 * @author arvikv
 * @version 1.1
 * вставляем время из файла, .withIntervalInSeconds(rabbitProperties())
 */
public class AlertRabbit {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = newJob(Rabbit.class).build();
            SimpleScheduleBuilder times = simpleSchedule().withIntervalInSeconds(rabbitProperties())
                    .repeatForever();
            Trigger trigger = newTrigger().startNow().withSchedule(times).build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    /**
     * метод достает цифирь из файла
     * @return на выходе значение
     * создаем переменную в которой будет храниться значение
     * читаем файл
     * загружаем свойства из объекта ридера
     * присваиваем переменной значение ключа rabbit.interval, в нашем случае 10
     * можно укоротить метод убрав конструкцию tryWithResourses и указав путь к файлу в теле метода load()
     * load(new FileReader("src/main/resources/rabbit.properties"))
     */
    private static int rabbitProperties() {
        int time = 0;
        try (BufferedReader in = new BufferedReader(
                new FileReader("src/main/resources/rabbit.properties"))) {
            Properties properties = new Properties();
            properties.load(in);
            time = Integer.parseInt(properties.getProperty("rabbit.interval"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
        }
    }
}