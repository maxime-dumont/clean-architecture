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

import jakarta.annotation.Resource;

@Configuration
public class UsecaseConfiguration {

	@Resource(name="commonUserFactory")
	private UserFactory commonUserFactory;

	@Resource(name="adminUserFactory")
	private UserFactory adminUserFactory;


	@Bean
	public UserRegisterInput userRegisterInput(
			UserRegisterDsOutput userDsGateway,
			PasswordEncoderOutput passwordEncoderOutput,
			UserPresenter userPresenter,
			UserResponseMapper userResponseMapper
	) {
		return new UserRegisterUsecase(
				userDsGateway,
				passwordEncoderOutput,
				userPresenter,
				commonUserFactory,
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