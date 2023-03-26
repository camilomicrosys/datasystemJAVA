/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;

//variable creada en login statica o de sesion
import static ventanas.Login.user;

/**
 *
 * @author Lenovo
 */
public class Graficastatus extends javax.swing.JFrame {
    //para almacenar la variable global de usuario logueado
    String user_logueado;
    //declaramos variables para los estados de los equipos
    int nuevoingreso,noreparado,enrevision,reparado,entregado;
    //creamos 2 vectores  el primero con 5 posiciones que son nuevoingreso,noreparado,enrevisiocn etc aca guarda el nombre de los estados
    String[] vector_estatus_nombre=new String[5];
    //aca la cantidades
    int[] vector_status_cantidad= new int[5];
    
    
    /**
     * Creates new form Graficastatus
     */
    public Graficastatus() {
        initComponents();
         //recuperamos el usuario que viene desde el login
        user_logueado=Login.user;
       
        
          //colocar la imagen dentro del label que creamos de paper para que tenga la imagen de fondo
        setSize(729, 395);
        //esto para no dejar modificar al usuario las dimensiones de la ventana
        setResizable(false);
        //titulo de la intefaz de login
        setTitle("Panel grafica status user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        //esto evida que se finalize el programa cuando cierrren esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //AGREAGAMOS LA IMAGEN EN EL JLABEL D EFONDO
        ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondograficastatus.getWidth(),fondograficastatus.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondograficastatus.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        //HACEMOS LA CONSULTA PARA QUE ME MUESTRE CUANTOS EQUIPOS Y EN QUE ESTADO 
            try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // seleccionamos cunatos equipo hay por esatado
                                    String sql = "SELECT estatus, COUNT(estatus) AS cantidad FROM equipos GROUP BY estatus";
                                 
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                   
                                    ResultSet rs = pst.executeQuery();
                                    
                                    if(rs.next()){
                                      //creamos una variable para poder recorrer los vectores de arriba
                                      int posicion=0;
                                      
                                      do{
                                          //el sql genera 2 columnas 1 estatus y la 2 cantidad eso es lo que se hace aca en los get y asignamos cantidad y dato en los array por cada vuelta
                                          vector_estatus_nombre[posicion]=rs.getString(1);
                                          vector_status_cantidad[posicion]=rs.getInt(2);
                                          
                                          //empezamos a validar cada vuelta viene el estado y la cantidad entonces aca les asignamos el valor a cada estado
                                          if(vector_estatus_nombre[posicion].equals("Nuevo ingreso")){
                                              nuevoingreso=vector_status_cantidad[posicion];
                                          }else if(vector_estatus_nombre[posicion].equals("No reparado")){
                                              noreparado=vector_status_cantidad[posicion];
                                          }else if(vector_estatus_nombre[posicion].equals("En revision")){
                                              enrevision=vector_status_cantidad[posicion];
                                          }else if(vector_estatus_nombre[posicion].equals("Reparado")){
                                              reparado=vector_status_cantidad[posicion];
                                          }else if(vector_estatus_nombre[posicion].equals("Entregado")){
                                              entregado=vector_status_cantidad[posicion];
                                          }
                                          
                                          posicion=posicion+1;
                                          
                                      }while(rs.next());
                                    }
                               
            //este metodo es interno de JAVA para llamar los graficos    que es la funcion que declare por fuera de la calse como paint()              
            repaint();
        }catch (SQLException e) {
            System.err.println("Error al ejecutar el query en vista graficastatus: " + e.getMessage());
            e.printStackTrace();
            }
        
                                    
                                       
                                   
              
        
    }
    //este es para saber el esatdo que mas se repite
    public int estatusrepetidos(int nuevoingreso,int noreparado,int enrevision,int reparado,int entregado){
        //es para validar cual es el que ams tienen ya que ese seria el limite de la ejecucion
        if(nuevoingreso> noreparado&&nuevoingreso>enrevision&&nuevoingreso>reparado &&nuevoingreso>entregado){
          return nuevoingreso;
          //aca ya no se pone nuevo por que se supone que nuevo ya no es el mayor por que paso aca
        }else if(noreparado>enrevision&& noreparado>reparado&& noreparado>entregado){
            return noreparado;
        }else if(enrevision>reparado && enrevision>entregado){
            return enrevision;
        }else if(reparado>entregado){
            return reparado;
        }else{
            return entregado;
        }
    }
    //generamos el codigo de las barras colocamos el overyde para reescribir el metodo paint
    @Override
    //este es el que permite crear la grafica visual de barras
     public void paint(Graphics g){
        super.paint(g);
        //alamcenamos en esat variable el dato del mas repetido esto para saber cual es el limite de la barra mas grande
        int esatatus_mas_repetido=estatusrepetidos(nuevoingreso,noreparado,enrevision,reparado,entregado);
        //584 es el ancho de la interface entonces para que no supere ese ancho
        //obtenemos los largos de las barras de los estados
        int largo_nuevoIngreso=nuevoingreso* 729 / esatatus_mas_repetido;
        int largo_noreparado=noreparado*729/esatatus_mas_repetido;
        int largo_revision=enrevision*729/esatatus_mas_repetido;
        int largo_reparado= reparado*729/esatatus_mas_repetido;
        int largo_entregado=entregado*729/esatatus_mas_repetido;
        
        //asignamos un color acada estado
           //Amarillo nuevo ingreso
            g.setColor(new Color(240,248,0));
            g.fillRect(100, 100, largo_nuevoIngreso, 40);
            g.drawString("Nuevo Ingreso", 10, 118);
            //escribimos la cantidad
            g.drawString("Cantidad:"+nuevoingreso, 10, 133);
            
            //rojo no reparado
            g.setColor(new Color(255,0,0));
            g.fillRect(100, 150, largo_noreparado, 40);
            g.drawString("No reparado", 10, 168);
            //escribimos la cantidad
            g.drawString("Cantidad:"+noreparado, 10, 183);
            
            //negro en revision
            g.setColor(new Color(0,0,0));
            g.fillRect(100, 200, largo_revision, 40);
            g.drawString("En revision", 10, 218);
            //escribimos la cantidad
            g.drawString("Cantidad:"+enrevision, 10, 233);
        
            
             //blancoen reparado
            g.setColor(new Color(255,255,255));
            g.fillRect(100, 250, largo_reparado, 40);
            g.drawString("reparado", 10, 268);
            //escribimos la cantidad
            g.drawString("Cantidad:"+reparado, 10, 283);
            
             //verde entregado
            g.setColor(new Color(0,85,0));
            g.fillRect(100, 300, largo_entregado, 40);
            g.drawString("entregado ", 10, 318);
            //escribimos la cantidad
            g.drawString("Cantidad:"+entregado, 10, 333);
            
      
            
        
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
        fondograficastatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de estatus:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 30));
        getContentPane().add(fondograficastatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 400));

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
            java.util.logging.Logger.getLogger(Graficastatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficastatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficastatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficastatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficastatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondograficastatus;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
