package ood.lsp;

/**
 * 0. Принцип подстановки Лисков. [#4915]
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * нарушен LiskinSubstitutionPrinciple, ослаблено постусловие в классе наследнике
 */
public class FarmerSon extends Farmer {
    private Farmer farmer;

    public FarmerSon(String skill, int age) {
        super(skill, age);
    }

    @Override
    public void message() {
        System.out.println("i'm a farmerSon");
    }
}
