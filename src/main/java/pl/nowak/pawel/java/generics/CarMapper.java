package pl.nowak.pawel.java.generics;

public class CarMapper  implements Mapper<Student, Car> {

    @Override
    public Car map(Student input) {
        Car car = new Car();
        car.setModel(input.getFirstName());

        return car;
    }
}
