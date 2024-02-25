package org.example.adapters.database.entities;

/**
 * We created a user factory method because of two reasons.
 * To stock to the stable abstractions principle and to isolate the user creation.
 */
public interface UserFactory {
    User create(String login, String password);
}