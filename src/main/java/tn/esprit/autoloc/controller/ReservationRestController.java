package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.interfaces.IReservationService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private final IReservationService reservationService;

    // http://localhost:8089/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public HashSet<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    // http://localhost:8089/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    // http://localhost:8089/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    // http://localhost:8089/reservation/remove-reservation/8
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    // http://localhost:8089/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }
}