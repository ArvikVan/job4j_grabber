package gc;

/**
 * класс описывает модель данных с методом finalize()
 * @author arvikv
 * @version 1.0
 */
public class UserGC {

    private int age;
    private String name;

    public UserGC(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public UserGC() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }
}
