/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;


import clases.Conexion;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;



//importamos la variable de sesion que viene por login
import static ventanas.Login.user;
//obtenemos tipo de user que se esta logueando donde 1 es admin 2 capturista
import static ventanas.Login.tipo_user;

/**
 *
 * @author Lenovo
 */
public class Tecnico extends javax.swing.JFrame {
    //para poner la variable de sesion de login variable estatica
String  user_logueado;
//creamos la variable del nombre del usaurio logueado con el query encontrar user_logueado la creamos estatica para que llegue a una visat de registar usuario que requiere el nombre de quien crea el usuario
public static String nombre_usuario_logueado;
//esta la sacamos desde login para si es adin cuando cierre esta ventana no se cierre la de admin pero si es capturista y cierra la ventana ahi si se cierre
int tipo_user=0;
    /**
    /**
     * Creates new form Tecnico
     */
    public Tecnico() {
        initComponents();
        user_logueado=Login.user;
        //miramos que rol de gente esta logueado para segun rol destruir la ventana anterior si es capturista se destruye login , si es admin no se destruye nada, ya que el user podra cerrar esta ventana
        //y no finalizar el sistema
        tipo_user=Login.tipo_user;
       
        
        //titulo de la intefaz de login
        setTitle("Panel capturista user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
           //TAMANP DE PANTALLA
        setSize(505, 300);
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondostecnicoss.getWidth(),fondostecnicoss.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondostecnicoss.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
          //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //si es admin y ciera la ventana evitamos que se finalize el programa
        //esto evita que se finalize el programa cuando cierrren esta ventana
        if(tipo_user==1){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
        //obtenemos el nombre del usuario nolgueado para mostrarlo en la interface que se abre
         //aca nos conectamos a la db para validar que usuario es el que ah inicado sesion en el sistema
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT nombre_usuario FROM usuarios WHERE username = ?";
                                  //  System.out.println("Consulta SQL: " + sql + ", Usuario: " + user);
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                    pst.setString(1, user_logueado);
                                    ResultSet rs = pst.executeQuery();
                                    
                                    //validamos que haya datos
                                    if(rs.next()){
                                       nombre_usuario_logueado=rs.getString("nombre_usuario");
                                       //ponemos el nombre del logueado en la ventana que se abre visualmente
                                       nombresesionlogueado.setText("Bienvenido "+nombre_usuario_logueado);
                                        System.err.println("Bienvenido "+nombre_usuario_logueado);
                                    }else{
                                        System.out.println("no encontro usuario en rs. en panel principal capturista");
                                    }
            
        }catch (SQLException e) {
            System.err.println("Error al ejecutar el query en vista panel capturista: " + e.getMessage());
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

        nombresesionlogueado = new javax.swing.JLabel();
        btngraficastatus = new javax.swing.JButton();
        btngraficamarcasss = new javax.swing.JButton();
        btngestionarequiposs = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fondostecnicoss = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nombresesionlogueado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 30));

        btngraficastatus.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\grafica.png")); // NOI18N
        getContentPane().add(btngraficastatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 100, 60));

        btngraficamarcasss.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\grafica.png")); // NOI18N
        getContentPane().add(btngraficamarcasss, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 100, 60));

        btngestionarequiposs.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\apoyo-tecnico.png")); // NOI18N
        getContentPane().add(btngestionarequiposs, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 60));

        jLabel1.setText("Gestion de equipos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, -1));

        jLabel2.setText("Grafica de status");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 90, -1));

        jLabel3.setText("Grafica de Marcas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));
        getContentPane().add(fondostecnicoss, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 505, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngestionarequiposs;
    private javax.swing.JButton btngraficamarcasss;
    private javax.swing.JButton btngraficastatus;
    private javax.swing.JLabel fondostecnicoss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nombresesionlogueado;
    // End of variables declaration//GEN-END:variables
}
