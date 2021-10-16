package ood.lsp.postcondition;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 * Постусловие - это условие, налагаемое на возвращаемое значение метода.
 */
public class WorkDays implements Iterable<Integer> {
    private Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}
