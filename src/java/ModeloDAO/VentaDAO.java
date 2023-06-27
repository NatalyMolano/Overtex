/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.VentaVO;
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
public class VentaDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;//se almacenan las peticiones sql
    private String idVenta, idCliente, idproductos, idUsuario, Numserie, Descripcion, VenFecha;
    private String cantidad;
    private String precio;
    private String Monto;
    private String Estado, SubTotal, Mes;

    

    public VentaDAO() {
    }

    //2.metodos principal le paso los datos de VO
    public VentaDAO(VentaVO venVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            idVenta = venVO.getidVenta();
            idCliente = venVO.getIdidCliente();
            idUsuario=venVO.getIdUsuario();
            VenFecha = venVO.getFecha();
            Monto = venVO.getMonto();
            Estado = venVO.getEstado();
            precio = venVO.getPrecio();
            cantidad = venVO.getCantidad();
            idproductos = venVO.getIdproductos();
            Mes = venVO.getMes();
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //llamar un metodo abstracto
        //llamar un metodo abstracto
        //llamar un metodo abstracto
        //llamar un metodo abstracto

    }

    
    
    
    public boolean agregarDetalleVenta() {//realizar compra
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO `detalle_venta` (`IdVenta`, `IdProducto`, `cantidad`, `PrecioUnidad`) VALUES (?,?,?,?); ";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            puente.setString(1, idVenta);
            puente.setString(2, idproductos);
            puente.setString(3, cantidad);
            puente.setString(4, precio);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;}
    @Override
    public boolean agregar() {//realizar compra
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO `venta` (`idCliente`, `idVendedor`, `VenFecha`, `Monto`, `Estado`) VALUES ( ?, ?, CURDATE(), ?, 1);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            puente.setString(1, idCliente);
            puente.setString(2, idUsuario);
            puente.setString(3, Monto);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;}

    @Override
    public boolean actualizar() {//actualizar datos
         try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "UPDATE `overtex`.`venta` SET `idCliente` = ?, `idVendedor` = ?, `ComFecha` = CURDATE(), `Estado` = 1 WHERE (`idVenta` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idCliente);
            puente.setString(2, idUsuario);
            puente.setString(3, idVenta);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();

            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;}

    @Override
    public boolean borrar() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "DELETE FROM `overtex`.`venta` WHERE (`idVenta` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idVenta);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();

            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    public VentaVO consultarPorVenta(String idVenta)/*retorna el VO se usa */ {
        VentaVO venVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "select * from venta where idVenta=?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idVenta);/*va lo que recibe en el parametro;
            */
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                venVO = new  VentaVO(idVenta,  mensajero.getString(2),  mensajero.getString(3),  mensajero.getString(4), 
                        mensajero.getString(5),  mensajero.getString(6));/*crear un VO*/
              
            }
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return venVO;
    }
    public ArrayList<VentaVO> listarCod() {
        ArrayList<VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `venta` WHERE Estado=1 order by idventa desc limit 1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVO venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarVentas.add(venVO);
            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;
    }
    
    
    public ArrayList<VentaVO> listarCod1() {
        ArrayList<VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `venta` WHERE Estado=1 order by idcompra desc limit 1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVO venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarVentas.add(venVO);
            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;
    }
    /**
     *
     * @return
     */
   public ArrayList<VentaVO> listarVenta() {
        ArrayList<VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT idventa,Documento,UsuDocumento,VenFecha,Monto,v.Estado FROM venta as v "
                    + "inner join cliente as p on p.idcliente= v.idCliente inner join usuario as u on u.idUsuario=v.idVendedor ";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVO venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarVentas.add(venVO);
            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;
   }
        
        
        public ArrayList<VentaVO> listarPorCodigoVenta(String idVenta) {
        ArrayList<VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `venta` WHERE Estado=1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVO venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarVentas.add(venVO);
            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;
    
    
    
    
}
        public ArrayList<VentaVO> listarCodigoVenta(String idVenta) {
        ArrayList<VentaVO> listarVentas = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `venta` WHERE idVenta=?";
            puente.setString(1, idVenta);
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVO venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarVentas.add(venVO);
            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarVentas;
        }
    
        public VentaVO consultarPorMes(String Mes) {
        VentaVO venVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT sum(Monto) FROM `venta` WHERE month(VenFecha) = ?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, Mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                venVO = new VentaVO(mensajero.getString(1));/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return venVO;
        }
    
        public VentaVO consultarPoridVendedor(String Mes, String id) {
        VentaVO venVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select sum(cantidad), sum(cantidad)*2000,month(VenFecha),u.UsuNombre from venta as v inner join detalle_venta as d on d.IdVenta= v.idVenta inner join usuario as u on u.idUsuario = v.idVendedor where idVendedor = ? and month(VenFecha) = ?;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, id);
            puente.setString(2, Mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                venVO = new VentaVO(mensajero.getString(1), mensajero.getString(2), Mes, id);/*crear un VO*/

            }
        } catch (Exception e) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return venVO;
    
    
}
        
    
    /*@Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    
}
