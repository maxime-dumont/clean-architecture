package org.example;


import org.example.archi.utils.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(
		type = FilterType.ANNOTATION,
		classes = {
				UseCase.class,
				InputAdapter.class,
				OutputAdapter.class,
				PersistanceAdapter.class,
				ResponsePresenter.class,
				Factory.class,
		}))
public class CleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureApplication.class, args);
	}

}