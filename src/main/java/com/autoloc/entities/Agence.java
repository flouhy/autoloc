package com.autoloc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    // Côté inverse : pas de colonne, on lit l'attribut "agence" d'Employe
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employe> employes = new ArrayList<>();

    public void addEmploye(Employe e) {
        employes.add(e);
        e.setAgence(this);
    }

    public void removeEmploye(Employe e) {
        employes.remove(e);
        e.setAgence(null);
    }
    // Côté inverse : pas de colonne créée
    @OneToMany(mappedBy = "agence", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vehicule> vehicules = new ArrayList<>();

    public void addVehicule(Vehicule v) {
        vehicules.add(v);
        v.setAgence(this);
    }

    public void removeVehicule(Vehicule v) {
        vehicules.remove(v);
        v.setAgence(null);
    }
}