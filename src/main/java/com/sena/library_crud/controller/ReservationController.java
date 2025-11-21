package com.sena.library_crud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.library_crud.dto.ReservationDto;
import com.sena.library_crud.service.ReservationService;
import com.sena.library_crud.view.Views;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    @JsonView(Views.Public.class)
    public ResponseEntity<ReservationDto> create(@RequestBody @Valid ReservationDto dto) {
        return ResponseEntity.ok(reservationService.create(dto));
    }

    @PutMapping("/{id}/cancel")
    @JsonView(Views.Public.class)
    public ResponseEntity<ReservationDto> cancel(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.cancel(id));
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public ResponseEntity<List<ReservationDto>> getAll() {
        return ResponseEntity.ok(reservationService.getAll());
    }

    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}