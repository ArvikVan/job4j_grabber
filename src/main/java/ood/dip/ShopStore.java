package ood.dip;

import java.util.Set;

/**
 * @author arvikv
 * @version 1.0
 * @since 27.10.2021
 */
public interface ShopStore {
    boolean saveUser(User user);
    boolean saveOrder(User user, Order order);
    Set<Order> getOrders(User user);
    Set<User> getUsers();
}
