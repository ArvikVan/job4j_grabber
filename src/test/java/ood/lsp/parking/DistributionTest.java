package ood.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 18.10.2021
 */
public class DistributionTest {
    @Test
    public void parkingTruck() {
        List<Car> carList = new ArrayList<>();
        Parking parking = new TruckParking(5);
        Car car = new Car("Volvo", 2);
        carList.add(car);
        Assert.assertTrue(parking.addCar(car));
        Assert.assertEquals(carList, parking.getAll());
    }

    @Test
    public void fillPassParking() {
        Parking parking = new PassCarParking(1);
        Car car1 = new Car("dodge", 1);
        Car car2 = new Car("toyota", 1);
        parking.addCar(car1);
        parking.addCar(car2);
    }

    @Test
    public void fillTruckParking() {
        Parking parking = new TruckParking(1);
        Car car = new Car("Volvo", 2);
        Car car2 = new Car("Volvo", 2);
        parking.addCar(car);
        parking.addCar(car2);
    }
}