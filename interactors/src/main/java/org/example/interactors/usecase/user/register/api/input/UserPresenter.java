package org.example.interactors.usecase.user.register.api.input;

import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;

public interface UserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}