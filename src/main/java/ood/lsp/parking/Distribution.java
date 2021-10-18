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

    public Distribution(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public void distribution(Car car) {
        for (Parking parking : parkingList) {
            parking.addCar(car);
        }
    }
}
