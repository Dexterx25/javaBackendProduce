package com.alibou.security.services;

import com.alibou.security.entities.Publication;
import com.alibou.security.repositories.PublicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository){
        this.publicationRepository = publicationRepository;
    }
    public Optional<Publication> getPublication(Long publicationId){
        return publicationRepository.findById(publicationId);
    }
    public List<Publication> getPublications() {
        return publicationRepository.findAll();
    }

    public Publication createPublication(Publication publication) {
       return publicationRepository.save(publication);
    }

    public void deletePublication(Long publicationId) {
        publicationRepository.deleteById(publicationId);
    }
    @Transactional
    public void updatePublication(Publication publication, long publicationId) {
        Publication publicationRef = publicationRepository.getReferenceById(publicationId);
        publicationRef.setDescription(publication.getDescription());
        publicationRef.setSummary(publication.getSummary());
        publicationRef.setImage(publication.getImage());
        publicationRef.setId(publicationId);
        publicationRepository.save(publicationRef);
    }
}
