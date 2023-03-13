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

/**
 *
 * @author Lenovo
 */
public class Login extends javax.swing.JFrame {

    //se crean las variables estaticas para poder enviar datos entre interfaces en este caso solo el user
    public static String user="";
    //creo otra estatica para mandarla a las vistas de paneles de administracion para si son admins validar si se cierran las ventanas que se abren o no
    //por ejemplo sia dmin entra a capturista y cierra no dbe finalizar el programa pero si entra capturista a capturista debe cerrarse el programa
    public static int tipo_user;
    String pass="";
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
         //colocar la imagen dentro del label que creamos de paper para que tenga la imagen de fondo
        setSize(400,550);
        //esto para no dejar modificar al usuario las dimensiones de la ventana
        setResizable(false);
        //titulo de la intefaz de login
        setTitle("Acceso al sistema");
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //AGREAGAMOS LA IMAGEN EN EL JLABEL D EFONDO
        ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(img_fondo.getWidth(),img_fondo.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        img_fondo.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        
        
        //ahora ponemos el el label de nombre variable logo la imagen del logo logo es el nombre de la variable en el formulario en la vista
        ImageIcon obj_logo= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\DS.png");
        Icon icono_logo= new ImageIcon(obj_logo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_DEFAULT));
        logo.setIcon(icono_logo);
        this.repaint();
        
    }

    
    
    /*icono de la ventanita donde salia la tasa de cafe aca hacemos polimorfismo de la clase pura esto no me funciono pero es el proceso
   @Override
    public Image getIconImage(){
        Image retValue= Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icon.png"));
        return retValue;
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        img_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, 190));

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 70, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        txt_user.setForeground(new java.awt.Color(51, 51, 51));
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 250, -1));

        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 250, -1));

        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 70, -1));
        getContentPane().add(img_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        //estas son la variables que declaramos al inicio de la clase y acceden al valor de los inputs
        user=txt_user.getText().trim();
        pass=txt_password.getText().trim();
        
        //si alguno esta vacio
        if(user.equals("")|| pass.equals("")){
            JOptionPane.showMessageDialog(rootPane,"el password y usuario deben estar diligenciados");
        }else{
                    //validamos login
                    try{
                                    //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    PreparedStatement pst = cn.prepareStatement("SELECT tipo_nivel, estatus FROM usuarios WHERE username = ? AND password = ?");
                                    pst.setString(1, user);
                                    pst.setString(2, pass);
                                    // ejecutamos el query
                                    ResultSet rs = pst.executeQuery();
                                //validamos si encontro coincidencias
                                if(rs.next()){

                                        //creamos valirable y con getString asignamos lo que vienen en la columna de la db
                                        String tipo_nivel=rs.getString("tipo_nivel");
                                        String estatus=rs.getString("estatus");
                                       //validaos que roll tiene el usuario que se esta logueando
                                       if(tipo_nivel.equals("administrador")&& estatus.equals("activo")){
                                           tipo_user=1;
                                         //esto lo que hace es que destruye en el sistema operativo la intefaz d elogin para poder interactuar con la siguiente vista de formulario
                                         dispose();
                                         //abrimos interface de administrador
                                         new Administrador().setVisible(true);
                                           
                                       }else if(tipo_nivel.equals("capturista")&& estatus.equals("activo")){
                                           tipo_user=2;
                                            //esto lo que hace es que destruye en el sistema operativo la intefaz d elogin para poder interactuar con la siguiente vista de formulario
                                         dispose();
                                         //abrimos interface de Capturista
                                         new Capturista().setVisible(true);
                                           
                                       }else if(tipo_nivel.equals("tecnico")&& estatus.equals("activo")){
                                           tipo_user=3;
                                         //esto lo que hace es que destruye en el sistema operativo la intefaz d elogin para poder interactuar con la siguiente vista de formulario
                                         dispose();
                                         //abrimos interface de Tecnico
                                         new Tecnico().setVisible(true);
                                       }

                                    //validamos que hacer dependiendo tipo de rol
                                }else{
                                    //le decimos que no existe y limipamos  los datos
                                      JOptionPane.showMessageDialog(rootPane,"datos incorrectos o, usuario no existe en el sistema USUARIO="+user+" PASS="+pass);
                                      txt_password.setText("");
                                      txt_user.setText("");
                                }
                       //OBTENEMOS EL ERROR DE LA DB 
                    }catch(SQLException e){

                        System.err.println("Error en el boton acceder login "+e);
                        JOptionPane.showMessageDialog(rootPane,"error al inicial sesion contacte al administrador");

                    }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel img_fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
