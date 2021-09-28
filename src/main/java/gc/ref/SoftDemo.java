package gc.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * класс описывает Soft Reference
 * @author arvikv
 * @version 1.0
 */
public class SoftDemo {
    public static void main(String[] args) {
        example2();
    }

    /**
     * метод описывает софт ссылку
     * создаем стронг ссыль объект
     * создаем софт ссылку на этот объект
     * зануляем стронг ссыль
     * в консоль объект, будет выводится пока память не заполнится
     */
    public static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    /**
     * метод показывает удаление софт ссылок
     * создаем лист софт ссылок (легче создать ссылку на лист)
     * бежим по листу и добавляемсофтссыль на новый объект
     * выполняем финализ
     * вызываем сборщик
     * хотим посмотреть сколько живых ссылок осталось, счетчик, цикл, валидация на нулл
     */
    public static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("---Object removed---");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }
}
