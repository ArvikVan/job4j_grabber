package cache;
/**
 * класс описывает структуру данных типа кэш
 * @author arvikv
 * @version 1.1
 * 1.1 Если get() вернет null, то Вы получите NPE. Эту ситуацию надо учесть.
 *  * В этом случае надо повторно грузить данные. (mentor)
 *  default V getOrDefault(Object key, V defaultValue)
 */

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * метод описывает добавление в кэш
     * @param key ключ
     * @param value данные которые кладем в кэш
     */
    public void put(K key, V value) {
        cache.put(key, new SoftReference<V>(value));
    }

    /**
     * метод описывает добавление в кэш  с валидацией
     * @param key ключ
     * @return на выходе объект в кэше
     * получаем объект в кэше, используя метод getOrDefault(), где значение по умолчанию ставим null
     * т.к. при использовании метода get() и при входящем null получим NPE
     * проверяем, если есть ли он в памяти, если нет то загружаем его
     * и кладем в кэш, доки
     */
    public V get(K key) {
        V v = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (v == null) {
            v = load(key);
            put(key, v);
        }
        return v;
    }

    /**
     * метод загрузки данных
     * @param key ключ данных
     * @return данные
     */
    protected abstract V load(K key);
}
