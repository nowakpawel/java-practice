package pl.nowak.pawel.java.crud;

import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.web.controller.UserController;
import pl.nowak.pawel.java.crud.web.model.UserModel;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================== CRUD Test =====================================");
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        UserModel user = new UserModel(null, "pawel", "pawel@testmail.com", "password");
        UserModel user2 = new UserModel(null, "zenek", "zenek@gmail.com", "securepasswd");

        UserModel createdUser = userController.createUser(user);
        UserModel createdUser2 = userController.createUser(user2);

        System.out.println(userController.readAllUsers());

        UserModel updatedUser = new UserModel(null, "pawel", "paweladmin@testmail.com", "verystrongpasswd");
        userController.updateUser(createdUser2.getId(), updatedUser);

        userController.deleteUser(createdUser.getId());

        //System.out.println(userController.readUser(user2.getId()));
        System.out.println(userController.readAllUsers());


    }

    //TODO: //Do każdej metody w repository dodac wyjatek, co najmniej UserException propagować wyjątki do controllera
    //TODO: //Artykuł o warstwach -> Zrobić mappera i użyć go w warstwie service, tak aby controller zwracał model, a repository entity
}
