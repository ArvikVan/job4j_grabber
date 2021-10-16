package ood.lsp;

/**
 * 0. Принцип подстановки Лисков. [#4915]
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * нарушение принципа Лискин, усиление предусловия в классе наследнике
 */
public class FarmerSecSon extends Farmer {
    public FarmerSecSon(String skill, int age) {
        super(skill, age);
    }

    @Override
    public void message() {
        if (skill.equals("abilityToPlant") && age < 18) {
            System.out.println("you are realy farmerSon");
        }
    }
}
