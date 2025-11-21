package com.sena.library_crud.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import com.sena.library_crud.enums.ReservationStatus;

@Getter
@Setter
public class ReservationDto {
    private Long id;
    private LocalDate reservationDate;
    private LocalDate expirationDate;
    private ReservationStatus status;
    private Long userId;
    private Long volumeId;
}