package org.example.interactors.usecase.user.register.mapper.response;

import org.example.interactors.usecase.user.register.api.ports.output.datastore.UserDsResponseModel;
import org.example.interactors.usecase.user.register.api.response.model.UserResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserResponseMapper {

	UserResponseModel toReponse(UserDsResponseModel source);
}