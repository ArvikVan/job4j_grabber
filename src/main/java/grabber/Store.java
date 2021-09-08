package grabber;
/**
 * Наш проект будет хранить данные в базе Postgresql. Связь с базой будет осуществляться через интерфейс.
 * @authior arvikv
 * @version 1.0
 */

import java.util.List;

public interface Store {
    void save(Post post);

    List<Post> getAll();

    Post findById(int id);
}
