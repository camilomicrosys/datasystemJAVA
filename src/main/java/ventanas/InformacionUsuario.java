/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
//creamos un pack llamado clases y alli metimos la conexion por eso lo importamos aca
import clases.Conexion;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
//variable creada en login statica o de sesion
import static ventanas.Login.user;
//importamos la variable que anda en interfaces que viene de gestionaruser
import static  ventanas.GestionUser.user_update;
/**
 *
 * @author Lenovo
 */
public class InformacionUsuario extends javax.swing.JFrame {
    //variable de sesion de login
    String user="";
    String user_update="";
    //el id de el que vamos actualizar
    int id;

    /**
     * Creates new form InformacionUsuario
     */
    public InformacionUsuario() {
        initComponents();
        //recuperamos el usuario que viene desde el login
        user=Login.user;
        //obtenemos el usuario que se selecciono a editar en gestionarUser
        user_update=GestionUser.user_update;
        
          //colocar la imagen dentro del label que creamos de paper para que tenga la imagen de fondo
        setSize(641, 450);
        //esto para no dejar modificar al usuario las dimensiones de la ventana
        setResizable(false);
        //titulo de la intefaz de login
        setTitle("Info del usuario: "+user_update+" , sesion: "+user);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        //esto evida que se finalize el programa cuando cierrren esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //AGREAGAMOS LA IMAGEN EN EL JLABEL D EFONDO
        ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoinfousuario.getWidth(),fondoinfousuario.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoinfousuario.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        //esta es la label que dice info fl usuario  que estamos editando es el titulo de la interface
        lbtinfodeusereditar.setText("Informacion del usuario "+user_update);
        //hacemos la consulta a la db del usaurio que estamos editando
          //aca nos conectamos a la db para validar que usuario es el que ah inicado sesion en el sistema
        try{
                                 //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT * FROM usuarios WHERE username = ?";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                    pst.setString(1, user_update);
                                    ResultSet rs = pst.executeQuery();
                                    
                                    //validamos que haya datos
                                    if(rs.next()){
                                      //recuperamos el id que vamos actualizar de la db  id de las comillas es id en db
                                      id=rs.getInt("id");
                                      //llenamos el front del formulario
                                      txt_infonombre4.setText(rs.getString("nombre_usuario"));
                                      txt_infotelefono.setText(rs.getString("telefono"));
                                      txt_infonoemail.setText(rs.getString("email"));
                                      labelinfouserregistradopor.setText(rs.getString("registrado_por"));
                                      txt_infousername.setText(rs.getString("username"));
                                      //para que salga seleccionado el nivel que tiene actualmente el usuario es con esta linea
                                      String tipo_nivel = rs.getString("tipo_nivel");
                                      String estatus = rs.getString("estatus");
                                      jComboBoxniveles.setSelectedItem(tipo_nivel);
                                      //lo mismo para el status que es select
                                      jComboBoxestados.setSelectedItem(estatus);
                                      
                                    }else{
                                        System.out.println("no encontro usuario en rs.");
                                    }
                                    
                                    //cerramos la conexion
                                    cn.close();
            
                }catch (SQLException e) {
            System.err.println("Error al ejecutar el query vista informacionUsuario: " + e.getMessage());
            e.printStackTrace();
            }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbtinfodeusereditar = new javax.swing.JLabel();
        labelinofotelefono = new javax.swing.JLabel();
        labelinofopermisos = new javax.swing.JLabel();
        labelinofousername = new javax.swing.JLabel();
        labelinofostatus = new javax.swing.JLabel();
        labelinoforegistradopor = new javax.swing.JLabel();
        labelinofonombre5 = new javax.swing.JLabel();
        txt_infotelefono = new javax.swing.JTextField();
        txt_infousername = new javax.swing.JTextField();
        txt_infonoemail = new javax.swing.JTextField();
        txt_infonombre4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxestados = new javax.swing.JComboBox<>();
        jComboBoxniveles = new javax.swing.JComboBox<>();
        btninfouserrestaurarpass = new javax.swing.JButton();
        btninfouseractualizar1 = new javax.swing.JButton();
        labelinfouserregistradopor = new javax.swing.JLabel();
        fondoinfousuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Desarrollado por: Camilo Agudelo ©");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 220, -1));

        lbtinfodeusereditar.setFont(new java.awt.Font("Segoe UI Emoji", 3, 18)); // NOI18N
        lbtinfodeusereditar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbtinfodeusereditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 430, 30));

        labelinofotelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinofotelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelinofotelefono.setText("Telefono:");
        getContentPane().add(labelinofotelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        labelinofopermisos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinofopermisos.setForeground(new java.awt.Color(255, 255, 255));
        labelinofopermisos.setText("Permisos:");
        getContentPane().add(labelinofopermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        labelinofousername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinofousername.setForeground(new java.awt.Color(255, 255, 255));
        labelinofousername.setText("Username:");
        getContentPane().add(labelinofousername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        labelinofostatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinofostatus.setForeground(new java.awt.Color(255, 255, 255));
        labelinofostatus.setText("Status:");
        getContentPane().add(labelinofostatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        labelinoforegistradopor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinoforegistradopor.setForeground(new java.awt.Color(255, 255, 255));
        labelinoforegistradopor.setText("Registardo por:");
        getContentPane().add(labelinoforegistradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        labelinofonombre5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelinofonombre5.setForeground(new java.awt.Color(255, 255, 255));
        labelinofonombre5.setText("Nombre:");
        getContentPane().add(labelinofonombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txt_infotelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_infotelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 180, -1));

        txt_infousername.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_infousername, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 180, -1));

        txt_infonoemail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_infonoemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 180, -1));

        txt_infonombre4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_infonombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jComboBoxestados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        jComboBoxestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxestadosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxestados, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jComboBoxniveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "capturista", "tecnico" }));
        getContentPane().add(jComboBoxniveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        btninfouserrestaurarpass.setText("Restaurar password");
        getContentPane().add(btninfouserrestaurarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 180, 30));

        btninfouseractualizar1.setText("Actualizar");
        getContentPane().add(btninfouseractualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 180, 30));

        labelinfouserregistradopor.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelinfouserregistradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 150, 30));
        getContentPane().add(fondoinfousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 641, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxestadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxestadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninfouseractualizar1;
    private javax.swing.JButton btninfouserrestaurarpass;
    private javax.swing.JLabel fondoinfousuario;
    private javax.swing.JComboBox<String> jComboBoxestados;
    private javax.swing.JComboBox<String> jComboBoxniveles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelinfouserregistradopor;
    private javax.swing.JLabel labelinofonombre5;
    private javax.swing.JLabel labelinofopermisos;
    private javax.swing.JLabel labelinoforegistradopor;
    private javax.swing.JLabel labelinofostatus;
    private javax.swing.JLabel labelinofotelefono;
    private javax.swing.JLabel labelinofousername;
    private javax.swing.JLabel lbtinfodeusereditar;
    private javax.swing.JTextField txt_infonoemail;
    private javax.swing.JTextField txt_infonombre4;
    private javax.swing.JTextField txt_infotelefono;
    private javax.swing.JTextField txt_infousername;
    // End of variables declaration//GEN-END:variables
}
