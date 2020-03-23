/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jugadores.humano;
import konquest_pj1.Konquest_Pj1;

/**
 *
 * @author jhonny
 */
public class cliente extends Thread {

    private final String ip;

    public cliente(String ip) {
        this.ip = ip;
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
                Turno turno = p.leer3(null,msj,true);
                turno.setJugador(new humano(turno.getJugador_()));
                inicio_partida.turnos.add(turno);
                if(inicio_partida.count_player==1)
                {
                inicio_partida.count_player=0;
                inicio_partida.ejecutarTurnos();
                inicio_partida.validarMov=true;
                }
                else {
                inicio_partida.count_player=1;
                inicio_partida.validarMov=true;
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
}
