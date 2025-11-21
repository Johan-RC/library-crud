package com.sena.library_crud.enums;

public enum ReservationStatus {
    REQUESTED,   // Usuario solicita la reserva
    CONFIRMED,   // Sistema valida disponibilidad
    ACTIVE,      // Reserva vigente y lista para préstamo
    CANCELLED,   // Usuario o sistema cancela
    EXPIRED      // Reserva vencida por tiempo
}