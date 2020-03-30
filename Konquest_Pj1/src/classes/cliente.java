/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import gramatica_guardar.LeerArchivoSave;
import gramatica_juego.LeerArchivoJuego;
import interfaz.inicio_partida;
import interfaz.nuevo_juego;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import jugadores.humano;
import konquest_pj1.Konquest_Pj1;
import mapa.juego;

/**
 *
 * @author jhonny
 */
public class cliente extends Thread {

    private final String ip;
    private final int numJugador;

    public cliente(String ip, int numJugador) {
        this.ip = ip;
        this.numJugador = numJugador;
    }

    public int getNumJugador() {
        return numJugador;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public void run() {
        try {
            ServerSocket cliente = new ServerSocket(9090);
            while (true) {
                Socket socket = cliente.accept();
                DataInputStream flujo = new DataInputStream(socket.getInputStream());
                String msj = flujo.readUTF();
                switch (inicio_partida.estadoDeVs) {
                    case 1:
                        if (msj.equals("esperando...")) {
                            guardar save = new guardar(nuevo_juego.juego, nuevo_juego.tablero);
                            String msjEnvio = save.config();
                            msjEnvio += " ENDLESS " + save.planetas();
                            inicio_partida.estadoDeVs = 2;
                            enviarMensaje(msjEnvio);
                        } else {
                            String array[] = msj.split("ENDLESS");
                            LeerArchivoJuego p = new LeerArchivoJuego();
                            juego game = p.getGame(array[0]);

                            LeerArchivoSave sav = new LeerArchivoSave();
                            guardar save = sav.getSave(array[1]);
                            archivoVs vs = new archivoVs(null);
                            nuevo_juego nuevo_cargado = new nuevo_juego();
                            nuevo_cargado.iniciarJuego(game);

                            for (int i = 0; i < game.getArray_neutrales().size(); i++) {
                                vs.ArreglarNeutrales2(save, i);
                            }
                            configurarTableroCliente t = new configurarTableroCliente();
                            t.cargarTablero(save, false);
                            nuevo_cargado.setSize2();
                            nuevo_cargado.show();
                            nuevo_cargado.setSize3();

                            inicio_partida.estadoDeVs = 2;
                        }

                        break;
                    case 2:
                        /*guardar save = new guardar(nuevo_juego.juego, nuevo_juego.tablero);
                        String msjEnvio = save.config();
                        msjEnvio += " ENDLESS " + save.planetas();
                        inicio_partida.estadoDeVs = 2;
                        enviarMensaje(msjEnvio);*/
                        if (msj.contains("ENDLESS")) {
                            String array[] = msj.split("ENDLESS");
                            LeerArchivoJuego read = new LeerArchivoJuego();
                            juego game = read.getGame(array[0]);
                            LeerArchivoSave sav = new LeerArchivoSave();
                            guardar save = sav.getSave(array[1]);
                            archivoVs vs = new archivoVs(null);
                            nuevo_juego.juego = game;
                            for (int i = 0; i < game.getArray_neutrales().size(); i++) {
                                vs.ArreglarNeutrales2(save, i);
                            }
                            configurarTableroCliente t = new configurarTableroCliente();
                            t.cargarTablero(save, false);
                            nuevo_juego.reiniciarTablero2();
                        } else if (msj.contains("CHANGETABLE")) {
                            String array[] = msj.split("ENDLESS");
                            LeerArchivoJuego read = new LeerArchivoJuego();
                            juego game = read.getGame(array[0]);
                            LeerArchivoSave sav = new LeerArchivoSave();
                            guardar save = sav.getSave(array[1]);
                            archivoVs vs = new archivoVs(null);
                            nuevo_juego.juego = game;
                            for (int i = 0; i < game.getArray_neutrales().size(); i++) {
                                vs.ArreglarNeutrales2(save, i);
                            }
                            configurarTableroCliente t = new configurarTableroCliente();
                            t.cargarTablero(save, false);
                        }

                        break;
                    case 3:
                        Konquest_Pj1 p = new Konquest_Pj1();
                        Turno turno = p.leer4(msj);
                        turno.config();
                        inicio_partida.end_turno.setVisible(true);
                        turno.setJugador(jugador(turno.getJugador_()));
                        inicio_partida.turnos.add(turno);
                        inicio_partida.count_player = inicio_partida.cliente.numJugador;
                        if (inicio_partida.count_player == 0) {
                            inicio_partida.ejecutarTurnos();
                            inicio_partida.cant_envios.disable();
                        }
                        inicio_partida.msj_jugador.setText("Jugador " + inicio_partida.game.getArray_jugadores().get(inicio_partida.count_player).getJugador());
                        inicio_partida.validarMov = true;
                        break;
                    default:
                        break;
                }
                flujo.close();
                socket.close();

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "aca");
        }
    }

    public void enviarMensaje(String msj) {
        try {
            Socket socket = new Socket("127.0.0.1", 9009);
            DataOutputStream flujo = new DataOutputStream(socket.getOutputStream());
            flujo.writeUTF(msj);
            flujo.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "ESTE");
        }
    }

    public humano jugador(String name) {
        humano humano = null;
        for (int i = 0; i < inicio_partida.game.getMapa().getTamaño().getWidth(); i++) {
            for (int j = 0; j < inicio_partida.game.getMapa().getTamaño().getHeight(); j++) {
                if (!inicio_partida.tablero[i][j].isEmpty()) {
                    if (name.equals(inicio_partida.tablero[i][j].getPlaneta().getDueño())) {
                        humano = new humano(name);
                        humano.color = inicio_partida.tablero[i][j].getColor();
                        break;
                    }
                }

            }
        }

        return humano;
    }

}
