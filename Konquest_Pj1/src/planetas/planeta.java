/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas;

import java.awt.Color;

/**
 *
 * @author jhonny
 */
abstract public class planeta {
    protected String dueño="";
    protected int x_,y_;
    protected  int inicial;

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int getInicial() {
        return inicial;
    }

    
    public int getX_() {
        return x_;
    }

    public void setX_(int x_) {
        this.x_ = x_;
    }

    public int getY_() {
        return y_;
    }

    public void setY_(int y_) {
        this.y_ = y_;
    }
    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
    private  boolean mostrarNaves, mostrarEstadisticas;
    private int produccion;
    protected int naves;
    protected double muertes;
    protected String nombre;
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setProduccion(int produccion) {
        this.produccion = produccion;
     
    }

    public void setMostrarNaves(boolean mostrarNaves) {
        this.mostrarNaves = mostrarNaves;
    }

    public void setMostrarEstadisticas(boolean mostrarEstadisticas) {
        this.mostrarEstadisticas = mostrarEstadisticas;
    }

    public void setNaves(int naves) {
        this.naves = naves;
    }

    public void setMuertes(double muertes) {
        this.muertes = muertes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public planeta(boolean mostrarNaves, boolean mostrarEstadisticas, int produccion) {
        this.mostrarNaves = mostrarNaves;
        this.mostrarEstadisticas = mostrarEstadisticas;
        this.produccion = produccion;
    }

    public planeta() {
        this.produccion = 0;
        this.mostrarEstadisticas = false;
        this.mostrarNaves = false;
    }

    public boolean isMostrarNaves() {
        return mostrarNaves;
    }

    public boolean isMostrarEstadisticas() {
        return mostrarEstadisticas;
    }

    public int getProduccion() {
        return produccion;
    }

    public int getNaves() {
        return naves;
    }

    public double getMuertes() {
        return muertes;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract Color getColorPlaneta();
}
