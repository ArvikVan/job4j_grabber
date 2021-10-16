package ood.lsp;

/**
 * 0. Принцип подстановки Лисков. [#4915]
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * нарушаем принцип Лискин, инвариантность, класс наследник не соблюдает условия предка
 */
public class FarmerThirdSon extends Farmer {
    public FarmerThirdSon(String skill, int age) {
        super(skill, age);
    }

    @Override
    public void setSkill(String skill) {
        super.setSkill(skill);
    }
}
