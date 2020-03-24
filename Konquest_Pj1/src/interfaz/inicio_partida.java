/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import classes.Ataque;
import classes.CuadroTexto;
import classes.MouseControl;
import classes.Replay;
import classes.Turno;
import classes.archivoEntrada;
import classes.cliente;
import classes.distancia;
import classes.guardar;
import classes.servidor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import konquest_pj1.Konquest_Pj1;
import mapa.juego;
import planetas.galaxia;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class inicio_partida extends javax.swing.JFrame {

    /**
     * Creates new form inicio_partida
     */
    public static juego game;
    public static galaxia tablero[][];
    public static int filas, columnas, contadorDeTurnos;
    public static Replay replay;
    public static boolean isVs;
    public static cliente cliente;
    private servidor server;

    public static void ejecutarTurnos() {
        int x = contadorDeTurnos + 1;
        mensajes_txt.setEditable(true);
        inicio_partida.mensajes_txt.append(Color.white, "Turno " + x + " \n \n");

        if (!turnos.isEmpty()) {
            for (int i = 0; i < turnos.size(); i++) {
                if (turnos.get(i).isValidar_()) {
                    turnos.get(i).realizarAtaque(contadorDeTurnos + 1);
                }
            }
            turnos.get(0).construir(game.getMapa().isAcumular());

        }
        contadorDeTurnos++;
        mensajes_txt.setEditable(false);
    }

    Dimension dimension;
    boolean showtools, showmensajes;
    public static boolean medirDistancia, destino, validarMov, origenMov;
    Border bd;
    public static int count_player;
    public static galaxia _o, _d;
    public static ArrayList<Turno> turnos;
    static ArrayList<Ataque> ataques;
    public static CuadroTexto mensajes_txt;
    public static String mensajeServidor;

    public inicio_partida() {
        contadorDeTurnos = 0;
        mensajeServidor = "";
        turnos = new ArrayList();
        ataques = new ArrayList();
        count_player = 0;
        dimension = new Dimension();
        game = null;
        destino = false;
        origenMov = false;
        initComponents();
        bd = this.terminar_partida.getBorder();
        showtools = true;
        showmensajes = true;
        dimension = more_options.getSize();
        more_options.disable();
        more_options.setBackground(Color.white);
        options.setVisible(false);
        show.setEnabled(true);
        medirDistancia = false;
        validarMov = false;
        _o = new galaxia();
        _d = new galaxia();
        jPanel1.setSize(new Dimension(1290, 660));
        mensajes_txt = new CuadroTexto();
        mensajes_txt.setSize(new Dimension(1280, 550));
        mensajes_txt.setBackground(Color.BLACK);
        jScrollPane1.setViewportView(mensajes_txt);
        contenido_mapa.setSize(new Dimension((int) contenido_mapa.getSize().getWidth(), 500));
        jScrollPane1.setSize(new Dimension(0, 0));
        showmensajes = false;
        iniciarTablero();

    }

    public static void iniciarContadorPlayer() {
        try {
            msj_jugador.setText("Jugador " + game.getArray_jugadores().get(count_player).getJugador() + ": seleccione el planeta origen");
        } catch (IndexOutOfBoundsException e) {
            ejecutarTurnos();
            count_player = 0;
        }
        msj_jugador.setText("Jugador " + game.getArray_jugadores().get(count_player).getJugador() + ": seleccione el planeta origen");
        cant_envios.disable();
        if (isVs && contadorDeTurnos > 0) {
            cliente.enviarMensaje(mensajeServidor);
            mensajeServidor = "";
            validarMov = false;
            JOptionPane.showMessageDialog(panel_tablero, "entra aca------------------>");
        } else {
            if (contadorDeTurnos == 0 && cliente.getNumJugador() == 0) {
                validarMov = false;
            } else {
                validarMov = true;
            }
        }

    }

    public static void ininiar_O_D(galaxia o, galaxia d) {
        _o = o;
        _d = d;
    }

    public static void iniciarTablero() {
        panel_tablero.removeAll();
        panel_tablero.repaint();
        try {
            MouseControl btn = new MouseControl(game);
            panel_tablero.setLayout(new java.awt.GridLayout(filas, columnas));
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    ActionListener[] action = tablero[i][j].getActionListeners();
                    try {
                        tablero[i][j].removeActionListener((ActionListener) action[0]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    if (!tablero[i][j].isEmpty()) {
                        tablero[i][j].setCoordx_(i);
                        tablero[i][j].setCoordy_(j);
                        tablero[i][j].addMouseListener(btn);
                        reiniciar(i, j);

                    }
                    tablero[i][j].setFocusPainted(false);
                    tablero[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

                    panel_tablero.add(tablero[i][j]);

                }

            }

        } catch (Exception e) {
        }
        contenido_mapa.repaint();
        contenido_mapa.validate();
        contenido_mapa.revalidate();
    }

    public static void realizarMovimiento() {
        validarMov = false;
        JOptionPane.showMessageDialog(options, "Seleccione el planeta destino");
        origenMov = true;

    }

    public static void iniciarMov() {
        JOptionPane.showMessageDialog(options, "Introduzca la cantidad de naves para enviar");
        cant_envios.enable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contenido_mapa = new javax.swing.JScrollPane();
        panel_tablero = new javax.swing.JPanel();
        more_options = new javax.swing.JPanel();
        terminar_partida = new javax.swing.JButton();
        fin_turno = new javax.swing.JButton();
        medir_distancia = new javax.swing.JButton();
        mostrar_posiciones = new javax.swing.JButton();
        vista_general = new javax.swing.JButton();
        barra_mensajes = new javax.swing.JButton();
        options = new javax.swing.JPanel();
        msj_jugador = new javax.swing.JLabel();
        end_turno = new javax.swing.JButton();
        cant_envios = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu_juego = new javax.swing.JMenuBar();
        juego = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        opciones = new javax.swing.JMenu();
        show = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(206, 196, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panel_tableroLayout = new javax.swing.GroupLayout(panel_tablero);
        panel_tablero.setLayout(panel_tableroLayout);
        panel_tableroLayout.setHorizontalGroup(
            panel_tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1258, Short.MAX_VALUE)
        );
        panel_tableroLayout.setVerticalGroup(
            panel_tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        contenido_mapa.setViewportView(panel_tablero);

        jPanel1.add(contenido_mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 1110, 370));

        more_options.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        terminar_partida.setBackground(java.awt.Color.white);
        terminar_partida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image URL.jpg"))); // NOI18N
        terminar_partida.setText("Finalizar partida");
        terminar_partida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        terminar_partida.setFocusPainted(false);
        terminar_partida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                terminar_partidaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                terminar_partidaMouseEntered(evt);
            }
        });
        more_options.add(terminar_partida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        fin_turno.setBackground(java.awt.Color.white);
        fin_turno.setText("Fin de turno");
        fin_turno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fin_turno.setFocusPainted(false);
        fin_turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fin_turnoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fin_turnoMouseEntered(evt);
            }
        });
        more_options.add(fin_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 140, 40));

        medir_distancia.setBackground(java.awt.Color.white);
        medir_distancia.setText("Medir distancia");
        medir_distancia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        medir_distancia.setFocusPainted(false);
        medir_distancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                medir_distanciaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                medir_distanciaMouseEntered(evt);
            }
        });
        medir_distancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medir_distanciaActionPerformed(evt);
            }
        });
        more_options.add(medir_distancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 140, 40));

        mostrar_posiciones.setBackground(java.awt.Color.white);
        mostrar_posiciones.setText("Mostrar posiciones");
        mostrar_posiciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mostrar_posiciones.setFocusPainted(false);
        mostrar_posiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostrar_posicionesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostrar_posicionesMouseEntered(evt);
            }
        });
        mostrar_posiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_posicionesActionPerformed(evt);
            }
        });
        more_options.add(mostrar_posiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, 40));

        vista_general.setBackground(java.awt.Color.white);
        vista_general.setText("Vista general de flota");
        vista_general.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        vista_general.setFocusPainted(false);
        vista_general.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vista_generalMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vista_generalMouseEntered(evt);
            }
        });
        vista_general.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vista_generalActionPerformed(evt);
            }
        });
        more_options.add(vista_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, 40));

        barra_mensajes.setBackground(java.awt.Color.white);
        barra_mensajes.setText("Ocultar/Mostrar barra de mensajes");
        barra_mensajes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barra_mensajes.setFocusPainted(false);
        barra_mensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barra_mensajesActionPerformed(evt);
            }
        });
        more_options.add(barra_mensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 330, 40));

        jPanel1.add(more_options, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 40));

        options.setBackground(new java.awt.Color(21, 16, 12));
        options.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msj_jugador.setFont(new java.awt.Font("Ubuntu Mono", 1, 14)); // NOI18N
        msj_jugador.setForeground(new java.awt.Color(234, 229, 229));
        msj_jugador.setText("jLabel2");
        options.add(msj_jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 960, 20));

        end_turno.setText("Terminar turno");
        end_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                end_turnoActionPerformed(evt);
            }
        });
        options.add(end_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, -1, -1));

        cant_envios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cant_enviosKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cant_enviosKeyReleased(evt);
            }
        });
        options.add(cant_envios, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 120, 30));

        jPanel1.add(options, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1290, 50));
        options.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 510));
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 512, 1280, 150));

        menu_juego.setOpaque(false);

        juego.setText("Juego");
        juego.setFont(new java.awt.Font("Ubuntu Mono", 0, 18)); // NOI18N
        juego.setOpaque(true);
        juego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                juegoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                juegoMouseEntered(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Ubuntu Mono", 0, 16)); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        juego.add(jMenuItem1);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Cargar partida");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        juego.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Guardar partida");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        juego.add(save);

        menu_juego.add(juego);

        opciones.setText("Opciones");
        opciones.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        opciones.setOpaque(true);
        opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionesMouseEntered(evt);
            }
        });

        show.setSelected(true);
        show.setText("Mostrar barra herramientas");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        opciones.add(show);

        menu_juego.add(opciones);

        setJMenuBar(menu_juego);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseEntered
        // TODO add your handling code here:
        java.awt.Color blue = new java.awt.Color(147, 226, 238);
        this.opciones.setBackground(blue);
        this.opciones.setText(this.opciones.getText().toUpperCase());

    }//GEN-LAST:event_opcionesMouseEntered

    private void opcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseExited
        // TODO add your handling code here:
        this.opciones.setBackground(null);
        this.opciones.setText(this.opciones.getText().toLowerCase());

    }//GEN-LAST:event_opcionesMouseExited

    private void juegoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_juegoMouseEntered
        // TODO add your handling code here:
        java.awt.Color blue = new java.awt.Color(147, 226, 238);
        this.juego.setBackground(blue);
        this.juego.setText(this.juego.getText().toUpperCase());

    }//GEN-LAST:event_juegoMouseEntered

    private void juegoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_juegoMouseExited
        // TODO add your handling code here:
        this.juego.setBackground(null);
        this.juego.setText(this.juego.getText().toLowerCase());

    }//GEN-LAST:event_juegoMouseExited

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea jugar vs otra maquina?", "Message", 1);
        archivoEntrada archivo = new archivoEntrada();

        switch (seleccion) {

            case 0:

                game = Konquest_Pj1.probar1(archivo.generateFile());
                game.voidValidarTodos();
                isVs = false;
                if (game.isValidarJuego()) {
                    nuevo_juego nuevo_cargado = new nuevo_juego();
                    nuevo_cargado.show();
                    mensajes_txt.setText("");
                    nuevo_cargado.iniciarJuego(game);
                    nuevo_cargado.setSize();
                } else {

                    JOptionPane.showMessageDialog(this, game.getMsj());
                }
                break;
            case 1:
                game = Konquest_Pj1.probar2(archivo.generateFile());
                game.voidValidarTodos();
                isVs = true;
                if (game.isValidarJuego() && game.getArray_jugadores().size() == 2) {
                    nuevo_juego nuevo_cargado = new nuevo_juego();
                    nuevo_cargado.setVs(true);
                    String ip = JOptionPane.showInputDialog(this, "Escriba la ip del jugador contrincante", "Ejemplo 192.168.0.10", 0);
                    String numeroJugador = JOptionPane.showInputDialog(this, "Ingrese el numero de jugador que desea ser", 0);
                    try {
                        ip.isEmpty();
                        server = new servidor();
                        server.start();
                        cliente = new cliente(ip, Integer.parseInt(numeroJugador));
                        cliente.start();
                        nuevo_cargado.show();
                        mensajes_txt.setText("");
                        nuevo_cargado.iniciarJuego(game);
                        nuevo_cargado.setSize();
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(this, "Vuelva pronto...");
                    } catch (NumberFormatException ex) {
                    }

                } else {
                    JOptionPane.showMessageDialog(this, game.getMsj());
                }
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
        if (showtools) {
            more_options.setVisible(false);
            showtools = false;
        } else {
            more_options.setVisible(true);
            showtools = true;
        }
    }//GEN-LAST:event_showActionPerformed

    private void terminar_partidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminar_partidaMouseEntered
        // TODO add your handling code here:
        this.terminar_partida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
    }//GEN-LAST:event_terminar_partidaMouseEntered

    private void terminar_partidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminar_partidaMouseExited
        // TODO add your handling code here:
        this.terminar_partida.setBorder(bd);
    }//GEN-LAST:event_terminar_partidaMouseExited

    private void fin_turnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fin_turnoMouseEntered
        // TODO add your handling code here:
        this.fin_turno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
    }//GEN-LAST:event_fin_turnoMouseEntered

    private void fin_turnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fin_turnoMouseExited
        // TODO add your handling code here:
        this.medir_distancia.setBorder(bd);
    }//GEN-LAST:event_fin_turnoMouseExited

    private void medir_distanciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medir_distanciaMouseEntered
        // TODO add your handling code here:
        this.medir_distancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
    }//GEN-LAST:event_medir_distanciaMouseEntered

    private void medir_distanciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medir_distanciaMouseExited
        // TODO add your handling code here:
        this.medir_distancia.setBorder(bd);
    }//GEN-LAST:event_medir_distanciaMouseExited

    private void mostrar_posicionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrar_posicionesMouseExited
        // TODO add your handling code here:
        this.mostrar_posiciones.setBorder(bd);
    }//GEN-LAST:event_mostrar_posicionesMouseExited

    private void mostrar_posicionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrar_posicionesMouseEntered
        // TODO add your handling code here:
        this.mostrar_posiciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
    }//GEN-LAST:event_mostrar_posicionesMouseEntered

    private void vista_generalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vista_generalMouseEntered
        // TODO add your handling code here:
        this.vista_general.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
    }//GEN-LAST:event_vista_generalMouseEntered

    private void vista_generalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vista_generalMouseExited
        // TODO add your handling code here:
        this.vista_general.setBorder(bd);
    }//GEN-LAST:event_vista_generalMouseExited

    private void medir_distanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medir_distanciaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Seleccione el planeta origen");
        medirDistancia = true;
        validarMov = false;
    }//GEN-LAST:event_medir_distanciaActionPerformed
    public void atacar(Turno trn) {
        options.enable();
        origenMov = false;
        // Turno trn = new Turno(ataques, game.getArray_jugadores().get(count_player));
        //   

        turnos.add(trn);
        if (!turnos.isEmpty()) {
            for (int i = 0; i < turnos.size(); i++) {
                if (turnos.get(i).isValidar_()) {
                    turnos.get(i).realizarAtaque(turnos.size());
                    trn.construir(game.getMapa().isAcumular());
                }
            }
        }

        ataques = new ArrayList();
        count_player++;
        cant_envios.disable();
        end_turno.disable();
        iniciarContadorPlayer();
    }

    private void end_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_end_turnoActionPerformed
        options.enable();
        origenMov = false;
        Turno trn = new Turno(ataques, game.getArray_jugadores().get(count_player));
        if (isVs) {
            mensajeServidor += trn.msj(turnos.size());
        }
        turnos.add(trn);
        ataques = new ArrayList();
        count_player++;
        cant_envios.disable();
        end_turno.disable();
        iniciarContadorPlayer();

    }//GEN-LAST:event_end_turnoActionPerformed

    private void cant_enviosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cant_enviosKeyTyped
        // TODO add your handling code here:
        char e = evt.getKeyChar();

        if (Character.isDigit(e)) {
        } else {
            evt.consume();
        }

    }//GEN-LAST:event_cant_enviosKeyTyped

    private void cant_enviosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cant_enviosKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int cant = Integer.parseInt(cant_envios.getText());
            if (cant <= _o.getPlaneta().getNaves()) {
                distancia d = new distancia(_o, _d);
                Object t[] = d.turno();
                int tr = (int) t[0];
                tr += contadorDeTurnos;
                String msj = "La distancia desde el planeta " + _o.getPlaneta().getNombre() + " al planeta " + _d.getPlaneta().getNombre() + ""
                        + " es de " + t[1] + " años luz. \n"
                        + "Una nave partiendo desde este turno llegara en el turno " + tr;
                JOptionPane.showMessageDialog(this, msj);
                cant_envios.setText("");
                int naves_ = tablero[_o.getCoordx_()][_o.getCoordy_()].getPlaneta().getNaves();
                tablero[_o.getCoordx_()][_o.getCoordy_()].getPlaneta().setNaves(naves_ - cant);
                reiniciar(_o.getCoordx_(), _o.getCoordy_());
                validarMov = true;
                _o.getPlaneta().setNaves(naves_ - cant);
                Ataque tmp = new Ataque(_o, _d, tr, cant, false);
                ataques.add(tmp);
            } else {
                JOptionPane.showMessageDialog(this, "No tiene suficiente naves, solo tiene " + _o.getPlaneta().getNaves());
            }
        }
    }//GEN-LAST:event_cant_enviosKeyReleased

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        guardar save_ = new guardar(game, tablero, turnos);

    }//GEN-LAST:event_saveActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        // TODO add your handling code here:
        mensajes_txt.setText("");
        game = null;
        tablero = null;
        Konquest_Pj1 p = new Konquest_Pj1();
        archivoEntrada archivo = new archivoEntrada();
        JOptionPane.showMessageDialog(this, "Seleccione un archivo de configuracion");
        game = p.probar1(archivo.generateFile());
        JOptionPane.showMessageDialog(this, "Seleccione un archivo de de guardado");
        guardar save = p.leer2(archivo.generateFile());
        JOptionPane.showMessageDialog(this, "Seleccione un de replay");
        p.leer3(archivo.generateFile(), "", false);
        ArrayList<Turno> turn = p.listTurnos;
        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea hacer un replay del juego?");
        replay = new Replay();;
        if (seleccion == 0) {
            replay(turn, save, true);
            cargarTablero(save, true);
            iniciarTablero();
            inicio_partida.options.setVisible(true);
            inicio_partida.more_options.enable();
            replay.time = 3;
            replay.start();
        } else if (seleccion == 1) {
            replay(turn, save, true);
            cargarTablero(save, true);
            iniciarTablero();
            inicio_partida.options.setVisible(true);
            inicio_partida.more_options.enable();
            replay.time = 0;
            replay.start();
        }


    }//GEN-LAST:event_openActionPerformed

    private void mostrar_posicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_posicionesActionPerformed
        // TODO add your handling code here:
        String txt = "hola jeje";
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            DataOutputStream flujo = new DataOutputStream(socket.getOutputStream());
            flujo.writeUTF(txt);
            flujo.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_mostrar_posicionesActionPerformed

    private void barra_mensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barra_mensajesActionPerformed

        if (showmensajes) {
            jPanel1.setSize(new Dimension(1290, 660));
            contenido_mapa.setSize(new Dimension((int) contenido_mapa.getSize().getWidth(), 500));
            jScrollPane1.setSize(new Dimension(0, 0));
            showmensajes = false;
            iniciarTablero();

        } else {

            jScrollPane1.setSize(new Dimension(1290, 140));
            jPanel1.setSize(new Dimension(1290, 510));
            contenido_mapa.setSize(new Dimension((int) contenido_mapa.getSize().getWidth(), 400));
            iniciarTablero();
            showmensajes = true;
        }

    }//GEN-LAST:event_barra_mensajesActionPerformed

    private void vista_generalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vista_generalActionPerformed
        flota fl = new flota();
        fl.setTurno(turnos);
        fl.set();
        fl.setVisible(true);

    }//GEN-LAST:event_vista_generalActionPerformed
    private void replay(ArrayList<Turno> turn, guardar save, boolean v) {
        for (int i = 0; i < turn.size(); i++) {
            for (int j = 0; j < game.getArray_jugadores().size(); j++) {
                if (game.getArray_jugadores().get(j).getJugador().equals(turn.get(i).getJugador_())) {
                    turn.get(i).setJugador(game.getArray_jugadores().get(j));
                    break;
                }

            }
            for (int j = 0; j < turn.get(i).getAtaques().size(); j++) {
                if (v) {
                    turn.get(i).getAtaques().get(j).setVerificar(false);
                }
                for (int k = 0; k < game.getArray_neutrales().size(); k++) {
                    for (int l = 0; l < save.getNeutrales().size(); l++) {
                        if (save.getNeutrales().get(l).getNombre().equals(game.getArray_neutrales().get(k).getNombre())) {
                            int x = save.getNeutrales().get(l).getX_();
                            int y = save.getNeutrales().get(l).getY_();

                            game.getArray_neutrales().get(k).setX_(x);
                            game.getArray_neutrales().get(k).setY_(y);
                            break;
                        }
                    }
                    for (int l = 0; l < save.getPlanetas().size(); l++) {
                        if (save.getPlanetas().get(l).getNombre().equals(game.getPlanetas().get(k).getNombre())) {
                            int x = save.getPlanetas().get(l).getX_();
                            int y = save.getPlanetas().get(l).getY_();

                            game.getPlanetas().get(k).setX_(x);
                            game.getPlanetas().get(k).setY_(y);
                            game.getPlanetas().get(k).setColor(save.getPlanetas().get(l).getColorPlaneta());

                            break;
                        }
                    }
                    if (turn.get(i).getAtaques().get(j).getO_().equals(game.getArray_neutrales().get(k).getNombre())) {
                        galaxia o = new galaxia();
                        o.setCoordx_(game.getArray_neutrales().get(k).getX_());
                        o.setCoordy_(game.getArray_neutrales().get(k).getY_());
                        o.inicializarPlanetaNeutral(game.getArray_neutrales().get(k));
                        turn.get(i).getAtaques().get(j).setO(o);
                    } else if (turn.get(i).getAtaques().get(j).getD_().equals(game.getArray_neutrales().get(k).getNombre())) {
                        galaxia d = new galaxia();
                        d.setCoordx_(game.getArray_neutrales().get(k).getX_());
                        d.setCoordy_(game.getArray_neutrales().get(k).getY_());
                        d.inicializarPlanetaNeutral(game.getArray_neutrales().get(k));
                        turn.get(i).getAtaques().get(j).setD(d);

                    }
                }

                for (int k = 0; k < game.getPlanetas().size(); k++) {
                    if (turn.get(i).getAtaques().get(j).getO_().equals(game.getPlanetas().get(k).getNombre())) {
                        galaxia o = new galaxia();
                        o.setCoordx_(game.getPlanetas().get(k).getX_());
                        o.setCoordy_(game.getPlanetas().get(k).getY_());
                        o.inicializarPlanetaJugador(game.getPlanetas().get(k));
                        turn.get(i).getAtaques().get(j).setO(o);
                    } else if (turn.get(i).getAtaques().get(j).getD_().equals(game.getPlanetas().get(k).getNombre())) {
                        galaxia d = new galaxia();
                        d.setCoordx_(game.getPlanetas().get(k).getX_());
                        d.setCoordy_(game.getPlanetas().get(k).getY_());
                        d.inicializarPlanetaJugador(game.getPlanetas().get(k));
                        turn.get(i).getAtaques().get(j).setD(d);

                    }
                }
            }

        }
        turnos = turn;
    }

    private void cargarTablero(guardar save, boolean par) {
        filas = (int) game.getMapa().getTamaño().getWidth();
        columnas = (int) game.getMapa().getTamaño().getHeight();
        tablero = new galaxia[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new galaxia();
                tablero[i][j].setBackground(tablero[i][j].getColor());

            }
        }

        for (int i = 0; i < game.getArray_neutrales().size(); i++) {
            if (!par) {
                for (int j = 0; j < save.getNeutrales().size(); j++) {
                    if (save.getNeutrales().get(j).getNombre().equals(game.getArray_neutrales().get(i).getNombre())) {
                        String dueño = save.getNeutrales().get(j).getDueño();
                        int naves = save.getNeutrales().get(j).getNaves();
                        int produc = save.getNeutrales().get(j).getProduccion();
                        int x = save.getNeutrales().get(j).getX_();
                        int y = save.getNeutrales().get(j).getY_();

                        Color c = save.getNeutrales().get(j).getColorPlaneta();
                        if (!dueño.equals("none")) {
                            game.getArray_neutrales().get(i).setDueño(dueño);
                        }
                        game.getArray_neutrales().get(i).setColor(c);
                        game.getArray_neutrales().get(i).setNaves(naves);
                        game.getArray_neutrales().get(i).setProduccion(produc);
                        game.getArray_neutrales().get(i).setX_(x);
                        game.getArray_neutrales().get(i).setY_(y);
                        break;
                    }

                }
            }

            tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].inicializarPlanetaNeutral(game.getArray_neutrales().get(i));
            tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].setBackground(tablero[game.getArray_neutrales().get(i).getX_()][game.getArray_neutrales().get(i).getY_()].getColor());

        }
        for (int i = 0; i < game.getPlanetas().size(); i++) {

            for (int j = 0; j < save.getPlanetas().size(); j++) {
                if (save.getPlanetas().get(j).getNombre().equals(game.getPlanetas().get(i).getNombre())) {
                    String dueño = save.getPlanetas().get(j).getDueño();
                    int naves = save.getPlanetas().get(j).getNaves();
                    int produc = save.getPlanetas().get(j).getProduccion();
                    int x = save.getPlanetas().get(j).getX_();
                    int y = save.getPlanetas().get(j).getY_();
                    Color c = save.getPlanetas().get(j).getColorPlaneta();
                    game.getPlanetas().get(i).setDueño(dueño);
                    if (!par) {
                        game.getPlanetas().get(i).setColor(c);
                        game.getPlanetas().get(i).setNaves(naves);
                        game.getPlanetas().get(i).setProduccion(produc);
                        game.getPlanetas().get(i).setX_(x);
                        game.getPlanetas().get(i).setY_(y);
                    }

                    break;
                }

            }

            tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].inicializarPlanetaJugador(game.getPlanetas().get(i));
            tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].setBackground(tablero[game.getPlanetas().get(i).getX_()][game.getPlanetas().get(i).getY_()].getColor());
        }
    }

    public static void reiniciar(int i, int j) {
        if (tablero[i][j].getPlaneta().getClass().equals(planeta_neutral.class)) {
            if (game.getMapa().getNeutral().isMostrarNaves() && game.getMapa().getNeutral().isMostrarEstadisticas()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Dueño:" + tablero[i][j].getPlaneta().getDueño() + "\n"
                        + "        <br>\n"
                        + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                        + "        <br>\n"
                        + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                        + "        <br>\n"
                        + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                        + "        </p>\n"
                        + "    </div></html>");

            } else if (game.getMapa().getNeutral().isMostrarEstadisticas()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Dueño:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                        + "        <br>\n"
                        + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                        + "        </p>\n"
                        + "    </div></html>");

            } else if (game.getMapa().getNeutral().isMostrarNaves()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202);\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                        + "        <br>\n"
                        + "        </p>\n"
                        + "    </div></html>");

            }

        } else if (tablero[i][j].getPlaneta().getClass().equals(planeta_jugador.class)) {
            if (game.getMapa().isMapaciego()) {
                tablero[i][j].setToolTipText("<html> <div style=\"background-color: rgb(206, 202, 202); width:200px\">\n"
                        + "        <p style=\"color: black;\">\n"
                        + "        Nombre:" + tablero[i][j].getPlaneta().getNombre() + "\n"
                        + "        <br>\n"
                        + "        Dueño:" + tablero[i][j].getPlaneta().getDueño() + "\n"
                        + "        <br>\n"
                        + "        Naves:" + tablero[i][j].getPlaneta().getNaves() + "\n"
                        + "        <br>\n"
                        + "        Produccion:" + tablero[i][j].getPlaneta().getProduccion() + "\n"
                        + "        <br>\n"
                        + "        Muertes(%):" + tablero[i][j].getPlaneta().getMuertes() + "\n"
                        + "        </p>\n"
                        + "    </div></html>");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio_partida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barra_mensajes;
    public static javax.swing.JPasswordField cant_envios;
    private static javax.swing.JScrollPane contenido_mapa;
    private static javax.swing.JButton end_turno;
    private javax.swing.JButton fin_turno;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu juego;
    private javax.swing.JButton medir_distancia;
    private javax.swing.JMenuBar menu_juego;
    public static javax.swing.JPanel more_options;
    private javax.swing.JButton mostrar_posiciones;
    private static javax.swing.JLabel msj_jugador;
    private javax.swing.JMenu opciones;
    private static javax.swing.JMenuItem open;
    public static javax.swing.JPanel options;
    public static javax.swing.JPanel panel_tablero;
    private javax.swing.JMenuItem save;
    private javax.swing.JCheckBoxMenuItem show;
    private javax.swing.JButton terminar_partida;
    private javax.swing.JButton vista_general;
    // End of variables declaration//GEN-END:variables
}
