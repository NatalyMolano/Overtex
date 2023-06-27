/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CompraVO;
import ModeloVO.ProveedoresVO;
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
public class ProveedoresDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;//se almacenan las peticiones sql
    private String idproveedores = "", Documento = "", ProvNombre = "", ProvApellido = "", NombreEmpresa = "", Telefono = "", Estado = "";

    public ProveedoresDAO() {
    }

    public ProveedoresDAO(ProveedoresVO ProVO) {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            idproveedores = ProVO.getIdproveedores();
            Documento = ProVO.getDocumento();
            ProvNombre = ProVO.getProvNombre();
            ProvApellido = ProVO.getProvApellido();
            NombreEmpresa = ProVO.getNombreEmpresa();
            Telefono = ProVO.getTelefono();
            Estado = ProVO.getEstado();
        } catch (Exception e) {
            Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //llamar un metodo abstracto

    }

    @Override
    public boolean agregar() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "INSERT INTO proveedores (Documento,ProvNombre,ProvApellido,NombreEmpresa,Telefono,Estado) values (?,?,?,?,?,1);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, Documento);
            puente.setString(2, ProvNombre);
            puente.setString(3, ProvApellido);
            puente.setString(4, NombreEmpresa);
            puente.setString(5, Telefono);
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

    @Override
    public boolean actualizar() {

        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "UPDATE `overtex`.`proveedores` SET `Documento` = ?, `ProvNombre` = ?, `ProvApellido` = ?, `NombreEmpresa` = ?, `Telefono` = ?, `Estado` = 1 WHERE (`idproveedores` = ?);";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, Documento);
            puente.setString(2, ProvNombre);
            puente.setString(3, ProvApellido);
            puente.setString(4, NombreEmpresa);
            puente.setString(5, Telefono);
            puente.setString(6, idproveedores);
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

    @Override
    public boolean borrar() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "DELETE FROM proveedores WHERE `proveedores`.`idproveedores` = ?;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idproveedores);
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

    public ProveedoresVO consultarPorProveedor(String documento)/*retorna el VO se usa */ {
        ProveedoresVO ProVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "select * from proveedores where documento=?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, documento);/*va lo que recibe en el parametro;
             */
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProVO = new ProveedoresVO(mensajero.getString(1), documento, mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));/*crear un VO*/

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
        return ProVO;
    }

    public ArrayList<ProveedoresVO> listar() {
        ArrayList<ProveedoresVO> listarProveedor = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "select * from proveedores where ESTADO= '1'";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProveedoresVO proVO = new ProveedoresVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));/*crear un VO*/
                listarProveedor.add(proVO);
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
        return listarProveedor;
    }
    
    public ArrayList<ProveedoresVO> ListarProveedor() {
        ArrayList<ProveedoresVO> listarProveedor = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT P.Documento,P.NombreEmpresa, P.Telefono,COUNT(P.idproveedores) as conteo FROM compra AS C INNER JOIN proveedores P ON C.idProveedor = P.idproveedores group by P.idproveedores ORDER BY conteo DESC limit 3;\n" +
"";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProveedoresVO proVO = new ProveedoresVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));/*crear un VO*/
                listarProveedor.add(proVO);
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
        return listarProveedor;
    }
    
    public ArrayList<ProveedoresVO> ListarProveedorMovimientos() {
        ArrayList<ProveedoresVO> listarProveedor = new ArrayList<>();/*se creo el objeto*/

        try {
            conexion = this.obtenerConexion();
            sql = "select p.Documento,p.NombreEmpresa,p.ProvNombre,pr.ProNombre,de.cantidad,de.PrecioUnitario,c.ComFecha from proveedores as p inner join compra as c on c.idProveedor=p.idproveedores inner join detalle_compra as de on de.IdCompra=c.idcompra inner join productos as pr on pr.idProductos=de.IdProducto;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes

            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProveedoresVO proVO = new ProveedoresVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));/*crear un VO*/
                listarProveedor.add(proVO);
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
        return listarProveedor;
    }
    
    }
