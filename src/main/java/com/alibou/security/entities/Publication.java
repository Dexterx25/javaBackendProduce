package com.alibou.security.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Publication {
    @Id
    @SequenceGenerator(
            name = "publication_sequence",
            sequenceName =  "publication_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "publication_sequence"
    )
    private Long id;
    private String description;
    private String image;
    private String summary;
    public Publication(){

    }
    public Publication(Long id, String description, String image, String summary) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.summary = summary;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
