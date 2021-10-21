package ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * класс описывает меню
 * @author arvikv
 * @version 1.0
 * @since 22.10.2021
 */
public class SomeMenu implements IMenu {
    List<Item> itemList = new ArrayList<>();

    /**
     * метод для добавление в лист итема
     * @param item на входе итем который нужно добавить
     */
    @Override
    public void add(Item item) {
        itemList.add(item);
    }

    /**
     * метод выводит меню
     * @return на выходе меню
     * бежим по листу и выводим ид итема
     */
    @Override
    public List<Item> getMenu() {
        for (Item item : itemList) {
            System.out.println(item.itemId() + " Item");
        }
        return itemList;
    }

    public static void main(String[] args) {
        IMenu menu = new SomeMenu();

        Item item1 = new MyItem("1.", "ItemName1");
        Item item11 = new MyItem(" 1.1.", "ItemName1.1");
        Item item111 = new MyItem(" 1.1.1.", "ItemName.1.1.");
        Item item2 = new MyItem("2.", "ItemName2");

        menu.add(item1);
        menu.add(item11);
        menu.add(item111);
        menu.add(item2);
        List<Item> result = menu.getMenu();
        Action.action(result);

    }

}
