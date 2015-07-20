/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import JFrames.Jugador1;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Bomba extends JLabel implements Runnable, Serializable{
    
    int x;
    int y;
    Jugador1 layer;
    
    public Bomba(int x,int y){
        this.x= x;
        this.y= y;
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bomb_f01.png")));
        this.setBounds((x/43)*43,(y/43)*43,43,43);  
        this.validate();
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run(){
        try {
            new SonidoBombaThread().start();            
            Thread.sleep(1000);            
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bomb_f02.png")));
            this.setBounds(x,y,43,43);
            this.validate();
            Thread.sleep(1000);
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bomb_f03.png")));
            this.setBounds(x,y,43,43);
            this.validate();
            Thread.sleep(1000);
            setVisible(false);
        } catch (InterruptedException ex) {Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);}
    }
}
