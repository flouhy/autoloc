package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Contrat;

import java.util.HashSet;

public interface IContratService {
    public Contrat modifyContrat(Contrat contrat);
    public Contrat retrieveContrat(Long contratId);
    public HashSet<Contrat> retrieveAllContrats();
    public void removeContrat(Long contratId);
    public Contrat addContrat(Contrat contrat);
}
