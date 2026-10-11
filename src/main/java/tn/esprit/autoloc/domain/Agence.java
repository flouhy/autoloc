package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, unique = true, length = 20)
    private String telephone;

    @Column(nullable = false, length = 50)
    private String adresse;

    @OneToMany(mappedBy = "agence")
    private Set<Vehicule> vehicules;

    @OneToMany(mappedBy = "agence")
    private Set<Employe> employees;



}
