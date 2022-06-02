package com.example.myapplication;

import java.io.Serializable;

public class ProduitsClass implements Serializable {
    public int id;
    public String Libelle,Famille;
    public double PrixAchat,PrixVente;
    public ProduitsClass() {

    }
    public ProduitsClass( String libelle, String famille, double prixAchat, double prixVente) {
        Libelle = libelle;
        Famille = famille;
        PrixAchat = prixAchat;
        PrixVente = prixVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getFamille() {
        return Famille;
    }

    public void setFamille(String famille) {
        Famille = famille;
    }

    public double getPrixAchat() {
        return PrixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        PrixAchat = prixAchat;
    }

    public double getPrixVente() {
        return PrixVente;
    }

    public void setPrixVente(double prixVente) {
        PrixVente = prixVente;
    }
}
