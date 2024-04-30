package org.example.configuration;


import org.example.adapters.database.UserDsResponseMapper;
import org.example.domain.entities.UserFactory;
import org.example.interactors.usecase.user.register.UserRegisterUsecase;
import org.example.interactors.usecase.user.register.api.ports.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.ports.input.UserRegisterInput;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserRegisterDsOutput;
import org.example.interactors.usecase.user.register.api.ports.output.encoder.PasswordEncoderOutput;
import org.example.interactors.usecase.user.register.mapper.response.UserResponseMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfiguration {


	@Bean
	public UserRegisterInput userRegisterInput(
			UserRegisterDsOutput userDsGateway,
			PasswordEncoderOutput passwordEncoderOutput,
			UserPresenter userPresenter,
			UserFactory userFactory,
			UserResponseMapper userResponseMapper
	) {
		return new UserRegisterUsecase(
				userDsGateway,
				passwordEncoderOutput,
				userPresenter,
				userFactory,
				userResponseMapper
		);

	}

	@Bean
	public UserResponseMapper userResponseMapper() {
		return Mappers.getMapper( UserResponseMapper.class );
	}

	@Bean
	public UserDsResponseMapper userDsResponseMapper() {
		return Mappers.getMapper( UserDsResponseMapper.class );
	}

}