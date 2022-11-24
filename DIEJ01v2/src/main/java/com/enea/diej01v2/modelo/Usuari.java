
package com.enea.diej01v2.modelo;

/**
 *
 * @author Enea
 */
public class Usuari {
    
    private int id;
    private String nom;
    private String llinatges;
    private String email;
    private String password;
    private Boolean admin;

    public Usuari() {
    }

    public Usuari(int id, String nom, String llinatges, String email, String password, Boolean admin) {
        this.id = id;
        this.nom = nom;
        this.llinatges = llinatges;
        this.email = email;
        this.password = password;
        this.admin = admin;
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

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuari{" + "id=" + id + ", nom=" + nom + ", llinatges=" + llinatges + ", email=" + email + ", password=" + password + ", admin=" + admin + '}';
    }
    
}
