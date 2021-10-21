package ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуем интерфейс в классе для грузовиков
 * @author arvikv
 * @version 1.1
 * @since 18.10.2021
 * 1.1 Второй список надо удалить, потому что на места для грузовых мы не можем парковать легковые машины.
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
        if (car.getSize() > 1 && truckParkingSize >= 1) {
            truckParkingList.add(car);
            truckParkingSize--;
            result = true;
        }
        return result;
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(truckParkingList);
    }

    @Override
    public int condition(Car car) {
        return truckParkingSize;
    }

}
