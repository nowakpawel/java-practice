package pl.nowak.pawel.java.crud.web.controller;

import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

import java.util.List;

/*Responsible ONLY for:
//http requests handling!!(statuses)
http request validation!! */

public class UserController {
    private UserService userService; //Relacja typu agregacja
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserModel createUser(UserModel userModel) {
        return userService.create(userModel);
    }

    public UserModel readUser(Integer id) throws UserException {
        return userService.read(id);
    }

    public UserModel updateUser(Integer id, UserModel userModel) throws UserException {
        return userService.update(id, userModel);
    }

    public void deleteUser(Integer id) {
        try {
            userService.delete(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<UserModel> readAllUsers() {
        return userService.list();
    }
}
