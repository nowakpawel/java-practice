package pl.nowak.pawel.java.crud.repository;

import org.springframework.stereotype.Repository;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        return usersList.stream()
                .filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() ->
                new UserNotFoundException("User with id " + id + " not found!"));
    }

    //update
    public UserEntity update (Integer id, UserEntity userEntityToUpdate) throws UserNotFoundException {
        UserEntity userEntity = usersList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found!"));
        usersList.stream()
              //  .map(UserEntity::getEmail)
                //.map(userEntity1 -> userEntity1.getEmail())
                .map(UserEntity::getEmail)
                .collect(Collectors.toList());

        userEntity.setLogin(userEntityToUpdate.getLogin());
        userEntity.setEmail(userEntityToUpdate.getPassword());
        userEntity.setPassword(userEntityToUpdate.getPassword());

        return userEntity;
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
