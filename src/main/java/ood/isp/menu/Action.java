package ood.isp.menu;

import java.util.List;
import java.util.Scanner;
/**
 * класс описывает действие с выбранным итемом
 * @author arvikv
 * @version 1.0
 * @since 22.10.2021
 */
public class Action {
    static void action(List<Item> itemList) {
        System.out.println("Choose your destiny: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String input = in.nextLine();
            for (Item item : itemList) {
                if (item.itemId().equals(input)) {
                    System.out.println("some action with " + item.name());
                }
            }
        }
    }
}