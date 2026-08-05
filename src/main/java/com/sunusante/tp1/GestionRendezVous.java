package com.sunusante.tp1;

public class GestionRendezVous {


    private final StockageRendezVous stockage;
    private final CalculateurTarif calculateur;
    private final AfficheurRendezVous afficheur;


    public GestionRendezVous(){

        stockage = new StockageRendezVous();
        calculateur = new CalculateurTarif();
        afficheur = new AfficheurRendezVous();
    }



    public double ajouterRendezVous(String patient,
                                    String type,
                                    String date,
                                    boolean estVip){


        if(patient == null || patient.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "Le nom du patient est obligatoire"
            );
        }


        if(date == null || date.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "La date est obligatoire"
            );
        }


        TypeConsultation consultation =
                TypeConsultation.valueOf(type);



        int nombre =
                stockage.nombreRendezVous(patient,date);



        // Prix avec réduction dégressive
        double prix =
                calculateur.calculer(
                        consultation,
                        date,
                        estVip,
                        nombre
                );



        // Prix sans réduction dégressive
        double prixFacture =
                calculateur.calculer(
                        consultation,
                        date,
                        estVip,
                        0
                );



        RendezVous rdv =
                new RendezVous(
                        patient,
                        consultation,
                        date,
                        estVip,
                        prix,
                        prixFacture
                );


        stockage.ajouter(rdv);


        System.out.println(
                "Rendez-vous ajouté pour "
                        + patient
                        + " ("
                        + type
                        + ") le "
                        + date
                        + " - "
                        + prix
                        + " FCFA"
        );


        return prix;
    }




    public double calculerTotalFacture(String patient){


        double total = 0;


        for(RendezVous rdv : stockage.getTous()){


            if(rdv.getPatient().equals(patient)){


                total += rdv.getPrixFacture();

            }
        }


        return total;
    }




    public int nombreRendezVous(String patient,String date){

        return stockage.nombreRendezVous(patient,date);
    }




    public void annulerRendezVous(String patient,String date){

        stockage.supprimer(patient,date);
    }




    public void afficherRendezVous(){

        afficheur.afficher(stockage);

    }
}