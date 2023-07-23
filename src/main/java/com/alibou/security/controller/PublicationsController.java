package com.alibou.security.controller;

import com.alibou.security.dto.PublicationDTO;
import com.alibou.security.entities.Publication;
import com.alibou.security.mapper.PublicationMapper;
import com.alibou.security.responses.ApiResponse;
import com.alibou.security.responses.exceptions.ApiRequestException;
import com.alibou.security.responses.success.ApiRequestSuccess;
import com.alibou.security.services.PublicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="api/v1/publications")
public class PublicationsController {
    private final PublicationService publicationService;
    private final PublicationMapper mapper;
    @Autowired
    public PublicationsController(PublicationMapper mapper, PublicationService publicationService) {
        this.publicationService = publicationService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PublicationDTO> getList() {
        List<Publication> publicationList = this.publicationService.getPublications();
        return mapper.modelsToDtos(publicationList);
    }

    @GetMapping("/{publicationId}")
    public PublicationDTO detailPublication(@PathVariable long publicationId){
          Optional<Publication> publicationFound = this.publicationService.getPublication(publicationId);
          if(publicationFound.isEmpty()){
              throw new ApiRequestException("Publication not found", HttpStatus.NOT_FOUND);
          }
          return mapper.modelToDto(publicationFound);
    };
    @PostMapping
    public ApiResponse createPublication(@RequestBody @Valid PublicationDTO publicationDTO) {
        Publication publication = mapper.dtoToModel(publicationDTO);
        PublicationDTO publicationCreated = mapper.modelCreatedToDTO(publicationService.createPublication(publication));
        return new ApiRequestSuccess("OK", HttpStatus.CREATED, publicationCreated).res();
    };
    @DeleteMapping(path = "{publicationId}")
    public ApiResponse deletePublication(@PathVariable Long publicationId){
        this.detailPublication(publicationId);
        publicationService.deletePublication(publicationId);
        return new ApiRequestSuccess("Deleted", HttpStatus.OK, null).res();

    }
    @PutMapping(path = "{publicationId}")
    @PreAuthorize("hasAuthority('management:update')")
    //@PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    public ApiResponse updatePublication(@PathVariable Long publicationId, @RequestBody @Valid PublicationDTO publicationDTO){
        this.detailPublication(publicationId);
        Publication publication = mapper.dtoToModel(publicationDTO);
        publicationService.updatePublication(publication, publicationId);
        return new ApiRequestSuccess("Updated", HttpStatus.valueOf(200), null).res();
    }
}
