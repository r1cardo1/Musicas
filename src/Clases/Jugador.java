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
public class Jugador {
    String nombre;
    String apellido;
    int puntos;
    int x;
    int y;
    JLabel bomberman = new JLabel();

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
       bomberman.setLocation(x, y-4);
   } 
    
   public void moverAbajo(){
       bomberman.setLocation(x,y+4);
   }
   
   public void moverDerecha(){
       bomberman.setLocation(x+4,y);
   }
   
   public void moverIzquierda(){
       bomberman.setLocation(x-4,y);
   }
   
   public void compruebaArriba(){
       
   }
   
}


