package cache;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * класс описывает реализацию абстрактного класса
 * @author arvikv
 * @version 1.0
 */
public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     * метод описывает загрузку данных из файла
     * @param key ключ данных
     * @return на выходе содержимое файла
     */
    @Override
    protected String load(String key) {
        String result = "";
        try {
            result = Files.readString(Path.of(cachingDir + key));
            put(key, result);
        } catch (IOException e) {
            System.out.println("class DirFileCache, protected String load()"); e.printStackTrace();
        }
        return result;
    }
}
