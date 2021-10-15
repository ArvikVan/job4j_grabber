package design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

/**
 * Добавить поддержку формата XML в генераторе отчетов.
 * @author arvikv
 * @version 1.0
 * @since 15.10.2021
 */
public class XMLReport implements Report {
    private final Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    /**
     * генерируем отчет в формате хмл
     * @param filter на входе нужный фильтр
     * @return на выходе отХМЛенный отчет
     * фильруем
     * Получаем контекст для доступа к АПИ JAXBContext context = JAXBContext.newInstance(Employees.class);
     * Создаем сериализатор Marshaller marshaller = context.createMarshaller();
     * Указываем, что нам нужно форматирование marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
     * Сериализуем
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees(store.findBy(filter));
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employees, writer);
                xml = writer.getBuffer().toString();
            }
        }  catch (IOException | JAXBException ex) {
            ex.printStackTrace();
        }
        return xml;

    }
}
