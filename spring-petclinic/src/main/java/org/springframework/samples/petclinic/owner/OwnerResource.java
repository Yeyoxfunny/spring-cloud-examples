package org.springframework.samples.petclinic.owner;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.dto.OwnerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/owners")
@RestController
public class OwnerResource {

    private final OwnerResourceService ownerService;

    public OwnerResource(OwnerResourceService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OwnerDTO getOwner(@PathVariable Integer ownerId) {
        return ownerService.findById(ownerId);
    }

    @PostMapping
    public void createOwner(@RequestBody @Valid OwnerDTO owner) {

    }

}
