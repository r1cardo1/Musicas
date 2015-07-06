/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.Jugador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo Marcano
 */
public class Registro extends javax.swing.JFrame {

    JLabel fondo;

    /**
     * Creates new form Registro
     */
    public Registro() {
        //setUndecorated(true);
        initComponents();

        claveIncorrecta.setVisible(false);
        fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoRegistro.png")));
        fondo.setBounds(0, 0, 700, 700);
        add(fondo);
        fondo.validate();


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        clave = new javax.swing.JLabel();
        nombreT = new javax.swing.JTextField();
        apellidoT = new javax.swing.JTextField();
        correoT = new javax.swing.JTextField();
        claveT = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        confClave = new javax.swing.JPasswordField();
        registro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        claveIncorrecta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 728));
        setResizable(false);

        nombre.setText("Nombre:");

        apellido.setText("Apellido:");

        correo.setText("Correo:");

        clave.setText("Contraseña:");

        jLabel1.setText("Confirme contraseña");

        registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegistroN.png"))); // NOI18N
        registro.setBorder(null);
        registro.setBorderPainted(false);
        registro.setContentAreaFilled(false);
        registro.setFocusPainted(false);
        registro.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegistroP.png"))); // NOI18N
        registro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegistroF.png"))); // NOI18N
        registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registroMousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasN.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasP.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atrasF.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        claveIncorrecta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        claveIncorrecta.setForeground(new java.awt.Color(255, 0, 0));
        claveIncorrecta.setText("Clave Incorrecta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(clave)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombre)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(correo)
                                    .addComponent(apellido))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreT)
                            .addComponent(apellidoT)
                            .addComponent(correoT)
                            .addComponent(confClave)
                            .addComponent(claveT, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(claveIncorrecta)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registro)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(nombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido)
                    .addComponent(apellidoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo)
                    .addComponent(correoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clave)
                    .addComponent(claveT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(confClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(registro)
                .addGap(18, 18, 18)
                .addComponent(claveIncorrecta)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        new Juego().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void registroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroMousePressed
        // TODO add your handling code here:
        String passsword = new String(confClave.getPassword());

        claveIncorrecta.setVisible(false);
        if (confClave.getPassword().equals(claveT.getPassword())) {

        
            try {
                Socket jugador = new Socket("127.0.0.1", 27015);
                Jugador player = new Jugador(nombreT.getText(), apellidoT.getText(), correoT.getText(), passsword);
                ObjectOutputStream datoS = new ObjectOutputStream(jugador.getOutputStream());
                datoS.writeObject("clienteNuevo");
                System.out.println("1");
                datoS.writeObject(player);
                                System.out.println("2");
                jugador.close();
            } catch (IOException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            new claveIncorrecta().setVisible(true);
        }
    }//GEN-LAST:event_registroMousePressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido;
    private javax.swing.JTextField apellidoT;
    private javax.swing.JLabel clave;
    private javax.swing.JLabel claveIncorrecta;
    private javax.swing.JPasswordField claveT;
    private javax.swing.JPasswordField confClave;
    private javax.swing.JLabel correo;
    private javax.swing.JTextField correoT;
    private javax.swing.JLabel estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreT;
    private javax.swing.JButton registro;
    // End of variables declaration//GEN-END:variables
}
