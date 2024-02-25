package org.example.interactors.ports;


import org.example.interactors.UserDsRequestModel;

public interface UserRegisterDsGateway {
    boolean existsByName(String name);
    void save(UserDsRequestModel requestModel);
}