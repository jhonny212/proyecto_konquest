/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import static interfaz.inicio_partida.contadorDeTurnos;
import static interfaz.inicio_partida.count_player;
import static interfaz.inicio_partida.game;
import static interfaz.inicio_partida.turnos;
import java.awt.Color;

/**
 *
 * @author jhonny
 */
public class Replay extends Thread {

    public int time;

    @Override
    public void run() {
        method(0);
        int x = turnos.size();
        int y = game.getArray_jugadores().size();
        contadorDeTurnos = (int) x / y;

        for (int i = 0; i < turnos.size(); i++) {
            x -= y;
            if (x == y) {
                count_player = 0;
                break;
            } else if (x < y) {
                count_player = x;
                break;
            }
        }
        if ((contadorDeTurnos * y) < turnos.size()) {

            for (int i = (contadorDeTurnos * y); i < turnos.size(); i++) {
                for (int j = 0; j < turnos.get(i).getAtaques().size(); j++) {
                    int envio = turnos.get(i).getAtaques().get(j).getCant();
                    int posx = turnos.get(i).getAtaques().get(j).getO().getCoordx_();
                    int posy = turnos.get(i).getAtaques().get(j).getO().getCoordy_();
                    int naves = turnos.get(i).getAtaques().get(j).getO().getPlaneta().getNaves();
                    inicio_partida.tablero[posx][posy].getPlaneta().setNaves(naves - envio);
                    inicio_partida.reiniciar(posx, posy);
                    turnos.get(i).type = 0;

                }

            }

        } else {
        }

        inicio_partida.iniciarContadorPlayer();
    }

    public void esperarXsegundos() {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void method(int y) {
        int x = turnos.size() / game.getArray_jugadores().size();
       for (int i = 0; i < x; i++) {
            inicio_partida.mensajes_txt.setEditable(true);

            int x2 = i + 1;
            inicio_partida.mensajes_txt.append(Color.white, "Turno: " + x2 + " \n \n");

            if (!turnos.isEmpty()) {
                for (int j = 0; j < turnos.size(); j++) {
                    if (turnos.get(j).isValidar_()) {
                        turnos.get(j).type = 1;
                        turnos.get(j).realizarAtaque(x2);
                    }
                }
                turnos.get(0).construir(game.getMapa().isAcumular());
            }
            inicio_partida.mensajes_txt.setEditable(false);
            esperarXsegundos();
       }
    }
}
