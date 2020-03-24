/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static interfaz.inicio_partida.game;
import java.util.ArrayList;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class archivoVs {
    private ArrayList<Turno> turn;

    public archivoVs(ArrayList<Turno> turn) {
        this.turn = turn;
    }
    
    public void ArreglarJugadores( int i){
      for (int j = 0; j < game.getArray_jugadores().size(); j++) {
                if (game.getArray_jugadores().get(j).getJugador().equals(turn.get(i).getJugador_())) {
                    turn.get(i).setJugador(game.getArray_jugadores().get(j));
                    break;
                }

            }
    }
    public void ArreglarNeutrales(guardar save,int k){
     for (int l = 0; l < save.getNeutrales().size(); l++) {
                        if (save.getNeutrales().get(l).getNombre().equals(game.getArray_neutrales().get(k).getNombre())) {
                            int x = save.getNeutrales().get(l).getX_();
                            int y = save.getNeutrales().get(l).getY_();

                            game.getArray_neutrales().get(k).setX_(x);
                            game.getArray_neutrales().get(k).setY_(y);
                            break;
                        }
                    }
                    for (int l = 0; l < save.getPlanetas().size(); l++) {
                        if (save.getPlanetas().get(l).getNombre().equals(game.getPlanetas().get(k).getNombre())) {
                            int x = save.getPlanetas().get(l).getX_();
                            int y = save.getPlanetas().get(l).getY_();

                            game.getPlanetas().get(k).setX_(x);
                            game.getPlanetas().get(k).setY_(y);
                            game.getPlanetas().get(k).setColor(save.getPlanetas().get(l).getColorPlaneta());

                            break;
                        }
                    }
    }
    public void arreglarPlanetas(int i,int j,int k){
      if (turn.get(i).getAtaques().get(j).getO_().equals(game.getPlanetas().get(k).getNombre())) {
                        galaxia o = new galaxia();
                        o.setCoordx_(game.getPlanetas().get(k).getX_());
                        o.setCoordy_(game.getPlanetas().get(k).getY_());
                        o.inicializarPlanetaJugador(game.getPlanetas().get(k));
                        turn.get(i).getAtaques().get(j).setO(o);
                    } else if (turn.get(i).getAtaques().get(j).getD_().equals(game.getPlanetas().get(k).getNombre())) {
                        galaxia d = new galaxia();
                        d.setCoordx_(game.getPlanetas().get(k).getX_());
                        d.setCoordy_(game.getPlanetas().get(k).getY_());
                        d.inicializarPlanetaJugador(game.getPlanetas().get(k));
                        turn.get(i).getAtaques().get(j).setD(d);

                    }
    }
    public void arreglarDatosDeTurnos(int i,int k,int j){
    
                    if (turn.get(i).getAtaques().get(j).getO_().equals(game.getArray_neutrales().get(k).getNombre())) {
                        galaxia o = new galaxia();
                        o.setCoordx_(game.getArray_neutrales().get(k).getX_());
                        o.setCoordy_(game.getArray_neutrales().get(k).getY_());
                        o.inicializarPlanetaNeutral(game.getArray_neutrales().get(k));
                        turn.get(i).getAtaques().get(j).setO(o);
                    } else if (turn.get(i).getAtaques().get(j).getD_().equals(game.getArray_neutrales().get(k).getNombre())) {
                        galaxia d = new galaxia();
                        d.setCoordx_(game.getArray_neutrales().get(k).getX_());
                        d.setCoordy_(game.getArray_neutrales().get(k).getY_());
                        d.inicializarPlanetaNeutral(game.getArray_neutrales().get(k));
                        turn.get(i).getAtaques().get(j).setD(d);

                    }
    }
}
