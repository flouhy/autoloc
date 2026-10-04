package com.autoloc;

import com.autoloc.entities.*;
import com.autoloc.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PersistenceContext
    private EntityManager em;

    @Bean
    @Transactional
    public CommandLineRunner demo() {
        return args -> {

            // ── 1. Agence ────────────────────────────────────────────────
            Agence agence = new Agence();
            agence.setNom("AutoLoc Paris");
            agence.setVille("Paris");
            agence.setAdresse("10 rue de la Paix");
            agence.setTelephone("0102030405");
            em.persist(agence);

            // ── 2. Employe ───────────────────────────────────────────────
            Employe agent = new Employe();
            agent.setNom("Dupont");
            agent.setPrenom("Jean");
            agent.setRole(RoleEmploye.AGENT);
            agence.addEmploye(agent);
            em.persist(agent);

            Employe manager = new Employe();
            manager.setNom("Martin");
            manager.setPrenom("Sophie");
            manager.setRole(RoleEmploye.MANAGER);
            agence.addEmploye(manager);
            em.persist(manager);

            // ── 3. Equipements ───────────────────────────────────────────
            Equipement gps = new Equipement();
            gps.setLibelle("GPS");
            em.persist(gps);

            Equipement siege = new Equipement();
            siege.setLibelle("Siège bébé");
            em.persist(siege);

            // ── 4. Vehicule ──────────────────────────────────────────────
            Vehicule v1 = new Vehicule();
            v1.setImmatriculation("AB-123-CD");
            v1.setMarque("Renault");
            v1.setModele("Clio");
            v1.setCategorie(CategorieVehicule.CITADINE);
            v1.setTarifJournalier(new BigDecimal("45.00"));
            v1.setStatut(StatutVehicule.DISPONIBLE);
            agence.addVehicule(v1);
            v1.addEquipement(gps);
            v1.addEquipement(siege);
            em.persist(v1);

            Vehicule v2 = new Vehicule();
            v2.setImmatriculation("EF-456-GH");
            v2.setMarque("Peugeot");
            v2.setModele("508");
            v2.setCategorie(CategorieVehicule.BERLINE);
            v2.setTarifJournalier(new BigDecimal("80.00"));
            v2.setStatut(StatutVehicule.DISPONIBLE);
            agence.addVehicule(v2);
            v2.addEquipement(gps);
            em.persist(v2);

            // ── 5. Maintenance ───────────────────────────────────────────
            Maintenance m1 = new Maintenance();
            m1.setDateDebut(LocalDate.of(2024, 1, 10));
            m1.setDateFin(LocalDate.of(2024, 1, 12));
            m1.setDescription("Vidange + révision");
            v1.addMaintenance(m1);
            em.persist(m1);

            // ── 6. Client ────────────────────────────────────────────────
            Client client = new Client();
            client.setNom("Durand");
            client.setPrenom("Alice");
            client.setEmail("alice@example.com");
            client.setTelephone("0611223344");
            client.setNumPermis("P-987654");
            client.setDateInscription(LocalDate.of(2023, 6, 1));
            em.persist(client);

            // ── 7. Reservation ───────────────────────────────────────────
            Reservation resa = new Reservation();
            resa.setDateDebut(LocalDate.of(2024, 3, 1));
            resa.setDateFin(LocalDate.of(2024, 3, 7));
            resa.setStatut(StatutReservation.CONFIRMEE);
            client.addReservation(resa);
            v1.addReservation(resa);
            em.persist(resa);

            // ── 8. Contrat ───────────────────────────────────────────────
            Contrat contrat = new Contrat();
            contrat.setDateSignature(LocalDate.of(2024, 3, 1));
            contrat.setMontantTotal(new BigDecimal("315.00")); // 7j × 45€
            contrat.setValide(true);
            contrat.setReservation(resa);
            em.persist(contrat);

            // ── 9. Paiement ──────────────────────────────────────────────
            Paiement p1 = new Paiement();
            p1.setMontant(new BigDecimal("315.00"));
            p1.setDatePaiement(LocalDate.of(2024, 3, 1));
            p1.setModePaiement(ModePaiement.CARTE);
            contrat.addPaiement(p1);
            em.persist(p1);

            em.flush();

            // ── Affichage récapitulatif ───────────────────────────────────
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║         DONNÉES PERSISTÉES AVEC SUCCÈS       ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println("🏢 Agence    : " + agence.getNom() + " (id=" + agence.getIdAgence() + ")");
            System.out.println("👷 Employés  : " + agence.getEmployes().size());
            System.out.println("🚗 Véhicules : " + agence.getVehicules().size());
            System.out.println("🔧 Maintenance sur " + v1.getMarque() + " : " + v1.getMaintenances().size());
            System.out.println("📦 Équipements sur " + v1.getMarque() + " : " + v1.getEquipements().size());
            System.out.println("👤 Client    : " + client.getNom() + " " + client.getPrenom());
            System.out.println("📅 Réservation du " + resa.getDateDebut() + " au " + resa.getDateFin());
            System.out.println("📄 Contrat   : " + contrat.getMontantTotal() + "€ — valide=" + contrat.isValide());
            System.out.println("💳 Paiement  : " + p1.getMontant() + "€ par " + p1.getModePaiement());
            System.out.println("🌐 Console H2 → http://localhost:8080/h2-console  (JDBC URL: jdbc:h2:mem:autoloc)\n");
        };
    }
}