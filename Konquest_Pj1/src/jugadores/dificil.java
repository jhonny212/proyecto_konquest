/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import classes.Ataque;
import classes.Turno;
import classes.distancia;
import interfaz.inicio_partida;
import java.awt.Color;
import java.util.ArrayList;
import planetas.galaxia;
import planetas.planeta_jugador;

/**
 *
 * @author jhonny
 */
public class dificil extends jugador {

    public dificil(String jugador, ArrayList<planeta_jugador> planetas) {
        super(jugador, planetas);
        this.tipo = "DIFICIL";

    }

    @Override
    double daño() {
        return 0.4;
    }

    @Override
    galaxia getGalaxiaAtacante(galaxia[][] o, int x, int y) {
        galaxia origen = null;
        ArrayList<galaxia> lista = new ArrayList();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!o[i][j].isEmpty()) {
                    if (o[i][j].getPlaneta().getDueño().equals(jugador)) {
                        lista.add(o[i][j]);
                    }
                }
            }
        }
        origen = getGalaxia(lista, 0, null, 2);
        return origen;
    }

    @Override
    galaxia getGalaxiaOponente(galaxia[][] d, int x, int y, galaxia origen) {
        galaxia destino = null;
        ArrayList<galaxia> lista = new ArrayList();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!d[i][j].isEmpty()) {
                    if (!d[i][j].getPlaneta().getDueño().equals(jugador)) {
                        lista.add(d[i][j]);

                    }
                }
            }
        }
        destino = getGalaxia(lista, 1, origen, 3);
        return destino;
    }

    private galaxia getGalaxia(ArrayList<galaxia> lista, int tipo, galaxia origen, int num) {
        double muertes = 0.0, aux = 0.0;
        int naves = 0, navesaux = 0;
        int numero = (int) (Math.random() * num);
        galaxia galaxia = null;
        int distancia = 0, distanciaaux = 0;

        for (int i = 0; i < lista.size(); i++) {
            switch (numero) {
                case 0:
                    if (i == 0) {
                        naves = lista.get(i).getPlaneta().getNaves();
                        navesaux = naves;
                        galaxia = lista.get(i);
                    } else {
                        naves = lista.get(i).getPlaneta().getNaves();
                        if (tipo == 1) {
                            if (naves < navesaux) {
                                navesaux = naves;
                                galaxia = lista.get(i);
                            }
                        } else {
                            if (naves > navesaux) {
                                navesaux = naves;
                                galaxia = lista.get(i);
                            }
                        }
                    }

                    break;
                case 1:
                    if (i == 0) {
                        muertes = lista.get(i).getPlaneta().getMuertes();
                        aux = muertes;
                        galaxia = lista.get(i);
                    } else {
                        muertes = lista.get(i).getPlaneta().getNaves();
                        if (tipo == 1) {
                            if (muertes < aux) {
                                aux = muertes;
                                galaxia = lista.get(i);
                            }
                        } else {
                            if (muertes > aux) {
                                aux = muertes;
                                galaxia = lista.get(i);
                            }
                        }
                    }
                    break;
                case 2:
                    if (i == 0) {
                        distancia t = new distancia(origen, lista.get(i));
                        distancia = (int) t.turno()[0];
                        distanciaaux = distancia;
                        galaxia = lista.get(i);
                    } else {
                        distancia t = new distancia(origen, lista.get(i));
                        distancia = (int) t.turno()[0];
                        if (tipo == 1) {
                            if (distanciaaux < distancia) {
                                distanciaaux = distancia;
                                galaxia = lista.get(i);
                            }
                        } else {
                            if (distanciaaux > distancia) {
                                distanciaaux = distancia;
                                galaxia = lista.get(i);
                            }
                        }
                    }
                    break;

            }
        }
        return galaxia;
    }

    @Override
    public Turno getTurno(galaxia[][] d, int x, int y, int turno, jugador jugador) {
        Turno trn = null;
        int naves = 0, aux = 0;
        ArrayList<Ataque> ataques = new ArrayList();
        int numero = (int) (Math.random() * 3);

        for (int i = 0; i < numero; i++) {
            try {
                galaxia o = getGalaxiaAtacante(d, x, y);
                galaxia des = getGalaxiaOponente(d, x, y, o);
                distancia dis = new distancia(o, des);
                Object ob[] = dis.turno();
                naves = o.getPlaneta().getNaves();
                aux = naves;
                if(naves!=0){
                if (naves > 7) {
                    int j = (naves / 2);
                    int count = 0;
                    for (j = j; j < naves; j++) {
                        count++;
                    }
                    naves = count;
                }
                Ataque ataque = new Ataque(o, des, (int) ob[0] + turno, naves, false);
                ataques.add(ataque);
                inicio_partida.tablero[o.getCoordx_()][o.getCoordy_()].getPlaneta().setNaves(aux - naves);
                }

            } catch (NullPointerException e) {
            }

        }
        trn = new Turno(ataques, jugador, turno);
        return trn;
    }

}
