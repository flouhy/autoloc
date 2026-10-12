package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Employe;

import java.util.HashSet;

public interface IEmployeService {
    public HashSet<Employe> retrieveAllEmployees();
    public Employe retrieveEmploye(Long id);
    public Employe modifyEmploye(Employe employe);
    public Employe addEmploye(Employe employe);
    public void removeEmploye(Long id);
}
