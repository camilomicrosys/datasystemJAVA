/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;


import java.sql.*;
import  clases.Conexion;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.awt.Image;
import static ventanas.Login.user;
/**
 *
 * @author Lenovo
 */
public class Administrador extends javax.swing.JFrame {
    //creamos variable y la estatica que  son als que puden viajar entre formularios de vistas
    String user,user_name;
    public static int session_usuario;
    
    

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        //aca recuperamos los datos de la ventana login  en los constructores es que podemos trabajar con ellos
        //aca decimos que en la user que cree yo en esta clase sea igual a la interface login .user que esta en la case login declarada asi pasamos de alla aca
        user=Login.user;
        session_usuario=1;
        //TAMANP DE PANTALLA
        setSize(650,430);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        
        //titulo de la intefaz de login
        setTitle("Panel Adminitrador sesion de -"+user);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoAdmin.getWidth(),fondoAdmin.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoAdmin.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
      
        //aca nos conectamos a la db para validar que usuario es el que ah inicado sesion en el sistema
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT nombre_usuario FROM usuarios WHERE username = ?";
                                    System.out.println("Consulta SQL: " + sql + ", Usuario: " + user);
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                    pst.setString(1, user);
                                    ResultSet rs = pst.executeQuery();
                                    
                                    //validamos que haya datos
                                    if(rs.next()){
                                       user_name=rs.getString("nombre_usuario");
                                       txt_nombre_user.setText(user_name);
                                        System.err.println("el nombre del user es "+user_name);
                                    }else{
                                        System.out.println("no encontro usuario en rs.");
                                    }
            
        }catch (SQLException e) {
            System.err.println("Error al ejecutar el query: " + e.getMessage());
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

        txt_nombre_user = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAcercade = new javax.swing.JButton();
        btnRegistarUser1 = new javax.swing.JButton();
        btnGestionarUser1 = new javax.swing.JButton();
        btnCreatividad1 = new javax.swing.JButton();
        btnCapturista1 = new javax.swing.JButton();
        btnTecnico1 = new javax.swing.JButton();
        fondoAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_user.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txt_nombre_user.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_nombre_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 15));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar usuarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Creatividad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Panel vista capturista");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Acerca de");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Panel vista tecnico");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jLabel7.setText("Desarrollado por: Camilo Agudelo ©");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, -1, -1));

        btnAcercade.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\geekipedia.png")); // NOI18N
        btnAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcercade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 110, 90));

        btnRegistarUser1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\addUser.png")); // NOI18N
        btnRegistarUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarUser1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistarUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 90));

        btnGestionarUser1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\informationuser.png")); // NOI18N
        btnGestionarUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarUser1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionarUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 110, 90));

        btnCreatividad1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\creatividad.png")); // NOI18N
        getContentPane().add(btnCreatividad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 110, 90));

        btnCapturista1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\capturista.png")); // NOI18N
        btnCapturista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturista1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapturista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 90));

        btnTecnico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\tecnico.png")); // NOI18N
        btnTecnico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnico1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTecnico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 110, 90));
        getContentPane().add(fondoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 680, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarUser1ActionPerformed
        // TODO add your handling code here:
        //ABRIMOS LA INTEFACE DEL REGISTER USER creando un objeto de la interface registeruser
        RegistarUser registrarusuarios= new RegistarUser();
        //mostramos la interface
        registrarusuarios.setVisible(true);
    }//GEN-LAST:event_btnRegistarUser1ActionPerformed

    private void btnGestionarUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarUser1ActionPerformed
        
        //ABRIMOS LA INTEFACE DEL GestionaUser creando un objeto de la interface Gestionar User
        GestionUser gestionarusers= new GestionUser();
        //mostramos la interface
        gestionarusers.setVisible(true);
    }//GEN-LAST:event_btnGestionarUser1ActionPerformed

    private void btnCapturista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturista1ActionPerformed
       
           //abrimos interface de Capturista
          new Capturista().setVisible(true);
    }//GEN-LAST:event_btnCapturista1ActionPerformed

    private void btnTecnico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnico1ActionPerformed
          //abrimos interface de Tecnico
          new Tecnico().setVisible(true);
    }//GEN-LAST:event_btnTecnico1ActionPerformed

    private void btnAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercadeActionPerformed
       //mostramos la vista acerca de 
       Acercade acerca= new Acercade();
       acerca.setVisible(true);
    }//GEN-LAST:event_btnAcercadeActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcercade;
    private javax.swing.JButton btnCapturista1;
    private javax.swing.JButton btnCreatividad1;
    private javax.swing.JButton btnGestionarUser1;
    private javax.swing.JButton btnRegistarUser1;
    private javax.swing.JButton btnTecnico1;
    private javax.swing.JLabel fondoAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel txt_nombre_user;
    // End of variables declaration//GEN-END:variables
}
