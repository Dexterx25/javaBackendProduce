package com.alibou.security.mapper;

import com.alibou.security.dto.PublicationDTO;
import com.alibou.security.entities.Publication;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public interface PublicationMapper {

    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    PublicationDTO modelToDto(Optional<Publication> publication);
    PublicationDTO modelCreatedToDTO(Publication publication);
    List<PublicationDTO> modelsToDtos(List<Publication> publications);

    @InheritInverseConfiguration
    Publication dtoToModel(PublicationDTO publicationDTO);

}
