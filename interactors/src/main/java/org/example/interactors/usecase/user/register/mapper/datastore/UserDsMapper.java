package org.example.interactors.usecase.user.register.mapper.datastore;

import org.example.domain.entities.User;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDsMapper {

	@Mapping(target = "creationTime", ignore = true)
	UserDsRequestModel toDsRequestModel(User source);

}