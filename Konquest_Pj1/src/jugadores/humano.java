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
public class humano extends jugador{
    
    public humano(String jugador, ArrayList<planeta_jugador> planetas) {
        super(jugador, planetas);
        this.tipo="HUMANO";
    }

    @Override
    double daño() {
    return 0.1;
    }


   
    
}
