package org.example.adapters.database.adapters.controllers;

import lombok.RequiredArgsConstructor;
import org.example.interactors.usecase.api.input.UserInputBoundary;
import org.example.interactors.usecase.api.request.model.UserRequestModel;
import org.example.interactors.usecase.api.response.model.UserResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class UserRegisterController {

    final UserInputBoundary userInput;

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel requestModel) {
		return userInput.create(requestModel);
    }
}