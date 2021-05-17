import java.nio.charset.StandardCharsets;

public class Person {
    private String name;
    private int age;
    private boolean gender;



    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @Override
    public int hashCode() {
        return 13 * 17 * age + name.getBytes(StandardCharsets.UTF_8)[0] +
                name.getBytes(StandardCharsets.UTF_8)[1] + (gender ? 51 : 37);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
