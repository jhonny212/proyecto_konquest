/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import mapa.juego;
import planetas.galaxia;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class guardar {

    juego juego;
    galaxia tablero[][];

    public guardar(juego juego, galaxia[][] tablero) {
        this.juego = juego;
        this.tablero = tablero;
        imprimir();
    }

    private void imprimir() {
        String txt = mapa() + "\n";
        txt += planetas() + "\n";
        txt += jugadores();
        System.out.println(txt);

    }

    private String mapa() {
        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        boolean azar = juego.getMapa().isAzar();
        boolean acum = juego.getMapa().isAcumular();
        boolean mciego = juego.getMapa().isMapaciego();
        boolean showNaves = juego.getMapa().getNeutral().isMostrarNaves();
        boolean showestadisticas = juego.getMapa().getNeutral().isMostrarEstadisticas();
        String txt = "mapa:\n"
                + "[\n"
                + "	dimensiones[\n"
                + "	filas:" + col + "\n"
                + "	columnas:" + fil + "	\n"
                + "	]\n"
                + "	azar:" + azar + "\n"
                + "	mapaciego:" + mciego + "\n"
                + "	acumular:" + acum + "\n"
                + "	neutrales[\n"
                + "		naves:" + showNaves + "\n"
                + "		estadisticas:" + showestadisticas + "\n"
                + "	]\n"
                + "]::";

        return txt;
    }

    private String planetas() {
        String txt = "";
        String planetas = "";
        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        for (int i = 0; i < col; i++) {

            for (int j = 0; j < fil; j++) {
                if (!tablero[i][j].isEmpty()) {
                    planetas += "[\n";
                    String name = tablero[i][j].getPlaneta().getNombre();
                    int naves = tablero[i][j].getPlaneta().getNaves();
                    int produc = tablero[i][j].getPlaneta().getProduccion();
                    double muertes = tablero[i][j].getPlaneta().getMuertes();
                    int x = tablero[i][j].getCoordx_();
                    int y = tablero[i][j].getCoordy_();
                    if (tablero[i][j].getPlaneta().getClass().equals(planeta_neutral.class)) {
                        planetas += "     neutral:true\n";
                    } else {
                        planetas += "     neutral:false\n";
                    }
                    planetas
                            += "        nombre:" + name + "\n"
                            + "         naves:" + naves + "\n"
                            + "	produccion:" + produc + "\n"
                            + "	muertes:" + muertes + "\n"
                            + "	posicion{\n"
                            + "	x:" + x + "\n"
                            + "	y:" + y + "\n}\n]\n";
                }
            }

        }
        txt = "planetas:[\n" + planetas + "]::";

        return txt;
    }

    private String jugadores() {
        String txt = "";
        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        for (int k = 0; k < juego.getArray_jugadores().size(); k++) {
            txt += "[\n nombre:" + juego.getArray_jugadores().get(k).getJugador() + "\n";
            txt += "tipo:" + juego.getArray_jugadores().get(k).getClass().getSimpleName() + "\n";
            txt += "planetas[\n";
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < fil; j++) {
                    if (!tablero[i][j].isEmpty()) {
                        if (tablero[i][j].getPlaneta().getDueño().equals(juego.getArray_jugadores().get(k).getJugador())) {
                            txt += "(nombre:" + tablero[i][j].getPlaneta().getNombre() + ")\n";
                        }
                    }
                }
            }
            txt += "]\n"
                    + "color[\n"
                    + "red:" + juego.getArray_jugadores().get(k).getColor().getRed() + "\n"
                    + "blue:" + juego.getArray_jugadores().get(k).getColor().getBlue() + "\n"
                    + "green:" + juego.getArray_jugadores().get(k).getColor().getGreen() + "\n"
                    + "\n] "
                    + "\n]\n";

        }
        return txt;
    }
}
