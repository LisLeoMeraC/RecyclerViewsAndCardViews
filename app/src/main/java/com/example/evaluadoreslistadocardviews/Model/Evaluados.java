package com.example.evaluadoreslistadocardviews.Model;

public class Evaluados {
    private String id, idEvaluado,nombres,genero,situacion,cargo,fechainicio,fechafin,imgJPG,imgjpg;

    public Evaluados() {
    }

    public Evaluados(String id, String idEvaluado, String nombres, String genero, String situacion, String cargo, String fechainicio, String fechafin, String imgJPG, String imgjpg) {
        this.id = id;
        this.idEvaluado = idEvaluado;
        this.nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEvaluado() {
        return idEvaluado;
    }

    public void setIdEvaluado(String idEvaluado) {
        this.idEvaluado = idEvaluado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public void setImgjpg(String imgjpg) {
        this.imgjpg = imgjpg;
    }
}
