package pl.nowak.pawel.java.crud.web.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.UserService;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

public class UserController {
    private UserService userService; //Relacja typu agregacja
    private UserMapper userMapper = new UserMapper();
    //private CarService

    public UserController(UserService userService) { //dependency injection
        this.userService = userService;
    }

    public UserModel createUser(UserModel userModel) {
        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        UserEntity userCreated = userService.create(userEntity); // po co przypisuje stworzonego usera do osobnej zmiennej? userEntity != userCreated?
        return userMapper.fromEntityToModel(userCreated);
    }

    public UserModel read(Integer id) throws UserException {
        return userService.read(id); //Delegate

    }
}
