/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import static interfaz.inicio_partida.tablero;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import jugadores.jugador;
import mapa.juego;
import planetas.galaxia;
import planetas.planeta;
import planetas.planeta_jugador;

/**
 *
 * @author jhonny
 */
public class MouseControl implements MouseListener {

    galaxia origen, destino;
    juego juego;

    public MouseControl(juego juego) {
        this.juego = juego;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (inicio_partida.origenMov) {
            destino = (galaxia) me.getSource();
            int x = inicio_partida.count_player;
            if (!destino.getPlaneta().getDueño().equals(juego.getArray_jugadores().get(x).getJugador())) {
                inicio_partida.ininiar_O_D(origen, destino);
                inicio_partida.origenMov = false;
                inicio_partida.iniciarMov();
            } else {
                JOptionPane.showMessageDialog(inicio_partida.panel_tablero, "No se puede atacar a ud mismo ");
            }
        }
        if (inicio_partida.validarMov && !inicio_partida.medirDistancia) {
            int x = inicio_partida.count_player;
            galaxia e = (galaxia) me.getSource();
            if (!e.isEmpty()) {
                if (e.getPlaneta().getDueño().equals(juego.getArray_jugadores().get(x).getJugador())) {
                    inicio_partida.validarMov = false;
                    origen = (galaxia) me.getSource();
                    inicio_partida.realizarMovimiento();
                } else {
                    JOptionPane.showMessageDialog(inicio_partida.panel_tablero, "Seleccione donde el dueño se " + juego.getArray_jugadores().get(x).getJugador());
                }
            }

        }

        if (inicio_partida.destino) {
            inicio_partida.destino = false;
            destino = (galaxia) me.getSource();
            distancia distancia = new distancia(origen, destino);
            JOptionPane.showMessageDialog(inicio_partida.panel_tablero, distancia.getmsj());
            inicio_partida.validarMov = true;

        }
        if (inicio_partida.medirDistancia) {
            origen = (galaxia) me.getSource();
            JOptionPane.showMessageDialog(inicio_partida.panel_tablero, "Ahora seleccione el planeta destino");
            inicio_partida.destino = true;
            inicio_partida.medirDistancia = false;
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        int g = me.getButton();
        System.out.println(g);
        galaxia o = (galaxia) me.getSource();
        System.out.println(o.getPlaneta().getDueño());
        System.out.println(o.getPlaneta().getNombre());

        if (o.getPlaneta().getClass().equals(planeta_jugador.class)) {
            String player = inicio_partida.game.getArray_jugadores().get(inicio_partida.count_player).getJugador();

            if (player.equals(o.getPlaneta().getDueño())) {
                ToolTipManager.sharedInstance().setEnabled(true);
            }
        } else {
            String player = inicio_partida.game.getArray_jugadores().get(inicio_partida.count_player).getJugador();

            if (player.equals(o.getPlaneta().getDueño())) {
                 o.setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202); width:200px\">\n"
                    + "        <p style=\"color: black;\">\n"
                    + "        Nombre:" + o.getPlaneta().getNombre() + "\n"
                    + "        <br>\n"
                    + "        Dueño:" + o.getPlaneta().getDueño() + "\n"
                    + "        <br>\n"
                    + "        Naves:" + o.getPlaneta().getNaves() + "\n"
                    + "        <br>\n"
                    + "        Produccion:" + o.getPlaneta().getProduccion() + "\n"
                    + "        <br>\n"
                    + "        Muertes(%):" + o.getPlaneta().getMuertes() + "\n"
                    + "        </p>\n"
                    + "    </div></html>");
            }
            ToolTipManager.sharedInstance().setEnabled(true);
            
        }

    }

    @Override
    public void mouseExited(MouseEvent me) {
        ToolTipManager.sharedInstance().setEnabled(false);
    }

}
