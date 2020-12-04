package pl.nowak.pawel.java.crud.service.mapper;

import pl.nowak.pawel.java.crud.repository.entity.UserEntity;
import pl.nowak.pawel.java.crud.web.model.UserModel;

public class UserMapper {
    public UserModel fromEntityToModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();

        userModel.setLogin(userEntity.getLogin());
        userModel.setEmail(userEntity.getEmail());
        userModel.setPassword(userEntity.getPassword());

        return userModel;

    }

    public UserEntity fromModelToEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();

        userEntity.setLogin(userModel.getLogin());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(userModel.getPassword());

        return userEntity;
    }
}
