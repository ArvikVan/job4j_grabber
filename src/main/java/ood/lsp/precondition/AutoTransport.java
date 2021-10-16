package ood.lsp.precondition;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * 1. Предусловия (Preconditions) не могут быть усилены в подклассе
 * Предусловие - это условие, которое проверяет корректность аргументов конструктора или метода.
 */
public class AutoTransport {
    protected float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 0) {
            throw new IllegalArgumentException("Need more fuel");
        }
    }
}
