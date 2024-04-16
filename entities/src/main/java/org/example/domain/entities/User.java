package org.example.domain.entities;

public interface User {
    boolean passwordIsValid();

    String getLogin();

    String getPassword();
}