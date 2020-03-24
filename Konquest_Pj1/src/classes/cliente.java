/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
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
                inicio_partida.end_turno.setVisible(true);
                turno.setJugador(jugador(turno.getJugador_()));
                inicio_partida.turnos.add(turno);
                inicio_partida.count_player = inicio_partida.cliente.numJugador;
                if (inicio_partida.count_player == 0) {
                    inicio_partida.ejecutarTurnos();
                    inicio_partida.cant_envios.disable();
                }
                /* if (inicio_partida.count_player == 1) {
                    inicio_partida.count_player = 0;
                  //  inicio_partida.ejecutarTurnos();
                    inicio_partida.cant_envios.disable();
                    inicio_partida.msj_jugador.setText("Jugador " + inicio_partida.game.getArray_jugadores().get(0).getJugador());
                } else {
                    inicio_partida.count_player = 1;
               
                }*/
                inicio_partida.msj_jugador.setText("Jugador " + inicio_partida.game.getArray_jugadores().get(inicio_partida.count_player).getJugador());
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
        for (int i = 0; i < inicio_partida.game.getMapa().getTamaño().getWidth(); i++) {
            for (int j = 0; j < inicio_partida.game.getMapa().getTamaño().getHeight(); j++) {
                if(!inicio_partida.tablero[i][j].isEmpty())
                {
                   if (name.equals(inicio_partida.tablero[i][j].getPlaneta().getDueño())) {
                    humano = new humano(name);
                    humano.color=inicio_partida.tablero[i][j].getColor();
                    break;
                }
                }
             
            }
        }

        return humano;
    }
    
  
}
