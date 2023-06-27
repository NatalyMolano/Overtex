/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClienteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;
import util.Crud;

/**
 *
 * @author APRENDIZ
 */
public class ClienteDAO extends ConexionBD implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String idCliente ="",cliNombre = "",cliTelefono = "",Documento = "",cliEstado = "";

    public ClienteDAO() {
    }
    
    
    public ClienteDAO(ClienteVO cliVO){
        super();
        try {
            conexion = this.obtenerConexion();
            idCliente = cliVO.getIdCliente();
            cliNombre = cliVO.getCliNombre();
            cliTelefono = cliVO.getCliTelefono();
            Documento = cliVO.getDocumento();
            cliEstado = cliVO.getCliEstado();
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
          
        
    } 

    @Override
    public boolean agregar() {
        try {
            
            sql = "insert into cliente(CliNombre,CliTelefono,Documento,Estado) values (?,?,?,?) ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, cliNombre);
            puente.setString(2, cliTelefono);
            puente.setString(3, Documento);
            puente.setString(4, cliEstado);
            puente.executeUpdate();
            operacion = true;
           
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                 Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizar() {
        try {

            sql = "UPDATE cliente SET CLINOMBRE = ?, CLITELEFONO = ?, DOCUMENTO = ?, ESTADO = ? WHERE IDCLIENTE = ?;";
            puente = conexion.prepareStatement(sql);         
            puente.setString(1, cliNombre);
            puente.setString(2, cliTelefono);
            puente.setString(3, Documento);
            puente.setString(4, cliEstado);
            puente.setString(5, idCliente);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean borrar() {
        try {

            sql = "DELETE FROM `cliente` WHERE `cliente`.`idcliente` = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idCliente);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    public  ClienteVO consultarPoridCliente(String idcliente){
        ClienteVO cliVO = null;       
        try {
            conexion = this.obtenerConexion();
            
            sql="select * from cliente where idcliente = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idcliente);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
                cliVO = new ClienteVO(idcliente, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                
            }
            
        } catch (Exception e) {
                   Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cliVO;
        
    }
    
    
    
    public ArrayList<ClienteVO>listar(){
        
        ArrayList<ClienteVO> listarCliente = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "select * from cliente where Estado = 1";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ClienteVO cliVO = new ClienteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                listarCliente.add(cliVO);    
            }
            
        } catch (Exception e) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarCliente;
  
    }
    public  ClienteVO consultarPorDocumento(String documento){
        ClienteVO cliVO = null;       
        try {
            conexion = this.obtenerConexion();
            
            sql="select * from cliente where documento = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, documento);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
                cliVO = new ClienteVO( mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                
            }
            
        } catch (Exception e) {
                   Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cliVO;
        
    }
    
   public ArrayList<ClienteVO>listarPorCliente(){
        
        ArrayList<ClienteVO> listarClienteVenta = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT C.CliNombre, C.CliTelefono, C.Documento, COUNT(V.idCliente) AS conteo FROM venta AS V INNER JOIN cliente C ON C.idcliente = V.idCliente inner join detalle_venta as de on de.IdVenta=V.idVenta GROUP BY V.idCliente ORDER BY conteo DESC limit 3;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ClienteVO cliVO = new ClienteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listarClienteVenta.add(cliVO);    
            }
            
        } catch (Exception e) {
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarClienteVenta;
  
    }

    
}
