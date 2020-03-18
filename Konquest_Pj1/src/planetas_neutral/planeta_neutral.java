/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas_neutral;

import interfaz.nuevo_juego;
import static interfaz.nuevo_juego.columnas;
import static interfaz.nuevo_juego.filas;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import planetas.planeta;
import planetas.planeta;

/**
 *
 * @author jhonny
 */
public class planeta_neutral extends planeta {

    private boolean produc;

    public boolean isProduc() {
        return produc;
    }

    public void setProduc(boolean produc) {
        this.produc = produc;
    }

    public planeta_neutral(int naves, double muertes, String nombre, boolean mostrarNaves, boolean mostrarEstadisticas, int produccion) {
        super(mostrarNaves, mostrarEstadisticas, produccion);
        this.naves = naves;
        this.muertes = muertes;
        this.nombre = nombre;
        this.produc = false;
        color=Color.yellow;
    }

    public planeta_neutral() {
    }

    public planeta_neutral(boolean mostrarNaves, boolean mostrarEstadisticas, int produccion) {
        super(mostrarNaves, mostrarEstadisticas, produccion);
        this.naves = 0;
        this.muertes = 0.0;
        this.nombre = "";
    }

    public planeta_neutral generarPlaneta(nuevo_juego aThis) {
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
        return new planeta_neutral(navess, death, name, false, false, produc);
    }

    public planeta_neutral planetaAleatorio(int total) {
        Random i = new Random(System.currentTimeMillis());
        int ix = (int) (Math.random() * total);
        int navess = (int) (Math.random() * 20 + 1);
        double muertess = (Math.random());
        int produc = (int) (Math.random() * 20 + 1);
        return new planeta_neutral(navess, muertess, "NEUTRL:_" + ix, false, false, produc);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColorPlaneta() {
        JButton br = new JButton();
       return color;

    }

}
