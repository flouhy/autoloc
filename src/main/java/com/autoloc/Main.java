package com.autoloc;

import com.autoloc.entities.Agence;
import com.autoloc.entities.Employe;
import com.autoloc.enums.RoleEmploye;
import com.autoloc.entities.Vehicule;
import com.autoloc.enums.StatutVehicule;
import com.autoloc.enums.CategorieVehicule;
import java.math.BigDecimal;
import com.autoloc.entities.Maintenance;
import java.time.LocalDate;
import com.autoloc.entities.Contrat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Agence a = new Agence();
        a.setNom("Test");
        System.out.println(a.getNom());
        Employe e = new Employe();
        e.setRole(RoleEmploye.MANAGER);
        System.out.println(e.getRole());
        Vehicule v = new Vehicule();
        v.setMarque("Renault");
        v.setCategorie(CategorieVehicule.CITADINE);
        v.setTarifJournalier(new BigDecimal("45.50"));
        v.setStatut(StatutVehicule.DISPONIBLE);
        System.out.println(v);
        Maintenance m = new Maintenance();
        m.setDateDebut(LocalDate.of(2026, 9, 20));
        m.setDescription("Vidange");
        System.out.println(m);
        Contrat c = new Contrat();
        c.setValide(true);
        System.out.println(c.isValide());
    }
}