module springBootApplication {
	requires databaseAdapter;
	requires restAdapter;
	requires sha256Adapter;
	requires interactors;
	requires archiUtils;

	requires static lombok;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.core;
	requires spring.context;
	requires spring.beans;
	requires org.mapstruct;
	requires entities;
	requires jakarta.annotation;

	opens org.example;
	opens org.example.configuration;
}