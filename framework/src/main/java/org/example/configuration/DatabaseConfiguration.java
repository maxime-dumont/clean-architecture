package org.example.configuration;

import org.example.adapters.database.JpaUser;
import org.example.adapters.database.adapters.presenters.UserResponseFormatter;
import org.example.domain.entities.CommonUserFactory;
import org.example.domain.entities.UserFactory;
import org.example.adapters.database.repository.JpaUserRepository;
import org.example.interactors.usecase.user.register.UserRegisterFactory;
import org.example.interactors.usecase.user.register.UserRegisterFactoryImpl;
import org.example.interactors.usecase.user.register.api.input.UserPresenter;
import org.example.interactors.usecase.user.register.api.input.UserRegisterInputBoundary;
import org.example.interactors.usecase.user.register.api.ports.data.UserRegisterDsGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

	@Bean
	public UserRegisterInputBoundary userInputBoundary(
			UserRegisterFactory userRegisterFactory,
			UserRegisterDsGateway userRegisterDsGateway,
			UserPresenter userPresenter,
			UserFactory userFactory
	){
		return userRegisterFactory.createUserUseCase(userRegisterDsGateway,userPresenter, userFactory);
	}

	@Bean
	public UserRegisterFactory userRegisterFactory(){
		return new UserRegisterFactoryImpl();
	}

	@Bean
	public UserRegisterDsGateway userRegisterDsGateway(JpaUserRepository jpaUserRepository){
		return new JpaUser(jpaUserRepository);
	}

	@Bean
	public UserPresenter userPresenter(){
		return new UserResponseFormatter();
	}

	@Bean
	public UserFactory userFactory(){
		return new CommonUserFactory();
	}

}