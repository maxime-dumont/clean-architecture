package org.example.adapters.database;

import lombok.RequiredArgsConstructor;
import org.example.adapters.database.dbo.UserDbo;
import org.example.interactors.UserDsRequestModel;
import org.example.interactors.ports.UserRegisterDsGateway;
import org.example.adapters.database.repository.JpaUserRepository;

@RequiredArgsConstructor
public class JpaUser implements UserRegisterDsGateway {

    final JpaUserRepository repository;

    // Constructor

    @Override
    public boolean existsByName(String login) {
        return repository.existsById(login);
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        UserDbo accountDataMapper = new UserDbo(requestModel.getLogin(), requestModel.getPassword(), requestModel.getCreationTime());
        repository.save(accountDataMapper);
    }
}