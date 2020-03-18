/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.awt.Dimension;
import planetas.planeta;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class mapa {
    private  String nombre;
    private  Dimension tamaño;
    private  boolean azar,mapaciego,acumular;
    private  int finalizacion,planetasNeutrales;
    private  planeta_neutral neutral;
    
    public mapa(String nombre, Dimension tamaño, boolean azar, boolean mapaciego, boolean acumular, int finalizacion, int planetasNeutrales, planeta_neutral neutral) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.azar = azar;
        this.mapaciego = mapaciego;
        this.acumular = acumular;
        this.finalizacion = finalizacion;
        this.planetasNeutrales = planetasNeutrales;
        this.neutral = neutral;
    }

    public String getNombre() {
        return nombre;
    }

    public Dimension getTamaño() {
        return tamaño;
    }

    public boolean isAzar() {
        return azar;
    }

    public boolean isMapaciego() {
        return mapaciego;
    }

    public boolean isAcumular() {
        return acumular;
    }

    public int getFinalizacion() {
        return finalizacion;
    }

    public int getPlanetasNeutrales() {
        return planetasNeutrales;
    }

    public planeta_neutral getNeutral() {
        return neutral;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamaño(Dimension tamaño) {
        this.tamaño = tamaño;
    }

    public void setAzar(boolean azar) {
        this.azar = azar;
    }

    public void setMapaciego(boolean mapaciego) {
        this.mapaciego = mapaciego;
    }

    public void setAcumular(boolean acumular) {
        this.acumular = acumular;
    }

    public void setFinalizacion(int finalizacion) {
        this.finalizacion = finalizacion;
    }

    public void setPlanetasNeutrales(int planetasNeutrales) {
        this.planetasNeutrales = planetasNeutrales;
    }

    public void setNeutral(planeta_neutral neutral) {
        this.neutral = neutral;
    }
    
}
