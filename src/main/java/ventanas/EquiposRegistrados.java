/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
//para la tabla
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//obtenemos el nombre del usuario logueado
import static ventanas.Login.user;
/**
 *
 * @author Lenovo
 */
public class EquiposRegistrados extends javax.swing.JFrame {
   String user_logueado;
   //creamos la variable estatica que viajara a la nueva interface cuando clikeen algun equipo de la tabla
   public static int idEquipo_update;
      //creamos el objeto del datatable esto lo que nos va a permitir es modificar datos de la tabla a su interior para los quipos del usuario
     DefaultTableModel model=new DefaultTableModel();
    /**
     * Creates new form EquiposRegistrados
     */
    public EquiposRegistrados() {
        initComponents();
         user_logueado=Login.user;
      
         //titulo de la intefaz de login
        setTitle("Panel equipos registrados user logueado: "+user_logueado);
        //centrar la interface en la pantalla
        setLocationRelativeTo(null);
           //TAMANP DE PANTALLA
        setSize(586, 420);
        //ponemos el fondo a la pantalla
         ImageIcon wallpaper= new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\datasystem\\src\\main\\java\\imagenes\\wallpaperPrincipal.jpg");
        //ACA LE DECIMOS QUE jLabel_walpaper ESE NOMBRE DE VARIABLE QUE FUE LA QUE PUSIMOS EN EL FORMULARIO AL LABEL PARA EL FONO QUE COJA EL LARGO Y ANCHO Y LO ACOPLE A ESTA IMAGEN O QUE LA IMAGEN SE ACOMODE A ESAS MEDIDAS QUE NO SE VEA MAS GRANDE O AMS FEA SINO ACOMODADA
        Icon icono= new ImageIcon(wallpaper.getImage().getScaledInstance(fondoequiposregistrados.getWidth(),fondoequiposregistrados.getHeight(),Image.SCALE_DEFAULT));
       //AHORA LE DECIMOS QUE A ESE LABEL LE PONGA LA CONFIGURACION QUE HICIMOS EN LA LINEA ANTERIOR
        fondoequiposregistrados.setIcon(icono);
        //esta se pone para que aplique los cambios
        this.repaint();
   
          //matamos proceso cuando se loguean destruimos la ejecucion de login para que solo siga esta ventana actual funcionando y ya no se ejecutaria en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //evitamos que finalice el programa al cerrar esta ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //ejecutamos el query para mostrar los datos en la tabla inicialmente muestra todos
           try{
                                 //creamos el objeto de conexion 
                                   Connection cn=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                    String sql = "SELECT id,tipo_equipo,marca,estatus FROM equipos";
                                    
                                    PreparedStatement pst = cn.prepareStatement(sql);
                                       
                                   //obtenemos los datos del query
                                   ResultSet rs = pst.executeQuery();
                                     //esta es el nombre de variable que le asignamos a la tabla graficamente en el deign
                                      tableequipostodos= new JTable(model);
                                      //le indicamos que la table_usuarios es la que va estar dentro del panel de la tabla o sea la interfacesiata d etabla
                                    //ademas esta linea hace un scroll si jay muchos registros en la consulta saca el scroll
                                    jScrollPane1.setViewportView(tableequipostodos);
                                   
                                    //colocamos los nombres de las columans de las tablas la primera se deja vacia que es el id esa la llenamos abajo con eñ 1+1
                                    model.addColumn(" ");
                                    model.addColumn("tipo_equipo");
                                    model.addColumn("marca");
                                    model.addColumn("estatus");
                                      //validamos que haya datos
                                    while(rs.next()){
                                        //creamos un vector object para mostrar los datos de la tabla ponemos 5 haciendo referencia a las 6 columnas que creamos anteriormente
                                        Object[] fila= new Object[4];
                                        //hacemos un recorrido de las fila las 5 columas por eso hasta que sea menor a 5
                                        for(int i=0;i<4;i++){
                                            //este es el indice ne la tabla
                                            fila[i]=rs.getObject(i+1);
                                            
                                        }
                                        //aca agregariamos a nuestra fila lo que vamos encontrando en el foreach
                                        model.addRow(fila);
                                       System.err.println("entraste por aca ");
                                      
                                    }
                                    
                                       
                                   
                                  //cerramos la conexion
                                   cn.close();
            
        }catch (SQLException e) {
            System.err.println("error al cosultar interface informacion cliente: " + e.getMessage());
            e.printStackTrace();
        }
           
            //ahora obtenemos el id del equipo que se clickee cuando den clic en alguna fila de la tabla de los equipos
          //esto es para obtener los datos del usuario que se clikee en el front de la tabla
            tableequipostodos.addMouseListener(new MouseAdapter(){
                  @Override  
                  public void mouseClicked(MouseEvent e){
                //obtenemos cual es la fila que se clikeo
                      int fila_point=tableequipostodos.rowAtPoint(e.getPoint());
                      //ponemos 0 quemado ya que trabajaremos con la columna de id en la tabla pintada, por ejemplo en la vista gestioanr users 
                      //podemos ir a esa visat y vemos este mismo codigo alla quemaban 2 ya que la tabla visual en la columna 2 era el nombre del cliente y liego trabajabamos el query ent la otra vista con ese nombre de usuario
                      //pero en este mandamos el id statico a la otra interface
                      int columna_point=0;
                       //no pueden haber negativos y la primera es cero ya que son array
                            if(fila_point>-1){
                                //aca obtenemos el id real que se clikeo
                                //esta seria la variable estatica que viajaria a la otra vista
                                idEquipo_update=(int)model.getValueAt(fila_point, columna_point);
                               JOptionPane.showMessageDialog(rootPane, idEquipo_update);
                                 //abrimos la interface de informacion del Equipo
                                 
                                 /*
                                            InformacionEquipo infoequipo= new  InformacionEquipo();
                                           //mostramos la interface
                                           infoequipo.setVisible(true);
                                
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableequipostodos = new javax.swing.JTable();
        opcionselectequiposregistrados = new javax.swing.JComboBox<>();
        btnmostrar = new javax.swing.JButton();
        fondoequiposregistrados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 220, 30));

        tableequipostodos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableequipostodos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 480, 180));

        opcionselectequiposregistrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(opcionselectequiposregistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        btnmostrar.setText("Mostrar");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 110, -1));
        getContentPane().add(fondoequiposregistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 586, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        //obtenemos el tipo de consulta seleccionada en el select
         String consulta=opcionselectequiposregistrados.getSelectedItem().toString();
         //toca crear una vairble query esto por que si es algun tipo de opcion lleva where estatus=x pero si es todos no lleva status where  entonces la validamos con un if
         String query="";
         if(consulta.equals("Todos")){
             query="SELECT id,tipo_equipo,marca,estatus FROM equipos";
         }else{
             query="SELECT id,tipo_equipo,marca,estatus FROM equipos WHERE estatus=?";
         }
        
         //limpiamos las filas y las columnas que nos aparecian inicialmente , por que si no limpiamos el acumula lo que esta mas lo del filtro con estas 2 lineas deja en 0 filas y columans
         model.setRowCount(0);
         model.setColumnCount(0);
         
         //ejecutamos la consulta y montamos los datos en la tabla
          //ejecutamos el query para mostrar los datos en la tabla inicialmente muestra todos
           try{
                                 //creamos el objeto de conexion 
                                   Connection cn2=Conexion.conectar();
                                  // validamos si existe el usuario que trata de loguearse
                                     String sql2 = query;
                                    
                                    PreparedStatement pst2 = cn2.prepareStatement(sql2);
                                    //este va de la mano con el if del query de arribita si es todos no pasamos parametro aca y si no es todos pasamos el parametro de conulta
                                    if(consulta.equals("Todos")){
                                        
                                    }else{
                                      pst2.setString(1, consulta)  ;  
                                    }
                                    
                                   //obtenemos los datos del query
                                   ResultSet rs2 = pst2.executeQuery();
                                     //esta es el nombre de variable que le asignamos a la tabla graficamente en el deign
                                      tableequipostodos= new JTable(model);
                                      //le indicamos que la table_usuarios es la que va estar dentro del panel de la tabla o sea la interfacesiata d etabla
                                    //ademas esta linea hace un scroll si jay muchos registros en la consulta saca el scroll
                                    jScrollPane1.setViewportView(tableequipostodos);
                                   
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
            tableequipostodos.addMouseListener(new MouseAdapter(){
                  @Override  
                  public void mouseClicked(MouseEvent e){
                //obtenemos cual es la fila que se clikeo
                      int fila_point=tableequipostodos.rowAtPoint(e.getPoint());
                      //ponemos 0 quemado ya que trabajaremos con la columna de id en la tabla pintada, por ejemplo en la vista gestioanr users 
                      //podemos ir a esa visat y vemos este mismo codigo alla quemaban 2 ya que la tabla visual en la columna 2 era el nombre del cliente y liego trabajabamos el query ent la otra vista con ese nombre de usuario
                      //pero en este mandamos el id statico a la otra interface
                      int columna_point=0;
                       //no pueden haber negativos y la primera es cero ya que son array
                            if(fila_point>-1){
                                //aca obtenemos el id real que se clikeo
                                //esta seria la variable estatica que viajaria a la otra vista
                                idEquipo_update=(int)model.getValueAt(fila_point, columna_point);
                               JOptionPane.showMessageDialog(rootPane, idEquipo_update);
                                 //abrimos la interface de informacion del Equipo
                                 
                                 /*
                                            InformacionEquipo infoequipo= new  InformacionEquipo();
                                           //mostramos la interface
                                           infoequipo.setVisible(true);
                                
                                */
                                
                                
                                
                               
                                
                            }

                    }
          });
         
         
         
    }//GEN-LAST:event_btnmostrarActionPerformed

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
            java.util.logging.Logger.getLogger(EquiposRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquiposRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquiposRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquiposRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquiposRegistrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmostrar;
    private javax.swing.JLabel fondoequiposregistrados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> opcionselectequiposregistrados;
    private javax.swing.JTable tableequipostodos;
    // End of variables declaration//GEN-END:variables
}
