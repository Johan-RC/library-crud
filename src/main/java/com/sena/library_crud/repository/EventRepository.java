package com.sena.library_crud.repository;

import com.sena.library_crud.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}