package grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * класс описывает загрузку деталей объявлений
 *
 * @author arvikv
 * @version 1.0
 */

public class PostSqlRuParse {

    /**
     * метод описывает считывание данных и даты создания объявления
     *
     * @param url на входе ссылка на страницу которую необходимо спарсить
     * @throws IOException ловим исключения
     * получаем документ
     * получаем элемент с id msgBody, их два, наш второй с индексом 1
     * получаем элемент с id msgFooter c индексом 0, он один
     * т.к. в теге не только время то берем первые 16 знаков, с датой и временем
     */

    public void postLoad(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element description = doc.select(".msgBody").get(1);
        System.out.println(description.text());
        Element dateCreation = doc.select(".msgFooter").get(0);
        System.out.println(dateCreation.text().substring(0, 16));

    }

    public static void main(String[] args) throws IOException {
        PostSqlRuParse postSqlRuParse = new PostSqlRuParse();
        postSqlRuParse.postLoad("https://www.sql.ru/forum/1325330/"
                + "lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-"
                + "moskva-do-200t");
    }
}
