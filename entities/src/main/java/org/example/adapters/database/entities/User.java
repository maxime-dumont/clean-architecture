package org.example.adapters.database.entities;

public interface User {
    boolean passwordIsValid();

    String getLogin();

    String getPassword();
}