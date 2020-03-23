/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
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
    private String o_, d_;
    private int tipe;

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }
    
    public String getO_() {
        return o_;
    }

    public void setO_(String o_) {
        this.o_ = o_;
    }

    public String getD_() {
        return d_;
    }

    public void setD_(String d_) {
        this.d_ = d_;
    }

    public Ataque(galaxia o, galaxia d, int trn, int cant, boolean verificar) {
        this.d = d;
        this.o = o;
        this.trn = trn;
        this.cant = cant;
        this.verificar = verificar;
        System.out.println(trn + " ");
    }
    

    public Ataque(String o, String d, int trn, int cant, boolean verificar) {
        this.d_ = d;
        this.o_ = o;
        this.trn = trn;
        this.cant = cant;
        this.verificar = verificar;
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

    public void setO(galaxia o) {
        this.o = o;
    }

    public void setD(galaxia d) {
        this.d = d;
    }
  public int vivos;
    public int[] realizarAtaque(jugador jugador) {
        if(tipe==1){
        int total=inicio_partida.tablero[o.getCoordx_()][o.getCoordy_()].getPlaneta().getNaves();
        System.out.println(total+"<<>> "+cant+" "+o.getPlaneta().getNombre());
        inicio_partida.tablero[o.getCoordx_()][o.getCoordy_()].getPlaneta().setNaves(total-cant);
        }
        double daño2 = d.getPlaneta().getMuertes();
        double daño1 = o.getPlaneta().getMuertes();
        int n2 = d.getPlaneta().getNaves();
        int n1 = cant;
        vivos=n2;
        int x = (int) (n1 * daño2);
        int y = (int) (n2 * daño1);

        if (n1 + 10 > n2) {
            n2 -= 1;
        }
        if (n2 + 10 > n1) {
            n1 -= 1;
        }

        n1 = n1 - x - 1;
        n2 = n2 - y - 1;

        if (n1 < 0) {
            n1 = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }

        int t[] = new int[2];
        t[0] = n1;
        t[1] = n2;
        return t;
    }
}
