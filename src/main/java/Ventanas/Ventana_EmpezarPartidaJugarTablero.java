/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import App.AppModificada;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class Ventana_EmpezarPartidaJugarTablero extends javax.swing.JPanel {

    private final AppModificada miApp; // Agrega una referencia a la instancia de Ventana_Principal
    private JButton[][] botones;

    /**
     * Creates new form VentanaOpcionesEmpezarPartida
     *
     * @param app
     */
    public Ventana_EmpezarPartidaJugarTablero(AppModificada app) {
        this.miApp = app;
        initComponents();
        crearTablero();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        BackGround = new javax.swing.JPanel();

        jScrollPane2.setViewportView(jTextPane1);

        setPreferredSize(new java.awt.Dimension(300, 300));

        BackGround.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    private void crearTablero() {
        // Crear la disposición del tablero
        BackGround.setLayout(new GridLayout(10, 10));

        // Inicializar la matriz de botones
        botones = new JButton[10][10];

        // Crear y agregar botones al tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setPreferredSize(new Dimension(1, 1)); // Ajusta el tamaño preferido
                botones[i][j].addActionListener(new BotonListener(i, j));
                BackGround.add(botones[i][j]);
            }
        }

    }

    // ActionListener para los botones
    private class BotonListener implements ActionListener {

        private int fila;
        private int columna;

        public BotonListener(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Acción a realizar cuando se hace clic en un botón
            JOptionPane.showMessageDialog(Ventana_EmpezarPartidaJugarTablero.this, "Fila: " + fila + ", Columna: " + columna);
            
        }
    }

}
