package pl.nowak.pawel.java.crud;

public class UserController {
    private UserService userService; //Relacja typu agregacja

    public UserController(UserService userService) { //dependency injection
        this.userService = userService;
    }
//    public UserController() {
//        this.userService = new UserService();
//    }

    public User create(User user) {
        return userService.create(user); //Delegate
    }

    public User read(Integer id) {
        return userService.read(id); //Delegate
    }
}
