package pl.nowak.pawel.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        strings.add("Ala ma kota");
        strings.add("1");

        Student student = new Student("Pawel", 18);
        System.out.println(student);

        StudentConverter<Student> studentConverter = new StudentConverter<>();
        studentConverter.information(student);

        //Test CarManager
        Car car = new Car("1981", "126P", "Fiat", 2000.0);
        Car truck = new Truck("1997", "FH16", "Volvo", 2576000.999, 70.5);


        CarManager<Car> carManager = new CarManager<>();

//        try {
//            carManager.addCar(truck);
//        } catch (NullPointerException e) {
//            System.out.println(e.toString());
//        }

        carManager.addCar(truck);
        carManager.addCar(car);
        System.out.println(carManager.getCarList());
        carManager.removeCar(truck);
        System.out.println(carManager.getCarList());
        //carManager.addCar(student); -> Test - should NOT compile
    }
    //POJO - Klasa z polami, konstruktorem, getterami i seterami?
    //TODO: jeszcze jedna klasa generyczna z metodą generyczną... + blog (klasa crud)
}
