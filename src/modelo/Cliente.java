/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian
 */
/*
public class Cliente extends Persona{
    private String nit;
    private int id;
    Conexion cn;
    public Cliente(){};

    public Cliente(int id, String nit,String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.nit = nit;
    }

    

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn= new Conexion();
            cn.abrir_conexion();
            String query;
            query = "Select id_cliente as id,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento from clientes;";
            ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
            
            String encabezado[] = {"id","Nit","Nombres","Apellidos","Direccion","Telefono","Nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos[]=new String[7];
            
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nit");
                datos[2] = consulta.getString("nombres");
                datos[3] = consulta.getString("apellidos");
                datos[4] = consulta.getString("direccion");
                datos[5] = consulta.getString("telefono");
                datos[6] = consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return tabla;
    }
    
    
    @Override
    public void agregar() {
        try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "INSERT INTO clientes(`nit`,`nombres`,`apellidos`,`direccion`,`telefono`,`fecha_nacimiento`) VALUES(?,?,?,?,?,?);";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
           parametro.setString(1, getNit());
           parametro.setString(2, getNombres());
           parametro.setString(3, getApellidos());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getFecha_nacimiento());
           int executer = parametro.executeUpdate();
           System.out.println("Inserto exitoso");
           cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }
    }
   
    public void actualizar(){
        try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "UPDATE `db_empresa2`.`clientes` SET `nit` = ?,`nombres` = ?,`apellidos` = ?,`direccion` = ?,`telefono` = ?,`fecha_nacimiento` = ? WHERE `id_cliente` = ?;";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
           parametro.setString(1, getNit());
           parametro.setString(2, getNombres());
           parametro.setString(3, getApellidos());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getFecha_nacimiento());
           parametro.setInt(7, getId());
           int executer = parametro.executeUpdate();
           System.out.println("Modificación exitosa");
           cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }

    }
    
    public void borrar(){
        try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "Delete FROM clientes WHERE `id_cliente` = ?;";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
           parametro.setInt(1, getId());
           int executer = parametro.executeUpdate();
           System.out.println("Eliminación exitosa");
           cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }
    }
 
}
*/