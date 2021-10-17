package ood.lsp.products;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * вынесли вычисление дней в процентах в отдельный класс
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class Percent {
    public static double percentation(Food food) {
        double daysCreateNow =  ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        double daysCreateExpiry =  ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return 100 - (daysCreateNow * 100 / daysCreateExpiry);
    }
}
