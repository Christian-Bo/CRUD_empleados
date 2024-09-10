/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class empleados extends Persona {
    private String codigo;
    private int puesto;
    private int id;
    Conexion cn;
    public empleados(){};
    public empleados(int id, String codigo, int puesto,String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo = codigo;
        this.puesto = puesto;
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
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
            query = "SELECT e.id_empleado as id, e.codigo, e.nombres, e.apellidos, e.direccion, e.telefono, e.fecha_nacimiento, p.puesto FROM empleados e LEFT JOIN puestos p ON e.id_puesto = p.id_puesto;";
            ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
            
            String encabezado[] = {"id","Codigo","Nombres","Apellidos","Direccion","Telefono","Nacimiento", "puesto"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos[]=new String[8];
          
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("codigo");
                datos[2] = consulta.getString("nombres");
                datos[3] = consulta.getString("apellidos");
                datos[4] = consulta.getString("direccion");
                datos[5] = consulta.getString("telefono");
                datos[6] = consulta.getString("fecha_nacimiento");
                datos[7] = consulta.getString("puesto");
                                
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
           String query = "INSERT INTO empleados(`codigo`,`id_puesto`,`nombres`,`apellidos`,`direccion`,`telefono`,`fecha_nacimiento`) VALUES(?,?,?,?,?,?,?);";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setInt(2, getPuesto());
            parametro.setString(3, getNombres());
            parametro.setString(4, getApellidos());
            parametro.setString(5, getDireccion());
            parametro.setString(6, getTelefono());
            parametro.setString(7, getFecha_nacimiento());
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
           String query = "UPDATE `empleados` SET `codigo` = ?,`id_puesto` = ?,`nombres` = ?,`apellidos` = ?,`direccion` = ?,`telefono` = ?,`fecha_nacimiento` = ? WHERE `id_empleado` = ?;";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
           parametro.setString(1, getCodigo());
           parametro.setInt(2, getPuesto());
           parametro.setString(3, getNombres());
           parametro.setString(4, getApellidos());
           parametro.setString(5, getDireccion());
           parametro.setString(6, getTelefono());
           parametro.setString(7, getFecha_nacimiento());
           parametro.setInt(8, getId());
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
           String query = "Delete FROM empleados WHERE `id_empleado` = ?;";
           parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
           parametro.setInt(1, getId());
           int executer = parametro.executeUpdate();
           System.out.println("Eliminación exitosa");
           cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }
    }
    
    public DefaultComboBoxModel leer_puesto(){
    DefaultComboBoxModel  combo = new DefaultComboBoxModel ();
    try{
       cn = new Conexion ();
       cn.abrir_conexion();
       String query;
       query = "SELECT id_puesto as id,puesto from puestos";
       ResultSet consulta =  cn.conexionDB.createStatement().executeQuery(query);
       combo.addElement("0) Elija Puesto");
                  while (consulta.next())
                    {            
                      combo.addElement(consulta.getString("id")+") "+consulta.getString("puesto"));
                    }
              cn.cerrar_conexion();
              
       
    }catch(SQLException ex){
        System.out.println("Error: " + ex.getMessage() );
    }
    return combo;
    }
}
