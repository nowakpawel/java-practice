package pl.nowak.pawel.java.crud.web.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService; //Relacja typu agregacja
    private UserMapper userMapper = new UserMapper();
    //private CarService

    public UserController(UserService userService) { //dependency injection
        this.userService = userService;
    }

    public UserModel createUser(UserModel userModel) {
        UserEntity userCreated = userService.create(userModel); // po co przypisuje stworzonego usera do osobnej zmiennej? userEntity != userCreated?
        return userMapper.fromEntityToModel(userCreated);
    }

    public UserModel readUser(Integer id) throws UserException {
        UserEntity userEntity = userService.read(id); //Delegate
        return userMapper.fromEntityToModel(userEntity);
    }

    public UserModel updateUser(Integer id, UserModel userModel) {
        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        userService.update(id, userEntity);
        return userMapper.fromEntityToModel(userEntity);
    }

    public void deleteUser(Integer id) {
        userService.delete(id);
    }

    public List<UserModel> readAllUsers() {
        List<UserModel> usersList = new ArrayList<>();
        for(UserEntity user : userService.list()) {
//            UserModel userModel = new UserModel();
            UserModel userModel = userMapper.fromEntityToModel(user);
            usersList.add(userModel);
        }

        return usersList;
    }
}
