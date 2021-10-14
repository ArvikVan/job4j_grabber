package ood.ocp;

/**
 * нарушаем принцип OCP
 * @author arvikv
 * @version 1.0
 * @since 14.10.2021
 * во избежание принципа необходимо вынести метод в интерфейс
 * и для каждого животного имплеменитировать его
 */
public class AnimalSound {
    public static class Cat {
        public void sound() {
            System.out.println("Cats sound");
        }
    }
}
