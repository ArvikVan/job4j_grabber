package ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает добавление продуктов в магаз
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class Shop implements Store {
    List<Food> shopFoodList = new ArrayList<>();
    int discount = 50;

    @Override
    public void save(Food food) {
        if (condition(food)) {
            shopFoodList.add(food);
        }
    }

    @Override
    public List<Food> getAll() {
        return shopFoodList;
    }

    @Override
    public boolean condition(Food food) {
        boolean result = false;
        if (Percent.percentation(food) >= 25 && Percent.percentation(food) <= 75) {
            System.out.println("Product go to Shop");
            result = true;
        }
        if (Percent.percentation(food) > 75 && Percent.percentation(food) < 100) {
            food.setDiscount(discount);
            System.out.println("Discount price!!!");
            result = true;
        }
        return result;
    }

    @Override
    public void removeList() {
        shopFoodList.clear();
    }
}
