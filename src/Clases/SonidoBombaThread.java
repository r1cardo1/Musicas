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
public class SonidoBombaThread extends Thread{
    private jlp bomba = null;
    String[] args = new String[1];
    public SonidoBombaThread(){
        
        args[0]="C:\\Users\\Ricardo Marcano\\Documents\\NetBeansProjects\\BombermanUneg\\src\\sonidos\\c4_beep3.mp3";
        bomba= jlp.createInstance(args);    
}
    
    @Override
    public void run(){
        for(int i=0;i<3;i++){
        try {
            bomba.play();
        } catch (JavaLayerException ex) {ex.printStackTrace();}
        
    }
        args[0]="C:\\Users\\Ricardo Marcano\\Documents\\NetBeansProjects\\BombermanUneg\\src\\sonidos\\c4_explode1.mp3";
        bomba= jlp.createInstance(args);
            try {
                bomba.play();
            } catch (JavaLayerException ex) {ex.printStackTrace();}
    }
}
