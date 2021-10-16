package ood.lsp.invariants;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class ThirdRule {
    public static void main(String[] args) {
        Subscriber subscriber = new SomeOperatorSubscriber(
                new PhoneNumber(+1, 111, 111_111_111)
        );
        subscriber.setPhoneNumber(
                new PhoneNumber(-1, 111, 111_111_111)
        );
    }
}
