/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

//importamos la variable de sesion que viene por login
import clases.Conexion;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import static ventanas.Login.user;
 //importamos el nombre del usuario logueado que es quien va a registarar este cliente y viene desde la vista capturista
import static ventanas.Capturista.nombre_usuario_logueado;

/**
 *
 * @author Lenovo
 */
public class GestinarClientes extends javax.swing.JFrame {

    //usuario de variable statica de login
    String user;
    //nombre del suaurio logueado que viene de variable estatica de capturista
    String user_logueado;
    //creamos una variable estatica de Id la cual viajara a otra interface cuando se de en la tabla para editar ese cliente
    public static int cliente_update;
   
     //creamos el objeto del datatable esto lo que nos va a permitir es modificar datos de la tabla a su interior
     DefaultTableModel model=new DefaultTableModel();
    
    /**
     * Creates new form GestinarClientes
     */
    public GestinarClientes() {
        initComponents();
        
         //aca recuperamos los datos de la ventana login  en los constructores es que podemos trabajar con ellos
        //aca decimos que en la user que cree yo en esta clase sea igual a la interface login .user que esta en la case login declarada asi pasamos de alla aca
        user=Login.user;
        user_logueado=Capturista.nombre_usuario_logueado;
        
        //TAMANP DE PANTALLA
        setSize(630, 330);
        //NO PUEDA CAMBIARLAS
        setResizable(false);
        
        //titulo de la intefaz de login
        setTitle("Panel Adminitrador sesion de -"+user);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
        
        //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         //esto evita que se finalize el programa cuando cierrren esta ventana de registro de clientes
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondogestionarclientes.getWidth(),fondogestionarclientes.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondogestionarclientes.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
        
         //aca hacemos la conexion a la db para sacar todos los clientes y listarlos en la tabla
        try{
              //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT id,nombre_cliente,email_cliente,tel_cliente,dir_cliente,ultima_modificacion FROM clientes";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                   //esta es el nombre de la variable que le dimos a la tabla en el fron y la igualamos a un objeto de jtable y le pasamos model que fue la bariable que declaramos al inicio de esta clase
                                    table_clientes=new JTable(model);
                                    //le indicamos que la table_usuarios es la que va estar dentro del panel de la tabla o sea la interfacesiata d etabla
                                    //ademas esta linea hace un scroll si jay muchos registros en la consulta saca el scroll
                                    jScrollPane1.setViewportView(table_clientes);
                                    
                                    //colocamos los nombres de las columans de las tablas la primera se deja vacia que es el id esa la llenamos abajo con eñ 1+1
                                    model.addColumn(" ");
                                    model.addColumn("nombre_cliente");
                                    model.addColumn("email_cliente");
                                    model.addColumn("tel_cliente");
                                    model.addColumn("dir_cliente");
                                    model.addColumn("ultima_modificacion");
                                    
                                    //validamos que haya datos
                                    while(rs.next()){
                                        //creamos un vector object para mostrar los datos de la tabla ponemos 5 haciendo referencia a las 6 columnas que creamos anteriormente
                                        Object[] fila= new Object[6];
                                        //hacemos un recorrido de las fila las 5 columas por eso hasta que sea menor a 5
                                        for(int i=0;i<6;i++){
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
            table_clientes.addMouseListener(new MouseAdapter(){
                  @Override  
                  public void mouseClicked(MouseEvent e){
                //obtenemos cual es la fila que se clikeo
                      int fila_point=table_clientes.rowAtPoint(e.getPoint());
                      //ponemos 0 quemado ya que trabajaremos con la columna de id en la tabla pintada, por ejemplo en la vista gestioanr users 
                      //podemos ir a esa visat y vemos este mismo codigo alla quemaban 2 ya que la tabla visual en la columna 2 era el nombre del cliente y liego trabajabamos el query ent la otra vista con ese nombre de usuario
                      //pero en este mandamos el id statico a la otra interface
                      int columna_point=0;
                       //no pueden haber negativos y la primera es cero ya que son array
                            if(fila_point>-1){
                                cliente_update=(int)model.getValueAt(fila_point, columna_point);
                                //imprimir para ver que cuando se de click en la tabla si muestre el id que se esta clikeando
                                //JOptionPane.showMessageDialog(null, cliente_update);
                                
                                
                                //creamos el objeto de la otra interfce donde veremos la info de este usuario
                                InformacionCliente informacion_clientes= new InformacionCliente();
                                // y abrimos esa nueva interface
                                informacion_clientes.setVisible(true);
                                
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        fondogestionarclientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Clientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 30));

        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 630, 180));

        jLabel2.setText("Desarrollado por: Camilo Agudelo ©");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 290, -1));
        getContentPane().add(fondogestionarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

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
            java.util.logging.Logger.getLogger(GestinarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestinarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestinarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestinarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestinarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondogestionarclientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_clientes;
    // End of variables declaration//GEN-END:variables
}
