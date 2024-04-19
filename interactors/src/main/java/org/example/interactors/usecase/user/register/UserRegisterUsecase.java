package org.example.interactors.usecase.user.register;

import lombok.AllArgsConstructor;
import org.example.archi.utils.annotation.UseCase;
import org.example.domain.entities.User;
import org.example.domain.entities.UserFactory;
import org.example.interactors.usecase.user.register.api.ports.output.encoder.PasswordEncoderOutput;
import org.example.interactors.usecase.user.register.api.ports.output.persistance.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.ports.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.ports.input.UserRegisterInput;
import org.example.interactors.usecase.user.register.api.ports.output.persistance.UserRegisterDsOutput;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;

import java.time.LocalDateTime;

@UseCase
@AllArgsConstructor
class UserRegisterUsecase implements UserRegisterInput {

    private final UserRegisterDsOutput userDsGateway;
    private final PasswordEncoderOutput passwordEncoderOutput;
    private final UserPresenter userPresenter;
    private final UserFactory userFactory;

    @Override
    public UserResponseModel register(UserRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getLogin())) {
            return userPresenter.prepareFailView("User already exists.");
        }
        User user = userFactory.create(requestModel.getLogin(), requestModel.getPassword());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        LocalDateTime now = LocalDateTime.now();
        UserDsRequestModel userDsModel = new UserDsRequestModel(user.getLogin(), passwordEncoderOutput.encode(user.getPassword()), now);

        userDsGateway.save(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getLogin(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}