package pl.nowak.pawel.java.generics;

public class StudentMapper implements Mapper<Car, Student> {

    @Override
    public Student map(Car input) {
        Student student = new Student();
        student.setFirstName(input.getModel());
        return student;
    }
}
