package org.example.adapters.database;

import org.example.adapters.database.dbo.UserDbo;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDsResponseMapper {

	@Mapping(target = "password", ignore = true)
	UserDsResponseModel toDsResponseModel(UserDbo source);

}