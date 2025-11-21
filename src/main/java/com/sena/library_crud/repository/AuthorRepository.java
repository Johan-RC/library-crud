package com.sena.library_crud.repository;

import com.sena.library_crud.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}