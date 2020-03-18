/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas;

import planetas_neutral.planeta_neutral;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author jhonny
 */
public class galaxia extends JButton {

    private planeta planeta;
    private final Color color;
    private int coordx_,coordy_,coord;
    public galaxia() {
        this.planeta = null;
        color=new Color(13,29,82);
         
    }

    public int getCoord() {
        return coord;
    }

    public void setCoord(int coord) {
        this.coord = coord;
    }

    public int getCoordx_() {
        return coordx_;
    }

    public void setCoordx_(int coordx_) {
        this.coordx_ = coordx_;
    }

    public int getCoordy_() {
        return coordy_;
    }

    public void setCoordy_(int coordy_) {
        this.coordy_ = coordy_;
    }

   

    public boolean isEmpty() {
        if (planeta == null) {
            return true;
        } else {
            return false;
        }
    }

    public planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(planeta planeta) {
        this.planeta = planeta;
    }

    public void inicializarPlanetaNeutral(planeta_neutral planeta_neutral) {
        planeta=planeta_neutral;
    }

    public void inicializarPlanetaJugador(planeta jugador) {
        planeta = jugador;
    }

    public Color getColor() {
        if (planeta == null) {
            return color;
        } else {
            return planeta.getColorPlaneta();
        }
    }

  

}
