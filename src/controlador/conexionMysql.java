package controlador;

import java.sql.Connection;     // exportaciones
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Velasquez
 */
public class conexionMysql {
    
   private Connection conectar = null;  // clase creada de topo privada
    
   //public conexionMysql(){} // manual
   
   
    public void iniciarConexion(){ // metodo para iniciar LA CONEXION 

        try{

          Class.forName("com.mysql.jdbc.Driver"); // inicializar el dirver
          conectar=DriverManager.getConnection("jdbc:mysql://localhost/dimolo8","root",""); // ruta con la base de datos
          //JOptionPane.showMessageDialog(null, "CONEXION OK"); // mensaje//
         }
    catch(Exception e){
    
     e.printStackTrace();
     JOptionPane.showMessageDialog(null,"Error en la conexion a BD"); // mensaje

     }
    
     
    }  
    public Connection getMyConnection(){ // metodo que retorna la variable creada
    return conectar;
    
    }
    public void Close(ResultSet rs){ // metodo que retorna un resultado 
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void Close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
      public void Cerrar(){
  
    if(conectar !=null){
    
         try{
               conectar.close();
            }
            catch(Exception e){}
        
        
    }
  }

    public Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
// nota para que no marque error se debe hacer la instalacion del driver en librerias
// add jar foldr
// buscar el archivo
// mysql conecta-java dar
// escojer el que bin // clic sobre el archivo y abrir