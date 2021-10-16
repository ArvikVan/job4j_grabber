package ood.lsp.precondition;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(5);
        bus.move(2);
    }
}
