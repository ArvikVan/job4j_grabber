package design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Хранилище
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class MemStore implements  Store {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }
    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
