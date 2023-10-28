package com.Reservation.Reservation.Service;

import com.Reservation.Reservation.Entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationServiceInterface {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
}
