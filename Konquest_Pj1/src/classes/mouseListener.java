/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.nuevo_juego;
import static interfaz.nuevo_juego.tabla_jugadores;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 *
 * @author jhonny
 */
public class mouseListener implements MouseListener {

    nuevo_juego aThis;
    JButton boton;

    public nuevo_juego getaThis() {
        return aThis;
    }

    public void setaThis(nuevo_juego aThis) {
        this.aThis = aThis;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!nuevo_juego.deleteElement){
        int columna = tabla_jugadores.columnAtPoint(e.getPoint());
       int fila = tabla_jugadores.rowAtPoint(e.getPoint());
        if (tabla_jugadores.getModel().getColumnClass(columna).equals(JButton.class)){
          Color getcolor = JColorChooser.showDialog(aThis, "Select a color", Color.red);
            nuevo_juego.juego.getArray_jugadores().get(fila).setColor(getcolor);
            nuevo_juego.setTabla();
            nuevo_juego.reiniciarTablero();
        }
        }
       
      
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
