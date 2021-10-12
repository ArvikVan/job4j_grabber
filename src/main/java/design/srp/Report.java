package design.srp;

import java.util.function.Predicate;

/**
 * В компании есть три департамента: бухгалтерия, программисты, HR.
 * Всем департаментам нужны отчеты. Программисты реализовали систему отчетов.
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public interface Report {
    String generate(Predicate<Employee> filter);
}
