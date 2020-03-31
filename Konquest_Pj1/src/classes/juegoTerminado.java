/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.inicio_partida;
import static interfaz.inicio_partida.cant_envios;
import static interfaz.inicio_partida.contenido_mapa;
import static interfaz.inicio_partida.end_turno;
import static interfaz.inicio_partida.panel_tablero;
import javax.swing.JOptionPane;
import planetas.galaxia;

/**
 *
 * @author jhonny
 */
public class juegoTerminado extends partida {
    
    public juegoTerminado(mapa.juego juego, galaxia[][] tablero) {
        super(juego, tablero);
    }
    
    public void closeDatas(){
      end_turno.setVisible(false);
        cant_envios.setVisible(false);
        panel_tablero.removeAll();
        panel_tablero.repaint();
        contenido_mapa.repaint();
        contenido_mapa.validate();
        contenido_mapa.revalidate();
        JOptionPane.showMessageDialog(panel_tablero, "Partida finalizada...\n vuelva pronto");
    }
    
    public void closeCliente(){
    inicio_partida.cliente.stop();
    inicio_partida.server.stop();
    }
    private void setTablaStatus(){
    
    String names[]=new String[inicio_partida.game.getArray_jugadores().size()];
        for (int i = 0; i < names.length; i++) {
            names[i]=inicio_partida.game.getArray_jugadores().get(i).getJugador();
        }
    }
    
    
}
