/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static interfaz.inicio_partida.columnas;
import static interfaz.inicio_partida.filas;
import static interfaz.inicio_partida.game;
import static interfaz.inicio_partida.tablero;
import java.awt.Color;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class FixDataReplay {

    public void cargarTablero2(guardar save, boolean par) {
        filas = (int) game.getMapa().getTamaño().getWidth();
        columnas = (int) game.getMapa().getTamaño().getHeight();
        tablero = new galaxia[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new galaxia();
                tablero[i][j].setBackground(tablero[i][j].getColor());
            }
        }

        for (int i = 0; i < game.getArray_neutrales().size(); i++) {
            if (!par) {
                for (int j = 0; j < save.getNeutrales().size(); j++) {
                    if (save.getNeutrales().get(j).getNombre().equals(game.getArray_neutrales().get(i).getNombre())) {
                        String dueño = save.getNeutrales().get(j).getDueño();
                        int naves = save.getNeutrales().get(j).getNaves();
                        int produc = save.getNeutrales().get(j).getProduccion();
                        int x = save.getNeutrales().get(j).getX_();
                        int y = save.getNeutrales().get(j).getY_();

                        Color c = save.getNeutrales().get(j).getColorPlaneta();
                        if (!dueño.equals("none")) {
                            game.getArray_neutrales().get(i).setDueño(dueño);
                        }
                        game.getArray_neutrales().get(i).setColor(c);
                        game.getArray_neutrales().get(i).setNaves(naves);
                        game.getArray_neutrales().get(i).setProduccion(produc);
                        game.getArray_neutrales().get(i).setX_(x);
                        game.getArray_neutrales().get(i).setY_(y);
                        break;
                    }

                }
            }

            tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].inicializarPlanetaNeutral(game.getArray_neutrales().get(i));
            tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].setBackground(tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].getColor());

        }
        for (int i = 0; i < game.getPlanetas().size(); i++) {

            for (int j = 0; j < save.getPlanetas().size(); j++) {
                if (save.getPlanetas().get(j).getNombre().equals(game.getPlanetas().get(i).getNombre())) {
                    String dueño = save.getPlanetas().get(j).getDueño();
                    int naves = save.getPlanetas().get(j).getNaves();
                    int produc = save.getPlanetas().get(j).getProduccion();
                    int x = save.getPlanetas().get(j).getX_();
                    int y = save.getPlanetas().get(j).getY_();
                    Color c = save.getPlanetas().get(j).getColorPlaneta();
                    game.getPlanetas().get(i).setDueño(dueño);
                    if (!par) {
                        game.getPlanetas().get(i).setColor(c);
                        game.getPlanetas().get(i).setNaves(naves);
                        game.getPlanetas().get(i).setProduccion(produc);
                        game.getPlanetas().get(i).setX_(x);
                        game.getPlanetas().get(i).setY_(y);
                    }

                    break;
                }

            }

            tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].inicializarPlanetaJugador(game.getPlanetas().get(i));
            tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].setBackground(tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].getColor());
        }
       
    }

  

}
