package pl.nowak.pawel.java.crud.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private  Integer id;
    private String login;
    private String email;
    private String password;
}
