package org.example.interactors.usecase.user.register;

import org.example.domain.entities.UserFactory;
import org.example.interactors.usecase.user.register.api.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.input.UserRegisterInputBoundary;
import org.example.interactors.usecase.user.register.api.ports.data.UserRegisterDsGateway;

public interface UserRegisterFactory {

	UserRegisterInputBoundary createUserUseCase(
			UserRegisterDsGateway userDsGateway,
			UserPresenter userPresenter,
			UserFactory userFactory
	);
}