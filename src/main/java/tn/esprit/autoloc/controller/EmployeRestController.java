package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.interfaces.IEmployeService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeRestController {

    private final IEmployeService employeService;

    // http://localhost:8089/employe/retrieve-all-employes
    @GetMapping("/retrieve-all-employes")
    public HashSet<Employe> getEmployes() {
        return employeService.retrieveAllEmployees();
    }

    // http://localhost:8089/employe/retrieve-employe/8
    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
        return employeService.retrieveEmploye(employeId);
    }

    // http://localhost:8089/employe/add-employe
    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    // http://localhost:8089/employe/remove-employe/8
    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long employeId) {
        employeService.removeEmploye(employeId);
    }

    // http://localhost:8089/employe/modify-employe
    @PutMapping("/modify-employe")
    public Employe modifyEmploye(@RequestBody Employe employe) {
        return employeService.modifyEmploye(employe);
    }
}