package org.example.interactors.usecase.user.register.api.ports.output.datastore;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDsResponseModel {

    String login;
    LocalDateTime creationTime;

}