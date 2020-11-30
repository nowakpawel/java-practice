package pl.nowak.pawel.java.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserRepository {
    private List<User> usersList = new ArrayList<>();
    private Random randomUserId = new Random();

    public User create(User user) {
        Integer id = randomUserId.nextInt();
        user.setId(id);
        usersList.add(user);
        return user;
    }
}
