package ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает добавление продукта в хранилище
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class Warehouse implements Store {
    private final List<Food> warhouseFoodList = new ArrayList<>();

    /**
     * метод описывает добавление в хранилище при выполнении условия
     * @param food на входе продукт
     */
    @Override
    public void save(Food food) {
        if (condition(food)) {
            System.out.println("Go to Warhouse!!!");
            warhouseFoodList.add(food);
        }
    }

    /**
     * выводим весь список продуктов в хранилище
     * @return на выходе список продуктов
     */
    @Override
    public List<Food> getAll() {
        return warhouseFoodList;
    }

    @Override
    public boolean condition(Food food) {
        return  Percent.percentation(food) < 25;
    }

    @Override
    public void removeList() {
        warhouseFoodList.clear();
    }
}
