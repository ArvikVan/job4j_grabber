package ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 18.10.2021
 */
public class PassCarParking implements Parking {
    List<Car> passCarParkingList = new ArrayList<>();

    @Override
    public void add(Car car) {

    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public boolean condition(Car car) {
        return false;
    }
}
