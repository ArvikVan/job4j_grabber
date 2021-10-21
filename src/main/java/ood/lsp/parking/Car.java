package ood.lsp.parking;

import java.util.Objects;

/**
 * Модель данных машин
 * @author arvikv
 * @version 1.1
 * @since 18.10.2021
 * 1.1 Car надо сделать абстрактным, раз от него идет наследование.
 */
public abstract class Car {
    protected String name;
    protected int size;

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return size == car.size && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
