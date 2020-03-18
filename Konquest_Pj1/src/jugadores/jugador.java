/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import java.awt.Color;
import java.util.ArrayList;
import planetas.planeta_jugador;

/**
 *
 * @author jhonny
 */
abstract public class jugador {

    private String jugador;
    private ArrayList<planeta_jugador> planetas;
    protected String tipo;
    private boolean validarJuego;
    private String msj;
    private Color color;
    abstract double daño();
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
         iniciarColores();
    }
    
    public jugador(String jugador, ArrayList<planeta_jugador> planetas) {
        this.jugador = jugador;
        this.planetas = planetas;
        color=Color.green;
        iniciarColores();
    }
    
    public void iniciarColores(){
        for (int i = 0; i < planetas.size(); i++) {
            planetas.get(i).setColor(color);
            
        }
    }
    
    public String getJugador() {
        return jugador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public ArrayList<planeta_jugador> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<planeta_jugador> planetas) {
        this.planetas = planetas;
    }

    public boolean isValidarJuego() {
        return validarJuego;
    }

    public String getMsj() {
        return msj;
    }

    public void validar() {
        String namesPlanets = "";
        validarJuego = true;
        msj = "";
        for (int i = 0; i < planetas.size(); i++) {
            if (namesPlanets.contains(planetas.get(i).getNombre())) {
                msj += " VERIFIQUE LOS NOMBRES DE PLANETAS EN EL APARTADO DE JUGADORES, PARA QUE NO SE REPITAN \n";
                validarJuego = false;
                break;
            } else {
                namesPlanets += planetas.get(i).getNombre() + " ";
            }
        }
    }
  
}
