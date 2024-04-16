package org.example.interactors.usecase.user.register.api.request.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestModel {

    String login;
    String password;

}