/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konquest_pj1;

import classes.Replay;
import classes.Turno;
import classes.guardar;
import gramaticaReplay.lexico_replay;
import gramaticaReplay.parser_replay;
import static gramaticaReplay.parser_replay.ataques;
import static gramaticaReplay.parser_replay.turnos_;
import gramaticaTurnosCliente_Servidor.lexico_cliente_servidor;
import gramaticaTurnosCliente_Servidor.parser_cliente_servidor;
import gramatica_guardar.LeerArchivoSave;
import gramatica_guardar.lexico_save;
import gramatica_guardar.parser_save;
import gramatica_juego.LeerArchivoJuego;
import gramatica_juego.lexico_juego;
import gramatica_juego.parser;
import interfaz.inicio_partida;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import mapa.juego;
import mapa.mapa;
import planetas_neutral.planeta_neutral;

/**
 * 525
 *
 * @author jhonny
 */
public class Konquest_Pj1 {

    public static ArrayList<Turno> listTurnos;

    public static Turno leer3(File file, String txt, boolean isVs) {
        parser_replay parser = null;
        ataques = new ArrayList();
        turnos_ = new ArrayList();
        try {
            String texto = "";
            if (isVs) {
                texto = txt;
            } else {
                texto = leer(file);
            }
            lexico_replay scan = new lexico_replay(new BufferedReader(new StringReader(texto)));

            parser = new parser_replay(scan);

            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        listTurnos = parser.turnos_;
        Turno trn = null;
        try {
            trn = parser.turnos_.get(0);
        } catch (IndexOutOfBoundsException e) {
            trn = new Turno();
        }
        return trn;
    }

    public static juego probar2(File file) {
        parser.pbj = new Object[3];
        parser parser = null;
        parser.array_neutrales = new ArrayList();
        parser.array_planetas = new ArrayList();
        parser.array_planetas_ = new ArrayList();
        parser.array_jugadores = new ArrayList();
        try {
            String texto = leer(file);
            lexico_juego scan = new lexico_juego(new BufferedReader(new StringReader(texto)));
            parser = new parser(scan);
            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean naves = (boolean) parser.pbj[0];
        boolean estadisticas = (boolean) parser.pbj[1];
        int produc = (int) parser.pbj[2];
        parser.neutral_ = new planeta_neutral(naves, estadisticas, produc);
        mapa mapa = new mapa(parser.nombre_mapa, parser.dimension, parser.azar_, parser.mapaciego_, parser.acumular_, parser.finalizacion_, parser.planetasNeutrales_, parser.neutral_);
        juego juego = new juego(mapa, parser.array_jugadores, parser.array_neutrales, parser.array_planetas_);
        juego.iniciarNeutrales();
        juego.configurarNeutrales();
        juego.validarDimensiones();
        juego.setiniciales();

        /* if (juego.isValidarJuego()) {

        } else {
            System.out.println("Errores");
            System.out.println(juego.getMsj());
        }*/
        return juego;
    }

    public static Turno leer4(String txt) {
        parser_cliente_servidor parser = null;
        parser.ataques = new ArrayList();
        parser.turnos_ = new ArrayList();
        try {
            lexico_cliente_servidor scan = new lexico_cliente_servidor(new BufferedReader(new StringReader(txt)));

            parser = new parser_cliente_servidor(scan);

            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        listTurnos = parser.turnos_;
        return parser.turnos_.get(0);
    }

    public static void main(String[] args) {
        inicio_partida start = new inicio_partida();
        start.show();
        // generarCompilador();
    }

    public static guardar leer2(File file) {

        String texto = leer(file);
        LeerArchivoSave save=new LeerArchivoSave ();
        guardar guardar=save.getSave(texto);
        return guardar;
    }

    private static void generarCompilador() {
        try {
            String ruta = "src/gramatica_juego/"; //ruta donde tenemos los archivos con extension .jflex y .cup
            String opcFlex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            // String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "parser.cup"};
            //  java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String leer(File pj) {
        FileReader fr = null;
        BufferedReader br = null;
        String txt = "";

        try {
            fr = new FileReader(pj);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                txt += (linea) + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return txt;
    }

    public static juego probar1(File file) {
        String texto = leer(file);
        LeerArchivoJuego game = new LeerArchivoJuego();
        juego juego = game.getGame(texto);
        return juego;
    }

}
