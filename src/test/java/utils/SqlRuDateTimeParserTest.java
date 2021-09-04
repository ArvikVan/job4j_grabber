package utils;

import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.junit.Assert.*;

public class SqlRuDateTimeParserTest {

    @Test
    public void data() {
        LocalDateTime localDateTime = new SqlRuDateTimeParser().parse("31 мая 00, 04:01");
        LocalDateTime res = LocalDateTime.of(
                LocalDate.of(2000, 05, 31),
                LocalTime.of(04,01));
        assertEquals(res, localDateTime);
    }

    @Test
    public void yesterday() {
        LocalDateTime yday = new SqlRuDateTimeParser().parse("вчера, 04:01");
        LocalDateTime res = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(04, 01));
        assertEquals(res, yday);
    }

    @Test
    public void today() {
        LocalDateTime today = new SqlRuDateTimeParser().parse("сегодня, 04:01");
        LocalDateTime res = LocalDateTime.of(LocalDate.now(), LocalTime.of(04, 01));
        assertEquals(res, today);
    }

}