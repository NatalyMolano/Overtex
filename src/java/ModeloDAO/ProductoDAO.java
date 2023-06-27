/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.ProductoVO;
import util.ConexionBD;
import util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gajop
 */
public class ProductoDAO extends ConexionBD implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String proNombre;
    private String idProductos,proStock,Estado;
    private String  precioUnidad;
    private String UnidadesVendidas;
    private String IdCompra;

    public ProductoDAO() {
    }
    
    public ProductoDAO(ProductoVO proVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idProductos = proVO.getIdProductos();
            proNombre = proVO.getProNombre();
            proStock = proVO.getProStock();
            Estado = proVO.getEstado();
            precioUnidad = proVO.getPrecioUnidad();
           
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregar() {
        try {

            sql = "insert into productos(ProNombre,ProStock,PrecioUnidad,Estado) values(?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, proNombre);
            puente.setString(2,proStock);
            puente.setString(3, precioUnidad);
            puente.setString(4, Estado);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    @Override
    public boolean borrar() {
        try {
            sql = "DELETE FROM productos  where idProductos = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idProductos);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    @Override
    public boolean actualizar() {
        try {

            sql = "update productos set ProNombre = ?,ProStock = ?,PrecioUnidad = ?,Estado = ? where idProductos=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, proNombre);
            puente.setString(2, proStock);
            puente.setString(3, precioUnidad);
            puente.setString(4, Estado);
            puente.setString(5, idProductos);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }
    public ArrayList<ProductoVO> listar() {
        ArrayList<ProductoVO> ListaProductos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from productos";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
                ListaProductos.add(proVO);
            }
        } catch (Exception e) {
            Logger.getLogger(ProductoVO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductoVO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return ListaProductos;
    }
     public ArrayList<ProductoVO> listarProducto() {
        ArrayList<ProductoVO> ListaProductos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from productos Where Estado = 1 order by idProductos desc;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
                ListaProductos.add(proVO);
            }
        } catch (Exception e) {
            Logger.getLogger(ProductoVO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductoVO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return ListaProductos;
    }
    
    public ProductoVO consultarporCodigo(String idpro) {
        ProductoVO proVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "Select * from productos WHERE idProductos = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idpro);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                proVO = new ProductoVO(idpro,mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
            }
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return proVO;
    }
    
}

