/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import jugadores.jugador;
import mapa.juego;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class partida {

    private String jugador;
    private boolean isEnd;
    juego juego;
    galaxia tablero[][];
    ArrayList<String> lista = new ArrayList();
        

    public partida(juego juego, galaxia[][] tablero) {
        this.juego = juego;
        this.tablero = tablero;
        isEnd = false;
    }

    public boolean terminarJuego(int contadorDeTurnos) {
        int finalizacion = juego.getMapa().getFinalizacion();

        if (finalizacion != 0) {
            if (finalizacion == contadorDeTurnos) {
                terminarJuego2(2);
            }
        } else {
            terminarJuego2(1);
        }
        return isEnd;
    }

    public void terminarJuego2(int type) {
        String name1 = "", name2 = "";
        int count = 0;
        int filas = (int) juego.getMapa().getTamaño().getWidth();
        int columnas = (int) juego.getMapa().getTamaño().getHeight();
        for (int i = 0; i < filas; i++) {
            if (isEnd) {
                break;
            }
            for (int j = 0; j < columnas; j++) {
                if (isEnd) {
                    break;
                }
                if (!tablero[i][j].isEmpty()) {
                    if (type == 1) {
                        if (count > 0) {
                            name2 = tablero[i][j].getPlaneta().getDueño();
                            if (!name1.equals(name2)) {
                                isEnd = true;
                            }
                        } else if (count == 0) {
                            name1 = tablero[i][j].getPlaneta().getDueño();
                        }
                        count++;
                    } else {
                        lista.add(tablero[i][j].getPlaneta().getDueño());
                    }
                }
            }
        }
        if (!isEnd) {
            this.jugador = name1;
        }
    }

    public void jugadorGanador() {
        ArrayList<jugador> listaJugadores = juego.getArray_jugadores();
        int cantPlanetas=0;
        int aux=0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            cantPlanetas=0;
            for (int j = 0; j < lista.size(); j++) {
                if(lista.get(j).equals(listaJugadores.get(i).getJugador())){
                cantPlanetas++;
                }
            }
            if(i!=0){
                if(aux>cantPlanetas){
                this.jugador=listaJugadores.get(i).getJugador();
                }
            }else{
            this.jugador=listaJugadores.get(i).getJugador();    
            aux=cantPlanetas;
            }
            
        }
        
    }

}
