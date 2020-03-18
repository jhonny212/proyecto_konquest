/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.nuevo_juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author jhonny
 */
public class ButtonController implements ActionListener{
   
   private int x;
   private int y;

   
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < nuevo_juego.filas; i++) {
            for (int j = 0; j < nuevo_juego.columnas; j++) {
                if(ae.getSource().equals(nuevo_juego.tablero[i][j])){
                    if(!nuevo_juego.tablero[i][j].isEmpty()){
                    this.x=i;
                    this.y=j;
                    nuevo_juego.showDatas(x,y);
                    }
                }
            }
        }
    }
      
}
