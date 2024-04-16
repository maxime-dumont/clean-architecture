package org.example.domain.entities;

public class CommonUserFactory implements UserFactory {

    public User create(String login, String password) {
        return new CommonUser(login, password);
    }

}