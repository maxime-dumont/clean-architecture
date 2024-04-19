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
public class CleanArchitectureApplication
//		extends SpringBootServletInitializer
		{


	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(CleanArchitectureApplication.class);
//	}


//	@Bean
//	BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
//		return beanFactory -> genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
//	}
//
//	void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
//		ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
//		beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
//		beanDefinitionScanner.scan("com.baeldung.pattern.cleanarchitecture");
//	}
//
//	static TypeFilter removeModelAndEntitiesFilter() {
//		return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
//				.getClassName()
//				.endsWith("Model");
//	}
}