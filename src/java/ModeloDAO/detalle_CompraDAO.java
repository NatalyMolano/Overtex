
package ModeloDAO;

import ModeloVO.CompraVO;
import ModeloVO.detalle_CompraVO;
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
public class detalle_CompraDAO extends ConexionBD {

    private String id_DetalleCompra = "", IdCompra = "",
            IdProducto = "", cantidad = "", PrecioUnitario = "", subtotal = "", Nombre = "";

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;

    public detalle_CompraDAO() {
    }

    //2.metodos principal le paso los datos de VO
    public detalle_CompraDAO(detalle_CompraVO ComVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            id_DetalleCompra = ComVO.getId_DetalleCompra();
            IdCompra = ComVO.getIdCompra();
            IdProducto = ComVO.getIdProducto();
            cantidad = ComVO.getCantidad();
            PrecioUnitario = ComVO.getPrecioUnitario();
            subtotal = ComVO.getSubtotal();
            Nombre = ComVO.getNomProducto();

        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //llamar un metodo abstracto

    }

    public ArrayList<detalle_CompraVO> listarDetalleCompra(String IdCompra) {
        ArrayList<detalle_CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "select d.id_DetalleCompra,d.IdProducto,P.ProNombre, cantidad,PrecioUnitario, cantidad * PrecioUnitario as subtotal\n"
                    + "from detalle_compra as d inner join productos as P on  P.idProductos= d.IdProducto\n"
                    + "where IdCompra= ? order by id_DetalleCompra asc;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdCompra);

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                detalle_CompraVO deVO = new detalle_CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5),mensajero.getString(6));
                listarCompras.add(deVO);
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
        return listarCompras;

    }

    public boolean borrarDetalleCompra() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "DELETE FROM `overtex`.`detalle_compra` WHERE (`id_DetalleCompra` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, id_DetalleCompra);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
}
