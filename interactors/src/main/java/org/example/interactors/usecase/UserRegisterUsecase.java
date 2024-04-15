package org.example.interactors.usecase;

import lombok.AllArgsConstructor;
import org.example.adapters.database.entities.User;
import org.example.adapters.database.entities.UserFactory;
import org.example.interactors.usecase.api.ports.data.model.UserDsRequestModel;
import org.example.interactors.UserPresenter;
import org.example.interactors.usecase.api.input.UserInputBoundary;
import org.example.interactors.usecase.api.ports.data.UserRegisterDsGateway;
import org.example.interactors.usecase.api.request.model.UserRequestModel;
import org.example.interactors.usecase.api.response.model.UserResponseModel;

import java.time.LocalDateTime;

@AllArgsConstructor
public class UserRegisterUsecase implements UserInputBoundary {

    final UserRegisterDsGateway userDsGateway;
    final UserPresenter userPresenter;
    final UserFactory userFactory;

    @Override
    public UserResponseModel create(UserRequestModel requestModel) {
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