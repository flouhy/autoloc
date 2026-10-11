package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @Column(nullable = false,length = 20)
    private LocalDate dateDebut;
    @Column(nullable = false,length = 20)
    private LocalDate dateFin;
    @Column(nullable = false,length = 20)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule;


}
