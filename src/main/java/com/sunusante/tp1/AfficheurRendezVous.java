package com.sunusante.tp1;

public class AfficheurRendezVous {


    public void afficher(StockageRendezVous stockage) {


        for (RendezVous rdv : stockage.getTous()) {


            System.out.println(
                    rdv.getPatient()
                            + " | "
                            + rdv.getType()
                            + " | "
                            + rdv.getDate()
                            + " | VIP="
                            + rdv.estVip()
                            + " | "
                            + rdv.getPrix()
                            + " FCFA"
            );
        }
    }
}