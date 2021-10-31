package ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 * Распределение по классам хранилищ, условия там же
 */
public class ControllQuality {
    List<Store> storeList;

    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    /**
     * метод отвечает за распределение продуктов
     * @param food на входе продукт
     */
    public void distribution(Food food) {
            for (Store store : storeList) {
                store.save(food);
            }
    }

    /**
     * метод отвечает за извлечение и перераспределение продуктов из
     * storeList в listForResort
     */
    public void resort() {
        List<Food> listForResort = new ArrayList<>();
        for (Store store : storeList) {
            listForResort.addAll(store.getAll());
            store.removeList();
        }

        for (Food food : listForResort) {
            distribution(food);
        }

    }
}
