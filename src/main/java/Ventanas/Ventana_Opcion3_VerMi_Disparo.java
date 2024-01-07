/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import App.Ventana_Principal;

/**
 *
 * @author mario
 */
public class Ventana_Opcion3_VerMi_Disparo extends javax.swing.JPanel {

    private final Ventana_Principal miApp; // Agrega una referencia a la instancia de Ventana_Principal
    private int id;

    /**
     * Creates new form VentanaOpcionesEmpezarPartida
     * @param app
     * @param id_partida
     */
    public Ventana_Opcion3_VerMi_Disparo(Ventana_Principal app, String id_partida) {
        initComponents();
        this.miApp = app; // Asigna la referencia de Ventana_Principal
        initializeButton();
        IdPartidaJLabel.setText("Id Partida: " + id_partida);
        id = Integer.parseInt(id_partida);

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
        jButtonBack = new javax.swing.JButton();
        IdPartidaJLabel = new javax.swing.JLabel();
        CoordenadasXJTextField = new javax.swing.JTextField();
        DispararJButton = new javax.swing.JButton();
        CoordenadasYJTextField = new javax.swing.JTextField();
        CoordenadasYJLabel = new javax.swing.JLabel();
        CoordenadasXJLabel = new javax.swing.JLabel();

        jButtonBack.setText("Atras");

        DispararJButton.setText("Disparar");
        DispararJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispararJButtonActionPerformed(evt);
            }
        });

        CoordenadasYJLabel.setText("Coordenada Y");

        CoordenadasXJLabel.setText("Coordenada X");

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addGap(0, 360, Short.MAX_VALUE)
                .addComponent(jButtonBack))
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(DispararJButton))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(CoordenadasYJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(CoordenadasYJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IdPartidaJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CoordenadasXJLabel)))
                        .addGap(18, 18, 18)
                        .addComponent(CoordenadasXJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IdPartidaJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CoordenadasXJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CoordenadasXJLabel))
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(CoordenadasYJLabel)
                        .addGap(48, 48, 48)
                        .addComponent(DispararJButton)
                        .addGap(71, 71, 71)
                        .addComponent(jButtonBack))
                    .addComponent(CoordenadasYJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void DispararJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispararJButtonActionPerformed
        int coordenadaX = Integer.parseInt(CoordenadasXJTextField.getText());
        int coordenadaY = Integer.parseInt(CoordenadasYJTextField.getText());
        miApp.getMiCliente().hacerDisparo(id, coordenadaX, coordenadaY);
        miApp.ShowJPanel(new Ventana_Opcion3_VerMi(miApp));
    }//GEN-LAST:event_DispararJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel CoordenadasXJLabel;
    private javax.swing.JTextField CoordenadasXJTextField;
    private javax.swing.JLabel CoordenadasYJLabel;
    private javax.swing.JTextField CoordenadasYJTextField;
    private javax.swing.JButton DispararJButton;
    private javax.swing.JLabel IdPartidaJLabel;
    private javax.swing.JButton jButtonBack;
    // End of variables declaration//GEN-END:variables

    private void initializeButton() {
        jButtonBack.addActionListener((java.awt.event.ActionEvent evt) -> {
            // Vuelve a la ventana Opcion 2 Ver Partida
            miApp.ShowJPanel(new Ventana_Opcion3_VerMi(miApp));
        });
    }
}