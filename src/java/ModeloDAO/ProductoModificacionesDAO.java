/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
import ModeloVO.ProductosModificacionesVO;
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
public class ProductoModificacionesDAO extends ConexionBD {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String id_modificacion_producto = "",
            ProNombre = "",
            Antiguo_PrecioUnidad = "",
            Modificado_PrecioUnidad = "",
            Antiguo_ProStock = "",
            Modificado_ProStock = "",
            Accion = "",
            modificacion_fecha = "";
    

    public ProductoModificacionesDAO() {
    }

    public ProductoModificacionesDAO(ProductosModificacionesVO proMVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_modificacion_producto =  proMVO.getId_modificacion_producto();
            ProNombre =  proMVO.getProNombre();
            Antiguo_PrecioUnidad =  proMVO.getAntiguo_PrecioUnidad();
            Modificado_PrecioUnidad =  proMVO.getModificado_PrecioUnidad();
            Antiguo_ProStock =  proMVO.getAntiguo_ProStock();
            Modificado_ProStock =  proMVO.getModificado_ProStock();
            Accion =  proMVO.getAccion();
            modificacion_fecha =  proMVO.getModificacion_fecha();
            

        } catch (Exception e) {
            Logger.getLogger(ProductoModificacionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

   
    public ArrayList<ProductosModificacionesVO> listar() {
        ArrayList<ProductosModificacionesVO> ListarProductos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM modificaciones_producto;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductosModificacionesVO proVO = new ProductosModificacionesVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6)
                ,mensajero.getString(7),mensajero.getString(8));
                ListarProductos.add(proVO);
            }
        } catch (Exception e) {
            Logger.getLogger(ProductosModificacionesVO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductosModificacionesVO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return  ListarProductos;
    }
   

}
