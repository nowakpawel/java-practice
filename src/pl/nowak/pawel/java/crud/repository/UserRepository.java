package pl.nowak.pawel.java.crud.repository;

import pl.nowak.pawel.java.crud.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class UserRepository {
    private List<UserEntity> usersList = new ArrayList<>();
    private Random randomUserId = new Random();

    public List<UserEntity> getUsersList() {
        return usersList;
    }

    //create
    public UserEntity create(UserEntity userEntity) {
        Integer id = randomUserId.nextInt();
        userEntity.setId(id);
        usersList.add(userEntity);
        return userEntity;
    }
    //read
    public UserEntity read(Integer id) {
        for (UserEntity userEntity : usersList) {
            if (userEntity.getId().equals(id)) {
                return userEntity;
            }
        }

        return null;
    }

    //update
    public UserEntity update (Integer id, UserEntity userEntityToUpdate) {
        for (UserEntity userEntity : usersList) {
            if (userEntity.getId().equals(id)) {
                //TODO: Implement validation:
                userEntity.setLogin(userEntityToUpdate.getLogin());
                userEntity.setEmail(userEntityToUpdate.getEmail());
                userEntity.setPassword(userEntityToUpdate.getPassword());

                return userEntity;
            }
        }
        return null;
    }

    //delete
    public void delete(Integer id) {
        Iterator<UserEntity> iterator = usersList.iterator();

        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();

            if(userEntity.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
