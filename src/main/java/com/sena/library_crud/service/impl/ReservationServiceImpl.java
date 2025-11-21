package com.sena.library_crud.service.impl;

import com.sena.library_crud.dto.ReservationDto;
import com.sena.library_crud.entity.Reservation;
import com.sena.library_crud.entity.User;
import com.sena.library_crud.entity.Volume;
import com.sena.library_crud.enums.ReservationStatus;
import com.sena.library_crud.mapper.ReservationMapper;
import com.sena.library_crud.repository.ReservationRepository;
import com.sena.library_crud.repository.UserRepository;
import com.sena.library_crud.repository.VolumeRepository;
import com.sena.library_crud.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    @Transactional
    public ReservationDto create(ReservationDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Volume volume = volumeRepository.findById(dto.getVolumeId()).orElseThrow();

        Reservation reservation = reservationMapper.toEntity(dto, user, volume);
        reservation.setStatus(ReservationStatus.ACTIVE);

        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    @Override
    @Transactional
    public ReservationDto cancel(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationDto> getAll() {
        return reservationRepository.findAll().stream().map(reservationMapper::toDto).toList();
    }

    @Override
    public ReservationDto getById(Long id) {
        return reservationRepository.findById(id).map(reservationMapper::toDto).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}