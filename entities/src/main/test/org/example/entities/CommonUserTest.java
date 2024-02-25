package test.org.example.entities;

import org.example.adapters.UserDsRequestModel;
import org.example.entities.CommonUser;
import org.example.entities.User;
import org.example.entities.UserFactory;
import org.example.interactors.UserInputBoundary;
import org.example.interactors.UserPresenter;
import org.example.interactors.UserRegisterDsGateway;
import org.example.interactors.UserRegisterInteractor;
import org.example.interactors.request.UserRequestModel;
import org.example.interactors.response.UserResponseModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CommonUserTest {


	UserRegisterDsGateway userDsGateway = mock(UserRegisterDsGateway.class);
	UserPresenter userPresenter = mock(UserPresenter.class);
	UserFactory userFactory = mock(UserFactory.class);
	UserInputBoundary interactor = new UserRegisterInteractor(userDsGateway, userPresenter, userFactory);


	@Test
	void given123Password_whenPasswordIsNotValid_thenIsFalse() {
		User user = new CommonUser("Baeldung", "123");

		assertThat(user.passwordIsValid()).isFalse();
	}

	@Test
	void givenBaeldungUserAnd123456Password_whenCreate_thenSaveItAndPrepareSuccessView() {
		User user = new CommonUser("baeldung", "123456");
		UserRequestModel userRequestModel = new UserRequestModel(user.getLogin(), user.getPassword());
		when(userFactory.create(anyString(), anyString())).thenReturn(new CommonUser(user.getLogin(), user.getPassword()));

		interactor.create(userRequestModel);

		verify(userDsGateway, times(1)).save(any(UserDsRequestModel.class));
		verify(userPresenter, times(1)).prepareSuccessView(any(UserResponseModel.class));
	}
}