package com.sena.library_crud.mapper;

import com.sena.library_crud.dto.ReservationDto;
import com.sena.library_crud.entity.Reservation;
import com.sena.library_crud.entity.User;
import com.sena.library_crud.entity.Volume;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationDto toDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setReservationDate(reservation.getReservationDate());
        dto.setExpirationDate(reservation.getExpirationDate());
        dto.setStatus(reservation.getStatus());
        dto.setUserId(reservation.getUser().getId());
        dto.setVolumeId(reservation.getVolume().getId());
        return dto;
    }

    public Reservation toEntity(ReservationDto dto, User user, Volume volume) {
        Reservation reservation = new Reservation();
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setExpirationDate(dto.getExpirationDate());
        reservation.setStatus(dto.getStatus());
        reservation.setUser(user);
        reservation.setVolume(volume);
        return reservation;
    }
}