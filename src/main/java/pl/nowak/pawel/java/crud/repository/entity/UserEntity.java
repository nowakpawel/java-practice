package pl.nowak.pawel.java.crud.repository.entity;

import java.util.Date;

public class UserEntity {
    private Integer id;
    private String login;
    private String email;
    private String password;
    //private Date creationDate;

    public UserEntity() {
    }

    public UserEntity(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id ='" + id + '\'' +
                ", login ='" + login + '\'' +
                ", email ='" + email + '\'' +
                ", password ='" + password + '\'' +
                '}';
    }
}
