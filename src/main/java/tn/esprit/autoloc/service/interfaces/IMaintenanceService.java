package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.HashSet;

public interface IMaintenanceService {
    public HashSet<Maintenance> retrieveAllMaintenances();
    public Maintenance retrieveMaintenance(Long id);
    public Maintenance addMaintenance(Maintenance maintenance);
    public void removeMaintenance(Long id);
    public Maintenance modifyMaintenance(Maintenance maintenance);
}