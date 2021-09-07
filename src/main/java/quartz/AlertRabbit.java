package quartz;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;

/**
 * класс описывает работу планировщика с бд
 * @author arvikv
 * @version 1.2
 * вставляем время из файла, .withIntervalInSeconds(rabbitProperties())
 * 1.2 При создании Job мы указываем параметры data. В них мы передаем ссылку на store.
 * Чтобы получить объекты из context используется следующий вызов.
 * * List<Long> store = (List<Long>) context.getJobDetail().getJobDataMap().get("store");
 */
public class AlertRabbit {
    /**
     * метод описывает работу планировщика с бд
     * @param args на входе данные
     * @throws Exception исключения ловим
     * создаем обект класс пропертис и передаем в него результат выполнения метода свойств
     * соединяемся с бд в теле try-with-resources чтобы закрыть потом автоматом
     * создлаем класс управляющий всеми - scheduler
     * создаем задание и передаем в него результат выполнения execute
     * создаем расписание - times
     * создаем триггер, когда запуск, с какой периодичностью trigger
     * грузим задачу и триггер в планировщик
     * метод работает  10 сек Thread.sleep(10000);
     * закрываем scheduler.shutdown();
     */
    public static void main(String[] args) throws Exception {
        Properties pr = properties();
        try (Connection connection = init(pr)) {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            data.put("connection", connection);
            JobDetail job = newJob(Rabbit.class).usingJobData(data).build();
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(Integer.parseInt(pr.getProperty("rabbit.interval")))
                    .repeatForever();
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            scheduler.scheduleJob(job, trigger);
            Thread.sleep(10000);
            scheduler.shutdown();
        }
    }

    /**
     * метод описывает соединение с бд
     * @param properties на входе свойства
     * @return на выходе имеем соединение с бд по адресу, с логином и паролем
     * @throws Exception исключения ловим
     */
    private static Connection init(Properties properties) throws SQLException {
        try {
            Class.forName(properties.getProperty("driver-class-name"));
        } catch (ClassNotFoundException e) {
            System.out.println("ошибка в методе init"); e.printStackTrace();
        }
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    /**
     * метод описывает поиск и чтение файла с настройками
     * @return на выходе разбитый по парам файл настроек, ключ-значение, свойства
     * @throws IOException исключения ловим
     */
    private static Properties properties() throws IOException {
        Properties config = new Properties();
        try (InputStream in = AlertRabbit.class.getClassLoader().getResourceAsStream("rabbit.properties")) {
            config.load(in);
        }
        return config;
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
        public Rabbit() {
            System.out.println(hashCode());
        }

        /**
         * метод описывает задание которое надо выполнить
         * @param context на входе условия выполнения
         * @throws JobExecutionException ловим исключения
         * соединяемся с бд
         * делаем запрос в бд
         */
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            Connection connection = (Connection) context.getJobDetail().getJobDataMap().get("connection");
            try (PreparedStatement statement =
                         connection.prepareStatement("insert into rabbit(created_date) values (?)")) {
                statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                statement.execute();
            } catch (SQLException throwables) {
                System.out.println("ошибка в методе execute"); throwables.printStackTrace();
            }
        }
    }


}