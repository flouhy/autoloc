package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.service.interfaces.IMaintenanceService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public HashSet<Maintenance> retrieveAllMaintenances() {
        return new HashSet<>(maintenanceRepository.findAll());
    }

    @Override
    public Maintenance retrieveMaintenance(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void removeMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance modifyMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
}