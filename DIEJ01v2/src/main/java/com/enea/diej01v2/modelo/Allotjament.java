/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enea.diej01v2.modelo;

import com.enea.diej01v2.controlador.Controlador;

/**
 *
 * @author Enea
 */
public class Allotjament {
    
    private int id;
    private String nom;
    private String descripcio;
    private String adresa;
    private String municipi;
    private int num_persones;
    private float preu_per_nit;

    public Allotjament() {
    }

    
    public Allotjament(int id, String nom, String descripcio, String adresa, String municipi, int num_persones, float preu_per_nit) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.adresa = adresa;
        this.municipi = municipi;
        this.num_persones = num_persones;
        this.preu_per_nit = preu_per_nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public int getNum_persones() {
        return num_persones;
    }

    public void setNum_persones(int num_persones) {
        this.num_persones = num_persones;
    }

    public float getPReu_per_nit() {
        return preu_per_nit;
    }

    public void setPreu_per_nit(float preu_per_nit) {
        this.preu_per_nit = preu_per_nit;
    }
    

    @Override
    public String toString() {
        return "Allotjament{" + "id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", adresa=" + adresa + ", municipi=" + municipi + ", num_persones=" + num_persones + ", preu_per_nit=" + preu_per_nit + '}';
    }

    int getId_municipi() {
        return 2;
    }

    int getId_propietari() {
        return Controlador.usuario.getId();
    }

}
