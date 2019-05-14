/*
 * BaseDao.java
 *
 * Created on 29 de abril de 2009, 05:31 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.cpxall.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Angelical
 */
public class ConexionOracle {
    private Connection conexion; /// Abtrae una conexion a la base de datos
     private String usuario = "root"; // usuario con permisos para conectarse a BD
    private String password = "root"; // contrasena del usuario que se puede conectar
    private String driver = "org.hibernate.dialect.MySQL5InnoDBDialect"; // Clase del Driver de jConnector
    private String beseDatos="jdbc:mysql://localhost:3306/test";
    private static ConexionOracle instancia;
    /** Creates a new instance of BaseDao
     * @return  ConexionOracle*/
    public static ConexionOracle getInstancia (){
    if(ConexionOracle.instancia==null){
    ConexionOracle.instancia=new ConexionOracle();
    }
    return instancia;
    }
    public static void main(String arg[])throws Exception{
    
    ConexionOracle.getInstancia().conectar();
    } 
    public void conectar()throws Exception {
        if(this.getConexion()!=null){
            return;
        }
        else if(this.getConexion() == null){ 
  
  
            try {
                Class.forName(this.getDriver()) ; // obtine una istancia de la clase Diver
// establece la conexion con el Diver jconector y este a su vez con la base de datos
                this.setConexion(DriverManager.getConnection(this.getBeseDatos(), this.getUsuario(), this.getPassword()));
                  
            } catch (SQLException ex) {
              throw new Exception("ERROR AL CONECTARCE CON LA BASE DE DATOS");
            } catch (ClassNotFoundException ex) {
                 throw new Exception("ERROR EL DRIVER NO HA SIDO INSTALADO");
            }
  }
  
    
    }
    public void desconectar()throws Exception{
    if(this.conexion!=null){
        this.setConexion(null);
        
    }
    }
    
    public ConexionOracle() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getBeseDatos() {
        return beseDatos;
    }

    public void setBeseDatos(String beseDatos) {
        this.beseDatos = beseDatos;
    }
    
}
