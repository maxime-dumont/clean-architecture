package org.example.adapters.database;

import org.example.adapters.database.dbo.UserDbo;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserDsResponseMapper {

	UserDsResponseModel toDsResponseModel(UserDbo source);

}