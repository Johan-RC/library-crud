package com.sena.library_crud.service;

import com.sena.library_crud.dto.ReservationDto;
import java.util.List;

public interface ReservationService {
    ReservationDto create(ReservationDto dto);
    ReservationDto cancel(Long id);
    List<ReservationDto> getAll();
    ReservationDto getById(Long id);
    void delete(Long id);
}