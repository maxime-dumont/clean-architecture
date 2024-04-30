module interactors {
	requires static lombok;
	requires entities;
	requires archiUtils;
	requires org.mapstruct;

//	exports org.example.interactors.usecase.user.register.api.ports.input;
//	exports org.example.interactors.usecase.user.register.api.ports.output.datastore;
//	exports org.example.interactors.usecase.user.register.api.ports.output.encoder;
//	exports org.example.interactors.usecase.user.register.api.request.model;
//	exports org.example.interactors.usecase.user.register.api.response.model;

	opens org.example.interactors.usecase.user.register;


	//	Problématique que le module soit être au courant de vers qui il exporte, donc il y a quand même une dépendance
	exports org.example.interactors.usecase.user.register.api.ports.input to restAdapter, springBootApplication;
	exports org.example.interactors.usecase.user.register.api.ports.output.datastore to databaseAdapter, springBootApplication;
	exports org.example.interactors.usecase.user.register.api.ports.output.encoder to sha256Adapter, springBootApplication;
	exports org.example.interactors.usecase.user.register.api.request.model to restAdapter, springBootApplication, com.fasterxml.jackson.core;
	exports org.example.interactors.usecase.user.register.api.response.model to restAdapter, springBootApplication;

	exports org.example.interactors.usecase.user.register.mapper.response to springBootApplication;
	exports org.example.interactors.usecase.user.register to springBootApplication;
}