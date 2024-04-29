package org.example.interactors.usecase.user.register.mapper.datastore;

import org.example.domain.entities.User;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDsMapper {

//	@Mapping(target = "login", source = "login")
	UserDsRequestModel toDsRequestModel(User source);

}