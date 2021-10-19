package ood.isp;

/**
 * @author arvikv
 * @version 1.0
 * @since 20.10.2021
 */
public class UdarnikDrill implements Drill {
    @Override
    public void screwdriver() {
        System.out.println("Описываем работу метода, имеется в характеристиках");
    }

    @Override
    public void reverse() {
        System.out.println("Описываем работу метода, имеется в характеристиках");
    }

    @Override
    public void puncher() {
        System.out.println("Нет опции, глушим");
    }

    @Override
    public void illumination() {
        System.out.println("Нет опции, глушим");
    }
}
