/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
        System.out.println(config());
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
        String txt = "";
        txt += planetas() + "\n";
        txt += turnos();
        System.out.println(txt);
        txt=config();
        System.out.println(txt);
        
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
        
        txt     ="{\n"
                + "     PLANETAS : ["
                + planetas
                + "     ] , \n"
                + "     PLANETAS_NEUTRALES : ["
                + neutrales
                + "     ] , \n"
                + mapa(1)
                + "\n"
                + ","
                + "     JUGADORES : ["
                + jugadores()
                + "     ]"
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
                    + "	id: “"+juego.getMapa().getNombre()+"”,\n"
                    + "	tamaño: {\n"
                    + "	columnas: "+fil+",\n"
                    + "  	filas: "+col+"\n"
                    + "  	  \n"
                    + "	},\n"
                    + "	alAzar: "+azar+",\n"
                    + "	planetasNeutrales: 3,\n"
                    + "	mapaCiego: "+mciego+",\n"
                    + "	acumular: "+acum+",\n"
                    + "	NEUTRALES: {\n"
                    + "  	  mostrarNaves: "+showNaves+",\n"
                    + "  	  mostrarEstadisticas: "+showestadisticas+",\n"
                    + "  	  produccion: "+juego.getMapa().getNeutral().getProduccion()+"\n"
                    + "	},\n"
                    + "	finalizacion: "+juego.getMapa().getFinalizacion()+"\n"
                    + "  }";

        }

        return txt;
    }

    private String planetas() {
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
                    + "      nombre= “" + name + "” ,\n"
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
            name = juego.getArray_jugadores().get(k).getClass().getSimpleName();
            jugadores
                    += "       ] ,"
                    + "       tipo: “" + name + "”"
                    + "}";
            count++;

        }
        txt = "  JUGADORES: [\n"
                + jugadores
                + " ] ";
        return txt;
    }

}
