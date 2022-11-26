/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.enea.diej01v2.vista;

import com.enea.diej01v2.controlador.Controlador;
import com.enea.diej01v2.modelo.DataAcces;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Enea
 */
public class Principal extends javax.swing.JFrame {
    public DataAcces da;
    /**
     * Creates new form Principal
     */
    public Principal() {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlBg = new javax.swing.JPanel();
        pnlMisAlojamientos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMisAlojamientos = new javax.swing.JTable();
        pnlFotos = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPlazas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnListarAlojamientos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        pnlUsuario = new javax.swing.JPanel();
        txtUsuarioId = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnUsuarioGuardar = new javax.swing.JButton();
        btnUsuarioModificar = new javax.swing.JButton();
        txtUsuarioPassword = new javax.swing.JTextField();
        txtUsuarioNombre = new javax.swing.JTextField();
        txtUsuarioApellido = new javax.swing.JTextField();
        txtUsuarioEmail = new javax.swing.JTextField();
        pnlLogin = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(null);

        pnlMain.setMinimumSize(new java.awt.Dimension(1100, 700));
        pnlMain.setPreferredSize(new java.awt.Dimension(1100, 700));
        pnlMain.setLayout(null);

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1100, 700));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1100, 700));

        pnlBg.setBackground(new java.awt.Color(255, 255, 255));
        pnlBg.setMinimumSize(new java.awt.Dimension(1100, 700));
        pnlBg.setLayout(null);

        pnlMisAlojamientos.setBackground(new java.awt.Color(255, 255, 255));
        pnlMisAlojamientos.setBorder(javax.swing.BorderFactory.createTitledBorder("Mis alojamientos:"));

        tblMisAlojamientos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblMisAlojamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DIRECCION", "MUNICIPIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMisAlojamientos.setGridColor(new java.awt.Color(255, 255, 255));
        tblMisAlojamientos.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jScrollPane1.setViewportView(tblMisAlojamientos);

        javax.swing.GroupLayout pnlMisAlojamientosLayout = new javax.swing.GroupLayout(pnlMisAlojamientos);
        pnlMisAlojamientos.setLayout(pnlMisAlojamientosLayout);
        pnlMisAlojamientosLayout.setHorizontalGroup(
            pnlMisAlojamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMisAlojamientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMisAlojamientosLayout.setVerticalGroup(
            pnlMisAlojamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMisAlojamientosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pnlBg.add(pnlMisAlojamientos);
        pnlMisAlojamientos.setBounds(10, 90, 550, 290);

        pnlFotos.setBorder(javax.swing.BorderFactory.createTitledBorder("Fotos"));

        javax.swing.GroupLayout pnlFotosLayout = new javax.swing.GroupLayout(pnlFotos);
        pnlFotos.setLayout(pnlFotosLayout);
        pnlFotosLayout.setHorizontalGroup(
            pnlFotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pnlFotosLayout.setVerticalGroup(
            pnlFotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        pnlBg.add(pnlFotos);
        pnlFotos.setBounds(10, 390, 550, 230);

        pnlDatos.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        pnlDatos.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("ID:");
        pnlDatos.add(jLabel1);
        jLabel1.setBounds(30, 30, 30, 20);

        txtId.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtId.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtId.setEnabled(false);
        pnlDatos.add(txtId);
        txtId.setBounds(60, 30, 64, 21);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        pnlDatos.add(jLabel2);
        jLabel2.setBounds(150, 30, 50, 20);

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtNombre.setEnabled(false);
        pnlDatos.add(txtNombre);
        txtNombre.setBounds(210, 30, 260, 21);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Dirección:");
        pnlDatos.add(jLabel3);
        jLabel3.setBounds(30, 70, 60, 20);

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtDireccion.setEnabled(false);
        pnlDatos.add(txtDireccion);
        txtDireccion.setBounds(100, 70, 370, 21);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Descripcion:");
        pnlDatos.add(jLabel4);
        jLabel4.setBounds(30, 150, 90, 20);

        txtMunicipio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtMunicipio.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtMunicipio.setEnabled(false);
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });
        pnlDatos.add(txtMunicipio);
        txtMunicipio.setBounds(100, 110, 370, 21);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Municipio:");
        pnlDatos.add(jLabel5);
        jLabel5.setBounds(30, 110, 60, 20);

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        pnlDatos.add(jScrollPane2);
        jScrollPane2.setBounds(30, 180, 440, 81);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Plazas:");
        pnlDatos.add(jLabel6);
        jLabel6.setBounds(30, 290, 40, 20);

        txtPlazas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPlazas.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtPlazas.setEnabled(false);
        pnlDatos.add(txtPlazas);
        txtPlazas.setBounds(80, 290, 71, 21);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("Precio por noche:");
        pnlDatos.add(jLabel7);
        jLabel7.setBounds(170, 290, 100, 20);

        txtPrecio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPrecio.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtPrecio.setEnabled(false);
        pnlDatos.add(txtPrecio);
        txtPrecio.setBounds(280, 290, 71, 21);

        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        pnlDatos.add(btnNuevo);
        btnNuevo.setBounds(20, 360, 90, 22);

        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        pnlDatos.add(btnGuardar);
        btnGuardar.setBounds(380, 360, 90, 22);

        btnModificar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        pnlDatos.add(btnModificar);
        btnModificar.setBounds(120, 360, 90, 22);

        pnlBg.add(pnlDatos);
        pnlDatos.setBounds(580, 40, 490, 400);

        btnListarAlojamientos.setText("Listar");
        pnlBg.add(btnListarAlojamientos);
        btnListarAlojamientos.setBounds(400, 60, 160, 23);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentarios"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        pnlBg.add(jPanel1);
        jPanel1.setBounds(580, 450, 490, 170);

        txtUsuario.setText("jLabel10");
        pnlBg.add(txtUsuario);
        txtUsuario.setBounds(30, 30, 210, 16);

        jTabbedPane1.addTab("Principal", pnlBg);

        pnlUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pnlUsuario.setPreferredSize(new java.awt.Dimension(1100, 700));
        pnlUsuario.setLayout(null);

        txtUsuarioId.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuarioId.setText("id");
        pnlUsuario.add(txtUsuarioId);
        txtUsuarioId.setBounds(390, 210, 60, 20);

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("Apellidos:");
        pnlUsuario.add(jLabel13);
        jLabel13.setBounds(320, 290, 60, 20);

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("Email:");
        pnlUsuario.add(jLabel11);
        jLabel11.setBounds(320, 330, 60, 20);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("Password:");
        pnlUsuario.add(jLabel10);
        jLabel10.setBounds(320, 370, 60, 20);

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        pnlUsuario.add(jLabel14);
        jLabel14.setBounds(320, 250, 60, 20);

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setText("ID:");
        pnlUsuario.add(jLabel15);
        jLabel15.setBounds(320, 210, 60, 20);

        btnUsuarioGuardar.setText("Guardar");
        pnlUsuario.add(btnUsuarioGuardar);
        btnUsuarioGuardar.setBounds(500, 450, 110, 23);

        btnUsuarioModificar.setText("Modificar");
        pnlUsuario.add(btnUsuarioModificar);
        btnUsuarioModificar.setBounds(330, 450, 110, 23);

        txtUsuarioPassword.setEnabled(false);
        pnlUsuario.add(txtUsuarioPassword);
        txtUsuarioPassword.setBounds(390, 370, 280, 22);

        txtUsuarioNombre.setEnabled(false);
        pnlUsuario.add(txtUsuarioNombre);
        txtUsuarioNombre.setBounds(390, 250, 280, 22);

        txtUsuarioApellido.setEnabled(false);
        pnlUsuario.add(txtUsuarioApellido);
        txtUsuarioApellido.setBounds(390, 290, 280, 22);

        txtUsuarioEmail.setEnabled(false);
        pnlUsuario.add(txtUsuarioEmail);
        txtUsuarioEmail.setBounds(390, 330, 280, 22);

        jTabbedPane1.addTab("Usuario", pnlUsuario);

        pnlMain.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1100, 700);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 1200, 800);

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setMinimumSize(new java.awt.Dimension(1100, 700));
        pnlLogin.setPreferredSize(new java.awt.Dimension(1100, 700));
        pnlLogin.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 48)); // NOI18N
        jLabel8.setText("INICIO DE SESIÓN");
        pnlLogin.add(jLabel8);
        jLabel8.setBounds(332, 62, 430, 65);

        btnLogin.setText("ENTRAR");
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(500, 520, 75, 23);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Enea\\Documents\\Desarrollo de interfaces\\DIEJ01v2\\src\\main\\java\\com\\enea\\diej01v2\\img\\logos-villaonline1.png")); // NOI18N
        pnlLogin.add(jLabel9);
        jLabel9.setBounds(230, 140, 610, 350);

        getContentPane().add(pnlLogin);
        pnlLogin.setBounds(0, 0, 1100, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Principal principal = new Principal();
        Controlador controlador = new Controlador(principal);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.pnlMain.setVisible(false);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnListarAlojamientos;
    public javax.swing.JButton btnLogin;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnUsuarioGuardar;
    public javax.swing.JButton btnUsuarioModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlFotos;
    public javax.swing.JPanel pnlLogin;
    public javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMisAlojamientos;
    public javax.swing.JPanel pnlUsuario;
    public javax.swing.JTable tblMisAlojamientos;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMunicipio;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPlazas;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JLabel txtUsuario;
    public javax.swing.JTextField txtUsuarioApellido;
    public javax.swing.JTextField txtUsuarioEmail;
    public javax.swing.JLabel txtUsuarioId;
    public javax.swing.JTextField txtUsuarioNombre;
    public javax.swing.JTextField txtUsuarioPassword;
    // End of variables declaration//GEN-END:variables
}
