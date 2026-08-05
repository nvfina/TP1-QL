package com.sunusante.tp1;

public enum TypeConsultation {

    GENERALISTE(5000),
    SPECIALISTE(10000),
    URGENCE(15000);

    private final double tarifBase;


    TypeConsultation(double tarifBase) {
        this.tarifBase = tarifBase;
    }


    public double getTarifBase() {
        return tarifBase;
    }
}