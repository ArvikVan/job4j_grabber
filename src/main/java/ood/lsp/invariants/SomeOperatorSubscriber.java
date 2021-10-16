package ood.lsp.invariants;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class SomeOperatorSubscriber extends Subscriber {
    public SomeOperatorSubscriber(PhoneNumber phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
