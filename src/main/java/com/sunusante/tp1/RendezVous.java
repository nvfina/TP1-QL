package com.sunusante.tp1;

public class RendezVous {

    private final String patient;
    private final TypeConsultation type;
    private final String date;
    private final boolean vip;

    // prix réellement payé (avec réduction dégressive)
    private final double prix;

    // prix utilisé pour la facture historique
    private final double prixFacture;


    public RendezVous(String patient,
                      TypeConsultation type,
                      String date,
                      boolean vip,
                      double prix,
                      double prixFacture) {

        this.patient = patient;
        this.type = type;
        this.date = date;
        this.vip = vip;
        this.prix = prix;
        this.prixFacture = prixFacture;
    }


    public String getPatient() {
        return patient;
    }


    public TypeConsultation getType() {
        return type;
    }


    public String getDate() {
        return date;
    }


    public boolean estVip() {
        return vip;
    }


    public double getPrix() {
        return prix;
    }


    public double getPrixFacture() {
        return prixFacture;
    }
}