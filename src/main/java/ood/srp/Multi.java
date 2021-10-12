package ood.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс нарушает принцип SRP
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class Multi {
    List<String> strings = new ArrayList<>();

    public void out() {
        System.out.println(strings);
    }

    public void add(String s) {
        strings.add(s);
    }

    public void delete(int index) {
        strings.remove(index);
    }

    public void order() {
        strings.sort(Comparator.naturalOrder());
    }
}
