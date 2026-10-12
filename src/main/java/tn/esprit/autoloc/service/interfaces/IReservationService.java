package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Reservation;

import java.util.HashSet;

public interface IReservationService {
    HashSet<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long id);
    Reservation addReservation(Reservation reservation);
    void removeReservation(Long id);
    Reservation modifyReservation(Reservation reservation);
}