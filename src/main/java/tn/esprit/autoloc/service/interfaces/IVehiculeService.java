package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.HashSet;

public interface IVehiculeService {
    HashSet<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long id);
    Vehicule addVehicule(Vehicule vehicule);
    void removeVehicule(Long id);
    Vehicule modifyVehicule(Vehicule vehicule);
}