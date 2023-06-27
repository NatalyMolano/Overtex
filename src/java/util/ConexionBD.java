/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author APRENDIZ
 */
public class ConexionBD {
        //1.declarar variables y/o objetos
    private String driver, user, password, urlBd, port, nameDB;
    private Connection conexion;

     public ConexionBD() {
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        nameDB = "overtex";
        port = "3306";
        urlBd = "jdbc:mysql://localhost:" + port + "/" + nameDB;

        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error al conectar" + e.toString());
        }
    }
    public Connection obtenerConexion(){
     return conexion;
    }
    public Connection cerrarConextion()throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args) {
        new ConexionBD();
    }
    
}
