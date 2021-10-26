package ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author arvikv
 * @version 1.0
 * @since 26.10.2021
 */
public interface Menu {
    void add(String parentName, Item child);

    class Item {
        private final String name;
        Action action;
        List<Item> itemList = new ArrayList<>();

        public Item(String name, Action action) {
            this.name = name;
            this.action = action;
        }

        public String getName() {
            return name;
        }

        public Action getAction() {
            return action;
        }

        public List<Item> getItemList() {
            return itemList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Item item = (Item) o;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public void addItem(Item child) {
            itemList.add(child);
        }
    }
}
