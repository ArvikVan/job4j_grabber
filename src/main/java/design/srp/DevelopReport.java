package design.srp;

import java.util.function.Predicate;

/**
 * Отчет для программистов
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class DevelopReport implements Report {
    private Store store;

    public DevelopReport(Store store) {
        this.store = store;
    }

    /**
     * готовим отчет для прогеров
     * @param filter нужный фильтр на входе
     * @return на выходе фильтрованый отчет в хтмле
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML>")
                .append("<html><body><table>")
                .append("<tr><td>Name</td>")
                .append("<td>Hired</td>")
                .append("<td>Fired</td>")
                .append("<td>Salary</td></tr>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td></tr>")
                    .append(System.lineSeparator());
        }
        text.append("</table></body></html>");
        return text.toString();
    }
}
