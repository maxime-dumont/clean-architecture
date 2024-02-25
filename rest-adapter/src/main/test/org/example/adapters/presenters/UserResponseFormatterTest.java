package org.example.adapters.presenters;

import org.example.interactors.response.UserResponseModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResponseFormatterTest {

	private final UserResponseFormatter userResponseFormatter = new UserResponseFormatter();

	@Test
	void givenDateAnd3HourTime_whenPrepareSuccessView_thenReturnOnly3HourTime() {
		UserResponseModel modelResponse = new UserResponseModel("baeldung", "2020-12-20T03:00:00.000");
		UserResponseModel formattedResponse = userResponseFormatter.prepareSuccessView(modelResponse);

		assertThat(formattedResponse.getCreationTime()).isEqualTo("03:00:00");
	}
}