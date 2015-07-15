/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.Jugador;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class ConfPartida extends javax.swing.JFrame {

       Jugador player;
    public ConfPartida(Jugador player) {
        this.player = player;
        initComponents();
        fondo();
        botones();
        nombre();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bombermans = new javax.swing.ButtonGroup();
        bombermanAmarillo = new javax.swing.JToggleButton();
        bombermanAzul = new javax.swing.JToggleButton();
        bombermanFucsia = new javax.swing.JToggleButton();
        bombermanNegro = new javax.swing.JToggleButton();
        bombermanRojo = new javax.swing.JToggleButton();
        bombermanVerde = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 728));

        bombermanAmarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/amarillo/Front/Bman_F_f00.png"))); // NOI18N

        bombermanAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/azul/Front/Bman_F_f00.png"))); // NOI18N

        bombermanFucsia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fucsia/Front/Bman_F_f00.png"))); // NOI18N

        bombermanNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/negro/Front/Bman_F_f00.png"))); // NOI18N

        bombermanRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rojo/Front/Bman_F_f00.png"))); // NOI18N

        bombermanVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verde/Front/Bman_F_f00.png"))); // NOI18N
        bombermanVerde.setToolTipText("");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciarPartidaN.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciarPartidaP.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciarPartidaF.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bombermanAmarillo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bombermanAzul)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bombermanFucsia))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bombermanNegro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bombermanRojo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bombermanVerde))))
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bombermanFucsia)
                    .addComponent(bombermanAmarillo)
                    .addComponent(bombermanAzul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bombermanNegro)
                    .addComponent(bombermanRojo)
                    .addComponent(bombermanVerde))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(139, 139, 139))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String color=null;
        if(bombermanAzul.isSelected())
            color = "azul";
        if(bombermanAmarillo.isSelected())
            color = "amarillo";
        if(bombermanFucsia.isSelected())
            color = "fucsia";
        if(bombermanNegro.isSelected())
            color = "negro";
        if(bombermanRojo.isSelected())
            color = "rojo";
        if(bombermanVerde.isSelected())
            color = "verde";
        new Jugador1(player.getNombre(),player.getApellido(),color).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void fondo(){
        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoConfPartida.png")));
        fondo.setBounds(0,0,700,700);
        add(fondo);
        fondo.validate();        
    }
    
    public void botones(){
        bombermans.add(bombermanAzul);
        bombermans.add(bombermanAmarillo);
        bombermans.add(bombermanFucsia);
        bombermans.add(bombermanNegro);
        bombermans.add(bombermanRojo);
        bombermans.add(bombermanVerde);
    }
    
    public void nombre(){
        JLabel nombre = new JLabel("Selecciona Un Personaje "+player.getNombre());
        nombre.setBounds(100,100,200,200);
        add(nombre);
        nombre.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bombermanAmarillo;
    private javax.swing.JToggleButton bombermanAzul;
    private javax.swing.JToggleButton bombermanFucsia;
    private javax.swing.JToggleButton bombermanNegro;
    private javax.swing.JToggleButton bombermanRojo;
    private javax.swing.JToggleButton bombermanVerde;
    private javax.swing.ButtonGroup bombermans;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
