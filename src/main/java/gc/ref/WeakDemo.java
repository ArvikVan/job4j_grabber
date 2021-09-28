package gc.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * класс описывает работу с Weak ссылками
 * @author arvikv
 * @version 1.0
 */
public class WeakDemo {
    public static void main(String[] args) throws InterruptedException {
        example3();
    }

    /**
     * метод показывает работу слабой ссылки
     * @throws InterruptedException ловим исключения
     * создаем экз. класса
     * выполняем финализ
     * создаем слабую сслыку на экз.класса
     * обнуляем стронг ссыль, собираем мусор
     * ждем и пытаемся вывести слабую ссыль на консоль, получаем нулл
     */
    private static void example1() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed");
            }
        };
        WeakReference<Object> weak = new WeakReference<>(object);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(weak.get());
    }

    /**
     * метод описывает удаление всех ссылок
     * @throws InterruptedException ловим исключения
     * создаем лист слабых ссылок на экз.
     * бежим по листу и добавляем туда слабую ссыль
     * выполняем финализ
     * собираем мусор, ждем
     * всем слабые ссылки удалятся
     */
    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new WeakReference<Object>(new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Removed!");
                }
            }));
        }
        System.gc();
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * метод описывает ReferenceQueue
     * @throws InterruptedException ловим исключения
     * создаем экз.класса
     * выполянем финализ
     * создаем ReferenceQueue
     * созадем слыбую ссыль, обнуляем ссылку
     * вызываем сборщик, ожидаем
     * выводим в консоль слабую и очередь ссылки
     * слабая удалится, очередь покажет
     */
    private static void example3() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed");
            }
        };
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weak = new WeakReference<>(object, queue);
        object = null;

        System.gc();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("from link " + weak.get());
        System.out.println("from queue " + queue.poll());
    }
}
