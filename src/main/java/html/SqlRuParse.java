package html;
/**
 * класс описывает извлечение текста из html  по атрибутам
 * @author arvikv
 * @version 1.0
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get(); //получаем document
        Elements row = doc.select(".postslisttopic"); // выбираем в document элементы с необходимым id
        for (Element td : row) { // бежим по этим элементам
            Element href = td.child(0); // и спускаемся вниз по дереву (child) и берем 0 элемент (в нашем случае их два)
            System.out.println(href.attr("href")); //ссылка
            System.out.println(href.text()); // текст ссылки
            Element date = td.parent().child(5); // поднимаемся вверх по дереву и берем пятый элемент
            // (он отвечает за время) т.к. altCol повторяется
            System.out.println(date.text()); //получаем текст
        }
    }
}
