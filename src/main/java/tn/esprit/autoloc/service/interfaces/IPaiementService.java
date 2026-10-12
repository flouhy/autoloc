package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Paiement;

import java.util.HashSet;

public interface IPaiementService {
    public HashSet<Equipement> retrieveAllPaiements();
    public Equipement retrievePaiement(Long id);
    public Paiement addPaiement(Paiement paiement);
    public void removePaiement(Long id);
    public Paiement modifyPaiement(Paiement paiement);
}