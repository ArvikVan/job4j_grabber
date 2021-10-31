package ood.lsp.products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class Trash implements Store {
    List<Food> trashFoodList = new ArrayList<>();

    @Override
    public void save(Food food) {
        if (condition(food)) {
            System.out.println("Product go to Trash!!!");
            trashFoodList.add(food);
        }
    }

    @Override
    public List<Food> getAll() {
        return trashFoodList;
    }

    @Override
    public boolean condition(Food food) {
        return LocalDate.now().isAfter(food.getExpiryDate());
    }

    @Override
    public void removeList() {
        trashFoodList.clear();
    }
}
