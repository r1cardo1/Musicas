/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Ricardo Marcano
 */
public class JavaApplication17 {

    
    public static void lectura() throws ClassNotFoundException, IOException{
        ObjectInputStream ois = null;
        try{
            File f = new File("datos.uneg");
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while(true){
                Jugador p=(Jugador)ois.readObject();
                System.out.println(p.nombre);
                System.out.println(p.apellido);
                System.out.println(p.clave);
                System.out.println(p.correo);
            }
        }catch(IOException e){}
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        lectura();
        // TODO code application logic here
    }
    
}
