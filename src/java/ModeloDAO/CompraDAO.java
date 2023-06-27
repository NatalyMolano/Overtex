
package ModeloDAO;

import ModeloVO.CompraVO;
import ModeloVO.ProveedoresVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Crud;
import util.ConexionBD;

/**
 *
 * @author APRENDIZ
 */
public class CompraDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;//se almacenan las peticiones sql
    private String idcompra="",idProveedor="",idGerente="",ComFecha="",Estado="",idproducto="",Mes="";
    private String Monto="",precio="",cantidad ="";
    

    public CompraDAO() {
    }

    //2.metodos principal le paso los datos de VO
    public CompraDAO(CompraVO ComVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            idcompra = ComVO.getId();
            idProveedor = ComVO.getIdProveedor();
            idGerente=ComVO.getIdGerente();
            ComFecha = ComVO.getFecha();
            Monto = ComVO.getMonto();
            Estado = ComVO.getEstado();
            precio = ComVO.getPrecio();
            cantidad = ComVO.getCantidad();
            idproducto = ComVO.getIdproductos();
            Mes = ComVO.getMes();
        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //llamar un metodo abstracto

    }

    
    
    
    public boolean agregarDetalleCompra() {//realizar compra
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO `detalle_compra` (`IdCompra`, `IdProducto`, `cantidad`, `PrecioUnitario`) VALUES ( ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            puente.setString(1, idcompra);
            puente.setString(2, idproducto);
            puente.setString(3, cantidad);
            puente.setString(4, precio);
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

        return operacion;}
    @Override
    public boolean agregar() {//realizar compra
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO `overtex`.`compra` (`idProveedor`, `idGerente`, `ComFecha`, `Monto`, `Estado`) VALUES (?, ?,  CURDATE(), ?, 1);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            puente.setString(1, idProveedor);
            puente.setString(2, idGerente);
            puente.setString(3, Monto);
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

        return operacion;}

    @Override
    public boolean actualizar() {//actualizar datos
         try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "UPDATE `overtex`.`compra` SET `idProveedor` = ?, `idGerente` = ?, `ComFecha` = CURDATE(), `Estado` = 1 WHERE (`idcompra` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idProveedor);
            puente.setString(2, idGerente);
            puente.setString(3, idcompra);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();

            } catch (Exception e) {
                Logger.getLogger(CompraDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;}

    @Override
    public boolean borrar() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "DELETE FROM `overtex`.`compra` WHERE (`idcompra` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idcompra);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(CompraDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();

            } catch (Exception e) {
                Logger.getLogger(CompraDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    public CompraVO consultarPorCompra(String idcompra)/*retorna el VO se usa */ {
        CompraVO croVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "select * from compra where idcompra=?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idcompra);/*va lo que recibe en el parametro;
            */
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                croVO = new  CompraVO(idcompra,  mensajero.getString(2),  mensajero.getString(3),  mensajero.getString(4), 
                        mensajero.getString(5),  mensajero.getString(6));/*crear un VO*/
              
            }
        } catch (Exception e) {
            Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return croVO;
    }
    public ArrayList<CompraVO> listarCod() {
        ArrayList<CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `compra` WHERE Estado=1 order by idcompra desc limit 1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraVO comVO = new CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarCompras.add(comVO);
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
    
    
    public ArrayList<CompraVO> listarCod1() {
        ArrayList<CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `compra` WHERE Estado=1 order by idcompra desc limit 1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraVO comVO = new CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarCompras.add(comVO);
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
    /**
     *
     * @return
     */
   public ArrayList<CompraVO> listarCompra() {
        ArrayList<CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT idcompra,p.NombreEmpresa,u.UsuNombre,ComFecha,Monto,c.Estado FROM compra as c \n" +
"inner join proveedores as p on p.idproveedores=c.idProveedor\n" +
"inner join usuario as u on u.idUsuario=c.idGerente;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraVO comVO = new CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarCompras.add(comVO);
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
        
        
        public ArrayList<CompraVO> listarPorCodigoCompra(String idcompra) {
        ArrayList<CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `compra` WHERE Estado=1;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraVO comVO = new CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarCompras.add(comVO);
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
        public ArrayList<CompraVO> listarCodigoCompra(String idcompra) {
        ArrayList<CompraVO> listarCompras = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM `compra` WHERE idCompra=?";
            puente.setString(1, idcompra);
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CompraVO comVO = new CompraVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listarCompras.add(comVO);
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
    
        public CompraVO consultarPorMes(String Mes) {
        CompraVO ComVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT sum(Monto) FROM `compra` WHERE month(ComFecha) = ?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, Mes);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ComVO = new CompraVO(mensajero.getString(1));/*crear un VO*/

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
        
    
    /*@Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    
}
