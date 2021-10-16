package ood.lsp.postcondition;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class ShopCountingRoom extends CountingRoom {
    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }

    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        return factHours * payPerHour;
    }
}
