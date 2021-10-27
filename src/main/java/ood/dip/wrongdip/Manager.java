package ood.dip.wrongdip;

import ood.dip.ShopStore;

import java.util.ArrayList;
import java.util.List;

/**
 * нарушаем принцип DIP засовывая все в кучу, для решения подобного нужно вынести
 * в интрефейс работника и каждым типом его реализовать
 *
 * @author arvikv
 * @version 1.0
 * @since 27.10.2021
 */
public class Manager {
    List<String> employersList = new ArrayList<>();

    void addDeveloper(String name) {
        employersList.add(name);
    }

    void addDesigner(String name) {
        employersList.add(name);
    }

    void addToster(String name) {
        employersList.add(name);
    }
}
