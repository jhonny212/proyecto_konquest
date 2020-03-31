/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jhonny
 */
public class archivoEntrada {

    public File generateFile() {
        File file = null;
        //Creamos el objeto JFileChooser
        JFileChooser fc = new JFileChooser();
//Indicamos que podemos seleccionar varios ficheros
        fc.setMultiSelectionEnabled(true);
//Indicamos lo que podemos seleccionar
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.json", "json");
//Le indicamos el filtro
        fc.setFileFilter(filtro);
//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion = fc.showOpenDialog(inicio_partida.panel_tablero);
//Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            file = fc.getSelectedFile();
        }
// verificar que el archivo no sea nulo y tipo:ide

        return file;
    }

    public String getPath() {
        JFileChooser seleccion = new JFileChooser();
        int opcion = seleccion.showOpenDialog(null);
        String path = "";
        if (opcion == JFileChooser.APPROVE_OPTION) {
            path = seleccion.getSelectedFile().getAbsolutePath();
        }
        System.out.println(path+"------------_>");
        return path;
    }
}
