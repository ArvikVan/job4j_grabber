package design.srp;

import java.util.function.Predicate;

/**
 * Новый отчет для бухгалтерии
 * Отдел бухгалтерии попросил изменить вид зарплаты.
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class BuhReport implements Report {
    private Store store;

    public BuhReport(Store store) {
        this.store = store;
    }

    /**
     * метод описывает получение отчета для бухгалтерии
     * @param filter на входе используется фильтр
     * @return на выходе фильтрованный отчет
     * Отдел бухгалтерии попросил изменить вид зарплаты.
     * .append(employee.getSalary() / 71).append(";") поменяли
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryInDollar;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 71).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
