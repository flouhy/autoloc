package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.service.interfaces.IPaiementService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public HashSet<Equipement> retrieveAllPaiements() {
        return new HashSet<>(paiementRepository.findAll());
    }


    public Equipement retrievePaiement(Long id) {
        return paiementRepository.findById(id).get();
    }


    public Paiement addPaiement(Paiement p) {
        return paiementRepository.save(p);
    }


    public void removePaiement(Long id) {
        paiementRepository.deleteById(id);
    }


    public Paiement modifyPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
}