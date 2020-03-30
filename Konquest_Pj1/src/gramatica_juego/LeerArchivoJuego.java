/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica_juego;

import classes.ErrorSintatico;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import mapa.juego;
import mapa.mapa;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class LeerArchivoJuego {

    public juego getGame(String texto) {

        parser parser = null;
        parser.listaErrores = new ArrayList();
        parser.pbj = new Object[3];
        parser.array_neutrales = new ArrayList();
        parser.array_planetas = new ArrayList();
        parser.array_planetas_ = new ArrayList();
        parser.array_jugadores = new ArrayList();
        lexico_juego scan =null;
        try {
            scan= new lexico_juego(new BufferedReader(new StringReader(texto)));
            parser = new parser(scan);
            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        juego juego = null;
        boolean naves=false;
        boolean estadisticas=false;
        int produc=0;
        try {
            naves = (boolean) parser.pbj[0];
            estadisticas = (boolean) parser.pbj[1];
            produc = (int) parser.pbj[2];
        } catch (NullPointerException e) {

        }

        parser.neutral_ = new planeta_neutral(naves, estadisticas, produc);
        mapa mapa = new mapa(parser.nombre_mapa, parser.dimension, parser.azar_, parser.mapaciego_, parser.acumular_, parser.finalizacion_, parser.planetasNeutrales_, parser.neutral_);

        juego = new juego(mapa, parser.array_jugadores, parser.array_neutrales, parser.array_planetas_);
        juego.iniciarNeutrales();
        juego.configurarNeutrales();
        juego.validarDimensiones();
        juego.setiniciales();
        juego.setListaDeErroresSintaticos(parser.listaErrores);
        juego.setListaDeErroresLexicos(scan.ErrorLexico);
        /*  if (juego.isValidarJuego()) {

        } else {
            System.out.println("Errores");
            System.out.println(juego.getMsj());

        }*/
        return juego;
    }
}
