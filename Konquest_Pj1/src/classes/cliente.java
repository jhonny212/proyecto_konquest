/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import jugadores.humano;
import jugadores.jugador;
import konquest_pj1.Konquest_Pj1;

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
                Konquest_Pj1 p = new Konquest_Pj1();
                Turno turno = p.leer4(msj);
                turno.config();
                turno.setJugador(jugador(turno.getJugador_()));
                inicio_partida.turnos.add(turno);

               
                if (inicio_partida.count_player == 1) {
                    inicio_partida.count_player = 0;
                  //  inicio_partida.ejecutarTurnos();
                    inicio_partida.cant_envios.disable();
                    inicio_partida.msj_jugador.setText("Jugador " + inicio_partida.game.getArray_jugadores().get(0).getJugador());
                } else {
                    inicio_partida.count_player = 1;
                    inicio_partida.msj_jugador.setText("Jugador " + inicio_partida.game.getArray_jugadores().get(1).getJugador());

                }

                inicio_partida.validarMov = true;

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
        for (int i = 0; i < inicio_partida.game.getArray_jugadores().size(); i++) {
            if (name.equals(inicio_partida.game.getArray_jugadores().get(i).getJugador())) {
                humano = (humano) inicio_partida.game.getArray_jugadores().get(i);
                break;
            }

        }
        return humano;
    }
}
