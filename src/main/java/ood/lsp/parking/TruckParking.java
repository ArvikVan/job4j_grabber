package ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуем интерфейс в классе для грузовиков
 * @author arvikv
 * @version 1.0
 * @since 18.10.2021
 */
public class TruckParking implements Parking {
    List<Car> truckParkingList = new ArrayList<>();

    @Override
    public void add(Car car) {

    }

    @Override
    public List<Car> getAll() {
        return truckParkingList;
    }

    @Override
    public boolean condition(Car car) {
        return false;
    }
}
