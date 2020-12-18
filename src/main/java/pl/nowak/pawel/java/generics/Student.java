package pl.nowak.pawel.java.generics;

public class Student {
    private String firstName;
    private int age;

    public Student() {
    }

    public Student(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
