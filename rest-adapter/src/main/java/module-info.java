module restAdapter {
	requires interactors;
	requires archiUtils;
	requires static lombok;
	requires org.slf4j;
	requires spring.web;

	opens org.example.adapters.rest.presenters;
	opens org.example.adapters.rest.controllers;
}