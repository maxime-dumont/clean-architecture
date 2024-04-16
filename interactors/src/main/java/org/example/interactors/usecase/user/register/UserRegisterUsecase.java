package org.example.interactors.usecase.user.register;

import lombok.AllArgsConstructor;
import org.example.domain.entities.User;
import org.example.domain.entities.UserFactory;
import org.example.interactors.usecase.user.register.api.ports.data.model.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.input.UserRegisterInputBoundary;
import org.example.interactors.usecase.user.register.api.ports.data.UserRegisterDsGateway;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;

import java.time.LocalDateTime;

@AllArgsConstructor
class UserRegisterUsecase implements UserRegisterInputBoundary {

    final UserRegisterDsGateway userDsGateway;
    final UserPresenter userPresenter;
    final UserFactory userFactory;

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
        UserDsRequestModel userDsModel = new UserDsRequestModel(user.getLogin(), user.getPassword(), now);

        userDsGateway.save(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getLogin(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}