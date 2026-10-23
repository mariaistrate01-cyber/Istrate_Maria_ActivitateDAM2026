package com.example.sem4practic;

import java.io.Serializable;

public class Imobil implements Serializable {
    private String adresa;
    private boolean areParcare;
    private String tip;
    private String oras;
    private float conditiiRating;
    private boolean esteMobilat;

    public Imobil(String adresa, boolean areParcare, String tip, String oras, float conditiiRating, boolean esteMobilat) {
        this.adresa = adresa;
        this.areParcare = areParcare;
        this.tip = tip;
        this.oras = oras;
        this.conditiiRating = conditiiRating;
        this.esteMobilat = esteMobilat;
    }

    @Override
    public String toString() {
        return "Imobil{" +
                "adresa='" + adresa + '\'' +
                ", parcare=" + (areParcare ? "Da" : "Nu") +
                ", tip='" + tip + '\'' +
                ", oras='" + oras + '\'' +
                ", rating=" + conditiiRating +
                " stele, mobilat=" + (esteMobilat ? "Da" : "Nu") +
                '}';
    }
}