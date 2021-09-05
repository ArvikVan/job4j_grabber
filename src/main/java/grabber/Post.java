package grabber;
/**
 * класс описывает модель данных
 * @author arvikv
 * @version 1.0
 *  - id типа int - идентификатор вакансии (берется из нашей базы данных);
 *  - title типа String - название вакансии;
 *  - link типа String - ссылка на описание вакансии;
 *  - description типа String - описание вакансии;
 *  - created типа LocalDateTime - дата создания вакансии.
 */

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String link;
    private String description;
    LocalDateTime created;

    public Post(int id, String title, String link, String description, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id && Objects.equals(title, post.title)
                && Objects.equals(link, post.link)
                && Objects.equals(description, post.description)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link, description, created);
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
