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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.Capturista.nombre_usuario_logueado;
import static ventanas.Login.user;
//importamos el id del equipo que viene de la vista info clientes al clikear el equipo en la tabla
//id del cliente que viene de la var estatica de gestioanr clientes
import static ventanas.InformacionCliente.id_equipo_edit;
//importamos el nombre del cliente propietario dele quipo que viene de la vista informaciooncliente
import static ventanas.InformacionCliente.nombre_cliente_global;

/**
 *
 * @author Lenovo
 */
public class InformacionEquipo extends javax.swing.JFrame {
    String user_logueado,nombre_cliente_propietario;
    int id_equipo_editar;
    //para armar la fecha
    String fecha,anio,mes,dia;
    //para los select
    String tipo_equipo,marca_equipo,estatus_equipo;
    
    /**
     * Creates new form InformacionEquipo
     */
    public InformacionEquipo() {
        initComponents();
        user_logueado=Login.user;
        id_equipo_editar=InformacionCliente.id_equipo_edit;
        nombre_cliente_propietario=InformacionCliente.nombre_cliente_global;
         //titulo de la intefaz de login
        setTitle("Panel capturista user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
           //TAMANP DE PANTALLA
        setSize(640, 370);
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoinformacionequios.getWidth(),fondoinformacionequios.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoinformacionequios.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
   
          //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //evitamos que finalice el programa al cerrar esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //ponemos el nombre del cliente en el formulario de la vista
        infoequiponombre.setText(nombre_cliente_propietario);
        
        //hacemos la consulta a la  base de datos para sacar los datos que se muestran en el formulario
        
          //obtenemos los datos del cliente que se clikeo con en la vista gestionar cliente en la tabla con su id
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT * FROM equipos WHERE id=?";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                        pst.setInt(1, id_equipo_editar);
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                   //si existen datos con la cosnulta
                                   if(rs.next()){
                                      
                                       
                                       //llenamos los inputs de la la vista 
                                       infoequiponombremodelo.setText(rs.getString("modelo"));
                                       infoequiponombreserie.setText(rs.getString("num_serie"));
                                       nombreuserultimamodificacion.setText(rs.getString("ultima_modificacion"));
                                       observacionesinfoequipo.setText(rs.getString("observaciones"));
                                       
                                       //sacamos los datos de la fecha y los procesamos
                                       anio=rs.getString("anio_ingreso");
                                       mes=rs.getString("mes_ingreso");
                                       dia=rs.getString("dia_ingreso");
                                       fecha=dia+"-"+mes+"-"+anio;
                                       aniosinfoequipo.setText(fecha);
                                       
                                       //obtenemos los datos de la base de datos que serian select
                                       marca_equipo=rs.getString("marca");
                                       tipo_equipo=rs.getString("tipo_equipo");
                                       estatus_equipo=rs.getString("estatus");
                                          //ahora ponemos por defecto a que muestre las opciones seleccionadas de la db
                                       infoequiponombremarca.setSelectedItem(marca_equipo);
                                       //ahora ponemos por defecto a que muestre las opciones seleccionadas de la db
                                       infoequiponombretipo.setSelectedItem(tipo_equipo);
                                          //ahora ponemos por defecto a que muestre las opciones seleccionadas de la db
                                       estatusequipo.setSelectedItem(estatus_equipo);
                                     
                                       
                                   }
                                  //cerramos la conexion
                                   cn.close();
            
        }catch (SQLException e) {
            System.err.println("error al cosultar interface informacion cliente: " + e.getMessage());
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
        infoequiponombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacionesinfoequipo = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        infoequiponombretipo = new javax.swing.JComboBox<>();
        estatusequipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        infoequiponombremarca = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        infoequiponombremodelo = new javax.swing.JTextField();
        btninfoactualizarcliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        infoequiponombreserie = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        aniosinfoequipo = new javax.swing.JTextField();
        nombreuserultimamodificacion = new javax.swing.JLabel();
        fondoinformacionequios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        getContentPane().add(infoequiponombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de ingreso:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estatus");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jScrollPane1.setViewportView(observacionesinfoequipo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 240, 100));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Comentarios y actualizacion de tecnico:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jTextPane2.setEditable(false);
        jScrollPane2.setViewportView(jTextPane2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 250, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Informacion del equipo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 290, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo equipo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        infoequiponombretipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(infoequiponombretipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        estatusequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(estatusequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Marca");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        infoequiponombremarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "hp", "Lenovo", "Samsumg" }));
        getContentPane().add(infoequiponombremarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modelo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));
        getContentPane().add(infoequiponombremodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 130, -1));

        btninfoactualizarcliente.setText("Actualizar cliente");
        btninfoactualizarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninfoactualizarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(btninfoactualizarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 180, 40));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Serie");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));
        getContentPane().add(infoequiponombreserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ultima modificacion :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        getContentPane().add(aniosinfoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 110, -1));
        getContentPane().add(nombreuserultimamodificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, -1));
        getContentPane().add(fondoinformacionequios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninfoactualizarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninfoactualizarclienteActionPerformed
        //obtenemos los datos del formulario
        String modelo_e=infoequiponombremodelo.getText();
        String serie_e=infoequiponombreserie.getText();
        String observaciones_e=observacionesinfoequipo.getText();
        String estado_e=estatusequipo.getSelectedItem().toString();     
        
        //JOptionPane.showMessageDialog(rootPane, "la opcion seleccionada fue "+estado_e);
        //para validar que losc ampos esten diligenciados
        int error_e=0;
        
        if(modelo_e.equals("")){
            infoequiponombremodelo.setBackground(Color.red);
           error_e=error_e+1; 
        }
        
        if(serie_e.equals("")){
            infoequiponombreserie.setBackground(Color.red);
           error_e=error_e+1; 
        }
        //si todo esta bien procedemos a actualizar los datos del equipo
        if(error_e==0){
                                try{
                                 //creamos el objeto de conexion 
                                                      Connection cn2=Conexion.conectar();
                                                     // validamos si existe el usuario que trata de loguearse
                                                       String sql2 ="UPDATE equipos set modelo=?,num_serie=?,observaciones=?,estatus=?,ultima_modificacion=? WHERE  id=?";

                                                        
                                    
                                                        PreparedStatement pst2 = cn2.prepareStatement(sql2);
                                                        pst2.setString(1,modelo_e);
                                                        pst2.setString(2,serie_e);
                                                        pst2.setString(3,observaciones_e);
                                                        pst2.setString(4,estado_e);
                                                        pst2.setString(5,user_logueado);
                                                        pst2.setInt(6, id_equipo_editar);

                                                        pst2.executeUpdate();
                                                        cn2.close();
                                    
                                    JOptionPane.showMessageDialog(rootPane, "Actualizacion exitosa");
                                    //CON ESTO CERRAMOS LA VENTANA ACTUAL A PENAS ACTUALIZE EL EQUIPO
                                    dispose();

                           }catch (SQLException e) {
                               System.err.println("error al actualziar datos del equipo vista informacion Euipo  " + e.getMessage());
                               e.printStackTrace();
                           }
            
            
            
            
        }else{
         JOptionPane.showMessageDialog(rootPane, "Todos los campos deben estar Diligenciados");   
        }
    }//GEN-LAST:event_btninfoactualizarclienteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aniosinfoequipo;
    private javax.swing.JButton btninfoactualizarcliente;
    private javax.swing.JComboBox<String> estatusequipo;
    private javax.swing.JLabel fondoinformacionequios;
    private javax.swing.JTextField infoequiponombre;
    private javax.swing.JComboBox<String> infoequiponombremarca;
    private javax.swing.JTextField infoequiponombremodelo;
    private javax.swing.JTextField infoequiponombreserie;
    private javax.swing.JComboBox<String> infoequiponombretipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel nombreuserultimamodificacion;
    private javax.swing.JTextPane observacionesinfoequipo;
    // End of variables declaration//GEN-END:variables
}
