package pl.nowak.pawel.java.crud;

public class VipUserService extends UserService {
    @Override
    public User read(Integer id) {
        System.out.println("Reading vip..." + id);
        return super.read(id);
    }
}
