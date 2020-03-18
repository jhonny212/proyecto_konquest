/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konquest_pj1;

import gramatica_guardar.lexico_save;
import gramatica_guardar.parser_save;
import gramatica_juego.lexico_juego;
import gramatica_juego.parser;
import interfaz.inicio_partida;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import mapa.juego;
import mapa.mapa;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 * 525
 *
 * @author jhonny
 */
public class Konquest_Pj1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicio_partida start = new inicio_partida();
        start.show();
        //generarCompilador();
        //leer2();
        // probar1();
    }

    public static juego leer2() {
        parser_save parser = null;
        parser.lista_ = new ArrayList();
        parser.neutrales_ = new ArrayList();
        parser.jugadores_ = new ArrayList();
        parser.players_ = new ArrayList();
        parser.Tipo_ = "";
        parser.count = 0;

        /*

import static gramatica_guardar.parser_save.Blue;
import static gramatica_guardar.parser_save.Green;
import static gramatica_guardar.parser_save.Muertes_;
import static gramatica_guardar.parser_save.Naves_;
import java_cup.runtime.Symbol;
import java.awt.Dimension;
import java.util.ArrayList;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;
import jugadores.jugador;
import static gramatica_guardar.parser_save.Nombre_;
import static gramatica_guardar.parser_save.Produccion_;
import static gramatica_guardar.parser_save.Red;
import static gramatica_guardar.parser_save.Tipo_;
import static gramatica_guardar.parser_save.coord_x;
import static gramatica_guardar.parser_save.coord_y;
import static gramatica_guardar.parser_save.dimension_;
import static gramatica_guardar.parser_save.jugadores_;
import static gramatica_guardar.parser_save.lista_;
import static gramatica_guardar.parser_save.neutrales_;
import static gramatica_guardar.parser_save.players_;

import static gramatica_guardar.parser_save.azar_;
import static gramatica_guardar.parser_save.mapaciego_;
import static gramatica_guardar.parser_save.acumular_;
import static gramatica_guardar.parser_save.naves_;
import static gramatica_guardar.parser_save.estadisticas_;
import static gramatica_guardar.parser_save.isNeutral_;
import java.awt.Color;
import jugadores.dificil;
import jugadores.facil;
import jugadores.humano;      
         */
        try {
            File file = new File("/home/jhonny/Escritorio/5to. Semestre/compiladores1/proyectos/entrada.txt");
            String texto = "mapa:\n"
                    + "[\n"
                    + "	dimensiones:[\n"
                    + "	filas:5\n"
                    + "	columnas:5\n"
                    + "	]"
                    + " azar:true"
                    + "	mapaciego:true"
                    + "	acumular:true"
                    + "	neutrales:["
                    + "		naves:true\n"
                    + "		estadisticas:true\n"
                    + "	]\n"
                    + "]\n planetas:[\n"
                    + "	{\n"
                    + "	neutral:true\n"
                    + "	nombre:fsa\n"
                    + "	naves:1\n"
                    + "	produccion:2\n"
                    + "	muertes:0.01\n"
                    + "	posicion{\n"
                    + "	coord_x: 2\n"
                    + "	coord_y: 2	\n"
                    + "	}\n"
                    + "	}"
                    + "	{\n"
                    + "	neutral:false\n"
                    + "	nombre:dd\n"
                    + "	naves:1\n"
                    + "	produccion:2\n"
                    + "	muertes:0.01\n"
                    + "	posicion{\n"
                    + "	coord_x: 1\n"
                    + "	coord_y: 1	\n"
                    + "	}\n"
                    + "	}"
                    + "	{\n"
                    + "	neutral:true\n"
                    + "	nombre:dda\n"
                    + "	naves:1\n"
                    + "	produccion:2\n"
                    + "	muertes:0.01\n"
                    + "	posicion{\n"
                    + "	coord_x: 0\n"
                    + "	coord_y: 1	\n"
                    + "	}\n"
                    + "	}"
                    + "] jugadores:[\n"
                    + "	{\n"
                    + "	nombre:ostia\n"
                    + "	tipo:dificil\n"
                    + "	color:[\n"
                    + "	rojo:12\n"
                    + "	azul:12\n"
                    + "	verde:12\n"
                    + "	]"
                    + "	planetas:[\n"
                    + "	nombre:g1\n"
                    + "	nombre:g2\n"
                    + "	nombre:g3\n"
                    + "	]\n"
                    + "	}\n"
                    + "	{\n"
                    + "	nombre:hola\n"
                    + "	tipo:dificil\n"
                    + "	color:[\n"
                    + "	rojo:12\n"
                    + "	azul:12\n"
                    + "	verde:12\n"
                    + "	]"
                    + "	planetas:[\n"
                    + "	nombre:dg1\n"
                    + "	nombre:dg2\n"
                    + "	nombre:dg3\n"
                    + "	]\n"
                    + "	}\n"
                    + "	{\n"
                    + "	nombre:holass\n"
                    + "	tipo:dificil\n"
                    + "	color:[\n"
                    + "	rojo:120\n"
                    + "	azul:140\n"
                    + "	verde:122\n"
                    + "	]"
                    + "	planetas:[\n"
                    + "	nombre:fa1\n"
                    + "	nombre:dd\n"
                    + "	nombre:fa3\n"
                    + "	]\n"
                    + "	}\n"
                    + "]";

            lexico_save scan = new lexico_save(new BufferedReader(new StringReader(texto)));
            parser = new parser_save(scan);
            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(parser.mapaciego_);
        System.out.println(parser.acumular_);
        System.out.println(parser.naves_);
        System.out.println(parser.estadisticas_);

        System.out.println(parser.dimension_.getHeight());
        System.out.println(parser.dimension_.getWidth());
        System.out.println("\n \n");

        for (int i = 0; i < parser.neutrales_.size(); i++) {
            System.out.println(parser.neutrales_.get(i).getNombre() + "Nombre");
            System.out.println(parser.neutrales_.get(i).getNaves() + "Naves");
            System.out.println(parser.neutrales_.get(i).getProduccion() + "Produccion");
            System.out.println(parser.neutrales_.get(i).getMuertes() + "Muertes");
            System.out.println(parser.neutrales_.get(i).getX_() + "X:");
            System.out.println(parser.neutrales_.get(i).getY_() + "Y:");

        }

        for (int i = 0; i < parser.jugadores_.size(); i++) {
            System.out.println(parser.jugadores_.get(i).getNombre() + "Nombre");
            System.out.println(parser.jugadores_.get(i).getNaves() + "Naves");
            System.out.println(parser.jugadores_.get(i).getProduccion() + "Produccion");
            System.out.println(parser.jugadores_.get(i).getMuertes() + "Muertes");
            System.out.println(parser.jugadores_.get(i).getX_() + "X:");
            System.out.println(parser.jugadores_.get(i).getY_() + "Y:");

        }
        int count = parser.players_.size() - 1;

        ArrayList<planeta_jugador> t0 = parser.players_.get(0).getPlanetas();
        ArrayList<planeta_jugador> t2 = new ArrayList();
        int count2 = 0;
        for (int j = 0; j < t0.size(); j++) {
            if (!t0.get(j).getNombre().equals("nuevo")) {
                System.out.println(t0.get(j).getNombre());
                t2.add(t0.get(j));

            } else {
                if (!t2.isEmpty()) {
                    parser.players_.get(count).setPlanetas(t2);
                    count--;
                    count2 = j;
                    t2 = new ArrayList();
                }
            }
        }
        t2 = new ArrayList();
        for (int j = count2 + 1; j < t0.size(); j++) {
            t2.add(t0.get(j));
        }
        parser.players_.get(0).setPlanetas(t2);
        System.out.println("------------------------------------------------------------------------------------------_>");

        for (int i = 0; i < parser.players_.size(); i++) {
            ArrayList<planeta_jugador> t = parser.players_.get(i).getPlanetas();
            for (int j = 0; j < t.size(); j++) {
                parser.players_.get(i).getPlanetas().get(j).setDueño(parser.players_.get(i).getJugador());
                for (int k = 0; k < parser.neutrales_.size(); k++) {
                    if (t.get(j).getNombre().equals(parser.neutrales_.get(k).getNombre())) {
                        parser.neutrales_.get(k).setDueño(parser.players_.get(i).getJugador());
                        parser.neutrales_.get(k).setColor(parser.players_.get(i).getColor());
                        parser.players_.get(i).getPlanetas().remove(j);
                    }
                }
            }
            for (int j = 0; j < t.size(); j++) {
                for (int k = 0; k < parser.jugadores_.size(); k++) {
                    if(t.get(j).getNombre().equals(parser.jugadores_.get(k).getNombre())){
                       parser.jugadores_.get(k).setColor(t.get(j).getColorPlaneta());
                       parser.jugadores_.get(k).setDueño(parser.players_.get(i).getJugador());
                    }
                }
            }
            
        }
        System.out.println("------------------------------------------------------------------------------------------_>");

        for (int i = 0; i < parser.players_.size(); i++) {
            System.out.println("nombre:" + parser.players_.get(i).getJugador());
            System.out.println("tipo:" + parser.players_.get(i).getClass().getSimpleName());
            System.out.println("Colores:");
            System.out.println("        rojo:" + parser.players_.get(i).getColor().getRed());
            System.out.println("        verde:" + parser.players_.get(i).getColor().getGreen());
            System.out.println("        azul:" + parser.players_.get(i).getColor().getBlue());
            System.out.println("Planetas:");
            ArrayList<planeta_jugador> t = parser.players_.get(i).getPlanetas();
            for (int j = 0; j < t.size(); j++) {
                System.out.println("   aca     ::" + t.get(j).getNombre() + " " + t.get(j).getDueño());
            }
        }

        for (int k = 0; k < parser.neutrales_.size(); k++) {
            System.out.println("   aca::::::::" + parser.neutrales_.get(k).getDueño());

        }

        mapa map = new mapa("f", parser.dimension_, parser.azar_, parser.mapaciego_, parser.acumular_, 0, 0, new planeta_neutral(parser.naves_, parser.estadisticas_, 0));
        juego game = new juego(map, parser.players_, parser.neutrales_, parser.jugadores_);

        return game;
    }

    private static void generarCompilador() {
        try {
            String ruta = "src/gramatica_guardar/"; //ruta donde tenemos los archivos con extension .jflex y .cup
            String opcFlex[] = {ruta + "lexico_save.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser_save", ruta + "parser_save.cup"};
            java_cup.Main.main(opcCUP);
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

    public static juego probar1() {
        parser.pbj = new Object[3];
        parser parser = null;
        parser.array_neutrales = new ArrayList();
        parser.array_planetas = new ArrayList();
        parser.array_planetas_ = new ArrayList();
        parser.array_jugadores = new ArrayList();

        try {
            File file = new File("/home/jhonny/Escritorio/5to. Semestre/compiladores1/proyectos/entrada.txt");
            String texto = leer(file);

            lexico_juego scan = new lexico_juego(new BufferedReader(new StringReader(texto)));
            parser = new parser(scan);
            parser.parse();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finaliza el analisis...");

        boolean naves = (boolean) parser.pbj[0];
        boolean estadisticas = (boolean) parser.pbj[1];
        int produc = (int) parser.pbj[2];
        parser.neutral_ = new planeta_neutral(naves, estadisticas, produc);

        mapa mapa = new mapa(parser.nombre_mapa, parser.dimension, parser.azar_, parser.mapaciego_, parser.acumular_, parser.finalizacion_, parser.planetasNeutrales_, parser.neutral_);

        /* for (int i = 0; i < parser.array_neutrales.size(); i++) {
            System.out.println(parser.array_neutrales.get(i).getProduccion()+" "+parser.array_neutrales.get(i).getNaves()+" "+parser.array_neutrales.get(i).getNombre());
            
        }
        for (int i = 0; i < parser.array_jugadores.size(); i++) {
            System.out.println(parser.array_jugadores.get(i).getJugador());
            for (int j = 0; j < parser.array_jugadores.get(i).getPlanetas().size(); j++) {
                
                System.out.println(parser.array_jugadores.get(i).getPlanetas().get(j));
            }
            
        }*/
        for (int i = 0; i < parser.array_planetas_.size(); i++) {
            System.out.println(parser.azar_);
        }

        juego juego = new juego(mapa, parser.array_jugadores, parser.array_neutrales, parser.array_planetas_);
        juego.iniciarNeutrales();
        juego.configurarNeutrales();
        juego.validarDimensiones();
        if (juego.isValidarJuego()) {

        } else {
            System.out.println("Errores");
            System.out.println(juego.getMsj());

        }
        return juego;
    }

}
