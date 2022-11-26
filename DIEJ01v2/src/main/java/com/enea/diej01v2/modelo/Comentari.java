/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enea.diej01v2.modelo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Enea
 */
public class Comentari {
    
    private int id;
    private String text;
    private String dataihora;
    private int idUsuari;
    private int idAllotjament;
    private int idComentariPare;

    public Comentari() {
    }

    public Comentari(int id, String text, String dataihora, int idUsuari, int idAllotjament, int idComentariPare) {
        this.id = id;
        this.text = text;
        this.dataihora = dataihora;
        this.idUsuari = idUsuari;
        this.idAllotjament = idAllotjament;
        this.idComentariPare = idComentariPare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDataihora() {
        return dataihora;
    }

    public void setDataihora(String dataihora) {
        this.dataihora = dataihora;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdAllotjament() {
        return idAllotjament;
    }

    public void setIdAllotjament(int idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    public int getIdComentariPare() {
        return idComentariPare;
    }

    public void setIdComentariPare(int idComentariPare) {
        this.idComentariPare = idComentariPare;
    }

    @Override
    public String toString() {
        return "Comentari{" + "id=" + id + ", text=" + text + ", dataihora=" + dataihora + ", usuari=" + idUsuari + ", idAllotjament=" + idAllotjament + ", idComentariPare=" + idComentariPare + '}';
    }
    
    
    
    
}
