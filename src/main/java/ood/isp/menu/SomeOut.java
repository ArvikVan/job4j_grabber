package ood.isp.menu;

import java.util.List;

/**
 * @author arvikv
 * @version 1.0
 * @since 26.10.2021
 */
public class SomeOut implements Out {
    @Override
    public void show(List<Menu.Item> itemList) {
        for (Menu.Item item : itemList) {
            String result = item.getName();
            System.out.println(result);
        }
    }
}
