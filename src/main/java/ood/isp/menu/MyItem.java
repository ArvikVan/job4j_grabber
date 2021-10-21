package ood.isp.menu;

/**
 * класс реализует интерфес итем
 * @author arvikv
 * @version 1.0
 * @since 22.10.2021
 */
public class MyItem implements Item {
    private final String id;
    private final String name;

    public MyItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String itemId() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
