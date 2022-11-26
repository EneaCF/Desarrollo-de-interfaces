
package com.enea.diej01v2.modelo;

/**
 *
 * @author Enea
 */
public class Servei {
    private int id;
    private String descripcio;

    public Servei() {
    }

    public Servei(int id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Servei{" + "id=" + id + ", descripcio=" + descripcio + '}';
    }
    
    
}
