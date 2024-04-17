package org.example.interactors.usecase.user.register.api.ports.input;

import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;

public interface UserRegisterInput {
    UserResponseModel register(UserRequestModel requestModel);
}