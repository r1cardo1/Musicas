/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import JFrames.Jugador1;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ricardo Marcano
 */
public class Partida extends Thread implements Serializable{
    public Jugador player1=null;
    public Jugador player2=null;
    public Jugador player3=null;
    public Jugador player4=null;
    public int tiempo = 2400;
    public String nombre;
    public int jugadores;
    
    public Jugador1 tablero;
    
    public Partida(String nombre){
        this.nombre = nombre;
    }

    public void setPlayer1(Jugador player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Jugador player2) {
        this.player2 = player2;
    }

    public void setPlayer4(Jugador player4) {
        this.player4 = player4;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador getPlayer1() {
        return player1;
    }

    public Jugador getPlayer2() {
        return player2;
    }

    public Jugador getPlayer3() {
        return player3;
    }

    public Jugador getPlayer4() {
        return player4;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getJugadores() {
        return jugadores;
    }

    public Jugador1 getTablero() {
        return tablero;
    }
    
    
    
    @Override
    public void run(){
        try {

            Thread.sleep(4000);
            
            
        } catch (InterruptedException ex) {ex.printStackTrace();
        }
    }    
}
