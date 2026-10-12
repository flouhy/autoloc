package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.interfaces.IPaiementService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private final IPaiementService paiementService;

    // http://localhost:8089/paiement/retrieve-all-paiements
    @GetMapping("/retrieve-all-paiements")
    public HashSet<Equipement> getPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    // http://localhost:8089/paiement/retrieve-paiement/8
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public Equipement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        return paiementService.retrievePaiement(paiementId);
    }

    // http://localhost:8089/paiement/add-paiement
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    // http://localhost:8089/paiement/remove-paiement/8
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.removePaiement(paiementId);
    }

    // http://localhost:8089/paiement/modify-paiement
    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifyPaiement(paiement);
    }
}