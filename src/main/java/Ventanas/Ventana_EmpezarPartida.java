/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import App.AppModificada;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Ventana_EmpezarPartida extends javax.swing.JPanel {

    private AppModificada miApp; // Agrega una referencia a la instancia de Ventana_Principal

    /**
     * Creates new form VentanaOpcionesEmpezarPartida
     */
    public Ventana_EmpezarPartida(AppModificada app) {
        initComponents();
        this.miApp = app; // Asigna la referencia de Ventana_Principal
        tablaJugadores();
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
        IdJugador = new javax.swing.JTextField();
        TextoIdJugador = new javax.swing.JLabel();
        JugarBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaJugadores = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(700, 400));

        BackGround.setPreferredSize(new java.awt.Dimension(700, 400));

        TextoIdJugador.setText("Id del Jugador: ");

        JugarBoton.setText("Jugar");
        JugarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarBotonActionPerformed(evt);
            }
        });

        TablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Id Jugador", "Nombre Jugador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaJugadores);

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextoIdJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JugarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 190, Short.MAX_VALUE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoIdJugador)
                            .addComponent(IdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JugarBoton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JugarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarBotonActionPerformed
        int id_jugador = Integer.parseInt(IdJugador.getText());
        int id_partida = miApp.getMiCliente().crearNuevaPartida(id_jugador);
        miApp.ShowJPanel(new Ventana_EmpezarPartidaJugar(miApp, id_partida));
    }//GEN-LAST:event_JugarBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JTextField IdJugador;
    private javax.swing.JButton JugarBoton;
    private javax.swing.JTable TablaJugadores;
    private javax.swing.JLabel TextoIdJugador;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void tablaJugadores() {
        DefaultTableModel modelo = (DefaultTableModel) TablaJugadores.getModel();
        modelo.setRowCount(0); // Limpiar todas las filas

        HashMap<Integer, String> usuario = miApp.getMiCliente().getListaUsuario();

        for (Map.Entry<Integer, String> entry : usuario.entrySet()) {
            Integer idJugador = entry.getKey();
            String nombreJugador = entry.getValue();

            modelo.addRow(new Object[]{idJugador, nombreJugador});
        }

        // Asegurarse de que la Tabla se actualiza
        modelo.fireTableDataChanged();
    }
}
