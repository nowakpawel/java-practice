package pl.nowak.pawel.java.crud;

import java.util.*;
import java.util.logging.Logger;


public class UserService {
    private static final Logger LOGGER  = Logger.getLogger(UserService.class.getName());
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    public User create(User user) {
        if (user == null) {
            throw new NoSuchElementException("User is null");
        }
     return userRepository.create(user);
    }

    //read
    public User read(Integer id) {
        //LOGGER.info("Reading normal user");
        return userRepository.read(id);
    }

    //update
    public User update(Integer id, User userToUpdate) {
        return userRepository.update(id, userToUpdate);
    }

    //delete
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> list() {
        return userRepository.getUsersList();
    }

    //TODO: przerobić resztę metod na delegaty..i przenieść logikę metod do repository
    //Teoria o własnych wyjątkach
    //LOGGER
}
