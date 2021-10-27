package ood.dip.wrongdip;

import ood.dip.Check;
import ood.dip.Order;
import ood.dip.User;

import java.util.Optional;

/**
 * @author arvikv
 * @version 1.0
 * @since 27.10.2021
 *  Подобная запись также является нарушением DIP, потому что есть прямая зависимость самого логгирования
 *  от реализации, в данном случае оно напрямую зависит от консольного вывода.
 *  Решение опять использование абстракции для логирования
 * private static final Logger LOGGER = Logger.getLogger("Shop logger");
 */
public class OrderForStore {
    public void payOrder(User user, Order order) {
        if (user.getName().isEmpty()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
    }
}
