package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.interfaces.IEmployeService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public HashSet<Employe> retrieveAllEmployees() {
        return new HashSet<>(employeRepository.findAll());
    }


    public Employe retrieveEmploye(Long id) {
        return employeRepository.findById(id).orElse(null);
    }


    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }


    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }


    public void removeEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}