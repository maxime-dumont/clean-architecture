module interactors {
	requires static lombok;
	requires entities;
//	Problématique que le module soit être au courant de vers qui il exporte, donc il y a quand même une dépendance
	exports org.example.interactors.usecase.user.register.api.ports.input to restAdapter;
	exports org.example.interactors.usecase.user.register.api.ports.output.persistance to databaseAdapter;
	exports org.example.interactors.usecase.user.register.api.ports.output.encoder to sha256Adapter;
	exports org.example.interactors.usecase.user.register.api.request.model to restAdapter;
	exports org.example.interactors.usecase.user.register.api.response.model to restAdapter;
	exports org.example.interactors.common;
}