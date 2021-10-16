package ood.lsp.invariants;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 */
public class Subscriber {
    protected PhoneNumber phoneNumber;

    public Subscriber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected void validate(PhoneNumber phoneNumber) {
        if (phoneNumber.getCountryCode() < 1 || phoneNumber.getCountryCode() > 999) {
            throw new IllegalArgumentException("Invalid country code!");
        }
        if (phoneNumber.getCityCode() < 1 || phoneNumber.getCityCode() > 999) {
            throw new IllegalArgumentException("Invalid city code!");
        }
        if (phoneNumber.getNumber() < 1 || phoneNumber.getNumber() > 999_999_999) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
