package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonUser implements User {
	private static final int MIN_PASSWORD_LENGTH = 5;

    String login;
    String password;
    public boolean passwordIsValid() {
        return password != null && password.length() > MIN_PASSWORD_LENGTH;
    }
}