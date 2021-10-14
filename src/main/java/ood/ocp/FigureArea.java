package ood.ocp;

/**
 * нарушение принципа Open Close Principle
 * @author arvikv
 * @version 1.0
 * @since 14.10.2021
 * для того, чтобы вычислить площадь квадрата, нужно будет менять метод, что нарушает
 * принцип OCP
 *
 */
public class FigureArea {
   private static class Area {
       public double area(double radius) {
           return 3.14 * Math.pow(radius, 2);
       }
   }
}
