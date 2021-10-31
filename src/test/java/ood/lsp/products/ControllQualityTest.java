package ood.lsp.products;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class ControllQualityTest {
    LocalDate currentDate = LocalDate.now();
    ControllQuality controllQuality;
    Warehouse warehouse;
    Shop shop;
    Trash trash;

    @Before
    public void initObjects() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        List<Store> storesList = List.of(warehouse, shop, trash);
        controllQuality = new ControllQuality(storesList);
        currentDate = LocalDate.now();
    }

    @Test
    public void whenWarehouse() {
        LocalDate createDate = currentDate.minusDays(10);
        LocalDate expiryDate = createDate.plusDays(50);
        Food food = new Food("Milk", expiryDate, createDate, 100, 20);
        controllQuality.distribution(food);
        List<Food> exp = List.of(food);
        System.out.println(Percent.percentation(food));
        assertThat(warehouse.getAll(), is(exp));
    }

    @Test
    public void whenShop() {
        LocalDate createDate = currentDate.minusDays(1);
        LocalDate expiryDate = currentDate.plusDays(3);
        Food food = new Food("Milk", createDate, expiryDate, 100, 20);
        controllQuality.distribution(food);
        List<Food> exp = List.of(food);
        System.out.println(Percent.percentation(food));

        assertThat(shop.getAll(), is(exp));
    }

    @Test
    public void whenShopDiscount() {
        LocalDate createDate = currentDate.minusDays(1);
        LocalDate expiryDate = currentDate.plusDays(4);
        Food food = new Food("Milk", createDate, expiryDate, 100, 20);
        controllQuality.distribution(food);
        List<Food> exp = List.of(food);
        System.out.println(Percent.percentation(food));

        assertThat(shop.getAll(), is(exp));
    }

    @Test
    public void whenResort() {
        LocalDate createDateShop = currentDate.minusDays(1);
        LocalDate expiryDateShop = currentDate.plusDays(4);
        Food shop = new Food("Milk", createDateShop, expiryDateShop, 100, 20);
        Food shop2 = new Food("Kilk", createDateShop, expiryDateShop, 100, 20);
        List<Food> foodList = List.of(shop, shop2);
        controllQuality.resort();
        List<Food> expect = List.of(
                new Food("Milk", createDateShop, expiryDateShop, 100, 20),
                new Food("Kilk", createDateShop, expiryDateShop, 100, 20)
        );
        assertEquals(foodList, expect);
    }

    @Test
    public void whenTrash() {
        LocalDate createDate = currentDate.minusDays(10);
        LocalDate expiryDate = currentDate.minusDays(1);
        Food food = new Food("Milk", createDate, expiryDate, 100, 20);
        controllQuality.distribution(food);
        List<Food> exp = List.of(food);
        System.out.println(Percent.percentation(food));
        assertThat(trash.getAll(), is(exp));
    }

}