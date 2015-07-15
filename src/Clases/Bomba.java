/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Bomba extends Thread{
    
    public JLabel bomba;
    public int tiempo=3;
    public int tamano=2;
    public JLabel fuego;
    int x;
    int y;
    
    public Bomba(int x, int y){
        this.x=x;
        this.y=y;
        bomba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bomba.png")));
        bomba.setBounds(x,y,43,43);
        bomba.validate();
    }
    
    @Override
    public void run(){
        
    }
}
