/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enea.diej01v2.controlador;

import com.enea.diej01v2.modelo.Allotjament;
import com.enea.diej01v2.modelo.DataAcces;
import com.enea.diej01v2.modelo.Usuari;
import com.enea.diej01v2.vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enea
 */
public class Controlador implements ActionListener{
    public static Usuari usuario = new Usuari();
    DataAcces da = new DataAcces();
    Principal principal = new Principal();
    DefaultTableModel model = new DefaultTableModel();
    Allotjament allotjamentSel = new Allotjament();

    public Controlador(Principal p) {
        this.principal = p;
        this.principal.btnListarAlojamientos.addActionListener(this);
        this.principal.btnNuevo.addActionListener(this);
        this.principal.btnGuardar.addActionListener(this);
        this.principal.btnModificar.addActionListener(this);
        this.principal.btnLogin.addActionListener(this);
    }
    
    public void CargarDatosUsuario(){
        principal.txtUsuarioId.setText(String.valueOf(usuario.getId()));
        principal.txtUsuarioNombre.setText(usuario.getNom());
        principal.txtUsuarioApellido.setText(usuario.getLlinatges());
        principal.txtUsuarioEmail.setText(usuario.getEmail());
        principal.txtUsuarioPassword.setText(usuario.getPassword());
    }
    
    //BORRAR?
    public void LimpiarTabla(JTable tabla){
        principal.tblMisAlojamientos.setModel(new DefaultTableModel());
        ListarMisAlojamientos(tabla);
    }
    
    
    
    
    public void ListarMisAlojamientos(JTable tabla){
       
        model = (DefaultTableModel)tabla.getModel();
        model.setRowCount(0);
        List<Allotjament> alojamientos = da.getAllotjaments(usuario.getId());
        Object[] objects = new Object[6];
        for(int i=0;i<alojamientos.size();i++){
            objects[0]=alojamientos.get(i).getId();
            objects[1]=alojamientos.get(i).getNom();
            objects[2]=alojamientos.get(i).getAdresa();
            objects[3]=alojamientos.get(i).getMunicipi();
            model.addRow(objects);
        }
        
        principal.tblMisAlojamientos.setModel(model);

        principal.tblMisAlojamientos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (principal.tblMisAlojamientos.getSelectedRow() > -1) {
                    int auxId = (int) principal.tblMisAlojamientos.getValueAt(principal.tblMisAlojamientos.getSelectedRow(), 0);
                    allotjamentSel = da.getAllotjament(auxId);
                    principal.txtId.setText(String.valueOf(allotjamentSel.getId()));
                    principal.txtNombre.setText(allotjamentSel.getNom());
                    principal.txtDireccion.setText(allotjamentSel.getAdresa());
                    principal.txtMunicipio.setText(allotjamentSel.getMunicipi());
                    principal.txtDescripcion.setText(allotjamentSel.getDescripcio());
                    principal.txtPrecio.setText(String.valueOf(allotjamentSel.getPReu_per_nit()));
                    principal.txtPlazas.setText(String.valueOf(allotjamentSel.getNum_persones()));
                }
            }
        });     
    }
    public void AbilitarTextBoxDatos(boolean b){
        if(b){
            //principal.txtId.setEnabled(true);
            principal.txtNombre.setEnabled(true);
            principal.txtDireccion.setEnabled(true);
            principal.txtMunicipio.setEnabled(true);
            principal.txtDescripcion.setEnabled(true);
            principal.txtPrecio.setEnabled(true);
            principal.txtPlazas.setEnabled(true);
        }else{
            //principal.txtId.setEnabled(false);
            principal.txtNombre.setEnabled(false);
            principal.txtDireccion.setEnabled(false);
            principal.txtMunicipio.setEnabled(false);
            principal.txtDescripcion.setEnabled(false);
            principal.txtPrecio.setEnabled(false);
            principal.txtPlazas.setEnabled(false);
        }
    }
    
    public void BotonModificar(){
        if(!principal.txtNombre.isEnabled()){
            AbilitarTextBoxDatos(true);
        }else{
            AbilitarTextBoxDatos(false);
        }
        principal.btnGuardar.setEnabled(true);
    }
    
    public void BotonNuevo(){
        //principal.txtId.setText("");
        principal.txtNombre.setText("");
        principal.txtDireccion.setText("");
        principal.txtMunicipio.setText("");
        principal.txtDescripcion.setText("");
        principal.txtPrecio.setText("");
        principal.txtPlazas.setText("");
        if(!principal.txtNombre.isEnabled()){
            AbilitarTextBoxDatos(true);
        }
        principal.btnGuardar.setEnabled(true);
    }
    
    public void BotonGuardar(){
        
        Allotjament allotjament = new Allotjament(Integer.parseInt(principal.txtId.getText()),
                principal.txtNombre.getText(),
                principal.txtDescripcion.getText(),
                principal.txtDireccion.getText(),
                principal.txtMunicipio.getText(), 
                Integer.parseInt(principal.txtPlazas.getText()),
                Float.parseFloat(principal.txtPrecio.getText()
        ));
        //System.out.println("ENVIAMOS " + allotjament);
        da.updateAllojtament(allotjament);
        //Cambiar esto por la forma correcta 
        principal.tblMisAlojamientos.setVisible(false);
        principal.tblMisAlojamientos.setVisible(true);
        principal.btnGuardar.setEnabled(false);
        AbilitarTextBoxDatos(false);
        
    }
    
    public void Login(){
        JTextField email = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
            "Email:", email,
            "Password:", password
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (password.getText().equals(da.findUserPassword(email.getText()))) {
                System.out.println("Login Correcto");
                usuario = da.getUser(email.getText());
                
                principal.txtUsuario.setText(usuario.getEmail());
                principal.pnlLogin.setVisible(false);
                principal.pnlMain.setVisible(true);
                ListarMisAlojamientos(principal.tblMisAlojamientos);
                CargarDatosUsuario();
            } else {
                JOptionPane.showMessageDialog(principal, "Login incorrecto! Intenta de nuevo");
            }
        } else {
            System.out.println("Login cancelado");
        }
    }
  
    //List<Allotjament> alojamientos = da.getAllotjaments(4);
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==principal.btnListarAlojamientos) {
            ListarMisAlojamientos(principal.tblMisAlojamientos);
        }
        else if(e.getSource()==principal.btnModificar){
            BotonModificar();
        }
        else if(e.getSource()==principal.btnNuevo){
            BotonNuevo();
        }
        else if(e.getSource()==principal.btnGuardar){
            BotonGuardar();
        }
        if(e.getSource()==principal.btnLogin){
            Login();
        }
    }
}
