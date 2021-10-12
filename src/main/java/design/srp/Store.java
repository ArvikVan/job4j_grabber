package design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Доступ к бд
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
