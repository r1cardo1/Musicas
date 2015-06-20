/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import JFrames.Jugador1;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Jugador {
    String nombre;
    String apellido;
    int puntos;
    int x;
    int y;
    JLabel bomberman = new JLabel();
    
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

    public void setBomberman(JLabel bomberman) {
        this.bomberman = bomberman;
    }

    public JLabel getBomberman() {
        return bomberman;
    }

    public String getNombre() {
        return nombre;
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
        }
   } 
    
   public void moverAbajo(){
       if(compruebaAbajo()){
           y+=4;
       bomberman.setLocation(x,y);
       }
   }
   
   public void moverDerecha(){
       if(compruebaDerecha()){
           x+=4;
       bomberman.setLocation(x,y);
       }
   }
   
   public void moverIzquierda(){
       if(compruebaIzquierda()){
           x-=4;
       bomberman.setLocation(x,y);
       }
   }
   
   public boolean compruebaArriba(){          
       boolean opc=false;       
       if((mapatext[(x/43)][(y/43)] == "S") && (mapatext[x/43][(y+42)/43] == "S")){
           opc=true;
       }       
       return opc;
   }
   
   public boolean compruebaAbajo(){          
       boolean opc=false;       
       if((mapatext[((x+42)/43)][(y/43)] == "S") && (mapatext[(x+42)/43][(y+42)/43] == "S")){
           opc=true;
       }       
       return opc;
   }
   
   public boolean compruebaIzquierda(){
       boolean opc=false;
       if((mapatext[x/43][y/43]=="S")&&(mapatext[(x+42)/43][y/43]=="S"))
           opc=true;
       return opc;
   }
   
   public boolean compruebaDerecha(){
       boolean opc=false;
       if((mapatext[x/43][(y+42)/43]=="S")&&(mapatext[(x+42)/43][(y+42)/43]=="S"))
           opc=true;
       return opc;
   }
}


