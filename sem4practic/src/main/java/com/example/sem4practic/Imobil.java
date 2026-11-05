package com.example.sem4practic;

import android.os.Parcel;
import android.os.Parcelable;

//import java.io.Serializable;

public class Imobil implements Parcelable {
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

    protected Imobil(Parcel in) {
        adresa = in.readString();
        areParcare = in.readByte() != 0;
        tip = in.readString();
        oras = in.readString();
        conditiiRating = in.readFloat();
        esteMobilat = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adresa);
        dest.writeByte((byte) (areParcare ? 1 : 0));
        dest.writeString(tip);
        dest.writeString(oras);
        dest.writeFloat(conditiiRating);
        dest.writeByte((byte) (esteMobilat ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Imobil> CREATOR = new Creator<Imobil>() {
        @Override
        public Imobil createFromParcel(Parcel in) {
            return new Imobil(in);
        }

        @Override
        public Imobil[] newArray(int size) {
            return new Imobil[size];
        }
    };

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

    public boolean isAreParcare() {
        return areParcare;
    }

    public void setAreParcare(boolean areParcare) {
        this.areParcare = areParcare;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public float getConditiiRating() {
        return conditiiRating;
    }

    public void setConditiiRating(float conditiiRating) {
        this.conditiiRating = conditiiRating;
    }

    public boolean isEsteMobilat() {
        return esteMobilat;
    }

    public void setEsteMobilat(boolean esteMobilat) {
        this.esteMobilat = esteMobilat;
    }

    public String getNume() {
        return tip + " - " + oras;
    }

    public String getDetalii() {
        return "Adresă: " + adresa + " | Rating: " + conditiiRating + "★";
    }


    public String getFacilitati() {
        return "Parcare: " + (areParcare ? "Da" : "Nu") + " | Mobilat: " + (esteMobilat ? "Da" : "Nu");
    }
}