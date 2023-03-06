/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import java.sql.*;
import  clases.Conexion;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.awt.Image;
import javax.swing.JOptionPane;
import static ventanas.Login.user;

/**
 *
 * @author Lenovo
 */
public class RegistarUser extends javax.swing.JFrame {
    //para recuperar el user que esta logueado
    String user;

    /**
     * Creates new form RegistarUser
     */
    public RegistarUser() {
        initComponents();
        //recuperamos el usuario que viene desde el login
        user=Login.user;
        
        //TAMANP DE PANTALLA
        setSize(630, 350);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        
        //titulo de la intefaz de login
        setTitle("Creacion de usuarios sesion -"+user);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //esto evida que se finalize el programa cuando cierrren esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        
         //AGREAGAMOS LA IMAGEN EN EL JLABEL D EFONDO
        ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoregistraruser.getWidth(),fondoregistraruser.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoregistraruser.setIcon(icono);
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
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nombres4 = new javax.swing.JTextField();
        txt_pas = new javax.swing.JPasswordField();
        btnagregarUsers = new javax.swing.JButton();
        cmb_niveles = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fondoregistraruser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 170, 15));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("telefono");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        txt_username.setBackground(new java.awt.Color(204, 255, 255));
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, 20));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rol:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txt_email.setBackground(new java.awt.Color(204, 255, 255));
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 220, 20));

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(204, 255, 255));
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 210, 20));

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txt_nombres4.setBackground(new java.awt.Color(204, 255, 255));
        txt_nombres4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombres4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 210, 20));

        txt_pas.setBackground(new java.awt.Color(204, 255, 255));
        txt_pas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pasActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 220, -1));

        btnagregarUsers.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\add.png")); // NOI18N
        btnagregarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarUsersActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregarUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "capturista", "tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("username:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desarrollado por: Camilo Agudelo ©");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));
        getContentPane().add(fondoregistraruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 630, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_pasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pasActionPerformed

    private void btnagregarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarUsersActionPerformed
        // TODO add your handling code here:
        
       //obtenemos los datos del formulario
       int permisos_cmb,validacion=0;
       
       String nombre,email,telefono,username,pass,permisos_string;
       
       nombre=txt_nombres4.getText().trim();
       email=txt_email.getText().trim();
       username=txt_username.getText().trim();
       pass=txt_pas.getText().trim();
       telefono=txt_telefono.getText().trim();
       //esto son los select y nos entrega los datos de la lista en numeros y el primero de la lista es 0 luego 1 luego 2 yo le sumo 1 para que admin sea 1 y no cero ya si sucecivamente
       permisos_cmb=cmb_niveles.getSelectedIndex()+1;
       
       //ahora validamos campos para qeu no esten vacios, si esta vacio le ponemos al input un backgound
       if(email.equals("")){
           txt_email.setBackground(Color.red);
           //y esta la ponemos para saber si hay error es muy cheverre aca nos evitamos un array push ya que vamos sumando errores a validacion
           validacion++;
       }
       
        if(username.equals("")){
           txt_username.setBackground(Color.red);
           //y esta la ponemos para saber si hay error es muy cheverre aca nos evitamos un array push ya que vamos sumando errores a validacion
           validacion++;
       }
       if(pass.equals("")){
           txt_pas.setBackground(Color.red);
           //y esta la ponemos para saber si hay error es muy cheverre aca nos evitamos un array push ya que vamos sumando errores a validacion
           validacion++;
       }
       if(nombre.equals("")){
           txt_nombres4.setBackground(Color.red);
           //y esta la ponemos para saber si hay error es muy cheverre aca nos evitamos un array push ya que vamos sumando errores a validacion
           validacion++;
       }
       
       if(telefono.equals("")){
           txt_telefono.setBackground(Color.red);
           //y esta la ponemos para saber si hay error es muy cheverre aca nos evitamos un array push ya que vamos sumando errores a validacion
           validacion++;
       }
       
       
       //ahora asignamos el rol de acuerdo al select que viene de numero
       if(permisos_cmb==1){
           permisos_string="administrador";
       }else if(permisos_cmb==2){
           permisos_string="capturista";
       }else{
          permisos_string="tecnico"; 
       }
       
       //validamos que el usaurio que estan mandando no exista en la db
       try{
                                   //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    PreparedStatement pst = cn.prepareStatement("SELECT username FROM usuarios WHERE username = ?");
                                    pst.setString(1, username);
                                    
                                    // ejecutamos el query
                                    ResultSet rs = pst.executeQuery();
                                    //hay dato es por que existe
                                    if(rs.next()){
                                        txt_username.setBackground(Color.red);
                                        JOptionPane.showMessageDialog(rootPane, "el usuario "+username+" ya se encuentra registardo en nuestro sistema por avor cambia el user");
                                        //cerramos conexion de la db
                                        cn.close();
                                        //si no existe hacemos el registro en la db
                                    }else{
                                                //cerramos la conexion de la consulta anterior para crear un query con conexion nueva
                                                 cn.close();
                                                //esta es la inicial que cada que habia error le poniamos ++ 1 mas si es =0 no hay error y pyede resgistrar user
                                                if(validacion==0){
                                                    
                                                        try{
                                                                   //creamos el objeto de conexion cada que creamos una nueva conexion y cerramos otra se debe cambiar la variable cn eneste caso pusimos cn2 al igual que el pst le pusimos pst2
                                                                   Connection cn2=Conexion.conectar();
                                                                   // validamos si existe el usuario que trata de loguearse
                                                                   PreparedStatement pst2 = cn2.prepareStatement("INSERT INTO usuarios values(?,?,?,?,?,?,?,?,?)");
                                                                   //mandamos los datos pusimos 8 signos ? que son 8 columas de la db a la primera que es id mandamos 0 opara que ya el sistema asigne su auto increment
                                                                    pst2.setInt(1, 0);
                                                                    pst2.setString(2, nombre);
                                                                    pst2.setString(3, email);
                                                                    pst2.setString(4, telefono);
                                                                    pst2.setString(5, username);
                                                                    pst2.setString(6, pass);
                                                                    pst2.setString(7, permisos_string);
                                                                    pst2.setString(8, "activo");
                                                                    pst2.setString(9, user);
                                                                    // ejecutamos el query de insercion
                                                                    pst2.executeUpdate();
                                                                    //cerramos la conexion
                                                                    cn2.close();
                                                                    //llamamos al metodo que creamos de limpiar campos para que pinte un backrong verde y limpie campos
                                                                    limpiarCampos();
                                                                    //en el codigo anterior limpiamos los campos y en este ponemos el backgron den verde en los campos
                                                                    txt_email.setBackground(Color.green);
                                                                    txt_nombres4.setBackground(Color.green);
                                                                    txt_username.setBackground(Color.green);
                                                                    txt_pas.setBackground(Color.green);
                                                                    txt_telefono.setBackground(Color.green);
                                                                    
                                                                    JOptionPane.showMessageDialog(rootPane,"Usuario agregado correctamente");
                                                                    //le decimos que esta interface la cierre para reducisir recursos del pc
                                                                    this.dispose();
                                                        }catch(SQLException e){
                                                               System.err.println("Error todos los campos estan bien para agregar usuario pero entrega error "+e);
                                                               JOptionPane.showMessageDialog(rootPane,"error al crear cliente ");
                                                        }

                                                }else{
                                                    
                                                }
                                           
                                    }
         //capturamos la excepcion sql                               
       }catch(SQLException e){
           
                        System.err.println("Error en el boton crear usuario "+e);
                        JOptionPane.showMessageDialog(rootPane,"error al crear nuevo usaurio contacte al administrador");
       }
       
       
       
    }//GEN-LAST:event_btnagregarUsersActionPerformed

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
            java.util.logging.Logger.getLogger(RegistarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistarUser().setVisible(true);
            }
        });
    }
    
    
    //creamos la funcion que limpiara los campos cuando se registre un susuario exitosamente
    public void limpiarCampos(){
        txt_email.setText("");
        txt_nombres4.setText("");
        txt_username.setText("");
        txt_pas.setText("");
        txt_telefono.setText("");
        //la interface se cierra y al abrirla ya el select sale sempre en admin es lo que debe ser pero si no se cerrara con este codigo vlvemos a poner en el select ela dmin de primero
        //0 equivale administrador 1 capturista 2 tecnico ya que asi estan  en orden en la lista y cada item es como si fuese un array
        cmb_niveles.setSelectedIndex(0);
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarUsers;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JLabel fondoregistraruser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombres4;
    private javax.swing.JPasswordField txt_pas;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
