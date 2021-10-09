package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author arvikv
 * @version 1.0
 * @since 09.10.2021
 */
public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
