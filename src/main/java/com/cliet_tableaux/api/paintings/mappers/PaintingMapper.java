package com.cliet_tableaux.api.paintings.mappers;

import com.cliet_tableaux.api.paintings.dtos.PaintingDto;
import com.cliet_tableaux.api.paintings.entities.PaintingEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaintingMapper {
    List<PaintingDto> listEntityToListDto(List<PaintingEntity> paintingEntityList);
    PaintingDto paintingEntityToDto(PaintingEntity paintingEntity);

    @Mapping(target = "id", ignore = true)
    List<PaintingEntity> listDtoToListEntity(List<PaintingDto> paintingDtoList);
    PaintingEntity paintingDtoToEntity(PaintingDto paintingDto);
}
