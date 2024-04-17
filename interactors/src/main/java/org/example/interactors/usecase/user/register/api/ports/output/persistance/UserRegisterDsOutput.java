package org.example.interactors.usecase.user.register.api.ports.output.persistance;

public interface UserRegisterDsOutput {
    boolean existsByName(String name);
    void save(UserDsRequestModel requestModel);
}