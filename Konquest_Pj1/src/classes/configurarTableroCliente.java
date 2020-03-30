/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static interfaz.nuevo_juego.juego;
import static interfaz.nuevo_juego.tablero;
import java.awt.Color;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class configurarTableroCliente {
        public void cargarTablero(guardar save, boolean par) {
     int   filas = (int) juego.getMapa().getTamaño().getWidth();
     int   columnas = (int) juego.getMapa().getTamaño().getHeight();
        tablero = new galaxia[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new galaxia();
                tablero[i][j].setBackground(tablero[i][j].getColor());

            }
        }

        for (int i = 0; i < juego.getArray_neutrales().size(); i++) {
            if (!par) {
                for (int j = 0; j < save.getNeutrales().size(); j++) {
                    if (save.getNeutrales().get(j).getNombre().equals(juego.getArray_neutrales().get(i).getNombre())) {
                        String dueño = save.getNeutrales().get(j).getDueño();
                        int naves = save.getNeutrales().get(j).getNaves();
                        int produc = save.getNeutrales().get(j).getProduccion();
                        int x = save.getNeutrales().get(j).getX_();
                        int y = save.getNeutrales().get(j).getY_();

                        Color c = save.getNeutrales().get(j).getColorPlaneta();
                        if (!dueño.equals("none")) {
                            juego.getArray_neutrales().get(i).setDueño(dueño);
                        }
                        juego.getArray_neutrales().get(i).setColor(c);
                        juego.getArray_neutrales().get(i).setNaves(naves);
                        juego.getArray_neutrales().get(i).setProduccion(produc);
                        juego.getArray_neutrales().get(i).setX_(x);
                        juego.getArray_neutrales().get(i).setY_(y);
                        break;
                    }

                }
            }

            tablero[juego.getArray_neutrales().get(i).getX_()][juego.getArray_neutrales().get(i).getY_()].inicializarPlanetaNeutral(juego.getArray_neutrales().get(i));
            tablero[juego.getArray_neutrales().get(i).getX_()][juego.getArray_neutrales().get(i).getY_()].setBackground(tablero[juego.getArray_neutrales().get(i).getX_()][juego.getArray_neutrales().get(i).getY_()].getColor());

        }
        for (int i = 0; i < juego.getPlanetas().size(); i++) {

            for (int j = 0; j < save.getPlanetas().size(); j++) {
                if (save.getPlanetas().get(j).getNombre().equals(juego.getPlanetas().get(i).getNombre())) {
                    String dueño = save.getPlanetas().get(j).getDueño();
                    int naves = save.getPlanetas().get(j).getNaves();
                    int produc = save.getPlanetas().get(j).getProduccion();
                    int x = save.getPlanetas().get(j).getX_();
                    int y = save.getPlanetas().get(j).getY_();
                    Color c = save.getPlanetas().get(j).getColorPlaneta();
                    juego.getPlanetas().get(i).setDueño(dueño);
                    if (!par) {
                        juego.getPlanetas().get(i).setColor(c);
                        juego.getPlanetas().get(i).setNaves(naves);
                        juego.getPlanetas().get(i).setProduccion(produc);
                        juego.getPlanetas().get(i).setX_(x);
                        juego.getPlanetas().get(i).setY_(y);
                    }

                    break;
                }

            }

            tablero[juego.getPlanetas().get(i).getX_()][juego.getPlanetas().get(i).getY_()].inicializarPlanetaJugador(juego.getPlanetas().get(i));
            tablero[juego.getPlanetas().get(i).getX_()][juego.getPlanetas().get(i).getY_()].setBackground(tablero[juego.getPlanetas().get(i).getX_()][juego.getPlanetas().get(i).getY_()].getColor());
        }
    }

}
