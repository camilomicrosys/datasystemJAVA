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
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
//importamos la libreria de calendario propia de java no funciona lo de la wikipedia con gpt encontre esta solucion
import java.util.Calendar;
import java.util.GregorianCalendar;

//importamos el nombre del cliene que viene de la interface informacion cliente
import  static  ventanas.InformacionCliente.nombre_cliente_global;
//id del cliente que viene de la var estatica de gestioanr clientes para al registar este equipo quede a nombre de este id
import static ventanas.GestinarClientes.cliente_update;

//obtenemos el nombre del usuario logueado
import static ventanas.Login.user;

/**
 *
 * @author Lenovo
 */
public class RegistarEquipo extends javax.swing.JFrame {
    //alamacenamos la variable estatica del nombre que viene de informacion de usaurio
    String nombre_cliente_global;
    //variable para almacenar el id del cliente al que le vamos asignar como propietario de este equipo
    int user_propietario_equipo;
    //variabe estatica que viene de login con el nombre del usuario logueado
    String usuario_logueado;
    //Estos son los del select ya con otro metodo accedemos al item exacto que selecciona ejemplo pc y no a un 0 que era la posicion
    String tipo_equipo_string="";
    String marca_equipo_string="";
    String dia_ingreso,mes_ingreso,anio_ingreso,estats_equipo,danos_equipos;
    /**
     * Creates new form RegistarEquipo
     */
    public RegistarEquipo() {
        initComponents();
        nombre_cliente_global=InformacionCliente.nombre_cliente_global;
        user_propietario_equipo=GestinarClientes.cliente_update;
        //nombre del usuario logueado
        usuario_logueado=Login.user;
          //TAMANP DE PANTALLA
        setSize(410, 300);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        
        //titulo de la intefaz de login
        setTitle("Registar nuevo equipo para  "+nombre_cliente_global);
        //le ponemos a la etiqueta que mostrara el nombre del cliente seleccionado
        registarNombrecliente.setText(nombre_cliente_global);
        
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         //esto evita que se finalize el programa cuando cierrren esta ventana de registro de clientes
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoregistrarequipo.getWidth(),fondoregistrarequipo.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoregistrarequipo.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        
        
        
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
        registarNombrecliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registrarModelo = new javax.swing.JTextField();
        registarSerie = new javax.swing.JTextField();
        btnregistarequipo2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbtipoequipo = new javax.swing.JComboBox<>();
        cmbmarcaequipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        danosyobservacionescliente = new javax.swing.JTextPane();
        fondoregistrarequipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de equipo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 190, 70));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        getContentPane().add(registarNombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 10));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Numero de serie:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(registrarModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, -1));
        getContentPane().add(registarSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, -1));

        btnregistarequipo2.setText("Registrar equipo");
        btnregistarequipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistarequipo2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistarequipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 130, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 180, -1));

        cmbtipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmbtipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        cmbmarcaequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "hp", "Lenovo", "Samsumg" }));
        getContentPane().add(cmbmarcaequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jScrollPane2.setViewportView(danosyobservacionescliente);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 170, 100));
        getContentPane().add(fondoregistrarequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistarequipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistarequipo2ActionPerformed
       
       //validamos que el modelo y el numero de serie no esten vacios
       String modelo_equipo=registrarModelo.getText().trim();
       String serie_equipo=registarSerie.getText().trim();
       //si los daños esta vacio reemplacamo el texto por no tiene reportes
        danos_equipos=danosyobservacionescliente.getText().trim();
       //de esta manera obtenemos no el idice del option sino el valor en etxto de la opcion
       tipo_equipo_string=cmbtipoequipo.getSelectedItem().toString();
       marca_equipo_string=cmbmarcaequipo.getSelectedItem().toString();
       estats_equipo="Nuevo ingreso";
       //creamos ya los campos de calendario
      Calendar calendar = new GregorianCalendar();
      dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
      //sele suma 1 por que enero es cero  feb 1 y asi
      mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH) + 1);
      anio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));
      

       //validamos si hay errores
       int errores_registar=0;
       
       if(modelo_equipo.equals("")){
           registrarModelo.setBackground(Color.red);
           errores_registar=errores_registar+1;
           
       }
       
       if(serie_equipo.equals("")){
           registarSerie.setBackground(Color.red);
           errores_registar=errores_registar+1;
       }
       
       if(danos_equipos.equals("")){
           danosyobservacionescliente.setText("sin observaciones");
           danos_equipos="sin observaciones";
       }
       
       //validamos si no hay errores procedemos a realizar el registr del equipo en la db
       if(errores_registar==0){
           
                
                        //si todo esta bien ahora procedemos a hacer la insercion en la db
                         try{
                                                                           //creamos el objeto de conexion cada que creamos una nueva conexion y cerramos otra se debe cambiar la variable cn eneste caso pusimos cn2 al igual que el pst le pusimos pst2
                                                                           Connection cn=Conexion.conectar();
                                                                           // validamos si existe el usuario que trata de loguearse
                                                                            PreparedStatement pst2 = cn.prepareStatement("INSERT INTO equipos (id,id_cliente, tipo_equipo, marca, modelo,num_serie,dia_ingreso,mes_ingreso,anio_ingreso,observaciones,estatus,ultima_modificacion,comentarios_tecnicos,	revision_tecnica_de) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                                                            pst2.setInt(1, 0);
                                                                            pst2.setInt(2, user_propietario_equipo);
                                                                            pst2.setString(3,tipo_equipo_string);
                                                                            pst2.setString(4, marca_equipo_string);
                                                                            pst2.setString(5,modelo_equipo );
                                                                            pst2.setString(6, serie_equipo);
                                                                            pst2.setString(7, dia_ingreso);
                                                                            pst2.setString(8, mes_ingreso);
                                                                            pst2.setString(9, anio_ingreso);
                                                                            pst2.setString(10, danos_equipos);
                                                                            pst2.setString(11, estats_equipo);
                                                                            pst2.setString(12,usuario_logueado);
                                                                            pst2.setString(13, "");
                                                                            pst2.setString(14, "");
                                                                            
                                                                           

                                                                            //ejecutamos el query
                                                                            pst2.executeUpdate();

                                                                            //cerramos la conexion
                                                                            cn.close();
                                                                          


                                                                            JOptionPane.showMessageDialog(rootPane,"Equipo registrado satisfactoriamente");
                                                                            //le decimos que esta interface la cierre para reducisir recursos del pc
                                                                            this.dispose();
                                                                }catch(SQLException e){
                                                                       System.err.println("Error todos los campos estan bien para equipo  panel RegistarEquipo "+e);
                                                                       JOptionPane.showMessageDialog(rootPane,"error al crear cliente ");
                                                                }











               }else{

                 JOptionPane.showMessageDialog(rootPane, "debes diligenciar todos los campos");  
               }
       
       
       
       
       
       
    }//GEN-LAST:event_btnregistarequipo2ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregistarequipo2;
    private javax.swing.JComboBox<String> cmbmarcaequipo;
    private javax.swing.JComboBox<String> cmbtipoequipo;
    private javax.swing.JTextPane danosyobservacionescliente;
    private javax.swing.JLabel fondoregistrarequipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel registarNombrecliente;
    private javax.swing.JTextField registarSerie;
    private javax.swing.JTextField registrarModelo;
    // End of variables declaration//GEN-END:variables
}
