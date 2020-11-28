package pl.nowak.pawel.java.crud;

import java.util.Date;

public class User {
    private String login;
    private String email;
    private String password;
    private Date creationDate;

    public User() {
    }

    public User(String login, String email, String password, Date creationDate) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
