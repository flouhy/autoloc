package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.service.interfaces.IAgenceService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    public final AgenceRepository agenceRepository;
    @Override
    public HashSet<Agence> retrieveAllAgences() {
        return new HashSet<>(agenceRepository.findAll());
    }
    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId).get();
    }
    public Agence addAgence(Agence c) {
        return agenceRepository.save(c);
    }
    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }
    public Agence modifyAgence(Agence agence){
        return agenceRepository.save(agence);
    }

}
