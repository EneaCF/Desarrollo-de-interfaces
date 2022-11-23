/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evtmallorca.diej01.dao;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Enea
 */
class Comentari {
    
    private int id;
    private String text;
    private LocalDateTime dataihora;
    private String usuari;
    private int idAllotjament;
    private int idComentariPare;

    public Comentari() {
    }

    public Comentari(int id, String text, LocalDateTime dataihora, String usuari, int idAllotjament, int idComentariPare) {
        this.id = id;
        this.text = text;
        this.dataihora = dataihora;
        this.usuari = usuari;
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

    public LocalDateTime getDataihora() {
        return dataihora;
    }

    public void setDataihora(LocalDateTime dataihora) {
        this.dataihora = dataihora;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
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
        return "Comentari{" + "id=" + id + ", text=" + text + ", dataihora=" + dataihora + ", usuari=" + usuari + ", idAllotjament=" + idAllotjament + ", idComentariPare=" + idComentariPare + '}';
    }
    
    
    
    
}
