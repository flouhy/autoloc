package tn.esprit.autoloc.service.impl;


import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.service.interfaces.IEquipementService;

import java.util.HashSet;

public class EquipementServiceImpl implements IEquipementService {
    EquipementRepository equipementRepository;
    public HashSet<Equipement> retrieveAllEquipements() {
        return new HashSet<>(equipementRepository.findAll());
    }
    public Equipement retrieveEquipement(Long id) {
        return equipementRepository.findById(id).get();
    }
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);

    }
    public void removeEquipement(Long id) {
        equipementRepository.deleteById(id);

    }
    public Equipement modifyEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

}
