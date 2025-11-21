package com.sena.library_crud.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthor {

    @EmbeddedId
    private BookAuthorId id = new BookAuthorId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Volume volume;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    private Author author;

    // Optional: extra attribute for the relationship
    private LocalDate collaborationDate;
}