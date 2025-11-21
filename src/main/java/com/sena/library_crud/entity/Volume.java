package com.sena.library_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Volumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Volume extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String isbn;

    private Integer publicationYear;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "volume", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VolumeAuthor> volumeAuthors = new HashSet<>();

    @OneToMany(mappedBy = "volumen", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VolumeCategory> volumeCategories = new HashSet<>();


}
