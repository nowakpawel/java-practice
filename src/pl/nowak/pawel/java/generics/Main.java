package pl.nowak.pawel.java.generics;

import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.web.controller.UserController;
import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.web.model.UserModel;

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
        Truck truck = new Truck("1997", "FH16", "Volvo", 2576000.999, 70.5);


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

        //====================================================================
        //                            CRUD TEST                             //
        //====================================================================

        System.out.println("=============================== CRUD Test =====================================");
//        UserService userService = new UserService();
//
//        System.out.println("User service at the beginning");
//        List<User> usersList = userService.list();
//        System.out.println(usersList + "\n");
//
//        System.out.println("Add one user to usersList");
//        User user1 = new User("admin", "admin@nowakpawel.pl", "secretpassword123");
//
//        System.out.println("User1: " + user1.toString());
//        User createdUser = userService.create(user1);
//        System.out.println("New created user: " + createdUser.toString());
//
//        System.out.println("List of users after adding one user: " + usersList);
//
//        System.out.println("\nUpdating user1:\n");
//
//        Integer firstUserId = usersList.get(0).getId();
//        User firstUser = userService.read(firstUserId);
//
//        System.out.println("User to modify: " + firstUser);
//        User userToUpdate = new User("Pawlo", "kontakt@nowakpawel.pl", "anothersecurepassword");
//
//        //update user
//        User updatedUser = userService.update(firstUserId, userToUpdate);
//
//        System.out.println("Users list after update " + usersList);
//
//        //add new user to users list.
//        User newUser = new User("admin", "admin@nowakpawel.pl", "securepassword123");
//        userService.create(newUser);
//        System.out.println("\nUsers list with new User: " + usersList);
//
//        //delete user:
//        userService.delete(usersList.get(0).getId());
//        System.out.println("\nUsers list after deleting one user: " + usersList);
        UserRepository userRepository = new UserRepository();
        UserMapper userMapper = new UserMapper();
        UserService userService = new UserService(userRepository, userMapper);
        UserController userController = new UserController(userService, userMapper);

        userController.readUser(-1);


        UserModel userModel = new UserModel();
        userModel.setEmail("admin@nowakpawel.pl");
        System.out.println(userModel);
    }

}
