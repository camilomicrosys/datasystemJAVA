/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

//obtenemos el nombre del usuario logueado
import static ventanas.Login.user;
//obtenemos la variable estatica del equipo que clickearon en la tabla
import static ventanas.EquiposRegistrados.idEquipo_update;


/**
 *
 * @author Lenovo
 */
public class Informacionequipotecnico extends javax.swing.JFrame {
    String user_logueado;
    //esta es para guardar la variable que viene estatica de la tabla que clikearon el equipo
    int id_equipo_actualziar;
    /**
     * Creates new form Informacionequipotecnico
     */
    public Informacionequipotecnico() {
        initComponents();
         user_logueado=Login.user;
         id_equipo_actualziar=EquiposRegistrados.idEquipo_update;
         //titulo de la intefaz de login
        setTitle("Panel informacion equipo tecnico user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
           //TAMANP DE PANTALLA
        setSize(711, 412);
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoinfoequipostecnico.getWidth(),fondoinfoequipostecnico.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoinfoequipostecnico.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
   
          //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //evitamos que finalice el programa al cerrar esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //obtenemos los datos del equipo clikeado para mostrarlo en la interface
          //obtenemos los datos del equipo que se clikeo con su id
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT * FROM equipos WHERE id=?";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                    pst.setInt(1, id_equipo_actualziar);
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                   //si existen datos con la cosnulta
                                   if(rs.next()){
                                      
                                      //ponemos los datos en el formulario visual
                                       tipo.setText(rs.getString("tipo_equipo"));
                                       marca.setText(rs.getString("marca"));
                                       modelo.setText(rs.getString("modelo"));
                                       series.setText(rs.getString("num_serie"));
                                       modificadopor.setText(rs.getString("ultima_modificacion"));
                                       //ponemos que en el select aparezca el estdo actual seleccionado por default al abrirlo
                                       estadoequiposelect.setSelectedItem(rs.getString("estatus"));
                                       String anio,mes,dia,fecha_completa;
                                       anio=rs.getString("anio_ingreso");
                                       mes=rs.getString("mes_ingreso");
                                       dia=rs.getString("dia_ingreso");
                                       fecha_completa=dia+"-"+mes+"-"+anio;
                                       fechas.setText(fecha_completa);
                                       danos.setText(rs.getString("observaciones"));
                                       comentariostecnicos.setText(rs.getString("comentarios_tecnicos"));
                                       
                                   }
                                  //cerramos la conexion
                                   cn.close();
            
        }catch (SQLException e) {
            System.err.println("error al cosultar panel informacion equipo tecnico: " + e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        eti = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        estadoequiposelect = new javax.swing.JComboBox<>();
        fechas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        danos = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentariostecnicos = new javax.swing.JTextPane();
        tipo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        series = new javax.swing.JLabel();
        modificadopor = new javax.swing.JLabel();
        btnactualziador = new javax.swing.JButton();
        fondoinfoequipostecnico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Equipo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha ingreso:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 90, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("estatus:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 100, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 250, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Comentarios Tecnicos:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 200, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Marca:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Modelo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Serie:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 20));

        eti.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        eti.setForeground(new java.awt.Color(255, 255, 255));
        eti.setText("Modificado por:");
        getContentPane().add(eti, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Informacion del Equipo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 220, 40));

        estadoequiposelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(estadoequiposelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));
        getContentPane().add(fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 140, -1));

        danos.setEditable(false);
        jScrollPane1.setViewportView(danos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 250, 50));

        jScrollPane2.setViewportView(comentariostecnicos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 250, 80));
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 20));
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        getContentPane().add(series, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        getContentPane().add(modificadopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        btnactualziador.setText("Comentar y Actualizar");
        btnactualziador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualziadorActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualziador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, 50));
        getContentPane().add(fondoinfoequipostecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 363));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualziadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualziadorActionPerformed
        //Procedemos actualizar los datos, unicamente estara habilitado el esatus y el comentario tecnico
        String estado_seleccionado,comentarios;
        int errores_actualizar=0;
        if(comentariostecnicos.getText().equals("")){
           comentariostecnicos.setBackground(Color.red);
           errores_actualizar=errores_actualizar+1;
        }
        
        
        
           //validamos si hay errores
        if(errores_actualizar==0){
          //sino hay errores actualizamos el estado del equipo
          estado_seleccionado= estadoequiposelect.getSelectedItem().toString();
          comentarios=comentariostecnicos.getText().trim();
          
              try{
                                                                   //creamos el objeto de conexion cada que creamos una nueva conexion y cerramos otra se debe cambiar la variable cn eneste caso pusimos cn2 al igual que el pst le pusimos pst2
                                                                   Connection cn2=Conexion.conectar();
                                                                   // validamos si existe el usuario que trata de loguearse
                                                                   PreparedStatement pst2 = cn2.prepareStatement("UPDATE equipos set estatus=?,ultima_modificacion=?,comentarios_tecnicos=?,revision_tecnica_de=? WHERE  id=?");
                                                                   //mandamos los datos pusimos 8 signos ? que son 8 columas de la db a la primera que es id mandamos 0 opara que ya el sistema asigne su auto increment
                                                                    
                                                                      pst2.setString(1, estado_seleccionado);
                                                                      //ultima modificacion
                                                                      pst2.setString(2, user_logueado);
                                                                      pst2.setString(3, comentarios);
                                                                      pst2.setString(4, user_logueado);
                                                                      pst2.setInt(5, id_equipo_actualziar);
                                                                   
                                                                    // ejecutamos el query de insercion
                                                                    pst2.executeUpdate();
                                                                    //cerramos la conexion
                                                                    cn2.close();
                                                                   
                                                                    //ahora ponemos en verde el input de comentarios
                                                                    comentariostecnicos.setBackground(Color.green);
                                                                   
                                                                    
                                                                    
        
                                                                    
                                                                    JOptionPane.showMessageDialog(rootPane,"Equipo actualizado correctamente");
                                                                    //le decimos que esta interface la cierre para reducisir recursos del pc
                                                                    this.dispose();
                                                        }catch(SQLException e){
                                                               System.err.println("error al actualziar cliente panel informacion equipo tecnico "+e);
                                                               JOptionPane.showMessageDialog(rootPane,"error al actualizar cliente");
                                                        }

            
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "debes diligenciar todos los campos");  
        }
        
        
        
    }//GEN-LAST:event_btnactualziadorActionPerformed

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
            java.util.logging.Logger.getLogger(Informacionequipotecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacionequipotecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacionequipotecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacionequipotecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacionequipotecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualziador;
    private javax.swing.JTextPane comentariostecnicos;
    private javax.swing.JTextPane danos;
    private javax.swing.JComboBox<String> estadoequiposelect;
    private javax.swing.JLabel eti;
    private javax.swing.JTextField fechas;
    private javax.swing.JLabel fondoinfoequipostecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel modificadopor;
    private javax.swing.JLabel series;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
