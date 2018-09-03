package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Velasquez
 */
public class conexionConsultas {
    Connection conectar;
  public conexionConsultas (){
   try{
        
        Class.forName("com.mysql.jdbc.Driver");
        conectar=DriverManager.getConnection("jdbc:mysql://localhost/dimolo8","root", ""); // importar
        
      
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
   public void IniciarConexion(){
    
      
    }
  
   public Connection getMyConnection(){
        return conectar;
    }
   
   public void Close(ResultSet rs){ // importar
        
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
    
    
    public void Cerrar(){ // nombre de la variable creada en la clase de conexion
  
    if(conectar !=null){
    
         try{
               conectar.close();
            }
            catch(Exception e){}
        
        
    }
  }
  
} 
    
    
    
    
    
    

