package ood.lsp.parking;

/**
 * @author arvikv
 * @version 1.1
 * @since 18.10.2021
 * 1.1 Второй аргумент конструктора уберите. Размер легкового авто всегда равен 1.
 */
public class PassengerCar extends Car {
    private final int size = 1;
    public PassengerCar(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        return size;
    }
}
