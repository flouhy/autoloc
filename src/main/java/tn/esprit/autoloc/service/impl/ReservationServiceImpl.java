package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.service.interfaces.IReservationService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public HashSet<Reservation> retrieveAllReservations() {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public Reservation retrieveReservation(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}