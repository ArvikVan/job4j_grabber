package ood.isp.menu;

import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 22.10.2021
 */
public interface IMenu {
    void add(Item item);
    List<Item> getMenu();
}
