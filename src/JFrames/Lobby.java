/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.Jugador;
import Clases.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Lobby extends javax.swing.JFrame implements Runnable{
    Partida parti;

    public Lobby(Partida part, Jugador player) {
        parti = part;
        initComponents();
        fondo();
        jugadorHost();
        Thread hilo = new Thread(this);
        hilo.start();
        
    }

    
        
        public void run(){
            try{
                while(true){
            try {
                Socket jugador = new Socket("127.0.0.1", 27015);
               ObjectInputStream datoE = new ObjectInputStream(jugador.getInputStream());
                ObjectOutputStream datoS = new ObjectOutputStream(jugador.getOutputStream());
                datoS.writeObject("ActualizaPartida");
                datoS.writeObject(parti.nombre);
                parti=(Partida)datoE.readObject();
                jugador.close();
            } catch (IOException ex) {ex.printStackTrace();}  
                jugadorHost();
                }
            }catch(Exception e){e.printStackTrace();}
            
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtchat = new javax.swing.JTextArea();
        txtmsj = new javax.swing.JTextField();
        jLplayer1 = new javax.swing.JLabel();
        jLplayer2 = new javax.swing.JLabel();
        jLplayer3 = new javax.swing.JLabel();
        jLplayer4 = new javax.swing.JLabel();
        btenviar = new javax.swing.JButton();
        btEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 728));

        txtchat.setColumns(20);
        txtchat.setRows(5);
        txtchat.setFocusable(false);
        jScrollPane1.setViewportView(txtchat);

        jLplayer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLplayer1.setPreferredSize(new java.awt.Dimension(56, 22));

        jLplayer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLplayer2.setPreferredSize(new java.awt.Dimension(56, 22));

        jLplayer3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLplayer3.setPreferredSize(new java.awt.Dimension(56, 22));

        jLplayer4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLplayer4.setPreferredSize(new java.awt.Dimension(56, 22));

        btenviar.setText("Enviar");

        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciaPartidaN.png"))); // NOI18N
        btEnviar.setBorder(null);
        btEnviar.setBorderPainted(false);
        btEnviar.setContentAreaFilled(false);
        btEnviar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciaPartidaP.png"))); // NOI18N
        btEnviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciaPartidaF.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLplayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLplayer2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jLplayer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLplayer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmsj, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btenviar)))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(btEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLplayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLplayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLplayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLplayer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmsj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btenviar))
                .addGap(27, 27, 27)
                .addComponent(btEnviar)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void fondo(){
        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoLobby.png")));
        fondo.setBounds(0,0,700,700);
        add(fondo);
        fondo.validate();
    }
    
    public void jugadorHost(){
        if(parti.player1!=null)
            jLplayer1.setText(parti.player1.getNombre());
        if(parti.player2!=null)
            jLplayer2.setText(parti.player2.getNombre());
        if(parti.player3!=null)
            jLplayer3.setText(parti.player3.getNombre());
        if(parti.player4!=null)
            jLplayer4.setText(parti.player4.getNombre());        
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btenviar;
    private javax.swing.JLabel jLplayer1;
    private javax.swing.JLabel jLplayer2;
    private javax.swing.JLabel jLplayer3;
    private javax.swing.JLabel jLplayer4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtchat;
    private javax.swing.JTextField txtmsj;
    // End of variables declaration//GEN-END:variables
}
