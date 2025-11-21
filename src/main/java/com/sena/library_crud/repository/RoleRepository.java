package com.sena.library_crud.repository;

import com.sena.library_crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}