package pl.nowak.pawel.java.crud.service;

import org.springframework.stereotype.Service;
import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.repository.UserRepository;
import pl.nowak.pawel.java.crud.exception.UserNotFoundException;
import pl.nowak.pawel.java.crud.service.mapper.UserMapper;
import pl.nowak.pawel.java.crud.web.model.UserModel;

import java.util.*;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger LOGGER  = Logger.getLogger(UserService.class.getName());
    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //create
    public UserModel create(UserModel userModel) {
        if (userModel == null) {
            throw new NoSuchElementException("User is null");
        }

        UserEntity userEntity = userMapper.fromModelToEntity(userModel);
        UserEntity createdUserEntity = userRepository.create(userEntity);
        return userMapper.fromEntityToModel(createdUserEntity);
    }

    //read
    public UserModel read(Integer id) throws UserNotFoundException {
        UserEntity userEntity = userRepository.read(id);
        return userMapper.fromEntityToModel(userEntity);

    }

    //update
    public UserModel update(Integer id, UserModel userModelToUpdate) throws UserNotFoundException {
        UserEntity userEntity = userMapper.fromModelToEntity(userModelToUpdate);

        return userMapper.fromEntityToModel(userRepository.update(id, userEntity));
    }

    //delete
    public void delete(Integer id) throws UserNotFoundException {
        userRepository.delete(id);
    }

    public List<UserModel> list() {
        List<UserEntity> entityUsers = userRepository.getUsersList();
        List<UserModel> modelUsers = new ArrayList<>();

        for (UserEntity entity : entityUsers) {
            UserModel userModel = userMapper.fromEntityToModel(entity);
            modelUsers.add(userModel);
        }

        return modelUsers;
    }
}
