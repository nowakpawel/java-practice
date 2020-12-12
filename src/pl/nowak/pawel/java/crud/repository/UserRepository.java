package pl.nowak.pawel.java.crud.repository;

import org.springframework.stereotype.Repository;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Repository
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
    public UserEntity read(Integer id) throws UserNotFoundException {
//        for (UserEntity userEntity : usersList) {
//            if (userEntity.getId().equals(id)) {
//                return userEntity;
//            }
//        }
        return usersList.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() ->
                new UserNotFoundException("User with id " + id + " not found!"));

        //throw new UserNotFoundException("User with id " + id + " not found!");
    }

    //update
    public UserEntity update (Integer id, UserEntity userEntityToUpdate) throws UserNotFoundException {
        for (UserEntity userEntity : usersList) {
            if (userEntity.getId().equals(id)) {
                //TODO: Implement validation:
                userEntity.setLogin(userEntityToUpdate.getLogin());
                userEntity.setEmail(userEntityToUpdate.getEmail());
                userEntity.setPassword(userEntityToUpdate.getPassword());

                return userEntity;
            }
        }
        throw new UserNotFoundException("User with id " + id + " not found!");
    }

    //delete
    public void delete(Integer id) throws UserNotFoundException {
        Iterator<UserEntity> iterator = usersList.iterator();
        boolean userFound = false;

        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();

            if (userEntity.getId().equals(id)) {
                userFound = true;
                iterator.remove();
            }
        }

        if (!userFound) {
            throw new UserNotFoundException("User with id " + id + " not found!");
        }
    }
}
