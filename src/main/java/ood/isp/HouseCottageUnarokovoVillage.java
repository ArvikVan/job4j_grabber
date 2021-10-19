package ood.isp;

/**
 * @author arvikv
 * @version 1.0
 * @since 20.10.2021
 */
public class HouseCottageUnarokovoVillage implements House {
    @Override
    public void centralGas() {
        System.out.println("Газа нет, стоит заглушка");
    }

    @Override
    public void centralElectricity() {
        System.out.println("Электричество в наличие, описываем работу");
    }

    @Override
    public void centralWater() {
        System.out.println("Центральной воды нет, глушим");
    }

    @Override
    public void centralTrashRemoval() {
        System.out.println("Вывоз мусора есть, описываем работу");
    }

    @Override
    public void internet() {
        System.out.println("Центрального интернета нет, глушим");
    }

    @Override
    public void outbuildings() {
        System.out.println("Хозпостройки имеются, описываем метод");
    }
}
