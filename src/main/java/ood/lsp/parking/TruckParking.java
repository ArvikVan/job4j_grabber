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
    private int truckParkingSize;
    List<Car> truckParkingList = new ArrayList<>();

    public TruckParking(int truckParkingSize) {
        this.truckParkingSize = truckParkingSize;
    }

    @Override
    public boolean addCar(Car car) {
        boolean result = false;
        if (condition(car)) {
            truckParkingList.add(car);
            result = true;
        }
        return result;
    }

    @Override
    public List<Car> getAll() {
        return truckParkingList;
    }

    @Override
    public boolean condition(Car car) {
        return true;
    }
}
