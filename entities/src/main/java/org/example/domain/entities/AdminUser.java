package org.example.domain.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class AdminUser implements User {
	private static final int MIN_PASSWORD_LENGTH = 12;
	private static final Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");

    String login;
    String password;
    public boolean passwordIsValid() {
	    if(password == null){
			return false;
	    }

		boolean isPasswordLengthValid = password.length() > MIN_PASSWORD_LENGTH;
	    boolean hasPasswordSpecialChar = !pattern.matcher(password).find();
		return isPasswordLengthValid && hasPasswordSpecialChar;
	}
}