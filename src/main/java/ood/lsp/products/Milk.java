package ood.lsp.products;

import java.time.LocalDate;

/**
 * @author arvikv
 * @version 1.0
 * @since 17.10.2021
 */
public class Milk extends Food {
    public Milk(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }


}
