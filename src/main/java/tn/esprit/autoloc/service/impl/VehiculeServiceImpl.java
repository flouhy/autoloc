package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.service.interfaces.IVehiculeService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public HashSet<Vehicule> retrieveAllVehicules() {
        return new HashSet<>(vehiculeRepository.findAll());
    }

    @Override
    public Vehicule retrieveVehicule(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule modifyVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}