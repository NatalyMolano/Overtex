/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.VentaModificacionesVO;
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
public class VentaModificacionesDAO extends ConexionBD {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String idVenta = "", new_PrecioUnidad = "", new_Cantidad = "", new_VenFecha = "", IdProductos = "";

    public VentaModificacionesDAO() {
    }

    public VentaModificacionesDAO(VentaModificacionesVO vmVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idVenta = vmVO.getIdVenta();
            new_PrecioUnidad = vmVO.getNew_PrecioUnidad();
            new_Cantidad = vmVO.getNew_Cantidad();
            new_VenFecha = vmVO.getNew_VenFecha();
            IdProductos = vmVO.getIdProductos();

        } catch (Exception e) {
            Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public VentaModificacionesVO consultarPorMes(String new_VenFecha) {

        VentaModificacionesVO vmVO = null;
        try {
            conexion = this.obtenerConexion();

            sql = "select idVenta,new_PrecioUnidad,new_Cantidad,new_VenFecha,IdProductos from venta_modificaciones where month(new_VenFecha)=?;";
            puente = conexion.prepareStatement(sql);

            puente.setString(1, new_VenFecha);

            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                vmVO = new VentaModificacionesVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), new_VenFecha, mensajero.getString(5));

            }

        } catch (Exception e) {
            Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                 this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return vmVO;

    }

    public ArrayList<VentaModificacionesVO> listarm(String new_VenFecha) {

        ArrayList<VentaModificacionesVO> listarMes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select idVenta,new_PrecioUnidad,new_Cantidad,new_VenFecha,IdProductos from venta_modificaciones where month (new_VenFecha)=03";
            //puente.setString(1, new_VenFecha); 
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaModificacionesVO vmVO = new VentaModificacionesVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                listarMes.add(vmVO);
            }

        } catch (Exception e) {
            Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarMes;

    }

    public VentaModificacionesVO consultarPoridVendedor(String Mes, String id) {
        VentaModificacionesVO venVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select sum(new_Cantidad),sum(new_Cantidad)*2000,month(new_VenFecha),idVendedor from modificaciones_venta where idVendedor = ? and month(new_VenFecha) = ?;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, id);
            puente.setString(2, Mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                venVO = new VentaModificacionesVO(mensajero.getString(1), mensajero.getString(2), Mes, id);/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return venVO;
    }

}
