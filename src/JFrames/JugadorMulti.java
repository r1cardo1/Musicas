/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.Jugador;
import Clases.Partida;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class JugadorMulti extends javax.swing.JFrame {

    int ii=0;
    String color;
    Partida parti;
    Jugador control;
    JLabel[][] mapa = new JLabel[15][15];
    
    public JugadorMulti() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 728));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
                if(evt.getKeyCode()== KeyEvent.VK_DOWN){
            
            control.getBomberman().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+color+"/Front/Bman_F_f0"+ii+".png")));
            control.getBomberman().validate();
            ii++;
            if(ii>7)
                ii=0;
            control.moverAbajo();            
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            
            control.getBomberman().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+color+"/Back/Bman_B_f0"+ii+".png")));
            control.getBomberman().validate();
            ii++;
            if(ii>7)
                ii=0;
            control.moverArriba();            
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            
            control.getBomberman().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+color+"/izquierda/Bman_F_f0"+ii+".png")));
            control.getBomberman().validate();
            ii++;
            if(ii>7)
                ii=0;
            control.moverIzquierda();
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            
            control.getBomberman().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+color+"/Side/Bman_F_f0"+ii+".png")));
            control.getBomberman().validate();
            ii++;
            System.out.print(ii);
            if(ii>7)
                ii=0;
            control.moverDerecha();
        }
    }//GEN-LAST:event_formKeyPressed

        public void generarmapa(){
        JLabel banner = new JLabel();
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banner.png")));
        add(banner);
        banner.setBounds(0,0,647,86);
        banner.validate();
        for(int i=0;i<=14;i++)
            for(int j=0;j<=12;j++){
                mapa[j][i] = new JLabel();
                mapa[j][i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/"+parti.mapatext[j][i]+".png")));
                add(mapa[j][i]);
            }
        for(int i=0;i<=14;i++)
            for(int j=0;j<=12;j++){
                mapa[j][i].setBounds(i*43,j*43+86,43,43);
                mapa[j][i].validate();
            }
    }
        
        public void cargarJugadores(){
            if(parti.player1!=null)
                add(parti.player1.getBomberman());
            if(parti.player2!=null)
                add(parti.player2.getBomberman());
            if(parti.player3!=null)
                add(parti.player3.getBomberman());
            if(parti.player4!=null)
                add(parti.player4.getBomberman());
        }

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
