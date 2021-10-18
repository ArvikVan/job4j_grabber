package ood.lsp.parking;

import java.util.List;

/**
 * Интерфейс по котормым наделаем паркингов для машин различных рамеров
 * @author arvikv
 * @version 1.0
 * @since 18.10.2021
 */
public interface Parking {
    void add(Car car);
    List<Car> getAll();
    boolean condition(Car car);
}
