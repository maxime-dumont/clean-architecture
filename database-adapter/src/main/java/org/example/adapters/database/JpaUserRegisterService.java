package org.example.adapters.database;

import lombok.RequiredArgsConstructor;
import org.example.adapters.database.dbo.UserDbo;
import org.example.archi.utils.annotation.PersistanceAdapter;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsResponseModel;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserRegisterDsOutput;
import org.example.adapters.database.repository.JpaUserRepository;

@PersistanceAdapter
@RequiredArgsConstructor
class JpaUserRegisterService implements UserRegisterDsOutput {

    private final JpaUserRepository repository;
    private final UserDsResponseMapper userDsResponseMapper;

    @Override
    public boolean existsByName(String login) {
        return repository.existsById(login);
    }

    @Override
    public UserDsResponseModel save(UserDsRequestModel requestModel) {
        UserDbo accountDataMapper = new UserDbo(requestModel.getLogin(), requestModel.getPassword(), requestModel.getCreationTime());
	    UserDbo savedUser = repository.save(accountDataMapper);
		return userDsResponseMapper.toDsResponseModel(savedUser);
    }
}