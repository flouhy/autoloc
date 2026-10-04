package com.autoloc.entities;

import com.autoloc.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // ManyToOne : plusieurs réservations pour un client, colonne client_id dans reservation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // ManyToMany : côté inverse (la table de jointure est définie dans Vehicule)
    @ManyToMany(mappedBy = "reservations")
    private List<Vehicule> vehicules = new ArrayList<>();

    // OneToOne : une réservation donne lieu à un contrat (côté propriétaire)
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contrat contrat;
}