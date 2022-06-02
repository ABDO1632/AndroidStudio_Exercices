package com.example.myapplication;

import java.io.Serializable;

public class ContactClass implements Serializable {
    private int image,id;
    private String Nom,Prenom,Email,Tel;
    public ContactClass(){

    }
    public ContactClass(int image, String nom, String prenom, String email, String tel) {
        this.image = image;
        Nom = nom;
        Prenom = prenom;
        Email = email;
        Tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}
