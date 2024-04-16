package org.example.interactors.usecase.user.register.api.input;

import org.example.interactors.usecase.UseCase;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;

public interface UserRegisterInputBoundary extends UseCase {
    UserResponseModel register(UserRequestModel requestModel);
}