package com.example.evaluadoreslistadocardviews.Model;

public class Evaluador {
    private String ideva, nom, are, urlFotoPNG, urlFotopng;

    public Evaluador() {
    }

    public Evaluador(String ideva, String nom, String are, String urlFotoPNG, String urlFotopng) {
        this.ideva = ideva;
        this.nom = nom;
        this.are = are;
        this.urlFotoPNG = urlFotoPNG;
        this.urlFotopng = urlFotopng;
    }

    public String getIdeva() {
        return ideva;
    }

    public void setIdeva(String ideva) {
        this.ideva = ideva;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAre() {
        return are;
    }

    public void setAre(String are) {
        this.are = are;
    }

    public String getUrlFotoPNG() {
        return urlFotoPNG;
    }

    public void setUrlFotoPNG(String urlFotoPNG) {
        this.urlFotoPNG = urlFotoPNG;
    }

    public String getUrlFotopng() {
        return urlFotopng;
    }

    public void setUrlFotopng(String urlFotopng) {
        this.urlFotopng = urlFotopng;
    }
}
