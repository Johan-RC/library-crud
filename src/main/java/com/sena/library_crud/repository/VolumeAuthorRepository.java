package com.sena.library_crud.repository;

import com.sena.library_crud.entity.VolumeAuthor;
import com.sena.library_crud.entity.VolumeAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeAuthorRepository extends JpaRepository<VolumeAuthor, VolumeAuthorId> {
}