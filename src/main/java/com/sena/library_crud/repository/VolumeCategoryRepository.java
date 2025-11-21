package com.sena.library_crud.repository;

import com.sena.library_crud.entity.VolumeCategory;
import com.sena.library_crud.entity.VolumeCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeCategoryRepository extends JpaRepository<VolumeCategory, VolumeCategoryId> {
}