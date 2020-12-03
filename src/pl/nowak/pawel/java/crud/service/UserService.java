package pl.nowak.pawel.java.crud.service;

import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.exception.UserException;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;

import java.util.*;
import java.util.logging.Logger;


public class UserService {
    private static final Logger LOGGER  = Logger.getLogger(UserService.class.getName());
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    public UserEntity create(UserEntity userEntity) {
        if (userEntity == null) {
            throw new NoSuchElementException("User is null");
        }
     return userRepository.create(userEntity);
    }

    //read
    public UserEntity read(Integer id) throws UserException {
        //LOGGER.info("Reading normal user");
        UserEntity userEntity =  userRepository.read(id);
        if (userEntity == null) {
            throw new UserNotFoundException("User not found for id " + id);
        } else {
            return userEntity;
        }
    }

    //update
    public UserEntity update(Integer id, UserEntity userEntityToUpdate) {
        return userRepository.update(id, userEntityToUpdate);
    }

    //delete
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<UserEntity> list() {
        return userRepository.getUsersList();
    }

    //TODO: przerobić resztę metod na delegaty..i przenieść logikę metod do repository
    //Teoria o własnych wyjątkach
    //LOGGER
}
