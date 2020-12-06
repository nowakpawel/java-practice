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
    private UserMapper userMapper = new UserMapper();


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    public UserEntity create(UserModel userModel) {
        if (userModel == null) {
            throw new NoSuchElementException("User is null");
        }

        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        return userRepository.create(userEntity);
    }

    //read
    public UserEntity read(Integer id) throws UserException {
        UserEntity userEntity =  userRepository.read(id);
        if (userEntity == null) {
            throw new UserNotFoundException("User not found for id " + id);
        } else {
            return userEntity;
        }
    }

//    //update
    public UserEntity update(Integer id, UserEntity userEntityToUpdate) {
        return userRepository.update(id, userEntityToUpdate);
    }
//
//    //delete
    public void delete(Integer id) {
        userRepository.delete(id);
    }
//
    public List<UserEntity> list() {
        return userRepository.getUsersList();
    }
}
