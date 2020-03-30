/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import classes.ButtonController;
import classes.guardar;
import classes.mouseListener;
import static interfaz.inicio_partida.cliente;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ToolTipManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import jugadores.dificil;
import jugadores.facil;
import jugadores.humano;
import jugadores.jugador;
import mapa.juego;
import mapa.mapa;
import planetas.galaxia;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class nuevo_juego extends javax.swing.JFrame {

    /**
     * Creates new form nuevo_juego
     */
    private boolean vs;

    public boolean isVs() {
        return vs;
    }

    public void setVs(boolean vs) {
        this.vs = vs;
    }

    DefaultComboBoxModel modelo;
    Border border2;
    Border border1;
    public static int filas;
    public static int columnas;
    public static galaxia tablero[][];
    public static juego juego;
    static boolean valid_combo;
    static int coord_x, coord_y;
    boolean validarTabla;

    public nuevo_juego() {
        initComponents();
        valid_combo = true;
        validarTabla = true;
        modelo = new DefaultComboBoxModel();
        this.setLocationRelativeTo(this);
        this.setSize(1019, 650);
        this.setTitle("Nueva partida-Konquest");
        this.players.setModel(modelo);
        ADCIONAITEM();
        CorComboBox();
        border1 = jPanel1.getBorder();
        border2 = delete.getBorder();
        delete.setBorder(border1);
        count2 = 0;

    }

    public void iniciarJuego(juego game) {
        this.juego = game;
    }

    public void setSize() {
        mapa map = juego.getMapa();
        map = juego.getMapa();
        this.altura.setValue(map.getTamaño().getHeight());
        this.ancho.setValue(map.getTamaño().getWidth());
        this.cant_planetaNeutrales.setValue(map.getPlanetasNeutrales());
        content_map.setBorder(javax.swing.BorderFactory.createTitledBorder(map.getNombre()));
        filas = (int) map.getTamaño().getWidth();
        columnas = (int) map.getTamaño().getHeight();
        tablero = new galaxia[filas][columnas];
        opciones();
        iniciar();
        inicializarNeutrales();
        inicializarPlanetas();
        inicializarTablero();
        iniciarCombo();
        setTabla();
        mouseListener bt = new mouseListener();
        tabla_jugadores.addMouseListener(bt);

    }

    private void opciones() {
        mapa map = juego.getMapa();
        if (map.isMapaciego()) {
            mapa_ciego.setSelected(true);
        }
        if (map.isAcumular()) {
            produccion_acumulativa.setSelected(true);
        }
        if (map.getNeutral().isMostrarNaves()) {
            naves.setSelected(true);
        }
        if (map.getNeutral().isMostrarEstadisticas()) {
            estadisticas.setSelected(true);
        }
        production.setValue(map.getNeutral().getProduccion());

    }

    public void setSize2() {
        mapa map = juego.getMapa();
        map = juego.getMapa();
        this.altura.setValue(map.getTamaño().getHeight());
        this.ancho.setValue(map.getTamaño().getWidth());
        this.cant_planetaNeutrales.setValue(map.getPlanetasNeutrales());
        content_map.setBorder(javax.swing.BorderFactory.createTitledBorder(map.getNombre()));
        filas = (int) map.getTamaño().getWidth();
        columnas = (int) map.getTamaño().getHeight();

    }

    public void setSize3() {
        opciones();
        iniciarCombo();
        setTabla();
        mouseListener bt = new mouseListener();
        tabla_jugadores.addMouseListener(bt);
        inicializarTablero();

    }

    private void iniciarCombo() {
        this.data_planets.removeAllItems();
        for (int i = 0; i < juego.getArray_neutrales().size(); i++) {
            this.data_planets.addItem(juego.getArray_neutrales().get(i).getNombre());
        }
        for (int i = 0; i < juego.getPlanetas().size(); i++) {
            this.data_planets.addItem(juego.getPlanetas().get(i).getNombre());
        }

    }

    private static void iniciar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new galaxia();
                tablero[i][j].setForeground(null);
            }
        }
    }

    private static void inicializarPlanetas() {
        ArrayList<jugador> list = juego.getArray_jugadores();
        int x = 0;
        Random i = new Random(System.currentTimeMillis());
        Random j = new Random(System.currentTimeMillis());
        for (int k = 0; k < list.size(); k++) {
            x = 0;
            ArrayList<planeta_jugador> list2 = list.get(k).getPlanetas();

            while (x < list2.size()) {
                for (int l = 0; l < juego.getPlanetas().size(); l++) {
                    if (list2.get(x).getNombre().equals(juego.getPlanetas().get(l).getNombre())) {
                        list2.get(x).setMuertes(juego.getPlanetas().get(l).getMuertes());
                        list2.get(x).setProduccion(juego.getPlanetas().get(l).getProduccion());
                        list2.get(x).setNaves(juego.getPlanetas().get(l).getNaves());

                        break;
                    }
                }
                int inti = i.nextInt(filas);
                int intj = i.nextInt(columnas);
                if (tablero[inti][intj].isEmpty()) {
                    list2.get(x).setDueño(list.get(k).getJugador());
                    tablero[inti][intj].inicializarPlanetaJugador(list2.get(x));
                    tablero[inti][intj].setCoord(x);
                    tablero[inti][intj].setCoordx_(inti);
                    tablero[inti][intj].setCoordy_(intj);

                    x++;
                }

            }

        }

        //     ToolTipManager.sharedInstance().setEnabled(false);
    }

    private static void inicializarNeutrales() {
        ArrayList<planeta_neutral> list = juego.getArray_neutrales();
        int x = 0;
        Random i = new Random(System.currentTimeMillis());
        Random j = new Random(System.currentTimeMillis());
        while (x < list.size()) {
            int inti = i.nextInt(filas);
            int intj = i.nextInt(columnas);
            if (tablero[inti][intj].isEmpty()) {
                tablero[inti][intj].inicializarPlanetaNeutral(list.get(x));
                tablero[inti][intj].setCoord(x);
                tablero[inti][intj].setCoordx_(inti);
                tablero[inti][intj].setCoordy_(intj);
                x++;
            }
        }
        // ToolTipManager.sharedInstance().setEnabled(false);
    }

    private static void inicializarTablero() {
        ButtonController bt = new ButtonController();
        map.setLayout(new java.awt.GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j].setBackground(tablero[i][j].getColor());
                map.add(tablero[i][j]);
                tablero[i][j].addActionListener(bt);
            }
        }
    }

    public static void showDatas(int x, int y) {
        valid_combo = false;
        if (tablero[x][y].getPlaneta().getClass().equals(new planeta_neutral().getClass())) {
            porcentaje_muertes.setText(String.valueOf(tablero[x][y].getPlaneta().getMuertes()));
            produccion.setText(String.valueOf(tablero[x][y].getPlaneta().getProduccion()));

            for (int i = 0; i < juego.getArray_neutrales().size(); i++) {
                if (juego.getArray_neutrales().get(i).getNombre().equals(tablero[x][y].getPlaneta().getNombre())) {
                    coord_x = x;
                    coord_y = y;

                    for (int j = 0; j < data_planets.getItemCount(); j++) {
                        if (data_planets.getItemAt(j).equals(tablero[x][y].getPlaneta().getNombre())) {
                            data_planets.setSelectedIndex(j);

                        }
                    }
                    break;
                }
            }
        } else {
            for (int i = 0; i < juego.getPlanetas().size(); i++) {
                if (juego.getPlanetas().get(i).getNombre().equals(tablero[x][y].getPlaneta().getNombre())) {
                    porcentaje_muertes.setText(String.valueOf(tablero[x][y].getPlaneta().getMuertes()));
                    produccion.setText(String.valueOf(tablero[x][y].getPlaneta().getProduccion()));
                    coord_x = x;
                    coord_y = y;
                    for (int j = 0; j < data_planets.getItemCount(); j++) {
                        if (data_planets.getItemAt(j).equals(tablero[x][y].getPlaneta().getNombre())) {
                            data_planets.setSelectedIndex(j);

                        }
                    }
                    break;
                }
            }

        }

        valid_combo = true;
    }

    public void ADCIONAITEM() {
        String[] mes = {"Añadir", "HUMANO", "DIFCIL", "FACIL"};
        for (String M : mes) {
            modelo.addElement(M);
        }
    }

    public void CorComboBox() {
        try {
            this.players.setRenderer(new Colorir<String>());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void setTabla() {

        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{
            "color",
            "Nombre",
            "Tipo"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            JButton.class, // <- noten que aquí se especifica que la última columna es un botón
            java.lang.String.class,
            java.lang.String.class
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        Object[][] datos = new Object[juego.getArray_jugadores().size()][3];
        for (int i = 0; i < juego.getArray_jugadores().size(); i++) {
            JButton bt = new JButton();
            bt.setBackground(juego.getArray_jugadores().get(i).getColor());
            bt.setBorderPainted(false);
            datos[i][0] = bt;
            datos[i][1] = juego.getArray_jugadores().get(i).getJugador();
            datos[i][2] = juego.getArray_jugadores().get(i).getTipo();

        }

        // Defino el TableModel y le indico los datos y nombres de columnas
        tabla_jugadores.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        tabla_jugadores.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar
                 * el objeto que se va a dibujar en la celda. Esto significa que
                 * se dibujará en la celda el objeto que devuelva el TableModel.
                 * También significa que este renderer nos permitiría dibujar
                 * cualquier objeto gráfico en la grilla, pues retorna el objeto
                 * tal y como lo recibe.
                 */
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue
         * pulsada la celda que contiene el botón. Noten que estamos capturando
         * el clic sobre JTable, no el clic sobre el JButton. Esto también
         * implica que en lugar de poner un botón en la celda, simplemente
         * pudimos definir un CellRenderer que hiciera parecer que la celda
         * contiene un botón. Es posible capturar el clic del botón, pero a mi
         * parecer el efecto es el mismo y hacerlo de esta forma es más "simple"
         */
        /*tabla_jugadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tabla_jugadores.rowAtPoint(e.getPoint());
                int columna = tabla_jugadores.columnAtPoint(e.getPoint());
                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el
                 * botón, si tuviéramos más de un botón por fila tendríamos que
                 * además preguntar por el contenido del botón o el nombre de la
                 * columna
         */
 /*   if (tabla_jugadores.getModel().getColumnClass(columna).equals(JButton.class) && validarTabla) {
                   System.out.println("entra------------------>");
                   Color getcolor=JColorChooser.showDialog(tabla_jugadores, "seleccione", Color.yellow);
                   juego.getArray_jugadores().get(columna).setColor(getcolor);
                   validarTabla=false;
                   setTabla();
                   validarTabla=true;
                   // tabla_jugadores.getModel().getColumnClass(columna).
                //    tabla_jugadores.getModel().getColumnClass(columna);
                    
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este
                     * ejemplo, voy a mostrar en un cuadro de dialogo todos los
                     * campos de la fila que no sean un botón.
         */
 /*StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tabla_jugadores.getModel().getColumnCount(); i++) {
                        if (!tabla_jugadores.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(tabla_jugadores.getModel().getColumnName(i)).append(": ").append(tabla_jugadores.getModel().getValueAt(fila, i));
                        }
                    }

                }
            }
        });*/
    }

    public static void setNewColorPlayer() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_jugadores = new javax.swing.JTable();
        players = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cant_planetaNeutrales = new javax.swing.JSpinner();
        ancho = new javax.swing.JSpinner();
        altura = new javax.swing.JSpinner();
        content_map = new javax.swing.JPanel();
        scroll_map = new javax.swing.JScrollPane();
        map = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        data_planets = new javax.swing.JComboBox<>();
        porcentaje_muertes = new javax.swing.JTextField();
        produccion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mapa_ciego = new javax.swing.JCheckBox();
        produccion_acumulativa = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        naves = new javax.swing.JCheckBox();
        estadisticas = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        production = new javax.swing.JSpinner();
        acept = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 195, 195)));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tabla_jugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_jugadores.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabla_jugadoresAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabla_jugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_jugadoresMouseClicked(evt);
            }
        });
        tabla_jugadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_jugadoresKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_jugadores);

        players.setBackground(new java.awt.Color(190, 212, 239));
        players.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        players.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        players.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        players.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playersMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playersMouseExited(evt);
            }
        });
        players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersActionPerformed(evt);
            }
        });

        delete.setBackground(java.awt.Color.white);
        delete.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        delete.setText("Eliminar");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(130, 206, 246)));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Jugadores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 290, 510));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 195, 195)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Mapa");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 13, -1, -1));

        jLabel4.setText("Planetas neutrales:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, -1, -1));

        jLabel5.setText("Anchura:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel6.setText("Altura:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jButton1.setText("Al azar");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 100, -1));

        cant_planetaNeutrales.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cant_planetaNeutralesStateChanged(evt);
            }
        });
        jPanel2.add(cant_planetaNeutrales, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 52, 81, -1));

        ancho.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                anchoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ancho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                anchoStateChanged(evt);
            }
        });
        jPanel2.add(ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 94, 81, -1));

        altura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alturaStateChanged(evt);
            }
        });
        jPanel2.add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 136, 81, -1));

        content_map.setBorder(javax.swing.BorderFactory.createTitledBorder("Mapa"));
        content_map.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map.setBackground(new java.awt.Color(30, 22, 14));

        javax.swing.GroupLayout mapLayout = new javax.swing.GroupLayout(map);
        map.setLayout(mapLayout);
        mapLayout.setHorizontalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        mapLayout.setVerticalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        scroll_map.setViewportView(map);

        content_map.add(scroll_map, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 240, 160));

        jPanel2.add(content_map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 330, 190));

        jLabel8.setText("Dueño");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel9.setText("Porcentaje muertes");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel10.setText("Produccion");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        data_planets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        data_planets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_planetsActionPerformed(evt);
            }
        });
        jPanel2.add(data_planets, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 350, 160, -1));

        porcentaje_muertes.setText("0");
        porcentaje_muertes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                porcentaje_muertesKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentaje_muertesKeyPressed(evt);
            }
        });
        jPanel2.add(porcentaje_muertes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 160, -1));

        produccion.setText("0");
        produccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                produccionKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                produccionKeyPressed(evt);
            }
        });
        jPanel2.add(produccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 340, 510));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 195, 195)));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Opciones");

        mapa_ciego.setText("Mapa ciego");
        mapa_ciego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapa_ciegoActionPerformed(evt);
            }
        });

        produccion_acumulativa.setText("Produccion acumulativa");
        produccion_acumulativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produccion_acumulativaActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 182, 182)), "Neutrales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        naves.setText("Mostrar naves");
        naves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navesActionPerformed(evt);
            }
        });

        estadisticas.setText("Mostrar estadisticas");
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });

        jLabel7.setText("Produccion");

        production.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                productionStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naves)
                    .addComponent(estadisticas)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)
                        .addComponent(production, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(naves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(estadisticas)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(production, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mapa_ciego, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(produccion_acumulativa, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(mapa_ciego)
                .addGap(18, 18, 18)
                .addComponent(produccion_acumulativa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 270, 510));

        acept.setSelected(true);
        acept.setText("Aceptar");
        acept.setToolTipText("Iniciar juego");
        acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptActionPerformed(evt);
            }
        });
        getContentPane().add(acept, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, -1, -1));

        jToggleButton2.setText("Cancelar");
        jToggleButton2.setToolTipText("cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBorder(border2);
        java.awt.Color blue = new java.awt.Color(217, 224, 227);
        delete.setBackground(blue);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBorder(border1);
        delete.setBackground(Color.white);

    }//GEN-LAST:event_deleteMouseExited

    private void navesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navesActionPerformed
        // TODO add your handling code here:
        if (naves.isSelected()) {
            juego.getMapa().getNeutral().setMostrarNaves(true);
        } else {
            juego.getMapa().getNeutral().setMostrarNaves(false);

        }
    }//GEN-LAST:event_navesActionPerformed

    private void playersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playersMouseClicked
        // TODO add your handling code here:
        java.awt.Color blue = new java.awt.Color(147, 226, 238);
        players.setBackground(blue);
    }//GEN-LAST:event_playersMouseClicked

    private void playersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playersMouseExited
        // TODO add your handling code here:
        players.setBackground(null);
    }//GEN-LAST:event_playersMouseExited
    int count = 0;
    private void anchoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_anchoStateChanged
        count++;
        if (count > 2) {
            int tmp = filas;
            filas = (int) Double.parseDouble(ancho.getValue().toString());
            juego.getMapa().getTamaño().setSize(filas, columnas);
            juego.validarDimensiones();
            if (juego.isValidarJuego()) {
                tablero = null;
                tablero = new galaxia[filas][columnas];
                reiniciarTablero();
            } else {
                filas = tmp;
                ancho.setValue(tmp);
                juego.getMapa().getTamaño().setSize(tmp, columnas);
                JOptionPane.showMessageDialog(this, "No hay espacio suficiente");
            }
        }

    }//GEN-LAST:event_anchoStateChanged

    private void alturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alturaStateChanged
        count++;
        if (count > 2) {
            int tmp = columnas;
            columnas = (int) Double.parseDouble(altura.getValue().toString());
            juego.getMapa().getTamaño().setSize(filas, columnas);
            juego.validarDimensiones();
            if (juego.isValidarJuego()) {
                tablero = null;
                tablero = new galaxia[filas][columnas];
                reiniciarTablero();
            } else {
                columnas = tmp;
                juego.getMapa().getTamaño().setSize(filas, tmp);
                JOptionPane.showMessageDialog(this, "No hay espacio suficiente");
                System.out.println(juego.getMapa().getTamaño().getHeight());
                this.altura.setValue(tmp);

            }

        }

    }//GEN-LAST:event_alturaStateChanged

    private void aceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptActionPerformed
        if (this.isVs()) {

        }
        inicio_partida.game = juego;
        inicio_partida.tablero = tablero;
        inicio_partida.filas = filas;
        inicio_partida.columnas = columnas;
        inicio_partida.iniciarTablero();
        inicio_partida.options.setVisible(true);
        inicio_partida.more_options.enable();
        inicio_partida.count_player = 0;
        inicio_partida.msj_jugador.setText("Jugador " + juego.getArray_jugadores().get(0).getJugador() + ": seleccione el planeta origen");

        inicio_partida.iniciarContadorPlayer();
        dispose();

    }//GEN-LAST:event_aceptActionPerformed
    int count2;
    private void data_planetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_planetsActionPerformed
        // TODO add your handling code here:
        if (count2 > 2) {
            if (valid_combo) {
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        try {
                            if (!tablero[i][j].isEmpty()) {
                                if (tablero[i][j].getPlaneta().getNombre().equals(data_planets.getSelectedItem().toString())) {
                                    porcentaje_muertes.setText(String.valueOf(tablero[i][j].getPlaneta().getMuertes()));
                                    produccion.setText(String.valueOf(tablero[i][j].getPlaneta().getProduccion()));
                                    coord_x = i;
                                    coord_y = j;
                                    break;
                                }
                            }
                        } catch (NullPointerException e) {
                        }

                    }
                }
            }
        }
        count2++;

    }//GEN-LAST:event_data_planetsActionPerformed

    private void porcentaje_muertesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentaje_muertesKeyTyped
        // TODO add your handling code here:
        char e = evt.getKeyChar();

        if (Character.isDigit(e)) {

        } else {
            if (!(e == '.')) {
                getToolkit().beep();
                evt.consume();
            }

        }
    }//GEN-LAST:event_porcentaje_muertesKeyTyped

    private void produccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produccionKeyTyped
        // TODO add your handling code here:
        char e = evt.getKeyChar();
        if (Character.isDigit(e)) {

        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_produccionKeyTyped

    private void porcentaje_muertesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentaje_muertesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!tablero[coord_x][coord_y].isEmpty()) {
                double _deaths = Double.parseDouble(porcentaje_muertes.getText());
                tablero[coord_x][coord_y].getPlaneta().setMuertes(_deaths);
                
            }
        }
    }//GEN-LAST:event_porcentaje_muertesKeyPressed

    private void produccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produccionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!tablero[coord_x][coord_y].isEmpty()) {

                int _produc = Integer.parseInt(produccion.getText());
                tablero[coord_x][coord_y].getPlaneta().setProduccion(_produc);
            }
        }
    }//GEN-LAST:event_produccionKeyPressed
    int count3 = 0;
    private void playersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersActionPerformed
        if (count3 > 1) {
            DefaultTableModel t = (DefaultTableModel) this.tabla_jugadores.getModel();
            if (players.getSelectedIndex() > 0) {
                int total = filas * columnas;
                int total2 = juego.getArray_neutrales().size() + juego.getPlanetas().size();
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de planetas que quiera"));
                if (total2 + cantidad < total) {
                    String namee = "";
                    int x = t.getRowCount() + 1;
                    namee = "Jugador" + x;
                    ArrayList<planeta_jugador> lista = new ArrayList();
                    int seleccion = 5;

                    for (int i = 0; i < cantidad; i++) {
                        seleccion = JOptionPane.showConfirmDialog(this, "¿Desea que los valores sean al azar?", "Message", 0);
                        switch (seleccion) {
                            case 0:
                                planeta_jugador tmp2 = new planeta_jugador("");
                                boolean v = true;
                                while (v) {
                                    tmp2 = tmp2.planetaAleatorio(filas * columnas);
                                    juego.getPlanetas().add(tmp2);
                                    juego.validarDimensiones("");
                                    if (juego.isValidarJuego()) {
                                        v = false;
                                    } else {
                                        juego.getPlanetas().remove(juego.getPlanetas().size() - 1);
                                    }
                                }
                                data_planets.addItem(tmp2.getNombre());
                                lista.add(tmp2);

                                break;
                            case 1:
                                v = true;
                                while (v) {
                                    planeta_jugador tmp = new planeta_jugador("");
                                    tmp = tmp.generarPlaneta(this);
                                    juego.getPlanetas().add(tmp);
                                    juego.validarDimensiones("");

                                    if (!juego.isValidarJuego()) {
                                        juego.getPlanetas().remove(juego.getPlanetas().size() - 1);
                                        JOptionPane.showMessageDialog(this, "El nombre del planeta ya existe. \n no fue posible agregarlo");
                                    } else {
                                        data_planets.addItem(tmp.getNombre());
                                        lista.add(tmp);
                                        v = false;
                                    }
                                }

                                break;

                        }
                    }
                    switch (players.getSelectedIndex()) {
                        case 1:
                            jugador human = new humano(namee, lista);
                            juego.getArray_jugadores().add(human);
                            reiniciarTablero();
                            setTabla();
                            break;
                        case 2:
                            jugador dificil = new dificil(namee, lista);
                            juego.getArray_jugadores().add(dificil);
                            reiniciarTablero();
                            setTabla();
                            break;
                        case 3:
                            jugador facil = new facil(namee, lista);
                            juego.getArray_jugadores().add(facil);
                            reiniciarTablero();
                            setTabla();
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No hay espacio");
                }

            }
        }
        count3++;
    }//GEN-LAST:event_playersActionPerformed

    private void tabla_jugadoresAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabla_jugadoresAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_tabla_jugadoresAncestorAdded
    public static boolean deleteElement = false;
    private void tabla_jugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_jugadoresMouseClicked
        if (deleteElement) {
            int fila = tabla_jugadores.getSelectedRow();
            for (int i = 0; i < juego.getArray_jugadores().get(fila).getPlanetas().size(); i++) {
                for (int j = 0; j < juego.getPlanetas().size(); j++) {
                    if (juego.getArray_jugadores().get(fila).getPlanetas().get(i).getNombre().equals(juego.getPlanetas().get(j).getNombre())) {
                        juego.getPlanetas().remove(j);
                    }
                }
            }
            juego.getArray_jugadores().remove(fila);
            setTabla();
            reiniciarTablero();
            deleteElement = false;
        }


    }//GEN-LAST:event_tabla_jugadoresMouseClicked

    private void tabla_jugadoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_jugadoresKeyReleased
        String tmp = this.tabla_jugadores.getSelectedRow() + " " + this.tabla_jugadores.getSelectedColumn();
        JOptionPane.showMessageDialog(this, tmp);
    }//GEN-LAST:event_tabla_jugadoresKeyReleased

    private void anchoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_anchoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_anchoAncestorAdded
    int count4 = 0;
    private void cant_planetaNeutralesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cant_planetaNeutralesStateChanged
        if (count4 > 0) {
            int x = Integer.parseInt(this.cant_planetaNeutrales.getValue().toString());
            juego.getMapa().setPlanetasNeutrales(x);
            if (x > juego.getArray_neutrales().size()) {
                juego.validarDimensiones();
                if (juego.isValidarJuego()) {
                    int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea que los valores sean al azar?", "Message", 1);
                    switch (seleccion) {

                        case 0:
                            planeta_neutral tmp2 = new planeta_neutral();
                            boolean v = true;
                            while (v) {
                                tmp2 = tmp2.planetaAleatorio(filas * columnas);
                                juego.getArray_neutrales().add(tmp2);
                                juego.validarDimensiones();
                                if (juego.isValidarJuego()) {

                                    v = false;
                                } else {
                                    juego.getArray_neutrales().remove(juego.getArray_neutrales().size() - 1);
                                }
                            }

                            data_planets.addItem(tmp2.getNombre());
                            reiniciarTablero();

                            break;
                        case 1:
                            planeta_neutral tmp = new planeta_neutral();
                            tmp = tmp.generarPlaneta(this);
                            juego.getArray_neutrales().add(tmp);
                            juego.validarDimensiones();
                            if (!juego.isValidarJuego()) {
                                juego.getArray_neutrales().remove(juego.getArray_neutrales().size() - 1);
                                JOptionPane.showMessageDialog(this, "El nombre del planeta ya existe. \n no fue posible agregarlo");
                            } else {
                                data_planets.addItem(tmp.getNombre());
                                reiniciarTablero();
                            }
                            break;
                        case 2:
                            this.cant_planetaNeutrales.setValue(x - 1);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay más espacio para planetas neutrales");
                    this.cant_planetaNeutrales.setValue(x - 1);
                    juego.getMapa().setPlanetasNeutrales(x - 1);
                }
            } else {
                if (!juego.getArray_neutrales().isEmpty()) {
                    juego.getArray_neutrales().remove(juego.getArray_neutrales().size() - 1);
                    iniciarCombo();
                    reiniciarTablero();
                }
                if (x < 0) {
                    juego.getMapa().setPlanetasNeutrales(0);
                    this.cant_planetaNeutrales.setValue(0);
                }
            }

        }
        count4++;
    }//GEN-LAST:event_cant_planetaNeutralesStateChanged

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int fila = tabla_jugadores.getSelectedRow();
        if (juego.getArray_jugadores().size() + 1 > 2) {
            JOptionPane.showMessageDialog(this, "De click sobre un jugador para \n eliminar");
            deleteElement = true;
        } else {
            JOptionPane.showMessageDialog(this, "No puedes juegar solo");
        }


    }//GEN-LAST:event_deleteActionPerformed

    private void mapa_ciegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapa_ciegoActionPerformed
        // TODO add your handling code here:
        if (mapa_ciego.isSelected()) {
            System.out.println("1");
            juego.getMapa().setMapaciego(true);
        } else {
            System.out.println("2");
            juego.getMapa().setMapaciego(false);

        }
    }//GEN-LAST:event_mapa_ciegoActionPerformed

    private void produccion_acumulativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produccion_acumulativaActionPerformed
        // TODO add your handling code here:
        if (produccion_acumulativa.isSelected()) {
            juego.getMapa().setAcumular(true);
        } else {
            juego.getMapa().setAcumular(false);

        }
    }//GEN-LAST:event_produccion_acumulativaActionPerformed

    private void estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasActionPerformed
        // TODO add your handling code here:
        if (estadisticas.isSelected()) {
            juego.getMapa().getNeutral().setMostrarEstadisticas(true);
        } else {
            juego.getMapa().getNeutral().setMostrarEstadisticas(false);

        }
    }//GEN-LAST:event_estadisticasActionPerformed
    int countp = 0;
    private void productionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_productionStateChanged
        if (countp > 0) {
            int x = Integer.parseInt(production.getValue().toString());
            juego.getMapa().getNeutral().setProduccion(x);
            for (int i = 0; i < juego.getArray_neutrales().size(); i++) {
                if (juego.getArray_neutrales().get(i).isProduc()) {
                    juego.getArray_neutrales().get(i).setProduccion(x);
                    boolean v = true;
                    for (int j = 0; j < filas; j++) {
                        v = true;
                        if (!v) {
                            break;
                        }
                        for (int k = 0; k < columnas; k++) {
                            if (!tablero[j][k].isEmpty()) {
                                if (tablero[j][k].getPlaneta().getNombre().equals(juego.getArray_neutrales().get(i).getNombre())) {
                                    tablero[j][k].getPlaneta().setProduccion(x);
                                    v = false;
                                    break;
                                }
                            }

                        }

                    }
                }
            }
        }
        countp++;
    }//GEN-LAST:event_productionStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    public static void reiniciarTablero() {
        map.removeAll();
        map.repaint();
        iniciar();
        inicializarNeutrales();
        inicializarPlanetas();
        inicializarTablero();
        scroll_map.repaint();
        scroll_map.validate();
        scroll_map.revalidate();
        if (inicio_partida.isVs) {
            guardar save = new guardar(nuevo_juego.juego, nuevo_juego.tablero);
            String msjEnvio = save.config();
            msjEnvio += " ENDLESS " + save.planetas();
            inicio_partida.estadoDeVs = 2;
            inicio_partida.cliente.enviarMensaje(msjEnvio);
        }
    }

    public static void reiniciarTablero2() {
        map.removeAll();
        map.repaint();
        inicializarTablero();
        scroll_map.repaint();
        scroll_map.validate();
        scroll_map.revalidate();
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
            java.util.logging.Logger.getLogger(nuevo_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevo_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevo_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevo_juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevo_juego().setVisible(true);
            }
        });
    }

    class Colorir<String> extends JLabel implements ListCellRenderer {

        java.awt.Color blue = new java.awt.Color(110, 174, 255);

        public Colorir() {
            super();
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());

            Object texto = modelo.getElementAt(index);
//              Object texto = COMBOBOX.getItemAt(index);

            if (texto != null) {
                setBackground(Color.white);
            } else {
                setBackground(Color.white);
            }
            setBorder(null);
            if (isSelected) {
                setBackground(blue);
            }

            return this;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton acept;
    private javax.swing.JSpinner altura;
    private javax.swing.JSpinner ancho;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JSpinner cant_planetaNeutrales;
    private static javax.swing.JPanel content_map;
    private static javax.swing.JComboBox<String> data_planets;
    private javax.swing.JButton delete;
    private javax.swing.JCheckBox estadisticas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JPanel map;
    private javax.swing.JCheckBox mapa_ciego;
    private javax.swing.JCheckBox naves;
    private javax.swing.JComboBox<String> players;
    private static javax.swing.JTextField porcentaje_muertes;
    private static javax.swing.JTextField produccion;
    private javax.swing.JCheckBox produccion_acumulativa;
    private javax.swing.JSpinner production;
    private static javax.swing.JScrollPane scroll_map;
    public static javax.swing.JTable tabla_jugadores;
    // End of variables declaration//GEN-END:variables
}
