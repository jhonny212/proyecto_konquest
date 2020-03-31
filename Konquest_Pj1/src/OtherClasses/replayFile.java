/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import classes.FixDataReplay;
import classes.Replay;
import classes.Turno;
import classes.archivoEntrada;
import classes.archivoVs;
import classes.guardar;
import interfaz.inicio_partida;
import static interfaz.inicio_partida.game;
import static interfaz.inicio_partida.iniciarTablero;
import static interfaz.inicio_partida.mensajes_txt;
import static interfaz.inicio_partida.replay;
import static interfaz.inicio_partida.tablero;
import static interfaz.inicio_partida.turnos;
import interfaz.tabla_de_errores;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import konquest_pj1.Konquest_Pj1;

/**
 *
 * @author jhonny
 */
public class replayFile {

    Component c;

    public replayFile(Component c) {
        this.c = c;
    }

    public void open() {
        mensajes_txt.setText("");
        game = null;
        tablero = null;
        Konquest_Pj1 p = new Konquest_Pj1();
        archivoEntrada archivo = new archivoEntrada();
        JOptionPane.showMessageDialog(c, "Seleccione un archivo de configuracion");
        File f1 = archivo.generateFile();
        try {
            if (f1.canRead()) {
                game = p.probar1(f1);
                JOptionPane.showMessageDialog(c, "Seleccione un archivo de de guardado");
                if (!game.getListaDeErroresSintaticos().isEmpty()) {
                    tabla_de_errores tableErrors = new tabla_de_errores();
                    tableErrors.errorSintatico_juego(game.getListaDeErroresSintaticos());
                    tableErrors.show();
                }
                if (!game.getListaDeErroresLexicos().isEmpty()) {
                    tabla_de_errores tableErrors = new tabla_de_errores();
                    tableErrors.errorLexico(game.getListaDeErroresLexicos());
                    tableErrors.show();
                }
                File f2 = archivo.generateFile();
                if (f2.canRead()) {
                    guardar save = p.leer2(f2);

                    JOptionPane.showMessageDialog(c, "Seleccione un de replay");
                    p.leer3(archivo.generateFile(), "", false);
                    ArrayList<Turno> turn = p.listTurnos;

                    if (!p.erroresSin.isEmpty()) {
                        tabla_de_errores tableErrors = new tabla_de_errores();
                        tableErrors.errorSintatico_juego(p.erroresSin);
                        tableErrors.show();
                    }
                    if (!p.erroresLex.isEmpty()) {
                        tabla_de_errores tableErrors = new tabla_de_errores();
                        tableErrors.setTitle("Error lexico en gramatica de REPLAY");
                        tableErrors.errorLexico(p.erroresLex);
                        tableErrors.show();
                    }

                    if (!save.getErroresSintatico().isEmpty()) {
                        tabla_de_errores tableErrors = new tabla_de_errores();
                        tableErrors.setTitle("Error sintatico en gramatica de GUARDAR");

                        tableErrors.setDatasErrors(save.getErroresSintatico());
                        tableErrors.show();
                    }
                    if (!save.getErroresLexico().isEmpty()) {
                        tabla_de_errores tableErrors = new tabla_de_errores();
                        tableErrors.setTitle("Error lexico en gramatica de GUARDAR");

                        tableErrors.errorLexico(save.getErroresLexico());
                        tableErrors.show();
                    }
                    int seleccion = JOptionPane.showConfirmDialog(c, "¿Desea hacer un replay del juego?");
                    replay = new Replay();
                    FixDataReplay f = new FixDataReplay();
                    if (seleccion == 0) {
                        replay(turn, save, true);
                        f.cargarTablero2(save, true);
                        iniciarTablero();
                        inicio_partida.options.setVisible(true);
                        inicio_partida.more_options.enable();
                        replay.time = 2;
                        replay.start();
                    } else if (seleccion == 1) {
                        replay(turn, save, true);
                        f.cargarTablero2(save, true);
                        iniciarTablero();
                        inicio_partida.options.setVisible(true);
                        inicio_partida.more_options.enable();
                        replay.time = 0;
                        replay.start();
                    }
                } else {
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private void replay(ArrayList<Turno> turn, guardar save, boolean v) {
        archivoVs vs = new archivoVs(turn);
        for (int i = 0; i < turn.size(); i++) {
            vs.ArreglarJugadores(i);

            for (int j = 0; j < turn.get(i).getAtaques().size(); j++) {
                if (v) {
                    turn.get(i).getAtaques().get(j).setVerificar(false);

                }
                for (int k = 0; k < game.getArray_neutrales().size(); k++) {
                    vs.ArreglarNeutrales(save, k);
                    vs.arreglarDatosDeTurnos(i, k, j);
                }

                for (int k = 0; k < game.getPlanetas().size(); k++) {
                    vs.arreglarPlanetas(i, j, k);
                }
            }

        }
        turnos = turn;
    }
}
