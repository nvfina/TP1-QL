package com.sunusante.tp1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalculateurTarif {


    public double calculer(TypeConsultation type,
                           String date,
                           boolean vip,
                           int nombreRendezVous) {


        double prix = type.getTarifBase();


        LocalDate d = LocalDate.parse(date);


        // Majoration weekend
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY ||
                d.getDayOfWeek() == DayOfWeek.SUNDAY) {

            prix = prix + prix * 0.20;
        }


        // Réduction VIP
        if (vip) {

            prix = prix - prix * 0.10;
        }


        // Réduction dégressive
        if (nombreRendezVous >= 1) {

            prix = prix - prix * 0.15;
        }


        return prix;
    }
}