package gc.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Класс описывает сильную(обычную) ссылку
 * @author arvikv
 * @version 1.0
 * Edite configuration -Xmx4m -Xms4m
 */
public class StrongDemo {
    public static void main(String[] args) throws InterruptedException {
            example3();
    }

    /**
     * метод описывает создание объектов с последующим занулением
     * @throws InterruptedException ловим исключения
     * создаем массив с размером
     * бежим в цикле по нему и создаем на каждой итерации объект записываея в массив
     * выполняем метод финализ
     * после же обнуляем ссылки
     * зовем сборщик мусора
     */
    private static void example1() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("---Object removed---");
                }
            };
        }
        for (int j = 0; j < 100; j++) {
            objects[j] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * метод описывает созданиеобъектов вместе с вложенными
     * @throws InterruptedException ловим исключения
     * создаем массив размером 100
     * бежим по нему создавая объекты
     * внутри которых внутренние объекты innerObject
     * где выполняем метод финализ
     * записываем в массив
     * далее зануляем сслыки на объекты
     * вызываем сборщик
     * ждем
     */
    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() {
                Object innerObject = new Object() {
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println("---Remove inner object---");
                    }
                };
            };
            objects[i] = object;
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * метод описывает переполнение памяти созданием бесконечного цикла
     */
    private static void example3() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add(String.valueOf(System.currentTimeMillis()));
        }
    }
}
