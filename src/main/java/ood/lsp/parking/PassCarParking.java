package ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arvikv
 * @version 1.1
 * @since 18.10.2021
 * 1.1 При парковке грузового на места для легковых,
 * количество свободных мест на парковке должно уменьшаться на size.
 * */
public class PassCarParking implements Parking {
    private int passCarParkingSize;
    List<Car> passCarParkingList = new ArrayList<>();

    public PassCarParking(int passCarParkingSize) {
        this.passCarParkingSize = passCarParkingSize;
    }

    @Override
    public boolean addCar(Car car) {
        boolean result = false;
        int size = car.getSize();
        if (size == 1 && passCarParkingSize >= size) {
            passCarParkingList.add(car);
            passCarParkingSize = passCarParkingSize - size;
            result = true;
        }
        if (size > 1 && passCarParkingSize >= size) {
            passCarParkingList.add(car);
            passCarParkingSize = passCarParkingSize - size;
            result = true;
        }
        return result;

    }

    @Override
    public List<Car> getAll() {
        return passCarParkingList;
    }

    @Override
    public int condition(Car car) {
        return passCarParkingSize;
    }
}
