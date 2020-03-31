/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mapa.juego;
import planetas.galaxia;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class guardar {

    juego juego;
    galaxia tablero[][];
    ArrayList<Turno> list;
    private ArrayList<planeta_jugador> planetas;
    private ArrayList<planeta_neutral> neutrales;
    private ArrayList<String> jugadores;
    private ArrayList<ErrorSintatico> erroresSintatico;
    private ArrayList<ErrorLexico> erroresLexico;

    public ArrayList<ErrorSintatico> getErroresSintatico() {
        return erroresSintatico;
    }

    public void setErroresSintatico(ArrayList<ErrorSintatico> erroresSintatico) {
        this.erroresSintatico = erroresSintatico;
    }

    public ArrayList<ErrorLexico> getErroresLexico() {
        return erroresLexico;
    }

    public void setErroresLexico(ArrayList<ErrorLexico> erroresLexico) {
        this.erroresLexico = erroresLexico;
    }

    public juego getJuego() {
        return juego;
    }

    public galaxia[][] getTablero() {
        return tablero;
    }

    public ArrayList<Turno> getList() {
        return list;
    }

    public ArrayList<planeta_jugador> getPlanetas() {
        return planetas;
    }

    public ArrayList<planeta_neutral> getNeutrales() {
        return neutrales;
    }

    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public guardar(juego juego, galaxia[][] tablero) {
        this.juego = juego;
        this.tablero = tablero;

    }

    public guardar(juego juego, galaxia[][] tablero, ArrayList<Turno> list) {
        this.juego = juego;
        this.tablero = tablero;
        this.list = list;
        imprimir();
    }

    public guardar(ArrayList<planeta_jugador> planetas, ArrayList<planeta_neutral> planetas0, ArrayList<String> jugadores) {
        this.planetas = planetas;
        this.neutrales = planetas0;
    }

    private void imprimir() {
        archivoEntrada file = new archivoEntrada();
        String path = file.getPath();
        String path2 = getSimplePath(path, 0);
        String name = getSimplePath(path, 1);
        String txt = planetas();

        createFile(txt, path);
        txt = turnos();
        createFile(txt, path2 + "/turnos" + name);

        // txt = config();
        // createFile(txt, path2 + "/config" + name);
        File f = inicio_partida.archivoSave;
        f.renameTo(new File(path2 + "/config" + name + ".json"));

    }

    private void createFile(String content, String path) {
        File file = new File(path + ".json");

        if (!file.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(content);
                bw.close();
            } catch (IOException ex) {
            }
        }
    }

    private String getSimplePath(String path, int x) {
        String a[] = path.split("/");
        path = "";
        if (x == 0) {
            for (int i = 0; i < a.length - 1; i++) {
                if (i != 0) {
                    path += "/" + a[i];
                }
            }
        } else {
            path = a[a.length - 1];
        }

        return path;
    }

    public String config() {
        String txt = "";
        String planetas = "";
        String neutrales = "";
        int count1 = 0;
        int count2 = 0;
        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < fil; j++) {
                if (!tablero[i][j].isEmpty()) {
                    String name = tablero[i][j].getPlaneta().getNombre();
                    int naves = tablero[i][j].getPlaneta().getNaves();
                    int produc = tablero[i][j].getPlaneta().getProduccion();
                    double muertes = tablero[i][j].getPlaneta().getMuertes();
                    if (tablero[i][j].getPlaneta().getClass().equals(planeta_neutral.class)) {
                        if (count1 > 0) {
                            neutrales += ",";
                        }
                        neutrales
                                += "	{\n"
                                + "  	  nombre: “" + name + "”,\n"
                                + "  	  naves: " + naves + ",\n"
                                + "  	  produccion: " + produc + ",\n"
                                + "  	  porcentajeMuertes: " + muertes + "\n"
                                + "	}";
                        count1++;
                    } else {
                        if (count2 > 0) {
                            planetas += ",";
                        }
                        planetas
                                += "	{\n"
                                + "  	  nombre: “" + name + "”,\n"
                                + "  	  naves: " + naves + ",\n"
                                + "  	  produccion: " + produc + ",\n"
                                + "  	  porcentajeMuertes: " + muertes + "\n"
                                + "	}";
                        count2++;

                    }
                }
            }

        }

        txt = "{\n"
                + "     PLANETAS : ["
                + planetas
                + "     ] , \n"
                + "     PLANETAS_NEUTRALES : ["
                + neutrales
                + "     ] , \n"
                + mapa(2)
                + "\n"
                + ","
                + players(col, fil)
                + "}";
        return txt;
    }

    private String turnos() {
        String txt = "";
        String retorno = "";
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                txt += ",\n";
            }
            txt += "	{\n"
                    + "	nombre: \"" + list.get(i).getJugador().getJugador() + "\",\n"
                    + "	numeroTurno: " + i + ",\n"
                    + "	ataque:{";

            for (int j = 0; j < list.get(i).getAtaques().size(); j++) {
                if (j > 0) {
                    txt += ",\n";
                }
                String origen = list.get(i).getAtaques().get(j).getO().getPlaneta().getNombre();
                String destino = list.get(i).getAtaques().get(j).getD().getPlaneta().getNombre();
                int trn = list.get(i).getAtaques().get(j).getTrn();
                int naves = list.get(i).getAtaques().get(j).getCant();
                boolean iscom = list.get(i).getAtaques().get(j).isVerificar();
                txt += "{\n"
                        + "		galaxias: {\n"
                        + "			origen: \"" + origen + "\",\n"
                        + "			destino: \"" + destino + "\",\n"
                        + "			turno: " + trn + "	\n"
                        + "		},\n"
                        + "		datos:{\n"
                        + "			naves:" + naves + ",\n"
                        + "			complete: " + iscom + "\n"
                        + "		}\n"
                        + "	}	\n"
                        + "	";
            }
            txt += "	}		\n"
                    + "	\n"
                    + "	}";
        }
        retorno = "{\n"
                + "turno:["
                + txt
                + "]\n"
                + "}";
        return retorno;
    }

    private String mapa(int tipo) {
        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        boolean azar = juego.getMapa().isAzar();
        boolean acum = juego.getMapa().isAcumular();
        boolean mciego = juego.getMapa().isMapaciego();
        boolean showNaves = juego.getMapa().getNeutral().isMostrarNaves();
        boolean showestadisticas = juego.getMapa().getNeutral().isMostrarEstadisticas();

        String txt = "";
        if (tipo == 1) {
            txt = "mapa:\n"
                    + "[\n"
                    + "	dimensiones:[\n"
                    + "         filas:" + col + "\n"
                    + "         columnas:" + fil + "	\n"
                    + "	]\n"
                    + "	azar:" + azar + "\n"
                    + "	mapaciego:" + mciego + "\n"
                    + "	acumular:" + acum + "\n"
                    + "	neutrales:[\n"
                    + "		naves:" + showNaves + "\n"
                    + "		estadisticas:" + showestadisticas + "\n"
                    + "	]\n"
                    + "]";
        } else {
            txt = " MAPA: {\n"
                    + "	id: “" + juego.getMapa().getNombre() + "”,\n"
                    + "	tamaño: {\n"
                    + "	columnas: " + fil + ",\n"
                    + "  	filas: " + col + "\n"
                    + "  	  \n"
                    + "	},\n"
                    + "	alAzar: " + azar + ",\n"
                    + "	planetasNeutrales: 3,\n"
                    + "	mapaCiego: " + mciego + ",\n"
                    + "	acumular: " + acum + ",\n"
                    + "	NEUTRALES: {\n"
                    + "  	  mostrarNaves: " + showNaves + ",\n"
                    + "  	  mostrarEstadisticas: " + showestadisticas + ",\n"
                    + "  	  produccion: " + juego.getMapa().getNeutral().getProduccion() + "\n"
                    + "	},\n"
                    + "	finalizacion: " + juego.getMapa().getFinalizacion() + "\n"
                    + "  }";

        }

        return txt;
    }

    public String planetas() {
        String txt = "";
        String planetas = "";
        String neutrales = "";
        int count1 = 0;
        int count2 = 0;

        int fil = (int) juego.getMapa().getTamaño().getHeight();
        int col = (int) juego.getMapa().getTamaño().getWidth();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < fil; j++) {
                if (!tablero[i][j].isEmpty()) {
                    String name = tablero[i][j].getPlaneta().getNombre();
                    int naves = tablero[i][j].getPlaneta().getNaves();
                    int produc = tablero[i][j].getPlaneta().getProduccion();
                    String dueño = tablero[i][j].getPlaneta().getDueño();
                    int x = tablero[i][j].getCoordx_();
                    int y = tablero[i][j].getCoordy_();
                    int red = tablero[i][j].getColor().getRed();
                    int blue = tablero[i][j].getColor().getBlue();
                    int green = tablero[i][j].getColor().getGreen();

                    if (dueño.isEmpty()) {
                        dueño = "none";
                    }
                    if (tablero[i][j].getPlaneta().getClass().equals(planeta_neutral.class)) {
                        if (count1 > 0) {
                            neutrales += ",";
                        }
                        neutrales += "		{\n"
                                + "			nombre:\"" + name + "\",\n"
                                + "			datos:{\n"
                                + "				naves:" + naves + ",\n"
                                + "				produccion:" + produc + ",\n"
                                + "				dueño:\"" + dueño + "\"		\n"
                                + "			},\n"
                                + "			color:{\n"
                                + "				rojo:" + red + ",\n"
                                + "				verde:" + green + ",\n"
                                + "				azul:" + blue + "			\n"
                                + "			},\n"
                                + "			posicion:{\n"
                                + "				coord_x:" + x + ",\n"
                                + "				coord_y:" + y + "\n"
                                + "                              }"
                                + "             }";
                        count1++;
                    } else {
                        if (count2 > 0) {
                            planetas += ",";
                        }
                        planetas += "		{\n"
                                + "			nombre:\"" + name + "\",\n"
                                + "			datos:{\n"
                                + "				naves:" + naves + ",\n"
                                + "				produccion:" + produc + ",\n"
                                + "				dueño:\"" + dueño + "\"		\n"
                                + "			},\n"
                                + "			color:{\n"
                                + "				rojo:" + red + ",\n"
                                + "				verde:" + green + ",\n"
                                + "				azul:" + blue + "			\n"
                                + "			},\n"
                                + "			posicion:{\n"
                                + "				coord_x:" + x + ",\n"
                                + "				coord_y:" + y + "\n"
                                + "                              }"
                                + "             }";
                        count2++;

                    }

                }
            }

        }
        String jugadores = jugadores();
        txt = "{	PLANETAS_NEUTRALES: [\n"
                + neutrales
                + "		],\n"
                + "	PLANETAS: [\n"
                + planetas
                + "	],"
                + jugadores
                + "}";

        return txt;
    }

    private String jugadores() {
        String txt = "";
        for (int k = 0; k < juego.getArray_jugadores().size(); k++) {
            if (k > 0) {
                txt += ",\n";
            }
            String nombre = juego.getArray_jugadores().get(k).getJugador();
            txt += "	nombre:\"" + nombre + "\"";

        }
        String txt_ = "	JUGADOR:[\n"
                + "	" + txt + "\n"
                + "	]";
        return txt_;
    }

    private String players(int col, int fil) {
        String txt = "";
        String jugadores = "";
        int count = 0;
        int count2 = 0;
        String name = "";
        for (int k = 0; k < juego.getArray_jugadores().size(); k++) {
            name = juego.getArray_jugadores().get(k).getJugador();
            if (count > 0) {
                jugadores += ",\n";
            }
            jugadores
                    += "{\n"
                    + "      nombre: “" + name + "” ,\n"
                    + "      planetas: [";
            name = "";
            count2 = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < fil; j++) {
                    if (!tablero[i][j].isEmpty()) {

                        if (tablero[i][j].getPlaneta().getDueño().equals(juego.getArray_jugadores().get(k).getJugador())) {
                            if (count2 > 0) {
                                name += ",\n";
                            }

                            name += "“" + tablero[i][j].getPlaneta().getNombre() + "”";
                            count2++;
                        }
                    }
                }
            }
            jugadores += name;
            name = juego.getArray_jugadores().get(k).getClass().getSimpleName();
            name = name.toUpperCase();
            jugadores
                    += "       ] ,"
                    + "       tipo: " + name + ""
                    + "}";
            count++;

        }
        txt = "  JUGADORES: [\n"
                + jugadores
                + " ] ";
        return txt;
    }

}
