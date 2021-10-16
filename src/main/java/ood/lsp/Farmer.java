package ood.lsp;

/**
 * 0. Принцип подстановки Лисков. [#4915]
 * @author arvikv
 * @version 1.0
 * @since 16.10.2021
 * Так же в литературе упоминается что принцип Лискин будет нарушен если дети фермера вместо
 * способности сажать, будут иметь способность играть в покер (например)
 */
public class Farmer {
    protected String skill = "abilityToPlant";
    protected int age;

    public Farmer(String skill, int age) {
        this.skill = skill;
        this.age = age;
    }

    public void message() {
        if (age < 18) {
            throw new IllegalArgumentException("wtf");
        }
    }

    public void validate(String skill) {
        if (!this.skill.equals("abilityToPlant")) {
            throw new IllegalArgumentException("You do not farmerSon");
        }
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        validate(skill);
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Farmer{"
                + "skill='" + skill + '\''
                + ", age=" + age
                + '}';
    }
}
