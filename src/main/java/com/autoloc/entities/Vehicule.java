package com.autoloc.entities;

import com.autoloc.enums.CategorieVehicule;
import com.autoloc.enums.StatutVehicule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // ManyToOne : côté propriétaire, colonne agence_id dans la table vehicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // OneToMany : un véhicule peut avoir plusieurs maintenances
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    public void addMaintenance(Maintenance m) {
        maintenances.add(m);
        m.setVehicule(this);
    }

    public void removeMaintenance(Maintenance m) {
        maintenances.remove(m);
        m.setVehicule(null);
    }

    // ManyToMany : un véhicule peut avoir plusieurs équipements (table de jointure vehicule_equipement)
    @ManyToMany
    @JoinTable(
        name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "vehicule_id"),
        inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements = new ArrayList<>();

    public void addEquipement(Equipement e) {
        equipements.add(e);
        e.getVehicules().add(this);
    }

    public void removeEquipement(Equipement e) {
        equipements.remove(e);
        e.getVehicules().remove(this);
    }

    // ManyToMany : un véhicule peut être lié à plusieurs réservations (table de jointure vehicule_reservation)
    @ManyToMany
    @JoinTable(
        name = "vehicule_reservation",
        joinColumns = @JoinColumn(name = "vehicule_id"),
        inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation r) {
        reservations.add(r);
        r.getVehicules().add(this);
    }

    public void removeReservation(Reservation r) {
        reservations.remove(r);
        r.getVehicules().remove(this);
    }
}