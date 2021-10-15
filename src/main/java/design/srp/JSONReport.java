package design.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

/**
 * Добавить поддержку формата JSON в генераторе отчетов
 * @author arvikv
 * @version 1.0
 * @since 15.10.2021
 */
public class JSONReport implements Report {
    private final Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    /**
     * генерируем отчет в джсан
     * @param filter на входе фильтр
     * @return на выходе отДЖСАНеный отчет
     * преобразуем фильтрованый объект из бд в джсон
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        var gson = new GsonBuilder().create();
        return gson.toJson(store.findBy(filter));
    }
}
