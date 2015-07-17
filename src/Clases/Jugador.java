/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import JFrames.Jugador1;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Jugador implements Serializable{
    
    int ii=0;
    String nombre;
    String apellido;
    int puntos;
    int x;
    int y;
    JLabel bomberman = new JLabel();
    public int bombas=0;
    public String correo;
    public String clave;
    public String ip;
    
    
    public String mapatext[][] = {{"H","H","H","H","H","H","H","H","H","H","H","H","H","H","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","S","H","S","H","S","H","S","H","S","H","S","H","S","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","S","H","S","H","S","H","S","H","S","H","S","H","S","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","S","H","S","H","S","H","S","H","S","H","S","H","S","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","S","H","S","H","S","H","S","H","S","H","S","H","S","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","S","H","S","H","S","H","S","H","S","H","S","H","S","H"},
    {"H","S","S","S","S","S","S","S","S","S","S","S","S","S","H"},
    {"H","H","H","H","H","H","H","H","H","H","H","H","H","H","H"},
    {"H","H","H","H","H","H","H","H","H","H","H","H","H","H","H"},
    {"H","H","H","H","H","H","H","H","H","H","H","H","H","H","H"}};

    


    public Jugador(String nombre, String apellido, int x, int y,String color) {
        this.nombre = nombre;
        this.apellido = apellido;
        puntos=0;
        this.x = x;
        this.y = y;
        bomberman.setBounds(x,y,43,43);

        
    }
    
    public Jugador(String nombre, String apellido, String correo, String clave){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo= correo;
        this.clave = clave;
    }

    public void setBomberman(JLabel bomberman) {
        this.bomberman = bomberman;
    }

    public JLabel getBomberman() {
        return bomberman;
    }

    public String getNombre() {
        return nombre;
    }

    public void setBombas(int bombas) {
        this.bombas = bombas;
    }

    public int getBombas() {
        return bombas;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void moverArriba(){
        if(compruebaArriba()){
            y-=4;
       bomberman.setLocation(x,y);
       bomberman.repaint();
        }
   } 
    
   public void moverAbajo(){
       if(compruebaAbajo()){
           y+=4;
       bomberman.setLocation(x,y);
       bomberman.repaint();
       }
   }
   
   public void moverDerecha(){
       if(compruebaDerecha()){
           x+=4;
       bomberman.setLocation(x,y);
       bomberman.repaint();
       }
   }
   
   public void moverIzquierda(){
       if(compruebaIzquierda()){
           x-=4;
       bomberman.setLocation(x,y);
       bomberman.repaint();
       }
   }
   
   public boolean compruebaArriba(){          
       boolean xb=false,yb=false,opc=false;
       for(int i=1;i<15;i+=2){
           if(((x) >=i*43) && ((x+23)<=(i+1)*43))
                       xb=true;
           for(int j=4;j<=15;j++)
                if(((y+53)>=j*43))
                    yb=true;
       }
       if(xb && yb)
           opc = true;          
       return opc;
   }
   
   public boolean compruebaAbajo(){          
       boolean xb=false,yb=false,opc=false;
       for(int i=1;i<15;i+=2)
           if(((x) >=i*43) && ((x+23)<=(i+1)*42))
                xb=true;
           for(int j=1;j<=16;j+=2)
           if(((y+53)<=j*43))               
               yb=true;
           if((y+53)>=602)
               yb=false;
       
       if(xb && yb)
           opc = true;
       return opc;
   }
   
   public boolean compruebaIzquierda(){
       boolean xb=false,yb=false,opc=false;
       for(int i=0;i<15;i+=2){
           if(((y+53) >=i*42) && ((y+53)<=i*44))
               yb=true;
           for(int j=2;j<=15;j++)
           if(((x+29)>=j*42))
               xb=true;
       }
       if(xb && yb)
           opc = true;
       return opc;
   }
   
   public boolean compruebaDerecha(){
       boolean xb=false,yb=false,opc=false;
       for(int i=0;i<15;i+=2){
           if(((y+53) >=i*42) && ((y+53)<=i*44))
               yb=true;
           if(((x+29)<=i*44))
               xb=true;
       }
       if(xb && yb)
           opc = true;
       return opc;
   }
   
   public void ponerBomba(){
       
       
   }
}


