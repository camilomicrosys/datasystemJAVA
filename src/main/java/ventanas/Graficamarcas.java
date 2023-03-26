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
//importacion para grafica cicular
import java.awt.Color;
import java.awt.Graphics;

//variable creada en login statica o de sesion
import static ventanas.Login.user;

/**
 *
 * @author Lenovo
 */
public class Graficamarcas extends javax.swing.JFrame {
       //para almacenar la variable global de usuario logueado
    String user_logueado;
    //este es para las marcas yo solo tengo 4 marcas esto es para guardar la cantidad de equipos por marca
    int[] vector_marcas_cantidad= new int[4];
    String[] vector_marcas_nombre=new String[4];
    //ponemos las marcas que tenemos para asignarles luego una cantidad
    int Acer,hp,Lenovo,Samsumg;

    /**
     * Creates new form Graficamarcas
     */
    public Graficamarcas() {
        initComponents();
                //recuperamos el usuario que viene desde el login
        user_logueado=Login.user;
       
        
          //colocar la imagen dentro del label que creamos de paper para que tenga la imagen de fondo
        setSize(669, 366);
        //esto para no dejar modificar al usuario las dimensiones de la ventana
        setResizable(false);
        //titulo de la intefaz de login
        setTitle("Panel grafica marcas user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        //esto evida que se finalize el programa cuando cierrren esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //AGREAGAMOS LA IMAGEN EN EL JLABEL D EFONDO
        ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondograficamarcas.getWidth(),fondograficamarcas.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondograficamarcas.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        //hacemos la consulta a la base de datos para mostrar cuantos equipos por marca tenemos
        //HACEMOS LA CONSULTA PARA QUE ME MUESTRE CUANTOS EQUIPOS pertenecen a x marca 
            try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // seleccionamos cunatos equipo hay por esatado
                                    String sql = "SELECT marca, COUNT(marca) AS cantidad FROM equipos GROUP BY marca";
                                 
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                   
                                    ResultSet rs = pst.executeQuery();
                                    
                                    if(rs.next()){
                                      //creamos una variable para poder recorrer los vectores de arriba
                                      int posicion=0;
                                      
                                      do{
                                          //el sql genera 2 columnas 1 estatus y la 2 cantidad eso es lo que se hace aca en los get y asignamos cantidad y dato en los array por cada vuelta
                                          vector_marcas_nombre[posicion]=rs.getString(1);
                                          vector_marcas_cantidad[posicion]=rs.getInt(2);
                                          
                                          //empezamos a validar cada vuelta viene el estado y la cantidad entonces aca les asignamos el valor a cada estado
                                          if(vector_marcas_nombre[posicion].equals("Acer")){
                                              Acer=vector_marcas_cantidad[posicion];
                                          }else if(vector_marcas_nombre[posicion].equals("hp")){
                                              hp=vector_marcas_cantidad[posicion];
                                          }else if(vector_marcas_nombre[posicion].equals("Lenovo")){
                                              Lenovo=vector_marcas_cantidad[posicion];
                                          }else if(vector_marcas_nombre[posicion].equals("Samsumg")){
                                              Samsumg=vector_marcas_cantidad[posicion];
                                          }
                                          
                                          posicion=posicion+1;
                                          
                                      }while(rs.next());
                                    }
                               
            //este metodo es interno de JAVA para llamar los graficos    que es la funcion que declare por fuera de la calse como paint()              
            repaint();
        }catch (SQLException e) {
            System.err.println("Error al ejecutar el query en vista grafica de marcas: " + e.getMessage());
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
        fondograficamarcas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de Marcas:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 290, 50));
        getContentPane().add(fondograficamarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 669, 366));

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
            java.util.logging.Logger.getLogger(Graficamarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficamarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficamarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficamarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficamarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondograficamarcas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
