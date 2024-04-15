package org.example.interactors.usecase.api.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseModel {

    String login;
    String creationTime;

}