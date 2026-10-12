package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.interfaces.IAgenceService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    private final IAgenceService agenceService;

    // http://localhost:8089/agence/retrieve-all-agences
    @GetMapping("/retrieve-all-agences")
    public HashSet<Agence> getAgences() {
        return agenceService.retrieveAllAgences();
    }

    // http://localhost:8089/agence/retrieve-agence/8
    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        return agenceService.retrieveAgence(agenceId);
    }

    // http://localhost:8089/agence/add-agence
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    // http://localhost:8089/agence/remove-agence/8
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.removeAgence(agenceId);
    }

    // http://localhost:8089/agence/modify-agence
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence agence) {
        return agenceService.modifyAgence(agence);
    }
}