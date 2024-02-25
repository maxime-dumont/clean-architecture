package org.example.interactors;

import org.example.adapters.UserDsRequestModel;
import org.example.entities.User;
import org.example.entities.UserFactory;
import org.example.interactors.request.UserRequestModel;
import org.example.interactors.response.UserResponseModel;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserRegisterInteractorTest {

	UserRegisterDsGateway userDsGateway = mock(UserRegisterDsGateway.class);
	UserPresenter userPresenter = mock(UserPresenter.class);
	UserFactory userFactory = mock(UserFactory.class);
	UserInputBoundary interactor = new UserRegisterInteractor(userDsGateway,userPresenter,userFactory);

	@Test
	void givenBaeldungUserAnd123456Password_whenCreate_thenSaveItAndPrepareSuccessView() {

		User user = new CommonUser("baeldung", "123456");
		UserRequestModel userRequestModel = new UserRequestModel(user.getLogin(), user.getPassword());
		when(userFactory.create(anyString(), anyString()))
				.thenReturn(new CommonUser(user.getLogin(), user.getPassword()));

		interactor.create(userRequestModel);

		verify(userDsGateway, times(1)).save(any(UserDsRequestModel.class));
		verify(userPresenter, times(1)).prepareSuccessView(any(UserResponseModel.class));
	}
}