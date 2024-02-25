package org.example.adapters.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonUser implements User {

    String login;
    String password;
    public boolean passwordIsValid() {
        return password != null && password.length() > 5;
    }
}