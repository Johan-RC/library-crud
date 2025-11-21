package com.sena.library_crud.repository;

import com.sena.library_crud.entity.BookCategory;
import com.sena.library_crud.entity.BookCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, BookCategoryId> {
}