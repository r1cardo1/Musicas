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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Ricardo Marcano
 */
public class Servidor implements Runnable {
    
    File datos ;
    Socket cliente;
    Jugador player;
    ServerSocket servidor;
    ObjectInputStream ois;
    ArrayList<Jugador> usuarios = new ArrayList<Jugador>();
    String funcion;
    String correo;
    
    public Servidor(){
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    public static void main(String args[]){
        new Servidor();
    }
    
    

    @Override
    public void run() {        
        try{
        servidor = new ServerSocket(27015);

            while(true){
                cliente=servidor.accept();
                ObjectOutputStream datoS = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream datoE = new ObjectInputStream(cliente.getInputStream());
                funcion =(String)datoE.readObject();
                System.out.println(funcion);
                if(funcion.equals("recuerdaClave")){
                         System.out.println("1");
                    correo = (String)datoE.readObject();
                         System.out.println("2");
                    recordarClave(correo);
                }
                if(funcion.equals("clienteNuevo") ){          
                    player=(Jugador)datoE.readObject();
                    if(compararBD(player)){
                        agregarUsuario(player);  
                    }
                }
                
                if(funcion.equals("iniciarSesion")){
                    String correoi=null;
                    String clavei=null;                    
                    correoi=(String)datoE.readObject();
                    clavei=(String)datoE.readObject();                    
                    datoS.writeObject(iniciarSesion(correoi,clavei));                    
                }
                
                
                
                
                
                cliente.close();
            }
        }catch(ClassNotFoundException | MessagingException e){e.printStackTrace();} catch (IOException ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
   

    public Jugador iniciarSesion(String correo, String clave){        
        Jugador p=null;
        Jugador a;
        ArrayList<Jugador> aux = new ArrayList<Jugador>();
        
        try{
            datos = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos");
            FileInputStream fis = new FileInputStream(datos);
            ObjectInputStream ais = new ObjectInputStream(fis);
            
            aux =(ArrayList<Jugador>)ais.readObject();
            ais.close();
            }catch(IOException | ClassNotFoundException e){System.out.println(e);} 
        
        for(int i=0;i<aux.size();i++){
            a=aux.get(i);
            if(a.clave.equals(clave) && a.correo.equals(correo))
                p=a;
        }
        
        return p;
    }
    
    
    public boolean compararBD(Jugador player) throws IOException{
        boolean opc = true;
        Jugador a;
        ArrayList<Jugador> aux = new ArrayList<Jugador>();
        
        try{
            datos = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos");
            FileInputStream fis = new FileInputStream(datos);
            ObjectInputStream ais = new ObjectInputStream(fis);
            
            aux =(ArrayList<Jugador>)ais.readObject();
            ais.close();
            }catch(IOException | ClassNotFoundException e){System.out.println(e);}       

                for(int i = 0;i<aux.size();i++){
                   a=aux.get(i);
                if(player.correo.equals(a.correo))
                    opc=false;
                }
        return opc;
    }
    
    public void agregarUsuario(Jugador player) throws FileNotFoundException, IOException, ClassNotFoundException{
    File f = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos");
    FileOutputStream fos = null;
    ObjectOutputStream escribirObjeto = null;
        ArrayList<Jugador> lista = new ArrayList<Jugador>();
    
    
    try{

        FileInputStream fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        
        lista = (ArrayList<Jugador>)ois.readObject();
    }catch(IOException | ClassNotFoundException e){}
        lista.add(player);
    try{
        fos = new FileOutputStream(f);
        escribirObjeto = new ObjectOutputStream(fos);
        escribirObjeto.writeObject(lista);
        escribirObjeto.close();        
    }
    catch( Exception e ){System.out.println(e); }

    }
    
    public void recordarClave(String correo) throws FileNotFoundException, IOException, ClassNotFoundException, MessagingException{
        Jugador usuario;
 
    String rutaArchivo="";
    String nombreArchivo="";
    String usuarioCorreo="rmarcano18@gmail.com";
    String password="fordracing";  
    String destinatario=correo;
    String asunto="CLAVE BOMBERMAN";
    String mensaje;//="ESTIMADO USUARIO "+player.nombre+" la clave de su cuenta es: "+player.clave;
    ArrayList<Jugador> lista;
    
    try
        {
       
            datos = new File("C:\\Users\\Ricardo Marcano\\Desktop\\pruebas\\datos");
            FileInputStream fis = new FileInputStream(datos);
            ObjectInputStream asd = new ObjectInputStream(fis);
            lista=(ArrayList<Jugador>)asd.readObject();
            asd.close();
            for(int i=0;i<lista.size();i++){
                usuario = lista.get(i);
                System.out.println(usuario.correo);
                if(correo.equals(usuario.correo)){ 
                    System.out.println("ENVIANDO CORREO!!!");
            mensaje = "ESTIMADO USUARIO "+usuario.nombre+" la clave de su cuenta es: "+usuario.clave;
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
            
        }}}
        catch (Exception e)
        {
            e.printStackTrace();            
        }
            
    }
}
