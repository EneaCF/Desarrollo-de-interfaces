package com.enea.diej01v2.modelo;

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
