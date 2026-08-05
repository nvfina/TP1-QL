package com.sunusante.tp1;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Filet de tests de caractérisation : ils décrivent le comportement ACTUEL
 * du code (avant tout refactoring) pour que vous puissiez le modifier en
 * confiance. Ne les supprimez pas, ne changez pas leurs attentes : s'ils
 * cassent après un refactoring, c'est que le comportement a changé, pas
 * seulement le code.
 *
 * Rappel des dates utilisées : le 21/07/2026 est un mardi (jour de semaine),
 * le 25/07/2026 est un samedi (weekend).
 */
class GestionRendezVousTest {

    @Test
    void ajouterRendezVous_generaliste_semaine_tarifDeBase() {
        GestionRendezVous g = new GestionRendezVous();
        double prix = g.ajouterRendezVous("Awa Ndiaye", "GENERALISTE", "2026-07-21", false);
        assertEquals(5000, prix);
    }

    @Test
    void ajouterRendezVous_specialiste_weekend_majore() {
        GestionRendezVous g = new GestionRendezVous();
        double prix = g.ajouterRendezVous("Awa Ndiaye", "SPECIALISTE", "2026-07-25", false);
        assertEquals(12000, prix); // 10000 + 20% de majoration weekend
    }

    @Test
    void ajouterRendezVous_urgence_vip_reduit() {
        GestionRendezVous g = new GestionRendezVous();
        double prix = g.ajouterRendezVous("Moussa Fall", "URGENCE", "2026-07-21", true);
        assertEquals(13500, prix); // 15000 - 10% de réduction VIP
    }

    @Test
    void calculerTotalFacture_sommeLesRendezVousDuPatient() {
        GestionRendezVous g = new GestionRendezVous();
        g.ajouterRendezVous("Awa Ndiaye", "GENERALISTE", "2026-07-21", false); // 5000
        g.ajouterRendezVous("Awa Ndiaye", "SPECIALISTE", "2026-07-21", false); // 10000
        assertEquals(15000, g.calculerTotalFacture("Awa Ndiaye"));
    }

    // TODO (TP1, étape TDD) : écrivez ici vos tests pour le tarif dégressif

    @Test
    void tarifDegressif() {
        GestionRendezVous gestion = new GestionRendezVous();


        // 1e rendez-vous
        double premierRv = gestion.ajouterRendezVous(
                "Awa Niang",
                "GENERALISTE",
                "2026-07-21",
                false
        );

        // 2e rendez-vous : même patient, même date
        double deuxiemeRv = gestion.ajouterRendezVous(
                "Awa Niang",
                "GENERALISTE",
                "2026-07-21",
                false
        );

        assertEquals(5000, premierRv);  //verifie si la valeur obtenue est egale a la valeur attendue
        assertEquals(4250, deuxiemeRv);


    }
    // du 2e rendez-vous du même patient le même jour, AVANT d'implémenter la
    // fonctionnalité dans GestionRendezVous (cycle RED -> GREEN -> REFACTOR).
}
