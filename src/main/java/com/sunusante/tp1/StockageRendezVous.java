package com.sunusante.tp1;

import java.util.ArrayList;
import java.util.List;

public class StockageRendezVous {


    private final List<RendezVous> rendezVous =
            new ArrayList<>();


    public void ajouter(RendezVous rdv) {

        rendezVous.add(rdv);
    }


    public List<RendezVous> getTous() {

        return rendezVous;
    }


    public int nombreRendezVous(String patient, String date) {

        int compteur = 0;


        for(RendezVous rdv : rendezVous){

            if(rdv.getPatient().equals(patient)
                    && rdv.getDate().equals(date)){

                compteur++;
            }
        }


        return compteur;
    }


    public void supprimer(String patient,String date){

        rendezVous.removeIf(
                rdv -> rdv.getPatient().equals(patient)
                        && rdv.getDate().equals(date)
        );
    }
}