package ood.lsp.products;

import java.util.List;

/**
 * Интерфейс описывающий хранилище
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 * добавлен метод очистки листа
 *
 */
public interface Store {
    void save(Food food);
    List<Food> getAll();
    boolean condition(Food food);
    void removeList();
}
