package kiss;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author arvikv
 * @version 1.0
 * @since 08.10.2021
 */
public class MaxMin {
    /**
     * метод показывает максимум
     * @param value список в котором изем макс
     * @param comparator компаратор
     * @param <T> тип
     * @return на выходе нашли максимум
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
       return find(value, comparator);
    }

    /**
     * метод показывает максимум наоборот, минимум
     * @param value список где нужен минимум
     * @param comparator компаратор
     * @param <T> тип
     * @return на выходе обратное максимуму
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }

    /**
     * метод описывает пробежку по списку и нахождением максимального значения
     * @param value список на входе
     * @param comparator компаратор на входе
     * @param <T> тип
     * @return на выходе результат
     */
    public <T> T find(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, result) > 0) {
                result = t;
            }
        }
        return result;
    }
}
