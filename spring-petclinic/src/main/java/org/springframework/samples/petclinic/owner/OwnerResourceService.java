package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.dto.OwnerDTO;
import org.springframework.samples.petclinic.mapper.OwnerMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerResourceService {

    private final OwnerRepository repository;
    private final OwnerMapper ownerMapper;

    public OwnerResourceService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.repository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public OwnerDTO findById(Integer id) {
        Owner owner = repository.findById(id);
        return ownerMapper.toDTO(owner);
    }

    public void createOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.toEntity(ownerDTO);
        repository.save(owner);
    }

}
