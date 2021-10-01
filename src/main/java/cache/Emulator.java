package cache;

/**
 * класс описывает реализацию кэша
 * @author arvikv
 * @version 1.0
 * @since 01.10.2021
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */
public class Emulator {

    private final DirFileCache dir;

    public Emulator(String dirFileCache) {
        dir = new DirFileCache(dirFileCache);
    }

    /**
     * звгружаем данные из файла
     * @param key по ключу
     */
    public void load(String key) {
        dir.load(key);
    }

    /**
     * добавляем в кэш
     * @param key по ключу
     * @return на выходе данные в кэше
     */
    public String getCacheData(String key) {
        return dir.get(key);
    }

    /**
     * демонстрация
     * @param args точка входа, данные
     *             указываем директорию
     *             добавляем в кэш
     *             читаем из кэша
     */
    public static void main(String[] args) {
        Emulator emulator = new Emulator("src/main/java/cache/");
        emulator.load("Names.txt");
        String data = emulator.getCacheData("Names.txt");
        System.out.println(data);
    }
}
