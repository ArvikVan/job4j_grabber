package ood.lsp.invariants;

/**
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * 3. Инварианты (Invariants) — все условия базового класса - также должны быть сохранены и в подклассе
 * Инвариант - это условие, которое постоянно на протяжении существования объекта.
 */
public class PhoneNumber {
    private int countryCode;
    private int cityCode;
    private int number;

    public PhoneNumber(int countryCode, int cityCode, int number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getNumber() {
        return number;
    }
}
