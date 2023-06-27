/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CompraMVO;
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
public class CompraMDAO extends ConexionBD {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;
    private String gastos_mensuales = "", mes = "", cantidad_productos = "", idcompra = "", idGerente = "", NomProducto = "", new_PrecioUnidad = "", old_PrecioUnidad = "", new_cantidad = "", old_cantidad = "", total_compra = "", new_ComFecha = "", old_ComFecha = "", id = "";

    public CompraMDAO() {
    }

    public CompraMDAO(CompraMVO ComVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            gastos_mensuales = ComVO.getGastos_mensuales();
            mes = ComVO.getMes();
            cantidad_productos = ComVO.getCantidad_productos();
            idcompra = ComVO.getIdcompra();
            idGerente = ComVO.getIdGerente();
            NomProducto = ComVO.getNomProducto();
            new_PrecioUnidad = ComVO.getNew_PrecioUnidad();
            old_PrecioUnidad = ComVO.getOld_PrecioUnidad();
            new_cantidad = ComVO.getNew_cantidad();
            old_cantidad = ComVO.getOld_cantidad();
            total_compra = ComVO.getTotal_compra();
            new_ComFecha = ComVO.getNew_ComFecha();
            old_ComFecha = ComVO.getOld_ComFecha();
            id = ComVO.getId();
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO

        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public CompraMVO consultarPorMes(String Mes) {
        CompraMVO ComVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select  sum(total_compra(new_cantidad,new_PrecioUnidad)) as gastos_mensuales,month(new_ComFecha) as mes,\n"
                    + "              sum(new_cantidad) as cantidad_productos from compra_modificaciones where\n"
                    + "                month(new_ComFecha) = ? and Estado=1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, Mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ComVO = new CompraMVO(mensajero.getString(1), Mes, mensajero.getString(3));/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ComVO;
    }

    public ArrayList<CompraMVO> listar() {
        ArrayList<CompraMVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT id_alteracion,idcompra,idGerente,NomProducto,new_PrecioUnidad,new_cantidad,total_compra(new_cantidad,new_PrecioUnidad) as total_compra,new_ComFecha \n"
                    + " FROM compra_modificaciones where Estado=1 order by idcompra desc;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraMVO comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                listarCompras.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarCompras;
    }

    public CompraMVO consultarPorId(String idcompra)/*retorna el VO se usa */ {
        CompraMVO comVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT id_alteracion,C.idcompra,C.idGerente,C.NomProducto,new_PrecioUnidad,old_PrecioUnidad,new_cantidad ,old_cantidad ,new_ComFecha \n"
                    + ",old_comFecha,C.Estado,Operacion FROM overtex.compra_modificaciones as cm inner join compra as C on C.idcompra=cm.idcompra where cm.idcompra = ?\n"
                    + "order by id_alteracion desc  limit 1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idcompra);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                comVO = new CompraMVO(mensajero.getString(1), idcompra, mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12));/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return comVO;
    }

    public CompraMVO consultarPortablaMes(String mes)/*retorna el VO se usa */ {
        CompraMVO comVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT idcompra,idGerente,NomProducto,new_PrecioUnidad,new_cantidad,total_compra(new_cantidad,new_PrecioUnidad), new_ComFecha FROM overtex.compra_modificaciones where month(new_ComFecha)=?;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mes);/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return comVO;
    }

    public ArrayList<CompraMVO> listarporMes(String mes) {
        ArrayList<CompraMVO> listarporMes = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT idcompra,idGerente,NomProducto,new_PrecioUnidad,new_cantidad,total_compra(new_cantidad,new_PrecioUnidad) as total_compra,new_ComFecha FROM compra_modificaciones where Estado=1 and month(new_ComFecha)=03;";

            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraMVO comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mes);
                listarporMes.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarporMes;
    }

    public ArrayList<CompraMVO> obtenerDatosPorMes(String mes) {
        ArrayList<CompraMVO> datos = new ArrayList<CompraMVO>();
        String sql = "SELECT id,idcompra, idGerente, NomProducto, new_PrecioUnidad, new_cantidad, total_compra(new_cantidad, new_PrecioUnidad) as total_compra, new_ComFecha FROM compra_modificaciones WHERE Estado = 1 AND MONTH(new_ComFecha) = ?;";
        try (Connection conn = obtenerConexion();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mes);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CompraMVO comVO = new CompraMVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), mes);
                datos.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datos;
    }

    public ArrayList<CompraMVO> listarCambios() {
        ArrayList<CompraMVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM compra_modificaciones order by idcompra desc;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraMVO comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12));
                listarCompras.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarCompras;
    }

    //llamar un metodo abstracto
    public boolean agregar() {//realizar compra
        try {

            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO `compra_modificaciones` ( `idcompra`, `idGerente`, `NomProducto`, `new_PrecioUnidad`, `old_PrecioUnidad`, \n"
                    + "`new_cantidad`, `old_cantidad`, `new_ComFecha`, `old_comFecha`, `Estado`, `Operacion`) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, '1', 'M');";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            puente.setString(1, idcompra);
            puente.setString(2, idGerente);
            puente.setString(3, NomProducto);
            puente.setString(4, new_PrecioUnidad);
            puente.setString(5, old_PrecioUnidad);
            puente.setString(6, new_cantidad);
            puente.setString(7, old_cantidad);
            puente.setString(8, new_ComFecha);
            puente.setString(9, old_ComFecha);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public ArrayList<CompraMVO> listarMovimientos() {
        ArrayList<CompraMVO> listarMovimientos = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT c.idcompra,p.ProNombre,de.cantidad,de.PrecioUnitario,pr.NombreEmpresa,u.UsuNombre,c.ComFecha FROM `compra` as c inner join detalle_compra as de on de.IdCompra=c.idcompra inner join productos as p on p.idProductos= de.IdProducto inner join proveedores as pr on pr.idproveedores=c.idProveedor inner join usuario as u on u.idUsuario=c.idGerente;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraMVO comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7));
                listarMovimientos.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarMovimientos;
    }
    public ArrayList<CompraMVO> listarVentas() {
        ArrayList<CompraMVO> listarMovimientos = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT v.idVenta,p.ProNombre,de.cantidad,de.PrecioUnidad,cli.CliNombre,u.UsuNombre,v.VenFecha FROM venta as v inner join detalle_venta as de on de.IdVenta=v.idVenta inner join productos as p on p.idProductos= de.IdProducto inner join cliente as cli on cli.idcliente=v.idCliente inner join usuario as u on u.idUsuario=v.idVendedor;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraMVO comVO = new CompraMVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7));
                listarMovimientos.add(comVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(CompraMDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarMovimientos;
    }

    
}
