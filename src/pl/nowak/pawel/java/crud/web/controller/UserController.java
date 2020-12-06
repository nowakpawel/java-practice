package pl.nowak.pawel.java.crud.web.controller;

import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService; //Relacja typu agregacja
    private UserMapper userMapper = new UserMapper();

    public UserController(UserService userService) { //dependency injection
        this.userService = userService;
    }

    public UserModel createUser(UserModel userModel) {
        UserEntity userCreated = userService.create(userModel);
        return userMapper.fromEntityToModel(userCreated);
    }

    public UserModel readUser(Integer id) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = userService.read(id); //Delegate
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return userMapper.fromEntityToModel(userEntity);
    }

    public UserModel updateUser(Integer id, UserModel userModel) {
        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        try {
            userService.update(id, userEntity);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return userMapper.fromEntityToModel(userEntity);
    }

    public void deleteUser(Integer id) {
        try {
            userService.delete(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<UserModel> readAllUsers() {
        List<UserModel> usersList = new ArrayList<>();
        for(UserEntity user : userService.list()) {
            UserModel userModel = userMapper.fromEntityToModel(user);
            usersList.add(userModel);
        }

        return usersList;
    }
}
