package org.example.interactors.usecase.user.register.api.ports.data;

import org.example.interactors.usecase.user.register.api.ports.data.model.UserDsRequestModel;

public interface UserRegisterDsGateway {
    boolean existsByName(String name);
    void save(UserDsRequestModel requestModel);
}