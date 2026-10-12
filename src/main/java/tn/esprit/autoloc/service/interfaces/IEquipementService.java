package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Equipement;

import java.util.HashSet;

public interface IEquipementService {
    public HashSet<Equipement> retrieveAllEquipements();
    public Equipement retrieveEquipement(Long id);
    public Equipement addEquipement(Equipement equipement);
    void removeEquipement(Long id);
    public Equipement modifyEquipement(Equipement equipement);
}
