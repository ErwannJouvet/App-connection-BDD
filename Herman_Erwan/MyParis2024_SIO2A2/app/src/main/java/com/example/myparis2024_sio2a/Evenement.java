package com.example.myparis2024_sio2a;

public class Evenement {
    private int idevenement, nbPlaces;
    private float prix;
    private String designation, lieu, dateEvent, heureEvent;

    public Evenement(int idevenement, int nbPlaces, float prix, String designation, String lieu, String dateEvent, String heureEvent) {
        this.idevenement = idevenement;
        this.nbPlaces = nbPlaces;
        this.prix = prix;
        this.designation = designation;
        this.lieu = lieu;
        this.dateEvent = dateEvent;
        this.heureEvent = heureEvent;
    }

    public Evenement(int nbPlaces, float prix, String designation, String lieu, String dateEvent, String heureEvent) {
        this.idevenement = 0;
        this.nbPlaces = nbPlaces;
        this.prix = prix;
        this.designation = designation;
        this.lieu = lieu;
        this.dateEvent = dateEvent;
        this.heureEvent = heureEvent;
    }

    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getHeureEvent() {
        return heureEvent;
    }

    public void setHeureEvent(String heureEvent) {
        this.heureEvent = heureEvent;
    }
}
