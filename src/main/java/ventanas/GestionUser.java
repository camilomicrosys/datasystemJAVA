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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static ventanas.Login.user;

/**
 *
 * @author Lenovo
 */
public class GestionUser extends javax.swing.JFrame {
    //creamos variable y la estatica que  son als que puden viajar entre formularios de vistas
     String user;
     //ESTA SERIA PARA PODER MANDAR DATOS ENTRE INTERFACES esta es para mandarla luego cuando clicken en latabla algun usuario se abrira la interface de info de usuario y alla mandamos esta esta la diligenciamos mas abajo cuando obtenemos el nombre de este usuario
     public static String user_update="";
     //creamos el objeto del datatable esto lo que nos va a permitir es modificar datos de la tabla a su interior
     DefaultTableModel model=new DefaultTableModel();

    /**
     * Creates new form GestionUser
     */
    public GestionUser() {
        initComponents();
        //aca decimos que en la user que cree yo en esta clase sea igual a la interface login .user que esta en la case login declarada asi pasamos de alla aca
        user=Login.user;
        //TAMANP DE PANTALLA
        setSize(650,430);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        
        //titulo de la intefaz de login
        setTitle("Panel usuarios registrados sesion de -"+user);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondogestionusuarios.getWidth(),fondogestionusuarios.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondogestionusuarios.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
         //aca hacemos la conexion a la db para sacar todos los usuarios y listarlos en la tabla
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT id,nombre_usuario,username,tipo_nivel,estatus FROM usuarios";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                   //esta es el nombre de la variable que le dimos a la tabla en el fron y la igualamos a un objeto de jtable y le pasamos model que fue la bariable que declaramos al inicio de esta clase
                                    table_usuarios=new JTable(model);
                                    //le indicamos que la table_usuarios es la que va estar dentro del panel de la tabla o sea la interfacesiata d etabla
                                    //ademas esta linea hace un scroll si jay muchos registros en la consulta saca el scroll
                                    jScrollPane1.setViewportView(table_usuarios);
                                    
                                    //colocamos los nombres de las columans de las tablas la primera se deja vacia que es el id esa la llenamos abajo con eñ 1+1
                                    model.addColumn(" ");
                                    model.addColumn("Nombre");
                                    model.addColumn("Usernames");
                                    model.addColumn("Permisos");
                                    model.addColumn("Estatus");
                                    
                                    //validamos que haya datos
                                    while(rs.next()){
                                        //creamos un vector object para mostrar los datos de la tabla ponemos 5 haciendo referencia a las 5 columnas que creamos anteriormente
                                        Object[] fila= new Object[5];
                                        //hacemos un recorrido de las fila las 5 columas por eso hasta que sea menor a 5
                                        for(int i=0;i<5;i++){
                                            //este es el indice ne la tabla
                                            fila[i]=rs.getObject(i+1);
                                            
                                        }
                                        //aca agregariamos a nuestra fila lo que vamos encontrando en el foreach
                                        model.addRow(fila);
                                      
                                    }
                                    //cerramos la conexion
                                    cn.close();
            
        }catch (SQLException e) {
            System.err.println("Error al llenar tabla en gestion de users: " + e.getMessage());
            e.printStackTrace();
            }
         //esto es para obtener los datos del usuario que se clikee en el front de la tabla
            table_usuarios.addMouseListener(new MouseAdapter(){
                  @Override  
                  public void mouseClicked(MouseEvent e){
                //obtenemos cual es la fila que se clikeo
                      int fila_point=table_usuarios.rowAtPoint(e.getPoint());
                      //ponemos 2 quemado ya que trabajaremos con la columna de nombre nosotros cuando clicken cogemos e nombre
                      int columna_point=2;
                       //no pueden haber negativos y la primera es cero ya que son array
                            if(fila_point>-1){
                                user_update=(String)model.getValueAt(fila_point, columna_point);
                                //creamos el objeto de la otra interfce donde veremos la info de este usuario
                                InformacionUsuario informacion_usaurio= new InformacionUsuario();
                                // y abrimos esa nueva interface
                                informacion_usaurio.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuarios = new javax.swing.JTable();
        fondogestionusuarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Usuarios registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 30));

        jLabel2.setText("Desarrollado por: Camilo Agudelo ©");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 290, -1));

        table_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 630, 180));
        getContentPane().add(fondogestionusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

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
            java.util.logging.Logger.getLogger(GestionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondogestionusuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_usuarios;
    // End of variables declaration//GEN-END:variables
}
