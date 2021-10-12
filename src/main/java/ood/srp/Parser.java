package ood.srp;

/**
 * Класс нарушает принцип SRP
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class Parser {

    public void postLoad(String url) {

    }

    public double circleArea(int radius) {
        return (3.14 * radius * radius);
    }
}
