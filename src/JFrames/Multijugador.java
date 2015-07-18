/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.Jugador;
import Clases.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

    
public class Multijugador extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    Jugador player;
    ServerSocket servidor;
    Socket cliente;
    ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
    

    public Multijugador(Jugador player) throws ClassNotFoundException {
        this.player = player;
        initComponents();
        fondo();
        iniciaTabla();
        cargarPartidas();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 728));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crearPartidaN.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crearPartidaP.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crearPartidaF.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unirmeN.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unirmeP.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unirmeF.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(113, 113, 113))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(147, 147, 147))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ConfiguraPartida(player,this).setVisible(true);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String v,opc;
        Partida parti;
        for(int i =0;i<modelo.getRowCount();i++){
           v=(String) modelo.getValueAt(i, 0);
                   try {
                Socket jugador = new Socket("127.0.0.1", 27015);
                ObjectOutputStream datoS = new ObjectOutputStream(jugador.getOutputStream());
                ObjectInputStream datoE = new ObjectInputStream(jugador.getInputStream());
                datoS.writeObject("unirmePartida");
                datoS.writeObject(v);
                datoS.writeObject(player);
                opc = (String)datoE.readObject();
                if(opc.equals("entrando")){
                       parti = (Partida)datoE.readObject();
                       new Lobby(parti,player).setVisible(true);
                       dispose();
                   }
                jugador.close();                
            } catch (IOException ex) {ex.printStackTrace();} catch (ClassNotFoundException ex) {ex.printStackTrace();}
           
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void fondo(){
        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMultijugador.png")));
        fondo.setBounds(0,0,700,700);
        add(fondo);
        fondo.validate();
}

    public void iniciaTabla(){
        String cabecera[]={"Nombre De La Partida","Cantidad De Jugadores"};
        String datos[][]={};
        modelo = new DefaultTableModel(datos,cabecera);
        jTable1.setModel(modelo);
    }
    
    public void cargarPartidas() throws ClassNotFoundException{
        
        try {
                Socket jugador = new Socket("127.0.0.1", 27015);
                ObjectOutputStream datoS = new ObjectOutputStream(jugador.getOutputStream());
                ObjectInputStream datoE = new ObjectInputStream(jugador.getInputStream());
                datoS.writeObject("cargaPartidas");
                listaPartidas = (ArrayList<Partida>)datoE.readObject();
                
                jugador.close();
            } catch (IOException ex) {ex.printStackTrace();}
        
        for(int i=0;i<listaPartidas.size();i++){
            String v[] ={listaPartidas.get(i).nombre,Integer.toString(listaPartidas.get(i).jugadores)};
            modelo.addRow(v);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
