package org.example.interactors.usecase.user.register.mapper.request;

import org.example.domain.entities.User;
import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsRequestModel;
import org.example.interactors.usecase.user.register.api.request.model.UserRequestModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserRequestMapper {

	User toDomain(UserRequestModel source);

}