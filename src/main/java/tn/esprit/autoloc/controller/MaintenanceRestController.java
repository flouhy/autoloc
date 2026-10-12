package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.interfaces.IMaintenanceService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    // http://localhost:8089/maintenance/retrieve-all-maintenances
    @GetMapping("/retrieve-all-maintenances")
    public HashSet<Maintenance> getMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    // http://localhost:8089/maintenance/retrieve-maintenance/8
    @GetMapping("/retrieve-maintenance/{maintenance-id}")
    public Maintenance retrieveMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        return maintenanceService.retrieveMaintenance(maintenanceId);
    }

    // http://localhost:8089/maintenance/add-maintenance
    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    // http://localhost:8089/maintenance/remove-maintenance/8
    @DeleteMapping("/remove-maintenance/{maintenance-id}")
    public void removeMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        maintenanceService.removeMaintenance(maintenanceId);
    }

    // http://localhost:8089/maintenance/modify-maintenance
    @PutMapping("/modify-maintenance")
    public Maintenance modifyMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifyMaintenance(maintenance);
    }
}