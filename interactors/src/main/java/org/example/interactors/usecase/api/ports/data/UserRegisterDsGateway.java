package org.example.interactors.usecase.api.ports.data;

import org.example.interactors.usecase.api.ports.data.model.UserDsRequestModel;

public interface UserRegisterDsGateway {
    boolean existsByName(String name);
    void save(UserDsRequestModel requestModel);
}