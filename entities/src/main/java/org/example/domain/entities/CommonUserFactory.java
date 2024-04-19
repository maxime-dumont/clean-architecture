package org.example.domain.entities;

import org.example.archi.utils.annotation.Factory;

@Factory
class CommonUserFactory implements UserFactory {
    public User create(String login, String password) {
        return new CommonUser(login, password);
    }

}