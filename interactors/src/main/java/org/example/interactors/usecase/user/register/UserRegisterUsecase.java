package org.example.interactors.usecase.user.register;

import lombok.AllArgsConstructor;
import org.example.archi.utils.annotation.UseCase;
import org.example.domain.entities.User;
import org.example.domain.entities.UserFactory;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsResponseModel;
import org.example.interactors.usecase.user.register.api.ports.output.encoder.PasswordEncoderOutput;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.ports.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.ports.input.UserRegisterInput;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserRegisterDsOutput;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;
import org.example.interactors.usecase.user.register.mapper.datastore.UserDsMapper;
import org.example.interactors.usecase.user.register.mapper.request.UserRequestMapper;
import org.example.interactors.usecase.user.register.mapper.response.UserResponseMapper;

import java.time.LocalDateTime;

@UseCase
@AllArgsConstructor
class UserRegisterUsecase implements UserRegisterInput {

    private final UserRegisterDsOutput userDsGateway;
    private final PasswordEncoderOutput passwordEncoderOutput;
    private final UserPresenter userPresenter;
    private final UserFactory userFactory;
    private final UserRequestMapper userRequestMapper;
    private final UserDsMapper userDsMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponseModel register(UserRequestModel requestModel) {

//		User user = userRequestMapper.toDomain(requestModel);

        if (userDsGateway.existsByName(requestModel.getLogin())) {
            return userPresenter.prepareFailView("User already exists.");
        }
//		UserDsRequestModel userDsRequestModel = userDsMapper.toDsRequestModel(user);
        User user = userFactory.create(requestModel.getLogin(), requestModel.getPassword());

	    if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        LocalDateTime now = LocalDateTime.now();
        UserDsRequestModel userDsModel = new UserDsRequestModel(user.getLogin(), passwordEncoderOutput.encode(user.getPassword()), now);

	    UserDsResponseModel response = userDsGateway.save(userDsModel);
        return userPresenter.prepareSuccessView(userResponseMapper.toReponse(response));
    }

}