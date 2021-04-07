package org.springframework.samples.petclinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.samples.petclinic.dto.OwnerDTO;
import org.springframework.samples.petclinic.owner.Owner;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(target = "pets", ignore = true)
    Owner toEntity(OwnerDTO owner);

    OwnerDTO toDTO(Owner owner);

}
