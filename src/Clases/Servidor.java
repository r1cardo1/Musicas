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
    
    public static ArrayList<String> listaIp;
    Partida parti;
    String opc=null;
    public static ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
    File datos;
    Jugador player;
    ObjectInputStream ois;
    ArrayList<Jugador> usuarios = new ArrayList<Jugador>();
    String funcion;
    String correo;
    Socket cssocket;
    
    public Servidor(Socket cliente){
        this.cssocket = cliente;
    }
    
    public static void main(String args[])throws Exception{
            
      ServerSocket ssock = new ServerSocket(27015);
      while (true) {
         Socket sock = ssock.accept();
         new Thread(new Servidor(sock)).start();
         
      }
   }
    
    @Override
    public void run() {        
        try{            
                ObjectOutputStream datoS = new ObjectOutputStream(cssocket.getOutputStream());
                ObjectInputStream datoE = new ObjectInputStream(cssocket.getInputStream());
                funcion =(String)datoE.readObject();
                System.out.println(funcion);
                if(funcion.equals("recuerdaClave")){
                    correo = (String)datoE.readObject();
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
                
                if(funcion.equals("crearPartida")){
                    String nombre;
                    Jugador player;
                    nombre=(String)datoE.readObject();
                    player=(Jugador)datoE.readObject();
                    nuevaPartida(nombre,player);
                    datoS.writeObject(opc);
                    if(opc.equals("entrando")){
                        datoS.writeObject(parti);
                        opc="";
                    }
                }
                
                if(funcion.equals("cargaPartidas")){
                    for(int i=0;i<listaPartidas.size();i++)
                        System.out.println(listaPartidas.get(i).nombre);
                    datoS.writeObject(listaPartidas);
                }
                
                if(funcion.equals("ActualizaPartida")){
                    String nombre;
                    nombre = (String)datoE.readObject();
                    datoS.writeObject(buscaPartida(nombre));
                }
                
                if(funcion.equals("unirmePartida")){
                    String nombre;
                    Jugador player;
                    nombre = (String) datoE.readObject();
                    player = (Jugador)datoE.readObject();
                    datoS.writeObject("entrando");
                    unirsePartida(nombre,player);
                    if(opc.equals("entrando")){
                        datoS.writeObject(parti);
                        opc="";
                    }                    
                }
                cssocket.close();
            
        }catch(ClassNotFoundException | MessagingException e){e.printStackTrace();} catch (IOException ex) {ex.printStackTrace();} 
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

    public void nuevaPartida(String nombre, Jugador player) throws IOException{
            listaPartidas.add(new Partida(nombre));
            unirsePartida(nombre,player);
    }
    
    public void unirsePartida(String nombre, Jugador player) throws IOException {
        
        for(int i=0;i<listaPartidas.size();i++){
            if(listaPartidas.get(i).getNombre().equals(nombre)){
                if(listaPartidas.get(i).jugadores<4){
                    opc = "entrando";
                    if(listaPartidas.get(i).player1==null){
                    listaPartidas.get(i).player1=player;
                    listaPartidas.get(i).jugadores++;
                    parti=listaPartidas.get(i);
                    }
                    else{
                        if(listaPartidas.get(i).player2==null){
                            listaPartidas.get(i).player2=player;
                            listaPartidas.get(i).jugadores++;
                            parti=listaPartidas.get(i);
                        }
                        else{
                            if(listaPartidas.get(i).player3==null){
                            listaPartidas.get(i).player3=player;
                            listaPartidas.get(i).jugadores++;
                            parti=listaPartidas.get(i);
                        }
                            else{
                                if(listaPartidas.get(i).player4==null){
                                listaPartidas.get(i).player4=player;
                                listaPartidas.get(i).jugadores++;
                                parti=listaPartidas.get(i);
                        }
                            }
                            
                        }
                    }
                }
            }
        }
    }
    
    public Partida buscaPartida(String nombre){
        Partida parti=null;
        for(int i = 0; i<listaPartidas.size();i++){
            if(listaPartidas.get(i).nombre.equals(nombre)){
                parti = listaPartidas.get(i);
            }
        }
        return parti;
    }
}
