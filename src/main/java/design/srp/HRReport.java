package design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Отдел HR попросил выводить сотрудников в порядке
 * убывания зарплаты и убрать поля даты найма и увольнения.
 * @author arvikv
 * @version 1.1
 * @since 12.10.2021
 * 1.1 Double.compare(y.getSalary(), x.getSalary()));
 * Для корректного сравнения лучше использовать Double.compare()
 */
public class HRReport implements Report {
    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> list = store.findBy(filter);
        list.sort((x, y) -> Double.compare(y.getSalary(), x.getSalary()));
        text.append("Name; Salary;");
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
