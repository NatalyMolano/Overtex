/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CompraVO;
import ModeloVO.detalle_CompraVO;
import ModeloVO.detalle_VentaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexionBD;

/**
 *
 * @author natal
 */
public class detalle_VentaDAO extends ConexionBD {

     private String id_DetalleVenta="",IdVenta="",IdProducto="",NomProducto="", cantidad="",PrecioUnitario="",subtotal="";

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;

    public detalle_VentaDAO() {
    }

    //2.metodos principal le paso los datos de VO
    public detalle_VentaDAO(detalle_VentaVO VenVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            id_DetalleVenta = VenVO.getId_DetalleVenta();
            IdVenta = VenVO.getIdVenta();
            IdProducto = VenVO.getIdProducto();
            cantidad = VenVO.getCantidad();
            PrecioUnitario = VenVO.getPrecioUnitario();
            subtotal = VenVO.getSubtotal();
            NomProducto = VenVO.getNomProducto();

        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //llamar un metodo abstracto

    }

    public ArrayList<detalle_VentaVO> listarDetalleVenta(String IdVenta) {
        ArrayList<detalle_VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "select d.idDetalleVenta,d.IdProducto,P.ProNombre, d.cantidad,d.PrecioUnidad, d.cantidad * d.PrecioUnidad as subtotal "
                    + "from detalle_venta as d inner join productos as P on P.idProductos= d.IdProducto "
                    + "where idVenta=? order by idDetalleVenta asc ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdVenta);

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                detalle_VentaVO deVentaVO = new detalle_VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5),mensajero.getString(6));
                listarVentas.add(deVentaVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;

    }

    public boolean borrarDetalleVenta() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "DELETE FROM `overtex`.`detalle_venta` WHERE `idDetalleVenta` = ? ;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, id_DetalleVenta);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(detalle_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(detalle_VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
}
