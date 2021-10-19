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
        Parking parking = new TruckParking(3);
        Car car = new Car("Volvo", 2);
        carList.add(car);
        Assert.assertTrue(parking.addCar(car));
        Assert.assertEquals(carList, parking.getAll());
    }

    @Test
    public void fillPassParking() {
        List<Car> carList = new ArrayList<>();
        Parking parking = new PassCarParking(2);
        Car car1 = new Car("dodge", 1);
        Car car2 = new Car("toyota", 1);
        carList.add(car1);
        carList.add(car2);
        Assert.assertTrue(parking.addCar(car1));
        Assert.assertTrue(parking.addCar(car2));
        Assert.assertEquals(carList, parking.getAll());


    }

    @Test
    public void fillTruckParking() {
        List<Car> carList = new ArrayList<>();
        Parking parking = new TruckParking(6);
        Car car = new Car("Volvo", 2);
        Car car2 = new Car("Volvo", 2);
        Car car3 = new Car("Volvo", 2);
        carList.add(car);
        carList.add(car2);
        carList.add(car3);
        Assert.assertTrue(parking.addCar(car));
        Assert.assertTrue(parking.addCar(car2));
        Assert.assertTrue(parking.addCar(car3));
        Assert.assertEquals(carList, parking.getAll());
    }
}