package com.example.myapplication;

public class Utilisateur {
    private  String login;
    private String motpass;
    public Utilisateur() {

    }
    public Utilisateur(String login, String motpass) {
        this.login = login;
        this.motpass = motpass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotpass() {
        return motpass;
    }

    public void setMotpass(String motpass) {
        this.motpass = motpass;
    }
}
