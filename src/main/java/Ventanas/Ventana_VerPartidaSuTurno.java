/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import App.AppModificada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Ventana_VerPartidaSuTurno extends javax.swing.JPanel {

    private AppModificada miApp; // Agrega una referencia a la instancia de Ventana_Principal

    /**
     * Creates new form VentanaOpcionesEmpezarPartida
     */
    public Ventana_VerPartidaSuTurno(AppModificada app) {
        initComponents();
        this.miApp = app; // Asigna la referencia de Ventana_Principal
        initializeButton();
        mostarListaDePartidas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonBack = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        BackGround.setPreferredSize(new java.awt.Dimension(700, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Partida", "Jugador 1", "Jugador 2", "Ultimo Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButtonBack.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Atras");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jButtonBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBack)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void initializeButton() {
        jButtonBack.addActionListener((java.awt.event.ActionEvent evt) -> {
            // Vuelve a la ventana VentanaOpciones
            miApp.ShowJPanel(new Ventana_VerPartidaSinTerminar(miApp));
        });
    }

    private void mostarListaDePartidas() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); // Limpiar todas las filas

        // Actualizamos las partidas
        miApp.getMiCliente().actualizarListaDePartidasSinTerminarSuTurno();
      
        HashMap<Integer, String> partidas = miApp.getMiCliente().getMisDatos().getListaPartidasSuTurno();

        for (Map.Entry<Integer, String> partida : partidas.entrySet()) {
            String[] datosPartida = partida.getValue().split(",");

            // Asegurarse de que hay suficientes datos para llenar las columnas
            if (datosPartida.length == 4) {
                modelo.addRow(new Object[]{
                    Integer.parseInt(datosPartida[0]), // Id Partida
                    datosPartida[1], // Jugador 1
                    datosPartida[2], // Jugador 2
                    datosPartida[3] // Último Turno
                });
            }
            jTable1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Doble clic
                        int filaSeleccionada = jTable1.getSelectedRow();
                        if (filaSeleccionada != -1) {
                            // Obtiene el valor de la columna "Id Partida" de la fila seleccionada
                            int idPartidaSeleccionada = (int) jTable1.getValueAt(filaSeleccionada, 0);

                            // Realiza la acción del botón jButton1ActionPerformed con el idPartidaSeleccionada
                            accionRendirse(idPartidaSeleccionada);
                        }
                    }
                }
            });
        }
        // Asegurarse de que la Tabla se actualiza
        modelo.fireTableDataChanged();
    }

    private void accionRendirse(int idPartida) {
        boolean rendicionExitosa = miApp.getMiCliente().solicitarRendirse(idPartida);

        if (rendicionExitosa) {
            JOptionPane.showMessageDialog(this, "Rendición exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la rendición", "Error", JOptionPane.ERROR_MESSAGE);
        }
        mostarListaDePartidas();
    }

}
