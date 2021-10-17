package ood.lsp.products;

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

    public void distribution(Food food) {
            for (Store store : storeList) {
                store.save(food);
            }
    }
}
