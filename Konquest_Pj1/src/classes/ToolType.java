/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static interfaz.inicio_partida.game;
import static interfaz.inicio_partida.tablero;
import javax.swing.ToolTipManager;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class ToolType {
 int i,j;

    public ToolType(int i, int j) {
        this.i = i;
        this.j = j;
    }
 
    public void restar(){
      if (tablero[i][j].getPlaneta().getClass().equals(planeta_neutral.class
        )) {

            if (game.getMapa().getNeutral().isMostrarNaves() && game.getMapa().getNeutral().isMostrarEstadisticas()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Dueño:" + tablero[i][j].getPlaneta().getDueño() + "\n"
                        + "        <br>\n"
                        + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                        + "        <br>\n"
                        + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                        + "        <br>\n"
                        + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                        + "        </p>\n"
                        + "    </div></html>");

            }
          else  if (game.getMapa().getNeutral().isMostrarEstadisticas()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Dueño:" + tablero[i][j].getPlaneta().getDueño() + "\n"
                        + "        <br>\n"
                        + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                        + "        <br>\n"
                        + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                        + "        </p>\n"
                        + "    </div></html>");

            }
         else   if (game.getMapa().getNeutral().isMostrarNaves()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                        + "        <br>\n"
                        + "        </p>\n"
                        + "    </div></html>");

            }

        } else if (tablero[i][j].getPlaneta().getClass().equals(planeta_jugador.class
        )) {

            tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202); width:200px\">\n"
                    + "        <p style=\"color: black;\">\n"
                    + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                    + "        <br>\n"
                    + "        Dueño:" + tablero[i][j].getPlaneta().getDueño() + "\n"
                    + "        <br>\n"
                    + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                    + "        <br>\n"
                    + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                    + "        <br>\n"
                    + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                    + "        </p>\n"
                    + "    </div></html>");
            
        }
        if (game.getMapa().isMapaciego()) {
                ToolTipManager.sharedInstance().setEnabled(false);
            }
    }
}
