package com.example.myparis2024_sio2a;

public class Inscription {
    private int idInscription;
    private String dateInscription, statut;
    private int idUser, idEvenement;

    public Inscription(int idInscription, String dateInscription,
                       String statut,int idUser,int idEvenement)
    {
        this.idInscription = idInscription;
        this.dateInscription = dateInscription;
        this.statut = statut;
        this.idUser = idUser;
        this.idEvenement = idEvenement;
    }

    public Inscription(String dateInscription,
                       String statut,int idUser,int idEvenement)
    {
        this.idInscription = 0;
        this.dateInscription = dateInscription;
        this.statut = statut;
        this.idUser = idUser;
        this.idEvenement = idEvenement;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }
}
