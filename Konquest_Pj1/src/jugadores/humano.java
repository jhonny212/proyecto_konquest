/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import classes.Turno;
import java.util.ArrayList;
import planetas.galaxia;
import planetas.planeta_jugador;

/**
 *
 * @author jhonny
 */
public class humano extends jugador {

    public humano(String jugador, ArrayList<planeta_jugador> planetas) {
        super(jugador, planetas);
        this.tipo = "HUMANO";

    }

    public humano(String jugador) {
        super(jugador);
    }

    /**
     *
     * @param string
     */
    @Override
    double daño() {
        return 0.1;
    }

    @Override
    galaxia getGalaxiaAtacante(galaxia[][] o, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno getTurno(galaxia[][] d, int x, int y, int turno, jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    galaxia getGalaxiaOponente(galaxia[][] d, int x, int y, galaxia origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
