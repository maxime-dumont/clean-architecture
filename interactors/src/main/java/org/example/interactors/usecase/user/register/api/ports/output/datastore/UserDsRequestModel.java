package org.example.interactors.usecase.user.register.api.ports.output.datastore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserDsRequestModel {

    String login;
    String password;
    LocalDateTime creationTime;

}