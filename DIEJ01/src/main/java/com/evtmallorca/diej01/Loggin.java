/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.evtmallorca.diej01;


import com.evtmallorca.diej01.dao.DataAcces;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Enea
 */
public class Loggin extends javax.swing.JFrame {

    public DataAcces da = new DataAcces();
    
    /**
     * Creates new form Loggin
     */
    public Loggin() {
        initComponents();
    }
    
    public boolean ComprobarPassword(){
        if(!txtUsuario.getText().isBlank() && !txtPassword.getText().isBlank()){
            if(txtPassword.getText().equals(da.findUserPassword(txtUsuario.getText()))){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setText("LOGO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 36, 130, 130);

        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 290, 70, 16);

        jLabel3.setText("USUARIO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 70, 16);

        txtPassword.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("***********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(30, 330, 330, 15);

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingresa tu nombre de usuario...");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(30, 230, 330, 15);

        jButton1.setText("ENTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 400, 130, 23);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(30, 250, 330, 3);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(30, 350, 330, 3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ComprobarPassword()) {
            //JOptionPane.showConfirmDialog(this, "Loggin CORRECTO");
            JOptionPane.showMessageDialog(this,"Bienvenido!");
            //this.dispose();
            Main.ventPrin.setEnabled(true);
            this.setVisible(false);
            
            //main.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Loggin incorrecto! inteta otra vez");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if(txtUsuario.getText().equals("Ingresa tu nombre de usuario...")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.BLACK);
        }
        if(txtPassword.getText().isEmpty()){
            txtPassword.setText("***********");
            txtPassword.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if(txtPassword.getText().equals("***********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.BLACK);
        }
        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setText("Ingresa tu nombre de usuario...");
            txtUsuario.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
