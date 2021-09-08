package grabber;
/**
 * Операция извлечения данных с  сайта описывается отдельным интерфейсом.
 * list(link) - этот метод загружает список объявлений по ссылке типа -
 * https://www.sql.ru/forum/job-offers/1
 * detail(link) - этот метод загружает детали объявления по ссылке типа -
 * https://www.sql.ru/forum/1323839/razrabotchik-java-g-kazan
 * @author arvikv
 * @version 1.0
 */

import java.io.IOException;
import java.util.List;

public interface Parse {

    List<Post> list(String link) throws IOException;

    Post detail(String link) throws IOException;
}
