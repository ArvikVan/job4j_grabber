package html;
/**
 * класс описывает извлечение текста из html  по атрибутам
 * @author arvikv
 * @version 1.3
 * 1.1 парсим первые 5 страниц
 * 1.2 собираем все элементы парсинга в один класс
 * 1.3 Парсер нужно использовать тот, что передается в конструкторе.
 */

import grabber.Parse;
import grabber.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.DateTimeParser;
import utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    private final List<Post> posts = new ArrayList<>();

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws Exception {
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        SqlRuParse sqlRuParse = new SqlRuParse(dateTimeParser);
        List<Post> lstPost = sqlRuParse.list("https://www.sql.ru/forum/job-offers");
        System.out.println(lstPost);
        System.out.println("Метод detail загружает все детали одного поста (имя, описание, "
                + "дату обновления, дату создания, ссылки на пост).");
        System.out.println(sqlRuParse.detail("https://www.sql.ru/forum/1325330/"
                + "lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-"
                + "moskva-do-200t"));
    }

    /**
     * метод описывает добавление в список всех постов
     * @param link на входе ссылка, откуда нужны все посты
     * @return на выходе список из всех постов в документе
     * @throws IOException учитываем исключения
     * определяем "документ"
     * определяем id
     * бежим по строкам с этим id и берем название под тегом href
     * добавляем в список экземпляра класса модели только текст постов
     */
    @Override
    public List<Post> list(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (Element td : row) {
            Element href = td.child(0);
            Post allPostModel = new Post(
                    href.text()
            );
            posts.add(allPostModel);
        }
        return posts;
    }

    /**
     * метод загружает все детали одного поста
     * @param link на входе ссылка одного поста
     * @return на выходе объект с загруженными данными, согласно конструктора
     * @throws IOException исключения ловим
     */
    @Override
    public Post detail(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Element dateCreation = doc.select(".msgFooter").get(0);
        return new Post(
                doc.select(".messageHeader").get(0).text(),
                link,
                doc.select(".msgBody").get(1).text(),
                dateTimeParser.parse(dateCreation.text().substring(0, 16)));
    }
}
