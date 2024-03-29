package org.example.interactors.response;

import org.example.adapters.presenters.UserResponseFormatter;
import org.example.entities.UserFactory;
import org.example.interactors.UserInputBoundary;
import org.example.interactors.UserPresenter;
import org.example.interactors.UserRegisterInteractor;
import org.example.interactors.request.UserRequestModel;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserResponseFormatterUnitTest {

    UserResponseFormatter userResponseFormatter = new UserResponseFormatter();
    UserRegisterDsGateway userDsGateway = mock(UserRegisterDsGateway.class);
    UserPresenter userPresenter = mock(UserPresenter.class);
    UserFactory userFactory = mock(UserFactory.class);
    UserInputBoundary userInputBoundary = new UserRegisterInteractor(userDsGateway, userPresenter, userFactory);
    ArgumentCaptor<String> userRequestModelArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Test
    void givenDateAnd3HourTime_whenPrepareSuccessView_thenReturnOnly3HourTime() {
        UserResponseModel modelResponse = new UserResponseModel("baeldung", "2020-12-20T03:00:00.000");
        UserResponseModel formattedResponse = userResponseFormatter.prepareSuccessView(modelResponse);

        assertThat(formattedResponse.getCreationTime()).isEqualTo("03:00:00");
    }

    @Test
    void whenPrepareFailView_thenThrowHttpConflictException() {
        assertThatThrownBy(() -> userResponseFormatter.prepareFailView("Invalid password")).isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void whenCreateUser_thenSuccess() {

        UserRequestModel userRequestModel = new UserRequestModel("baeldung", "123456");
        when(userFactory.create(anyString(), anyString())).thenReturn(new CommonUser("baeldung", "123456"));

        userInputBoundary.create(userRequestModel);

        verify(userDsGateway).existsByName(userRequestModelArgumentCaptor.capture());
        String name = userRequestModel.getLogin();
        assertEquals("baeldung", name);
    }
}