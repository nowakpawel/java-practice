package pl.nowak.pawel.java.crud.web.controller;

import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.web.model.UserModel;

public class UserController {
    private UserService userService; //Relacja typu agregacja
    //private CarService

    public UserController(UserService userService) { //dependency injection
        this.userService = userService;
    }
//    public UserController() {
//        this.userService = new UserService();
//    }

    public UserModel create(UserEntity userEntity) {
        return userService.create(userEntity); //Delegate
    }

    public UserModel read(Integer id) throws UserException {
        return userService.read(id); //Delegate

    }
}
