package ood.isp;

import com.google.gson.internal.bind.util.ISO8601Utils;

/**
 * @author arvikv
 * @version 1.0
 * @since 20.10.2021
 */
public class Buhanka implements Car {
    @Override
    public boolean abs() {
        return false;
    }

    @Override
    public void engine() {
        System.out.println("Двигатель имеется, описание");
    }

    @Override
    public void transmission() {
        System.out.println("Трансмиссия, одно ведро");
    }

    @Override
    public void autoSound() {
        System.out.println("На звуке заглушка");
    }

    @Override
    public void ruleHeater() {
        System.out.println("Подогрева руля нет, поэтому глушим этот метод");
    }

    @Override
    public void condition() {
        System.out.println("Кондиционера нет, поэтому глушим метод");
    }
}
