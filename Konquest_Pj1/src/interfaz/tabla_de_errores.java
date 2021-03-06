/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import classes.ErrorDatas;
import classes.ErrorLexico;
import classes.ErrorSintatico;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhonny
 */
public class tabla_de_errores extends javax.swing.JFrame {

    int parametro;
    ArrayList<ErrorSintatico> listaError;
    ArrayList<ErrorLexico> listaErrorLexico;

    /**
     * Creates new form NewJFrame
     */
    public tabla_de_errores() {
        initComponents();
        parametro = 0;
        this.tabla_errores.setRowHeight(25);
        this.setLocationRelativeTo(this);
    }

    public void errorSintatico_juego(ArrayList<ErrorSintatico> listaErrores) {
        ErrorDatas errores = new ErrorDatas(listaErrores);
        errores.arreglarErroresSintaticos();
        String columnas[] = {"Token error", "Token despues de error", "Fila", "Columna", "Solucion"};
        setDatas1(columnas, errores.getListaDeErrores());
        parametro = 4;
        this.listaError = listaErrores;
    }

    public void errorLexico(ArrayList<ErrorLexico> listaErrores) {
        ErrorDatas errores = new ErrorDatas();
        errores.setListaErrores(listaErrores);
        String columnas[] = {"Token error",  "Fila", "Columna"};
        setDatas11(columnas, errores.getListaErrores());
        parametro = 4;
        this.listaErrorLexico = listaErrores;
    }

    public void setDatas1(String[] columnas, ArrayList<ErrorSintatico> listaErrores) {
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < columnas.length; i++) {
            String columna = columnas[i];
            model.addColumn(columna);

        }
        this.tabla_errores.setModel(model);

        for (int i = 0; i < listaErrores.size(); i++) {
            String fila = String.valueOf(listaErrores.get(i).getFil());
            String columna = String.valueOf(listaErrores.get(i).getCol());
            String token = listaErrores.get(i).getToken();
            String solucion = listaErrores.get(i).getSolucion();
            String tokenSiguiente = listaErrores.get(i).getLetterId();
            String datas[] = {token, tokenSiguiente, fila, columna, solucion};
            model.addRow(datas);
        }
        scroll_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores sintaticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(162, 146, 146)));
        this.tabla_errores.setModel(model);
        this.tabla_errores.setRowHeight(15);
    }

    public void setDatas11(String[] columnas, ArrayList<ErrorLexico> listaErrores) {
        DefaultTableModel model = new DefaultTableModel();
        scroll_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores Lexicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(162, 146, 146)));
        for (String columna : columnas) {
            model.addColumn(columna);
        }
        this.tabla_errores.setModel(model);

        for (int i = 0; i < listaErrores.size(); i++) {
            String fila = String.valueOf(listaErrores.get(i).getFil());
            String columna = String.valueOf(listaErrores.get(i).getCol());
            String token = listaErrores.get(i).getLetterId();
            String datas[] = {token, fila, columna};
            model.addRow(datas);
        }

        this.tabla_errores.setModel(model);
        this.tabla_errores.setRowHeight(15);

    }

    public void setDatasErrors(ArrayList<ErrorSintatico> listaErrores){
     DefaultTableModel model = new DefaultTableModel();
     String[] columnas={"Token:","Fila","Columna"};
        for (int i = 0; i < columnas.length; i++) {
            String columna = columnas[i];
            model.addColumn(columna);
      }
        this.tabla_errores.setModel(model);

        for (int i = 0; i < listaErrores.size(); i++) {
            String fila = String.valueOf(listaErrores.get(i).getFil());
            String columna = String.valueOf(listaErrores.get(i).getCol());
            String token = listaErrores.get(i).getToken();
            String datas[] = {token,  fila, columna};
            model.addRow(datas);
        }
        scroll_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores sintaticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(162, 146, 146)));
        this.tabla_errores.setModel(model);
        this.tabla_errores.setRowHeight(15);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        scroll_tabla = new javax.swing.JScrollPane();
        tabla_errores = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        scroll_tabla.setBackground(new java.awt.Color(207, 207, 207));
        scroll_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(162, 146, 146))); // NOI18N
        scroll_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scroll_tablaMouseClicked(evt);
            }
        });

        tabla_errores.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_errores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_erroresMouseClicked(evt);
            }
        });
        scroll_tabla.setViewportView(tabla_errores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_erroresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_erroresMouseClicked
        // TODO add your handling code here:
        try {
            int columna = this.tabla_errores.getSelectedColumn();
            if (columna == parametro) {
                int fila = this.tabla_errores.getSelectedRow();
                String data = this.listaError.get(fila).getSolucion();
                JOptionPane.showMessageDialog(this, data);
            }
        } catch (NullPointerException e) {
        }

    }//GEN-LAST:event_tabla_erroresMouseClicked

    private void scroll_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scroll_tablaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scroll_tablaMouseClicked

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
            java.util.logging.Logger.getLogger(tabla_de_errores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla_de_errores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla_de_errores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla_de_errores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla_de_errores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane scroll_tabla;
    private javax.swing.JTable tabla_errores;
    // End of variables declaration//GEN-END:variables
}
