/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import App.AppModificada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Ventana_VerPartidaTerminada extends javax.swing.JPanel {

    private AppModificada miApp; // Agrega una referencia a la instancia de Ventana_Principal

    /**
     * Creates new form VentanaOpcionesEmpezarPartida
     *
     * @param app
     */
    public Ventana_VerPartidaTerminada(AppModificada app) {
        initComponents();
        this.miApp = app; // Asigna la referencia de Ventana_Principal;
        llenarTablaConDatos();
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
        TablaPartidas = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(700, 500));

        TablaPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Partida", "Jugador 1", "Jugador 2", "Ganador", "Ultimo Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPartidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(TablaPartidas);

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JTable TablaPartidas;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void llenarTablaConDatos() {
        DefaultTableModel modelo = (DefaultTableModel) TablaPartidas.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de agregar nuevos datos

        //Actualizamos la lista de partidas
        miApp.getMiCliente().actualizarListaDePartidasTerminadas();

        // Obtén la lista de partidas terminadas desde la aplicación
        HashMap<Integer, String> partidas = miApp.getMiCliente().getMisDatos().getListaPartidaTermindas();

        // Itera sobre la lista y agrega cada partida a la tabla
        for (HashMap.Entry<Integer, String> entrada : partidas.entrySet()) {
            Scanner sc = new Scanner(entrada.getValue());
            sc.useDelimiter(";");
            // Verifica la existencia de los elementos antes de acceder a ellos

            int idPartida = sc.nextInt();
            String nombreJugador1 = sc.next();
            String nombreJugador2 = sc.next();
            String nombreGanador = sc.next();
            String nombreUltimoTurno = sc.next();

            // Agrega los datos a la tabla
            modelo.addRow(new Object[]{idPartida, nombreJugador1, nombreJugador2, nombreGanador, nombreUltimoTurno});

            sc.close();
        }
        // Asegurarse de que la Tabla se actualiza
        modelo.fireTableDataChanged();

        // Centrar datos en la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TablaPartidas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic
                    int filaSeleccionada = TablaPartidas.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        // Obtiene el valor de la columna "Id Partida" de la fila seleccionada
                        String idPartidaSeleccionada = TablaPartidas.getValueAt(filaSeleccionada, 0).toString();

                        // Realiza la acción del botón verJButtonActionPerformed con el idPartidaSeleccionada
                        verJButtonActionPerformed(idPartidaSeleccionada);
                    }
                }
            }
        });
    }

    private void verJButtonActionPerformed(String idPartida) {
        miApp.ShowJPanel(new Ventana_VerPartidaTerminadaRepeticion(miApp, idPartida));
    }

}
