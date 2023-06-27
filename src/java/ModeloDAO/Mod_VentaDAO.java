/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.Mod_VentaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;

/**
 *
 * @author chiri
 */
public class Mod_VentaDAO extends ConexionBD {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String idVenta = "",new_PrecioUnidad = "",old_PrecioUnidad = "",new_Cantidad = "",old_Cantidad = "",new_VenFecha = "",old_VenFecha = "",idVendedor = "",idCliente = "",Estado = "",IdProductos = "",operacionv = "";

    public Mod_VentaDAO() {
    }

    public Mod_VentaDAO(Mod_VentaVO modvenVO){
        super();
        try {
            conexion = this.obtenerConexion();
            idVenta = modvenVO.getIdVenta();
            new_PrecioUnidad = modvenVO.getNew_PrecioUnidad();
            old_PrecioUnidad = modvenVO.getOld_PrecioUnidad();
            new_Cantidad = modvenVO.getNew_Cantidad();
            old_Cantidad = modvenVO.getOld_Cantidad();
            new_VenFecha = modvenVO.getNew_VenFecha();
            old_VenFecha = modvenVO.getOld_VenFecha();
            idVendedor = modvenVO.getIdVendedor();
            idCliente = modvenVO.getIdCliente();
            Estado = modvenVO.getEstado();
            IdProductos = modvenVO.getIdProductos();
            operacionv = modvenVO.getOperacionv();
        } catch (Exception e) {
             Logger.getLogger(Mod_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
    }
    public  Mod_VentaVO consultar(String idVenta){
        
        Mod_VentaVO modvenVO = null;       
        try {
            conexion = this.obtenerConexion();
            
            sql="select * from venta_modificaciones where idVenta = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idVenta);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
                modvenVO = new Mod_VentaVO(idVenta, new_PrecioUnidad, old_PrecioUnidad, new_Cantidad, old_Cantidad, new_VenFecha, old_VenFecha, idVendedor, idCliente, Estado, IdProductos, operacionv);
                
            }
            
        } catch (Exception e) {
                   Logger.getLogger(Mod_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(Mod_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return modvenVO;
        
    }
    public ArrayList<Mod_VentaVO>listar(){
        
        ArrayList<Mod_VentaVO> listarModVen = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "select * from venta_modificaciones;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                Mod_VentaVO modvenVO = new Mod_VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12));
                listarModVen.add(modvenVO);    
            }
            
        } catch (Exception e) {
             Logger.getLogger(Mod_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(Mod_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarModVen;
  
    }
    
}
