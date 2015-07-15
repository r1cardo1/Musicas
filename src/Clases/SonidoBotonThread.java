/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.jlp;

/**
 *
 * @author Ricardo Marcano
 */
public class SonidoBotonThread extends Thread{
    
    private jlp boton = null;
    
    public SonidoBotonThread(){
        String[] args = new String[1];
        args[0]="C:\\Users\\Ricardo Marcano\\Documents\\NetBeansProjects\\BombermanUneg\\src\\sonidos\\boton.mp3";
        boton= jlp.createInstance(args);
    }
    
    @Override
    public void run(){
        try {
            boton.play();
        } catch (JavaLayerException ex) {ex.printStackTrace();}
        
    }
}
