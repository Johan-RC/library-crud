package com.sena.library_crud.repository;

import com.sena.library_crud.entity.BookAuthor;
import com.sena.library_crud.entity.BookAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {
}