package org.example.adapters.rest.controllers;

import lombok.RequiredArgsConstructor;

import org.example.archi.utils.annotation.InputAdapter;
import org.example.interactors.usecase.user.register.api.ports.input.UserRegisterInput;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@InputAdapter
@RestController
class UserRegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);

    private final UserRegisterInput userInput;

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel requestModel) {
		LOGGER.info("create : {}", requestModel);
		return userInput.register(requestModel);
    }
}