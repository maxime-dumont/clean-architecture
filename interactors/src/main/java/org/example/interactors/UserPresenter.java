package org.example.interactors;

import org.example.interactors.response.UserResponseModel;

public interface UserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}