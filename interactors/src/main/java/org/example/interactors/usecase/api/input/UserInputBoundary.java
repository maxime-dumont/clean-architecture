package org.example.interactors.usecase.api.input;

import org.example.interactors.usecase.api.request.model.UserRequestModel;
import org.example.interactors.usecase.api.response.model.UserResponseModel;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}