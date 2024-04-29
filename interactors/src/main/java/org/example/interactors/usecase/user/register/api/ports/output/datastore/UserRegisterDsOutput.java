package org.example.interactors.usecase.user.register.api.ports.output.datastore;

public interface UserRegisterDsOutput {
    boolean existsByName(String name);
    UserDsResponseModel save(UserDsRequestModel requestModel);
}