package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
@EnableCaching
public class CleanArchitectureApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CleanArchitectureApplication.class);
	}


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