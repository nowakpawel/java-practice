package pl.nowak.pawel.java.crud;

import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.controller.UserController;
import pl.nowak.pawel.java.crud.web.model.UserModel;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================== CRUD Test =====================================");
        UserMapper userMapper = new UserMapper();
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository, userMapper);
        UserController userController = new UserController(userService, userMapper);
        UserModel user = new UserModel(null, "pawel", "pawel@testmail.com", "password");
        UserModel user2 = new UserModel(null, "zenek", "zenek@gmail.com", "securepasswd");

        UserModel createdUser = userController.createUser(user);
        UserModel createdUser2 = userController.createUser(user2);

        System.out.println("List after users added: " + userController.readAllUsers());

        UserModel updatedUser = new UserModel(null, "pawel", "paweladmin@testmail.com", "verystrongpasswd");
        userController.updateUser(createdUser2.getId(), updatedUser);

        System.out.println("List after updated second user: " + userController.readAllUsers());

        userController.deleteUser(createdUser.getId());

        System.out.println("List after deleted first user: " + userController.readAllUsers());

        ;
    }
}
