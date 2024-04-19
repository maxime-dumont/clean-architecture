module entities {
	requires static lombok;
    requires archiUtils;
    exports org.example.domain.entities to interactors;

    opens org.example.domain.entities;
}