package com.example.myapplication;

public class Etudiant {
    private String ident;
    private String nom;
    private String ville;
    private String dateNaissance;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Double getNoteFrns() {
        return noteFrns;
    }

    public void setNoteFrns(Double noteFrns) {
        this.noteFrns = noteFrns;
    }

    public Double getNotemath() {
        return notemath;
    }

    public void setNotemath(Double notemath) {
        this.notemath = notemath;
    }

    public Double getNotehist() {
        return notehist;
    }

    public void setNotehist(Double notehist) {
        this.notehist = notehist;
    }

    public Double getNotephys() {
        return notephys;
    }

    public void setNotephys(Double notephys) {
        this.notephys = notephys;
    }

    private Double noteFrns;
    private Double notemath;
    private Double notehist;
    private Double notephys;


    public Etudiant(){}

    public Etudiant(String ident, String nom, String ville, String dateNaissance, Double noteFrns, Double notemath, Double notehist, Double notephys) {
        this.ident = ident;
        this.nom = nom;
        this.ville = ville;
        this.dateNaissance = dateNaissance;
        this.noteFrns = noteFrns;
        this.notemath = notemath;
        this.notehist = notehist;
        this.notephys = notephys;
    }

}
