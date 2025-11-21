package com.sena.library_crud.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Table(name = "book_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory {

    @EmbeddedId
    private BookCategoryId id = new BookCategoryId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Volume volume;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;
}