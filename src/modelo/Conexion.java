/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Christian
 */
public class Conexion {
    /*
        Nombre del servidor = localhost;
        puerto = 3306
        usuario = root
        contraseña = 123456
        driver conexion = com.mysql.cj.jdbc.Driver
        url de conexion (cadena de conexion : 
        tipo conector(jdbc), nombre del servidor,
        puerto, base de datos
    */
    
    private final String puerto = "3306";
    private final String db = "db_empresa2";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puerto, db);
    private final String usuario = "root";
    private final String contra = "123456";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public Connection conexionDB;
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionDB = DriverManager.getConnection(urlConexion,usuario,contra);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }
        
    }
    
    public void cerrar_conexion(){
        try{
            conexionDB.close();
        }catch(SQLException ex){
            System.out.println("algo Salio mal" + ex.getMessage());
        }
    }
    
    
}
