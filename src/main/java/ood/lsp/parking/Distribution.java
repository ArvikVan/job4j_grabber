package ood.lsp.parking;

import java.util.List;

/**
 * распределяем машины по паркингам
 * @author arvikv
 * @version 1.0
 * @since 18.10.2021
 */
public class Distribution {
    List<Parking> parkingList;
    Parking truck;
    Parking passenger;

    public Distribution(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public boolean distribution(List<Car> carList) {
        boolean result = true;
        for (Car car : carList) {
            int size = car.getSize();
            if (size > 1) {
                if (truck.condition(car) >= 1) {
                    result = truck.addCar(car);
                } else {
                    result = passenger.addCar(car);
                }
            } else if (size == 1) {
                result = passenger.addCar(car);
            }
        }
        return result;
    }
}
