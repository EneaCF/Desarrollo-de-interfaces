package com.evtmallorca.diej01.dao;

/**
 *
 * @author Enea
 */
public class Municipi {
    
    private int id;
    private String nom;

    public Municipi() {
    }

    public Municipi(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
    
    

}
