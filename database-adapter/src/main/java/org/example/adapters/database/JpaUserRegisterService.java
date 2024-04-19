package org.example.adapters.database;

import lombok.RequiredArgsConstructor;
import org.example.adapters.database.dbo.UserDbo;
import org.example.archi.utils.annotation.PersistanceAdapter;
import org.example.interactors.usecase.user.register.api.ports.output.persistance.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.ports.output.persistance.UserRegisterDsOutput;
import org.example.adapters.database.repository.JpaUserRepository;

@PersistanceAdapter
@RequiredArgsConstructor
class JpaUserRegisterService implements UserRegisterDsOutput {

    final JpaUserRepository repository;

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