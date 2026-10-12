package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Agence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IAgenceService {
    public HashSet<Agence> retrieveAllAgences();
    public Agence retrieveAgence(Long agenceId);
    public Agence addAgence(Agence c);
    public void removeAgence(Long agenceId);
    public Agence modifyAgence(Agence agence);
}
