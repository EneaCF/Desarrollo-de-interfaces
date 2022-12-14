package com.enea.diej01v2.controlador;

import com.enea.diej01v2.modelo.Allotjament;
import com.enea.diej01v2.modelo.Comentari;
import com.enea.diej01v2.modelo.DataAcces;
import com.enea.diej01v2.modelo.Municipi;
import com.enea.diej01v2.modelo.Usuari;
import com.enea.diej01v2.modelo.Servei;
import com.enea.diej01v2.vista.Principal;
import com.mysql.cj.util.StringUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
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
    public List<JCheckBox> ckb = new ArrayList();
    
    public Controlador(Principal p) {
        this.principal = p;
        this.principal.btnNuevo.addActionListener(this);
        this.principal.btnGuardar.addActionListener(this);
        this.principal.btnModificar.addActionListener(this);
        this.principal.btnLogin.addActionListener(this);
        this.principal.jButton1.addActionListener(this);
        this.principal.btnUsuarioModificar.addActionListener(this);
        this.principal.btnUsuarioGuardar.addActionListener(this);
        
    }
    
    public void CargarListaCheckBox(){
        ckb.add(principal.ckbPiscina);
        ckb.add(principal.ckbMascotas);
        ckb.add(principal.ckbAire);
        ckb.add(principal.ckbAscensor);
        ckb.add(principal.ckbAparcamiento);
        ckb.add(principal.ckbWifi);
    }
    
    public void CargarDatosUsuario(){
        principal.txtUsuarioId.setText(String.valueOf(usuario.getId()));
        principal.txtUsuarioNombre.setText(usuario.getNom());
        principal.txtUsuarioApellido.setText(usuario.getLlinatges());
        principal.txtUsuarioEmail.setText(usuario.getEmail());
        principal.txtUsuarioPassword.setText(usuario.getPassword());
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
                //principal.txtServicio4.setVisible(false);
                //principal.pnlServicios.setVisible(false);
                
                principal.txtComentarios.setText("");
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
                    principal.txtValoracion.setText(String.valueOf(da.getValoracioAllotjamentAvg(allotjamentSel.getId())));
                    CargarComentarios(allotjamentSel.getId());
                    CargarServicios(allotjamentSel.getId());
                }
            }
        });     
    }
    public void VisibleServicios(String nServicio,int posicion){
        switch (posicion) {
            case 1:
                principal.txtServicio1.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio1.setVisible(true);
                break;
            case 2:
                principal.txtServicio2.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio2.setVisible(true);
                break;
            case 3:
                principal.txtServicio3.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio3.setVisible(true);
                break;
            case 4:
                principal.txtServicio4.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio4.setVisible(true);
                break;
            case 5:
                principal.txtServicio5.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio5.setVisible(true);
                break;
            case 6:
                principal.txtServicio6.setIcon(principal.CargarImagenes(nServicio));
                principal.txtServicio6.setVisible(true);
                break;
            default:
                principal.txtServicio1.setVisible(false);
                principal.txtServicio2.setVisible(false);
                principal.txtServicio3.setVisible(false);
                principal.txtServicio4.setVisible(false);
                principal.txtServicio5.setVisible(false);
                principal.txtServicio6.setVisible(false);
                principal.pnlCheckBox.setVisible(false);
                break;
        }
    }
    
    public void CargarServicios(int idAlojamiento){
        principal.pnlServicios.setVisible(true);
        List<Servei> servicios = da.getServeisAllotjament(idAlojamiento);
        int aux = 1;
        if (servicios.isEmpty()) {
            VisibleServicios("asd", 0);
        }else{
            for(Servei s : servicios){
            switch (s.getId()) {
                case 1:
                    VisibleServicios("piscina", aux);
                    aux++;
                    break;
                case 2:
                    VisibleServicios("mascotas", aux);
                    aux++;
                    break;
                case 3:
                    VisibleServicios("aire", aux);
                    aux++;
                    break;
                case 4:
                    VisibleServicios("ascensor", aux);
                    aux++;
                    break;
                case 5:
                    VisibleServicios("aparcamiento", aux);
                    aux++;
                    break;
                case 6:
                    VisibleServicios("wifi", aux);
                    aux++;
                    break;
                default:
                    break;
                }
            }
        }
        
    }
    public void AbilitarTextBoxUsuario(boolean b){
        if(b){
            principal.txtUsuarioNombre.setEnabled(true);
            principal.txtUsuarioApellido.setEnabled(true);
            principal.txtUsuarioEmail.setEnabled(true);
            principal.txtUsuarioPassword.setEnabled(true);
            
        }else{
            principal.txtUsuarioNombre.setEnabled(false);
            principal.txtUsuarioApellido.setEnabled(false);
            principal.txtUsuarioEmail.setEnabled(false);
            principal.txtUsuarioPassword.setEnabled(false); 
        }
    }
        
    public void BotonModificarUsuario(){
        if(!principal.txtUsuarioNombre.isEnabled()){
            AbilitarTextBoxUsuario(true);
        }else{
            AbilitarTextBoxUsuario(false);
        }
        principal.btnUsuarioGuardar.setEnabled(true);
    }
    
    public void BotonGuardarUsuario(){
        Usuari u = new Usuari(usuario.getId(), principal.txtUsuarioNombre.getText(), 
                principal.txtUsuarioApellido.getText(), 
                principal.txtUsuarioEmail.getText(),
                principal.txtUsuarioPassword.getText(),
                Boolean.TRUE);
        
        da.updateUsuari(u);
        AbilitarTextBoxUsuario(false);
        principal.btnUsuarioGuardar.setEnabled(false);
       
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
        principal.txtId.setText("0");
        principal.txtNombre.setText("");
        principal.txtDireccion.setText("");
        principal.txtMunicipio.setText("");
        principal.txtDescripcion.setText("");
        principal.txtPrecio.setText("");
        principal.txtPlazas.setText("");
        if(!principal.txtNombre.isEnabled()){
            AbilitarTextBoxDatos(true);
            principal.pnlCheckBox.setVisible(true);
            principal.SetVisibleCkb();
            CargarListaCheckBox();
        }else{
            AbilitarTextBoxDatos(false);
            principal.pnlCheckBox.setVisible(false);
        }
        principal.btnGuardar.setEnabled(true);
    }
    
    public int getIdMunicipi(String municipio){
        List<Municipi> municipis = da.getMunicipis();
        for(Municipi m : municipis){
            String aux = Normalizer.normalize(m.getNom() , Normalizer.Form.NFD);
            aux = aux.replaceAll("[^\\p{ASCII}]", "");
            if(aux.equalsIgnoreCase(municipio)){
                return m.getId();
            }
        } 
        return 1;
    }
    
    public void BotonGuardar(){
        int aux = getIdMunicipi(principal.txtMunicipio.getText());
        //int auxid = GetLastId() +1;
        Allotjament allotjament = new Allotjament(Integer.parseInt(principal.txtId.getText()),
                principal.txtNombre.getText(),
                principal.txtDescripcion.getText(),
                principal.txtDireccion.getText(),
                //principal.txtMunicipio.getText()
                String.valueOf(aux), 
                Integer.parseInt(principal.txtPlazas.getText()),
                Float.parseFloat(principal.txtPrecio.getText()
        ));
        
        if (Integer.parseInt(principal.txtId.getText())==0) {
            da.insertAllotjament(allotjament);
            //InsertarServicios(da.getIdLastInsertedAllotjament()); 
        }else{
            da.updateAllojtament(allotjament); 
        }       
        
        //Cambiar esto por la forma correcta 
        principal.tblMisAlojamientos.setVisible(false);
        principal.tblMisAlojamientos.setVisible(true);
        principal.btnGuardar.setEnabled(false);
        AbilitarTextBoxDatos(false);  
        VisibleServicios("", 55);
        
    }
    
    public void CargarComentarios(int idPropiedad){
        List<Comentari> comentarios = da.getComentaris(idPropiedad);
        String aux = "";
        for(Comentari c : comentarios){
            aux = principal.txtComentarios.getText() + "Id: " + c.getId() + 
                " id usaurio: " + c.getIdUsuari() + "\n" + c.getText();
        }
        principal.txtComentarios.setText(aux + "\n");
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
    
    public void Logout(){
        Usuari u = new Usuari();
        usuario = u;
        principal.pnlLogin.setVisible(true);
        principal.pnlMain.setVisible(false);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==principal.btnModificar){
            BotonModificar();
        }
        if(e.getSource()==principal.btnNuevo){
            BotonNuevo();
        }
        if(e.getSource()==principal.btnGuardar){
            BotonGuardar();
            ListarMisAlojamientos(principal.tblMisAlojamientos);
        }
        if(e.getSource()==principal.btnLogin){
            Login();
        }
        if(e.getSource()==principal.btnUsuarioModificar){
            BotonModificarUsuario();
        }
        if(e.getSource()==principal.btnUsuarioGuardar){
            BotonGuardarUsuario();
        }
        if(e.getSource()==principal.jButton1){
            Logout();
        }
    }
    
    //Servicios
    
//    private void InsertarServicios(int idAlojamiento) {
//        for(JCheckBox c : ckb){
//            if (c.isSelected()) {
//                int aux = ckb.indexOf(c) + 1;
//                //int aux = 2;
//                da.insertServei(aux, idAlojamiento + 1);
//            }
//        }
//    }
}
