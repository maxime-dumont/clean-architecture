package org.example.interactors.input;

import org.example.interactors.request.UserRequestModel;
import org.example.interactors.response.UserResponseModel;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}