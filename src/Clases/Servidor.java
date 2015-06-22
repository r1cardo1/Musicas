/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Ricardo Marcano
 */
public class Servidor implements Runnable {
    
    File datos = null;
    Socket cliente;
    Jugador player;
    ServerSocket servidor;
    ObjectInputStream ois;
    
    public Servidor(){
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    public static void main(String args[]) throws IOException{
        new Servidor();
    }
    
    

    @Override
    public void run() {
        
        try{
        servidor = new ServerSocket(27015);

            while(true){
                cliente=servidor.accept();
                ObjectInputStream datoE = new ObjectInputStream(cliente.getInputStream());
                player=(Jugador)datoE.readObject();
                if(comparar(player))
                    agregarUsuario(player);
            }
        }catch(Exception e){} 
        }
    
    public boolean comparar(Jugador player) throws IOException{
        boolean opc = true;
        
        try{
            datos = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos.uneg");
            FileInputStream fis = new FileInputStream(datos);
            ois = new ObjectInputStream(fis);
            while(true){
                Jugador aux=(Jugador)ois.readObject();
                if(player.correo==aux.correo)
                    opc=false;
            }            
            }catch(Exception e){}finally{
            ois.close();
        }
        
        return opc;
    }
    
    public void agregarUsuario(Jugador player){
            File f = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos.uneg");
 
    //Esto siempre debe de ir el FileOutputStream y ObjectOutputStream
    FileOutputStream fos = null;
    ObjectOutputStream escribirObjeto = null;
 
    try{
        /* Sabemos muy bien que en lugar de 'f' que es de tipo file
         * puede tambien colocarse un variable tipo String o una cadena como tal
         * Ejemplo: fos = new FileOutputStream( "capsula.bin" );
         * Ejemplo: String s = "capsula.bin";
         *          fos = new FileOutputStream( s );
         */
        fos = new FileOutputStream( f );
        escribirObjeto = new ObjectOutputStream( fos );
 
        //Se escribe la instancia de la clase CasaBulma
        escribirObjeto.writeObject( player );
    }
    catch( Exception e ){ }
    finally
    {
        try{
            //Se cierra el archivo y listo.
            if( escribirObjeto != null ) escribirObjeto.close();
        }catch( Exception ex ){}
    }
    }
    
    public boolean recordarClave(Jugador player) throws FileNotFoundException, IOException, ClassNotFoundException, MessagingException{
    String rutaArchivo="";
    String nombreArchivo="";
    String usuarioCorreo="rmarcano18@gmail.com";
    String password="fordracing";  
    String destinatario=player.correo;
    String asunto="CLAVE BOMBERMAN";
    String mensaje="ESTIMADO USUARIO "+player.nombre+" la clave de su cuenta es: "+player.clave;
    
    try
        {
            
            datos = new File("C:\\Users\\Ricardo Marcano\\datos.uneg");
            FileInputStream fis = new FileInputStream(datos);
            ois = new ObjectInputStream(fis);
            while(true){
                Jugador aux=(Jugador)ois.readObject();
                if(player.correo==aux.correo){               
                
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("")){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);                
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")){
                multiParte.addBodyPart(adjunto);
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }}}
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }finally{
            ois.close();
        }
            
    }
}
