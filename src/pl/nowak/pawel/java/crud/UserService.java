package pl.nowak.pawel.java.crud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class UserService {
    private List<User> usersList = new ArrayList<>();
    private Random randomUserId = new Random();

    //create
    public User create(User user) {
        Integer id = randomUserId.nextInt();
        user.setId(id);

        usersList.add(user);
        return user;
    }

    //read
    public User read(Integer id) {
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
}
