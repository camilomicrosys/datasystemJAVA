/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Conexion;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

//importamos esto de pdf
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

//esto para manejar insersion de imagenes 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//para la tabla
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static ventanas.Login.user;
 //importamos el nombre del usuario logueado que es quien va a registarar este cliente y viene desde la vista capturista
import static ventanas.Capturista.nombre_usuario_logueado;
//id del cliente que viene de la var estatica de gestioanr clientes
import static ventanas.GestinarClientes.cliente_update;




/**
 *
 * @author Lenovo
 */
public class InformacionCliente extends javax.swing.JFrame {
    //usuario de variable statica de login
    String user;
    //nombre del suaurio logueado que viene de variable estatica de capturista
    String user_logueado;
    //para recibir la variable estatica del id del cliente a modificar que viene de vista gestionarclientes
    int id_clientes;
    //declaramos una variable id equipo statica para mas adelante mandarla a otrainterface en a tabla cuando clikeen un equipo
    public static int id_equipo_edit;
    //creamos ota estatica para que viaje el nombre del cliente a la vista que lo requiera llamar en este caso la de registrar clientes
    public static String nombre_cliente_global;
    //campos del formulario actualizar el cliente
    String nombre_info_cliente,email_info_cliente,telefono_info_cliente,direccion_info_clientes;
    
     //creamos el objeto del datatable esto lo que nos va a permitir es modificar datos de la tabla a su interior para los quipos del usuario
     DefaultTableModel model=new DefaultTableModel();
     
 
     
    
    /**
     * Creates new form InformacionCliente
     */
    public InformacionCliente() {
        initComponents();
        
          //aca recuperamos los datos de la ventana login  en los constructores es que podemos trabajar con ellos
        //aca decimos que en la user que cree yo en esta clase sea igual a la interface login .user que esta en la case login declarada asi pasamos de alla aca
        user=Login.user;
        user_logueado=Capturista.nombre_usuario_logueado;
        id_clientes=GestinarClientes.cliente_update;
       
        //TAMANP DE PANTALLA
        setSize(706, 395);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        //esto es para yo validar en el titulo a ver si si me llega el id que vamosa  editar
        String cliente_editar_Str = String.valueOf(id_clientes);
        
        //
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
   
        
         //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //esto evita que se finalize el programa cuando cierrren esta ventana de registro de clientes
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
         
         
           
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoinformacioncliente.getWidth(),fondoinformacioncliente.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoinformacioncliente.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        
         //obtenemos los datos del cliente que se clikeo con en la vista gestionar cliente en la tabla con su id
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT * FROM clientes WHERE id=?";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                        pst.setInt(1, id_clientes);
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                   //si existen datos con la cosnulta
                                   if(rs.next()){
                                       //ponemos el titulo de la interface rs get string obtiene el dato con el nombre de la tabla de la db
                                       setTitle("Informacion del cliente"+rs.getString("nombre_cliente")+" - sesion de: "+nombre_usuario_logueado);
                                       jLabel7.setText("informacion del cliente: "+rs.getString("nombre_cliente"));
                                       
                                       //llenamos los inputs de la la vista 
                                       infoclientenombres.setText(rs.getString("nombre_cliente"));
                                       infoclientemail.setText(rs.getString("email_cliente"));
                                       infoclientetelefono.setText(rs.getString("tel_cliente"));
                                       infoclientedireccion.setText(rs.getString("dir_cliente"));
                                       infoclientemodificadopor.setText(rs.getString("ultima_modificacion"));
                                       //llenamos la variable estatica para poder enviala a las vistas que la requieran
                                       nombre_cliente_global=rs.getString("nombre_cliente");
                                       
                                   }
                                  //cerramos la conexion
                                   cn.close();
            
        }catch (SQLException e) {
            System.err.println("error al cosultar interface informacion cliente: " + e.getMessage());
            e.printStackTrace();
        }
        
        
        //hacemos el otro query para sacar los datos del equipo registrado
        
         try{
                                 //creamos el objeto de conexion 
                                   Connection cn2=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql2 = "SELECT id,tipo_equipo,marca,estatus FROM equipos WHERE id_cliente=?";
                                    
                                    PreparedStatement pst2 = cn2.prepareStatement(sql2);
                                        pst2.setInt(1, id_clientes);
                                   //obtenemos los datos del query
                                   ResultSet rs2 = pst2.executeQuery();
                               
                                      tableinfoclientess= new JTable(model);
                                      //le indicamos que la table_usuarios es la que va estar dentro del panel de la tabla o sea la interfacesiata d etabla
                                    //ademas esta linea hace un scroll si jay muchos registros en la consulta saca el scroll
                                    jScrollPane1.setViewportView(tableinfoclientess);
                                   
                                    //colocamos los nombres de las columans de las tablas la primera se deja vacia que es el id esa la llenamos abajo con eñ 1+1
                                    model.addColumn(" ");
                                    model.addColumn("tipo_equipo");
                                    model.addColumn("marca");
                                    model.addColumn("estatus");
                                      //validamos que haya datos
                                    while(rs2.next()){
                                        //creamos un vector object para mostrar los datos de la tabla ponemos 5 haciendo referencia a las 6 columnas que creamos anteriormente
                                        Object[] fila= new Object[4];
                                        //hacemos un recorrido de las fila las 5 columas por eso hasta que sea menor a 5
                                        for(int i=0;i<4;i++){
                                            //este es el indice ne la tabla
                                            fila[i]=rs2.getObject(i+1);
                                            
                                        }
                                        //aca agregariamos a nuestra fila lo que vamos encontrando en el foreach
                                        model.addRow(fila);
                                       System.err.println("entraste por aca ");
                                      
                                    }
                                    
                                       
                                   
                                  //cerramos la conexion
                                   cn2.close();
            
        }catch (SQLException e) {
            System.err.println("error al cosultar interface informacion cliente: " + e.getMessage());
            e.printStackTrace();
        }
        
         //ahora obtenemos el id del equipo que se clickee cuando den clic en alguna fila de la tabla de los equipos
          //esto es para obtener los datos del usuario que se clikee en el front de la tabla
            tableinfoclientess.addMouseListener(new MouseAdapter(){
                  @Override  
                  public void mouseClicked(MouseEvent e){
                //obtenemos cual es la fila que se clikeo
                      int fila_point=tableinfoclientess.rowAtPoint(e.getPoint());
                      //ponemos 0 quemado ya que trabajaremos con la columna de id en la tabla pintada, por ejemplo en la vista gestioanr users 
                      //podemos ir a esa visat y vemos este mismo codigo alla quemaban 2 ya que la tabla visual en la columna 2 era el nombre del cliente y liego trabajabamos el query ent la otra vista con ese nombre de usuario
                      //pero en este mandamos el id statico a la otra interface
                      int columna_point=0;
                       //no pueden haber negativos y la primera es cero ya que son array
                            if(fila_point>-1){
                                //aca obtenemos el id real que se clikeo
                                id_equipo_edit=(int)model.getValueAt(fila_point, columna_point);
                                JOptionPane.showMessageDialog(rootPane, id_equipo_edit);
                                /*
                                aca mostrariamos la siguiente interface que es la para editar el equipo al cual se le dio click
                                creamos el objeto de la otra interfce donde veremos la info de este usuario
                                InformacionCliente informacion_clientes= new InformacionCliente();
                                // y abrimos esa nueva interface
                                informacion_clientes.setVisible(true);
                                */
                                
                            }

                    }
          });
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableinfoclientess = new javax.swing.JTable();
        infoclientemail = new javax.swing.JTextField();
        infoclientenombres = new javax.swing.JTextField();
        infoclientedireccion = new javax.swing.JTextField();
        infoclientetelefono = new javax.swing.JTextField();
        infoclientemodificadopor = new javax.swing.JTextField();
        btnActualizarcliente = new javax.swing.JButton();
        btnregistrarequipo1 = new javax.swing.JButton();
        btnimprimirclientex = new javax.swing.JButton();
        fondoinformacioncliente = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefono");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ultima modificacion por:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 50));

        tableinfoclientess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableinfoclientess);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 410, 190));
        getContentPane().add(infoclientemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 150, -1));
        getContentPane().add(infoclientenombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, -1));
        getContentPane().add(infoclientedireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 150, -1));
        getContentPane().add(infoclientetelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 150, -1));

        infoclientemodificadopor.setEditable(false);
        getContentPane().add(infoclientemodificadopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 150, -1));

        btnActualizarcliente.setText("Actualizar cliente");
        btnActualizarcliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 130, 30));

        btnregistrarequipo1.setText("Registar equipo");
        btnregistrarequipo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistrarequipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarequipo1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrarequipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 30));

        btnimprimirclientex.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\impresora.png")); // NOI18N
        getContentPane().add(btnimprimirclientex, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 90, 80));
        getContentPane().add(fondoinformacioncliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 389));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarequipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarequipo1ActionPerformed
         //ABRIMOS LA INTEFACE DEL GestionaUser creando un objeto de la interface Gestionar User
        RegistarEquipo registar_equipo= new RegistarEquipo();
        //mostramos la interface
        registar_equipo.setVisible(true);
    }//GEN-LAST:event_btnregistrarequipo1ActionPerformed

    private void btnActualizarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarclienteActionPerformed
        //obtenemos los datos del formulario y validamos que no esten vacios
        int errores=0;
        nombre_info_cliente= infoclientenombres.getText().trim();
        email_info_cliente=infoclientemail.getText().trim();
        telefono_info_cliente=infoclientetelefono.getText().trim();
        direccion_info_clientes=infoclientedireccion.getText().trim();
        
        //validamos que no esten vacios
        if(nombre_info_cliente.equals("")){
            infoclientenombres.setBackground(Color.red);
            errores=errores+1;
        }
        
        
        if(email_info_cliente.equals("")){
            infoclientemail.setBackground(Color.red);
            errores=errores+1;
        }
        
        
        if(telefono_info_cliente.equals("")){
            infoclientetelefono.setBackground(Color.red);
            errores=errores+1;
        }
        
        if(direccion_info_clientes.equals("")){
            infoclientedireccion.setBackground(Color.red);
            errores=errores+1;
        }
        
        //validamos si hay errores
        if(errores==0){
            //hacemos el update a la tabla users
            
              try{
                                                                   //creamos el objeto de conexion cada que creamos una nueva conexion y cerramos otra se debe cambiar la variable cn eneste caso pusimos cn2 al igual que el pst le pusimos pst2
                                                                   Connection cn2=Conexion.conectar();
                                                                   // validamos si existe el usuario que trata de loguearse
                                                                   PreparedStatement pst2 = cn2.prepareStatement("UPDATE clientes set nombre_cliente=?,email_cliente=?,tel_cliente=?,dir_cliente=?,ultima_modificacion=? WHERE  id=?");
                                                                   //mandamos los datos pusimos 8 signos ? que son 8 columas de la db a la primera que es id mandamos 0 opara que ya el sistema asigne su auto increment
                                                                    
                                                                    pst2.setString(1, nombre_info_cliente);
                                                                    pst2.setString(2, email_info_cliente);
                                                                    pst2.setString(3, telefono_info_cliente);
                                                                    pst2.setString(4, direccion_info_clientes);
                                                                    pst2.setString(5, user_logueado);
                                                                    pst2.setInt(6, id_clientes);
                                                                    // ejecutamos el query de insercion
                                                                    pst2.executeUpdate();
                                                                    //cerramos la conexion
                                                                    cn2.close();
                                                                   
                                                                    //en el codigo anterior limpiamos los campos y en este ponemos el backgron den verde en los campos
                                                                    infoclientenombres.setBackground(Color.green);
                                                                    infoclientemail.setBackground(Color.green);
                                                                    infoclientetelefono.setBackground(Color.green);
                                                                    infoclientedireccion.setBackground(Color.green);
                                                                   
                                                                    
                                                                    
        
                                                                    
                                                                    JOptionPane.showMessageDialog(rootPane,"Cliente actualizado correctamente");
                                                                    //le decimos que esta interface la cierre para reducisir recursos del pc
                                                                    this.dispose();
                                                        }catch(SQLException e){
                                                               System.err.println("error al actualziar cliente panel informacion cliente "+e);
                                                               JOptionPane.showMessageDialog(rootPane,"error al actualizar cliente");
                                                        }

            
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "debes diligenciar todos los campos");  
        }
        
        
        
        
    }//GEN-LAST:event_btnActualizarclienteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarcliente;
    private javax.swing.JButton btnimprimirclientex;
    private javax.swing.JButton btnregistrarequipo1;
    private javax.swing.JLabel fondoinformacioncliente;
    private javax.swing.JTextField infoclientedireccion;
    private javax.swing.JTextField infoclientemail;
    private javax.swing.JTextField infoclientemodificadopor;
    private javax.swing.JTextField infoclientenombres;
    private javax.swing.JTextField infoclientetelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableinfoclientess;
    // End of variables declaration//GEN-END:variables
}
