package grabber;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/**
 * В этом проекты мы будем использовать quartz для запуска парсера. Но напрямую мы не будем его использовать.
 * Абстрагируемся через интерфейс.
 * @author arvikv
 * @version 1.0
 */
public interface Grab {
    void init(Parse parse, Store store, Scheduler scheduler) throws SchedulerException;
}
