package com.cliet_tableaux.api.users.mappers;

import com.cliet_tableaux.api.users.dtos.UserDto;
import com.cliet_tableaux.api.users.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserDto> listEntityToListDto(List<UserEntity> userEntityList);
    UserDto userEntityToDto(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    List<UserEntity> listDtoToListEntity(List<UserDto> userDtoList);
    UserEntity userDtoToEntity(UserDto userDto);
}
