package Controller;

import Entity.Reservation;
import Service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationServiceInterface ReservationService;

    @PostMapping("/createReservation")
    public Reservation createReservation(@RequestBody Reservation R) {
        return ReservationService.createReservation(R);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return ReservationService.getAllReservations();
    }

    @GetMapping("/getReservationById/{id}")
    public Reservation getReservationById(@PathVariable("id") Long Id) {
        return ReservationService.getReservationById(Id).get();
    }

    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") Long Id, @RequestBody Reservation R) {
        return ReservationService.updateReservation(Id, R);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable("id") Long Id) {
        ReservationService.deleteReservation(Id);
    }

}
