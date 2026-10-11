package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false,length = 20)
    private LocalDate dateDebut;
    @Column(nullable = false,length = 20)
    private LocalDate dateFin;
    @Column(nullable = false,length = 20)
    @Enumerated(EnumType.STRING)
    private StatutReservation statutReservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(fetch =  FetchType.LAZY)
    private Contrat contrat;

}
