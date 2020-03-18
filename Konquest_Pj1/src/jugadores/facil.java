/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import java.util.ArrayList;
import planetas.planeta_jugador;

/**
 *
 * @author jhonny
 */
public class facil  extends jugador{
    
    public facil(String jugador, ArrayList<planeta_jugador> planetas) {
        super(jugador, planetas);
        this.tipo="FACIL";
    }

    @Override
    double daño() {
        return 0.2;
    }
    
    
}
