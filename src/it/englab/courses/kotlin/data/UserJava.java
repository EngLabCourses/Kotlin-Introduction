package it.englab.courses.kotlin.data;

public class UserJava {

    private String name;
    private int age;

    public UserJava(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJava userJava = (UserJava) o;

        if (age != userJava.age) return false;
        return name != null ? name.equals(userJava.name) : userJava.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "UserJava{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
