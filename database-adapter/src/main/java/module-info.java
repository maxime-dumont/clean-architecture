module databaseAdapter {
	requires jakarta.persistence;
	requires static lombok;
	requires spring.context;
	requires spring.data.jpa;
	requires org.hibernate.orm.core;

	requires archiUtils;
	requires interactors;
	requires org.mapstruct;

	opens org.example.adapters.database.dbo;
	opens org.example.adapters.database;
	exports org.example.adapters.database;
}