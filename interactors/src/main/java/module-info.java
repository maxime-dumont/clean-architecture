module interactors {
	requires static lombok;
	requires entities;
	requires archiUtils;
	requires org.mapstruct;

	exports org.example.interactors.usecase.user.register.api.ports.input;
	exports org.example.interactors.usecase.user.register.api.ports.output.datastore;
	exports org.example.interactors.usecase.user.register.api.ports.output.encoder;
	exports org.example.interactors.usecase.user.register.api.request.model;
	exports org.example.interactors.usecase.user.register.api.response.model;

////	Problématique que le module soit être au courant de vers qui il exporte, donc il y a quand même une dépendance
//	exports org.example.interactors.usecase.user.register.api.ports.input to restAdapter;
//	exports org.example.interactors.usecase.user.register.api.ports.output.persistance to databaseAdapter;
//	exports org.example.interactors.usecase.user.register.api.ports.output.encoder to sha256Adapter;
//	exports org.example.interactors.usecase.user.register.api.request.model to restAdapter, com.fasterxml.jackson.core;
//	exports org.example.interactors.usecase.user.register.api.response.model to restAdapter;


	opens org.example.interactors.usecase.user.register;
}