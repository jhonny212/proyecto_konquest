/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.awt.Color;
import java.util.ArrayList;
import jugadores.jugador;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class Turno {

    private String jugador_;

    public String getJugador_() {
        return jugador_;
    }

    public void setJugador_(String jugador_) {
        this.jugador_ = jugador_;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setJugador(jugador jugador) {
        this.jugador = jugador;
    }

    public jugador getJugador() {
        return jugador;
    }

    public int getNumTurn() {
        return numTurn;
    }

    private ArrayList<Ataque> ataques;
    private jugador jugador;
    private boolean validar_;
    private int numTurn;

    public Turno(ArrayList<Ataque> ataques, jugador jugador) {
        this.ataques = ataques;
        this.jugador = jugador;
        this.validar_ = true;
    }

    public Turno(ArrayList<Ataque> ataques, jugador jugador, int numTurn) {
        this.ataques = ataques;
        this.jugador = jugador;
        this.validar_ = true;
        this.numTurn = numTurn;
    }

    public Turno(ArrayList<Ataque> ataques, String jugador_, int numTurn) {
        this.ataques = ataques;
        this.jugador_ = jugador_;
        this.validar_ = true;
        this.numTurn = numTurn;
    }

    public boolean isValidar_() {
        return validar_;
    }
    public int type;

    public void realizarAtaque(int x) {
        int count = 0;
        for (int i = 0; i < ataques.size(); i++) {
            if (ataques.get(i).getTrn() == x && !ataques.get(i).isVerificar()) {
                ataques.get(i).setVerificar(true);
                count++;
                if (type == 1) {
                    ataques.get(i).setTipe(1);
                }
                int datos[] = ataques.get(i).realizarAtaque(jugador);
                galaxia o = ataques.get(i).getO();
                galaxia d = ataques.get(i).getD();
                int naves = o.getPlaneta().getNaves();
                int dd = naves + datos[0];
                inicio_partida.tablero[o.getCoordx_()][o.getCoordy_()].getPlaneta().setNaves(naves + datos[0]);
                if (datos[1] == 0) {
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setNaves(0);
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setDueño(jugador.getJugador());
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].setBackground(jugador.getColor());
                    inicio_partida.mensajes_txt.append(Color.white, "El planeta ");
                    inicio_partida.mensajes_txt.append(d.getPlaneta().getColorPlaneta(), d.getPlaneta().getNombre());
                    inicio_partida.mensajes_txt.append(Color.white, " ha caido ante ");
                    inicio_partida.mensajes_txt.append(o.getPlaneta().getColorPlaneta(), jugador.getJugador() + " \n");
                } else {
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setNaves(datos[1]);
                    inicio_partida.mensajes_txt.append(Color.white, "El planeta ");
                    inicio_partida.mensajes_txt.append(d.getPlaneta().getColorPlaneta(), d.getPlaneta().getNombre());
                    inicio_partida.mensajes_txt.append(Color.white, " se defendio contra ");
                    inicio_partida.mensajes_txt.append(o.getPlaneta().getColorPlaneta(), jugador.getJugador() + " \n");

                    inicio_partida.mensajes_txt.append(Color.white, "       El planeta ");
                    inicio_partida.mensajes_txt.append(o.getPlaneta().getColorPlaneta(), o.getPlaneta().getNombre() + "\n");

                    String msj = "";
                    msj = "             Total de Naves:" + dd + " Naves con vida despues de lucha:" + datos[0];

                    msj += "            Ataco con:" + ataques.get(i).getCant() + " y un porcentaje de muertes de:" + o.getPlaneta().getMuertes() + "\n";
                    inicio_partida.mensajes_txt.append(Color.white, msj);

                    inicio_partida.mensajes_txt.append(Color.white, "       El planeta ");
                    inicio_partida.mensajes_txt.append(d.getPlaneta().getColorPlaneta(), d.getPlaneta().getNombre() + "\n");
                    msj = "             Total de Naves:" + datos[1];
                    msj += "            Contrataco con:" + ataques.get(i).vivos + "  y un porcentaje de muertes de:" + d.getPlaneta().getMuertes() + "\n \n";

                    inicio_partida.mensajes_txt.append(Color.white, msj);

                }
                inicio_partida.reiniciar(o.getCoordx_(), o.getCoordy_());
                inicio_partida.reiniciar(d.getCoordx_(), d.getCoordy_());

            }
        }
        if (count == ataques.size()) {
            this.validar_ = false;
        }

    }

    public void construir(boolean azar) {
        for (int i = 0; i < inicio_partida.filas; i++) {
            for (int j = 0; j < inicio_partida.columnas; j++) {
                if (!inicio_partida.tablero[i][j].isEmpty()) {
                    int naves = inicio_partida.tablero[i][j].getPlaneta().getNaves();
                    int produc = inicio_partida.tablero[i][j].getPlaneta().getProduccion();
                    if (azar) {
                        inicio_partida.tablero[i][j].getPlaneta().setProduccion(produc + 1);
                    }
                    inicio_partida.tablero[i][j].getPlaneta().setNaves(naves + produc);
                    inicio_partida.reiniciar(i, j);
                }
            }
        }

    }

    public void configurarNaves() {
        for (int i = 0; i < this.ataques.size(); i++) {
            int x = ataques.get(i).getO().getPlaneta().getX_();
            int y = ataques.get(i).getO().getPlaneta().getY_();
            int naves = inicio_partida.tablero[x][y].getPlaneta().getNaves();
            int cant = ataques.get(i).getCant();
            System.out.println(x + "x: " + y + "y: " + naves + " " + cant);

            inicio_partida.tablero[x][y].getPlaneta().setNaves(naves - cant);

        }
    }

    public String msj(int num) {
        String msj = "{\n"
                + "turno:[	{\n"
                + "	nombre: \"" + jugador.getJugador() + "\",\n"
                + "	ataque:{"
                + ataques()
                + "		}		\n"
                + "	\n"
                + "	}\n"
                + "     ]\n"
                + " }\n";

        return msj;
    }

    public String ataques() {
        String txt = "";

        for (int i = 0; i < ataques.size(); i++) {
            if (i > 0) {
                txt += ",\n";
            }

            txt += "{\n"
                    + "		galaxias: {\n"
                    + "			origen: ["
                    + "                     \"" + ataques.get(i).getO().getPlaneta().getNombre() + "\","
                    + "                     posicion: ["
                    + "                         x:"+ataques.get(i).getO().getCoordx_()+","
                    + "                         y:"+ataques.get(i).getO().getCoordy_()+""
                    + "                     ]"
                    + "                 ],\n"
                    + "			destino: [\"" + ataques.get(i).getD().getPlaneta().getNombre() + "\","
                    + "                     posicion: ["
                    + "                         x:"+ataques.get(i).getD().getCoordx_()+","
                    + "                         y:"+ataques.get(i).getD().getCoordy_()+""
                    + "                     ]"
                    + "                 ],\n"
                    + "			turno: " + ataques.get(i).getTrn() + "	\n"
                    + "		},\n"
                    + "		datos:{\n"
                    + "			naves:" + ataques.get(i).getCant() + ",\n"
                    + "			complete: false\n"
                    + "		}\n"
                    + "	}	\n";

        }

        return txt;
    }
    public void config(){
        for (int i = 0; i < ataques.size(); i++) {
            int naves=ataques.get(i).getO().getPlaneta().getNaves();
            int x=ataques.get(i).getO().getCoordx_();
            int y=ataques.get(i).getO().getCoordy_();
            inicio_partida.tablero[x][y].getPlaneta().setNaves(naves-ataques.get(i).getCant());
            inicio_partida.reiniciar(x, y);
        }
    }
}
