package tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author arvikv
 * @version 1.1
 * @since 09.10.2021
 * 1.1 Добавьте еще тесты на исключительные ситуации, когда на пример есть попытка купить билет
 * на одно и то же место, купить на некорректное место или дату и т.п.
 */
public class CinemaTest {

    @Ignore
    @Test(expected = AssertionError.class)
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test(expected = AssertionError.class)
    public void buy2Ticket1Place() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket ticket2 = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
        assertNull(ticket2);
    }

    @Ignore
    @Test(expected = AssertionError.class)
    public void wrongDate() {
        Calendar premiereDay = Calendar.getInstance();
        premiereDay.set(2021, 10, 10, 23, 00);
        Calendar ticketDay = Calendar.getInstance();
        ticketDay.set(2020, 10, 10, 23, 00);
        assertNotEquals(premiereDay, ticketDay);
    }

    @Ignore
    @Test (expected = AssertionError.class)
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test (expected = AssertionError.class)
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

}