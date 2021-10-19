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
    List<Car> passCarParkingList = new ArrayList<>();

    public TruckParking(int truckParkingSize) {
        this.truckParkingSize = truckParkingSize;
    }

    @Override
    public boolean addCar(Car car) {
        boolean result = false;
        if (car.getSize() > 1 && truckParkingSize >= 1) {
            passCarParkingList.add(car);
            truckParkingSize--;
            result = true;
        }
        return result;
    }

    @Override
    public List<Car> getAll() {
        List<Car> list = new ArrayList<>();
        list.addAll(passCarParkingList);
        list.addAll(truckParkingList);
        return list;
    }

    @Override
    public int condition(Car car) {
        return truckParkingSize;
    }

}
