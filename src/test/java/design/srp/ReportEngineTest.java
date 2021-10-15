package design.srp;

import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author arvikv
 * @version 1.0
 * @since 12.10.2021
 */
public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenBuhGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new BuhReport(store);
        String expect = "Name; Hired; Fired; SalaryInDollar;"
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() / 71 + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Semen", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDeveloperGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new DevelopReport(store);
        String expect = "<!DOCTYPE HTML>"
                + "<html><body><table>"
                + "<tr><td>Name</td>"
                + "<td>Hired</td>"
                + "<td>Fired</td>"
                + "<td>Salary</td></tr>"
                + "<tr><td>" + worker.getName() + "</td>"
                + "<td>" + worker.getHired() + "</td>"
                + "<td>" + worker.getFired() + "</td>"
                + "<td>" + worker.getSalary() + "</td></tr>"
                + System.lineSeparator()
                + "</table></body></html>";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void WhenJSONReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Semen", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new JSONReport(store);
        StringBuilder expect = new StringBuilder();
        var gson = new GsonBuilder().create();
        expect.append("[")
                .append(gson.toJson(worker))
                .append(",")
                .append(gson.toJson(worker2))
                .append("]");


        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void WhenXMLReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Semen", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new XMLReport(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "\n" +
                "<employees>\n" +
                "    <employee>\n" +
                "        <fired>" + dateFormat.format(worker.getHired().getTime()) + "</fired>\n" +
                "        <hired>" + dateFormat.format(worker.getHired().getTime()) + "</hired>\n" +
                "        <name>Ivan</name>\n" +
                "        <salary>100.0</salary>\n" +
                "    </employee>\n" +
                "    <employee>\n" +
                "        <fired>" + dateFormat.format(worker.getHired().getTime()) + "</fired>\n" +
                "        <hired>" + dateFormat.format(worker.getHired().getTime()) + "</hired>\n" +
                "        <name>Semen</name>\n" +
                "        <salary>200.0</salary>\n" +
                "    </employee>\n" +
                "</employees>\n";
        assertThat(engine.generate(em -> true), is(expect));
    }

}