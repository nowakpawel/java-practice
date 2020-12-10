package pl.nowak.pawel.java.crud.service;

import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

import java.util.*;
import java.util.logging.Logger;


public class UserService {
    private static final Logger LOGGER  = Logger.getLogger(UserService.class.getName());
    private UserRepository userRepository;
    private UserMapper userMapper = new UserMapper(); //dependency injection


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    public UserModel create(UserModel userModel) {
        if (userModel == null) {
            throw new NoSuchElementException("User is null");
        }

        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        UserEntity createdUserEntity = userRepository.create(userEntity);
        return userMapper.fromEntityToModel(createdUserEntity);

    }

    //read
    public UserEntity read(Integer id) throws UserNotFoundException {
        UserEntity userEntity = userRepository.read(id);
        return userEntity;

    }

    //update
    public UserEntity update(Integer id, UserEntity userEntityToUpdate) throws UserNotFoundException {
        return userRepository.update(id, userEntityToUpdate);
    }

    //delete
    public void delete(Integer id) throws UserNotFoundException {
        userRepository.delete(id);
    }

    public List<UserEntity> list() {
        return userRepository.getUsersList();
    }
}
