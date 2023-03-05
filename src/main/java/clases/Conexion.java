/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class Conexion {
    
    public static Connection conectar(){
                try{

                   //conexion a base de datos
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/stsitemaernesto","root","");
                   return cn;
                 }catch(Exception e){
                    System.err.println("ha ocurrido un error en la conexion local"+e.getMessage());
                }
        
         return(null);
    }
    
}
