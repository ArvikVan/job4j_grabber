package ood.ocp;

/**
 * Нарушение принципа OCP
 * @author arvikv
 * @version 1.0
 * @since 14.10.2021
 * Во избежание нарушения, необходимо вынести в интерфес операцию
 * и имплементировать метод для каждой операции
 */
public class Calc {

    private double a;
    private double b;
    public double result;

    public class Adition {
        public void operation() {
            result = a + b;
        }
    }
}
