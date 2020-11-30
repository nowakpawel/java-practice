package pl.nowak.pawel.java.crud;

public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        VipUserService vipUserService = new VipUserService();

        UserController userController = new UserController(vipUserService);
        userController.read(987);

    }
}
