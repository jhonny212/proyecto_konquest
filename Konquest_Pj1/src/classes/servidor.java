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

/**
 *
 * @author jhonny
 */
public class servidor extends Thread {

    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(9009);
            while (true) {
                Socket socket = servidor.accept();
                DataInputStream flujo = new DataInputStream(socket.getInputStream());
                String msj = flujo.readUTF();
                if (!msj.isEmpty()) {
                    try {
                        System.out.println("entra");
                        Socket socket2 = new Socket(inicio_partida.cliente.getIp(), 9090);
                        DataOutputStream flujo2 = new DataOutputStream(socket2.getOutputStream());
                        flujo2.writeUTF(msj);
                        flujo2.close();
                        socket2.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage() + "------------>");
                    }
                }
                flujo.close();
                socket.close();

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "aca");
        }
    }
}
