/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas;

import interfaz.nuevo_juego;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class planeta_jugador extends planeta {
   
    public planeta_jugador(int naves, double muertes, String nombre, boolean mostrarNaves, boolean mostrarEstadisticas, int produccion) {
        super(mostrarNaves, mostrarEstadisticas, produccion);
        this.naves = naves;
        this.muertes = muertes;
        this.nombre = nombre;
      
        
    }
    public planeta_jugador(String nombre) {
        this.nombre = nombre;
    }
   
    public planeta_jugador(boolean mostrarNaves, boolean mostrarEstadisticas, int produccion) {
        super(mostrarNaves, mostrarEstadisticas, produccion);
    }
    
      public planeta_jugador planetaAleatorio(int total) {
        Random i = new Random(System.currentTimeMillis());
        int ix = 0;
        ix = i.nextInt(total);
        int navess=i.nextInt(20);
        double muertes=i.nextDouble();
        int produc=i.nextInt(20);
    return new planeta_jugador(navess,muertes,"PLANET_"+ix,false,false,produc);
    }
      public planeta_jugador generarPlaneta(nuevo_juego aThis) {
        boolean v = true;
        String name = "";
        int navess = 0;
        int produc = 0;
        double death = 0.0;
        name = JOptionPane.showInputDialog(aThis, "Ingrese el nombre");
        while (v) {
            try {
                navess = Integer.parseInt(JOptionPane.showInputDialog(aThis, "La cantidad de naves"));
                v = false;
            } catch (NumberFormatException e) {
            }
        }
        v = true;
        while (v) {
            try {
                death = Double.parseDouble(JOptionPane.showInputDialog(aThis, "Ingrese el porcentaje de muertes"));
                v = false;
            } catch (NumberFormatException e) {
            }
            if (death > 1) {
                v = true;
            }
        }
        v = true;
        while (v) {
            try {
                produc = Integer.parseInt(JOptionPane.showInputDialog(aThis, "Ingrese la produccion"));
                v = false;
            } catch (NumberFormatException e) {

            }
        }
        return new planeta_jugador(navess, death, name, false, false, produc);
    }
  
      
    @Override
   public Color getColorPlaneta() {
   return color; 
   }
   
    @Override
   public void setColor(Color color){
       this.color=color;
   }

  
    
}
