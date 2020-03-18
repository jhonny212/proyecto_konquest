/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import jugadores.dificil;
import jugadores.facil;
import jugadores.humano;
import jugadores.jugador;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class Ataque {

    private galaxia o, d;
    private int trn;
    int cant;
    private boolean verificar;
    public Ataque(galaxia o, galaxia d, int trn,int cant,boolean verificar) {
        this.d = d;
        this.o = o;
        this.trn = trn;
        this.cant=cant;
        this.verificar=verificar;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public boolean isVerificar() {
        return verificar;
    }

    public void setVerificar(boolean verificar) {
        this.verificar = verificar;
    }

    public int getTrn() {
        return trn;
    }

    public galaxia getO() {
        return o;
    }

    public galaxia getD() {
        return d;
    }

    public int[] realizarAtaque(jugador jugador) {
        double daño2 = d.getPlaneta().getMuertes();
        double daño1 = o.getPlaneta().getMuertes();
        int n2 = d.getPlaneta().getNaves();
        int n1 = cant;

        if ((n2 > n1) && (daño2 > daño1)) {
            n1 = 0;
        } else if ((n2 < n1) && (daño2 < daño1)) {
            n1 = n1 - n2;
        } else if ((n2 == n1) && (daño2 == daño1)) {
            n2 = 0;
            n1 = 0;

        } else if ((n2 > n1) && (daño2 < daño1)) {
            if ((daño2 + 0.3) > daño1) {
                if ((n1 - 1 + (n1 / 2) > n2)) {
                    n2 = 0;
                    n1 = n2 - n1 - 1;

                } else {
                    n1 = 0;
                    n2 = n2 - n1 - 1;
                }
            } else {
                n1 = 0;
                n2 = n2 - n1 - 2;
            }

        } else if ((n2 < n1) && (daño2 > daño1)) {
            if ((daño1 + 0.3) > daño2) {
                if ((n2 + (n2 / 2) - 1) > n1) {
                    n1 = 0;
                    n2 = n1 - n2 - 1;
                } else {
                    n1 = n2 - n1 - 2;
                    n2 = 0;
                }
            } else {
                n1 = n2 - n1 - 2;
                n2 = 0;
            }

        } else if ((n2 == n1) && (daño2 > daño1)) {
            if (daño1 + 0.3 > daño2) {
                n2 = 0;
                n1 = 1;
            } else {
                n1 = 0;
                n2 = n2 - n1 - 2;
            }

        } else if ((n2 == n1) && (daño2 < daño1)) {
            if (daño2 + 0.3 > daño1) {
                n2 = 1;
                n1 = 0;
            } else {
                n2 = 0;
                n1 = n2 - n1 - 2;
            }

        } else if ((n2 < n1) && (daño2 == daño1)) {
            if ((n2 - 1 + (n2 / 2) > n1)) {
                n2 = n2 - n1 - 1;
            } else {
                n2 = 0;
                n1 = 1;
            }

        } else if ((n2 > n1) && (daño2 == daño1)) {
            if ((n1 - 1 + (n1 / 2) > n2)) {
                n1 = n1 - n2 - 1;
            } else {
                n1 = 0;
                n2 = 1;
            }
        }
        if (n1 < 0) {
            n1 = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        int t[]=new int[2];
        t[0]=n1;
        t[1]=0;
    return t;}
}
