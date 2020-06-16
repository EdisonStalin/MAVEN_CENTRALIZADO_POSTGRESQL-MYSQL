/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemacentralizadomaven;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edison.jumbo
 */
public class Test {
    
    public static void main(String[] args) {
       Test t = new Test();
        //t.insertar();
        //t.actualizar(3,"PERA", 15.33);
        //t.eliminar(3);
    }
    
    
    
    
    public Connection getConexion(){
        Connection conexion = null;
        String servidor = "localhost";
        String puerto = "5432";
        String baseDatos = "supermercado";
        String url = "jdbc:postgresql://"+ servidor +":"+ puerto +"/"+ baseDatos;
        String usuario ="postgres";
        String clave = "1234";
        try {
            conexion = DriverManager.getConnection(url,usuario,clave);
            
        } catch (SQLException eX) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,eX);
        }
        
        return conexion;
        
    }
    
    public void insertar(){
        Connection conexion = getConexion();
        String sql ="INSERT INTO producto (codigo, nombre, precio) VALUES (3,'ACEITE',12.56)";
        
        try (Statement st = conexion.createStatement()){
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizar(int codigo, String nombre, double precio){
        Connection conexion = getConexion();
        String sql = "UPDATE producto SET "+"nombre='" + nombre + "'" + ",precio=" + precio + "WHERE codigo=" + codigo;
        
        try (Statement st = conexion.createStatement()){
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(int codigo){
        Connection conexion = getConexion();
        String sql ="DELETE FROM producto WHERE codigo = "+codigo;
        
        try (Statement st = conexion.createStatement()){
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
