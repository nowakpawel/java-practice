package pl.nowak.pawel.java.crud;

import java.util.*;
import java.util.logging.Logger;

public class UserService {
//    private List<User> usersList = new ArrayList<>();
//    private Random randomUserId = new Random();
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
        //System.out.println("Reading normal user...");
        LOGGER.info("Reading normal user");
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }

    //update
    public User update(Integer id, User userToUpdate) {
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                //TODO: Implement validation:
                user.setLogin(userToUpdate.getLogin());
                user.setEmail(userToUpdate.getEmail());
                user.setPassword(userToUpdate.getPassword());

                return user;
            }
        }
        return null;
    }

    //delete
    public void delete(Integer id) {
        Iterator<User> iterator = usersList.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<User> list() {
        return usersList;
    }

    //TODO: przerobić resztę metod na delegaty..i przenieść logikę metod do repository
    //Teoria o własnych wyjątkach
    //LOGGER
}
