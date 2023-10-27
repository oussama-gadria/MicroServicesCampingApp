package com.Reservation.Reservation.Repository;

import com.Reservation.Reservation.Entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}