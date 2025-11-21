package com.sena.library_crud.repository;

import com.sena.library_crud.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}