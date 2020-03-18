/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jugadores.jugador;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class Turno {

    private ArrayList<Ataque> ataques;
    private jugador jugador;
    private boolean validar_;

    public Turno(ArrayList<Ataque> ataques, jugador jugador) {
        this.ataques = ataques;
        this.jugador = jugador;
        this.validar_ = true;
        construir();
    }

    public boolean isValidar_() {
        return validar_;
    }

    public void realizarAtaque(int x) {
        int count = 0;
        for (int i = 0; i < ataques.size(); i++) {
            if (ataques.get(i).getTrn() == x && !ataques.get(i).isVerificar()) {
                ataques.get(i).setVerificar(true);
                count++;
                int datos[] = ataques.get(i).realizarAtaque(jugador);
                galaxia o = ataques.get(i).getO();
                galaxia d = ataques.get(i).getD();
                int naves = o.getPlaneta().getNaves();
                inicio_partida.tablero[o.getCoordx_()][o.getCoordy_()].getPlaneta().setNaves(naves + datos[0]);
                if (datos[1] == 0) {
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setNaves(0);
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setDueño(jugador.getJugador());
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].setBackground(jugador.getColor());
                    String msj = "El planeta " + d.getPlaneta().getNombre() + " ha caido ante " + jugador.getJugador();
                    JOptionPane.showMessageDialog(inicio_partida.panel_tablero, msj);
                } else {
                    inicio_partida.tablero[d.getCoordx_()][d.getCoordy_()].getPlaneta().setNaves(datos[1]);
                }
                String msj = "El planeta " + d.getPlaneta().getNombre() + " fue atacado por el " + jugador.getJugador() + " \n"
                        + ", planeta" + o.getPlaneta().getNombre();

                JOptionPane.showMessageDialog(inicio_partida.panel_tablero, msj);

                inicio_partida.reiniciar(o.getCoordx_(), o.getCoordy_());
                inicio_partida.reiniciar(d.getCoordx_(), d.getCoordy_());
            }
        }
        if (count == ataques.size()) {
            this.validar_ = false;
        }

    }

    public void construirNaves() {
        if (ataques.size() > 0) {
            galaxia o = ataques.get(0).getO();
            galaxia d = ataques.get(0).getD();
            int x1 = o.getCoordx_();
            int x2 = d.getCoordx_();
            int y1 = o.getCoordy_();
            int y2 = d.getCoordy_();
            inicio_partida.tablero[x1][y1].getPlaneta().setNaves(o.getPlaneta().getNaves() + o.getPlaneta().getProduccion());
            inicio_partida.tablero[x2][y2].getPlaneta().setNaves(d.getPlaneta().getNaves() + d.getPlaneta().getProduccion());
        }
    }

    private void construir() {
        for (int i = 0; i < inicio_partida.filas; i++) {
            for (int j = 0; j < inicio_partida.columnas; j++) {
                if (!inicio_partida.tablero[i][j].isEmpty()) {
                    int naves = inicio_partida.tablero[i][j].getPlaneta().getNaves();
                    int produc = inicio_partida.tablero[i][j].getPlaneta().getProduccion();
                    inicio_partida.tablero[i][j].getPlaneta().setNaves(naves + produc);
                    inicio_partida.reiniciar(i, j);
                }
            }
        }

    }

}
