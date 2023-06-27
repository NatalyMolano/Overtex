/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.usuarioVO;
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
 * @author Janus
 */
public class usuarioDAO extends ConexionBD implements Crud {

    public usuarioDAO() {
    }

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String idUsuario = "", UsuDocumento = "", UsuNombre = "", UsuContrasena = "", Usudireccion = "", UsuTelefono = "", UsuEstado = "", IdRol = "";

    public usuarioDAO(usuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idUsuario = usuVO.getIdUsuario();
            UsuDocumento = usuVO.getUsuDocumento();
            UsuNombre = usuVO.getUsuNombre();
            UsuContrasena = usuVO.getUsuContrasena();
            Usudireccion = usuVO.getUsudireccion();
            UsuTelefono = usuVO.getUsuTelefono();
            UsuEstado = usuVO.getUsuEstado();
            IdRol = usuVO.getIdRol();

        } catch (Exception e) {
            // es la libreria manda el log que son los errores por severidad
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregar() {
        try {
            sql = "INSERT INTO `overtex`.`usuario` (`UsuDocumento`, `UsuNombre`, `UsuContraseña`, `Usudireccion`, `UsuTelefono`, `UsuEstado`, `IdRol`) VALUES (?,?,?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, UsuDocumento);
            puente.setString(2, UsuNombre);
            puente.setString(3, UsuContrasena);
            puente.setString(4, Usudireccion);
            puente.setString(5, UsuTelefono);
            puente.setString(6, UsuEstado);
            puente.setString(7, IdRol);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public usuarioVO consultarID(String idUsuario)//este metodo es para buscar solo una columna en la bd
    {
        usuarioVO usuVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where idUsuario = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idUsuario);
            puente.executeQuery();
            mensajero = puente.executeQuery();   //las consultas se hacen a traves de esto
            while (mensajero.next()) { //mensajero.next va y busca en todo hasta que encuentra
                //aca tambien se puede usar los numeros de las columnas en vez del nombre de las columnas ej: mensajero.getString(1)
                usuVO = new usuarioVO(mensajero.getString("idUsuario"), mensajero.getString("UsuDocumento"), mensajero.getString("UsuNombre"), mensajero.getString("UsuContraseña"), mensajero.getString("Usudireccion"), mensajero.getString("UsuTelefono"), mensajero.getString("UsuEstado"), mensajero.getString("IdRol"));

            }
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return usuVO;

    }

    public ArrayList<usuarioVO> listar() {
        ArrayList<usuarioVO> usuarios = new ArrayList<>(); // Crea una lista para almacenar los vehículos encontrados
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where UsuEstado=1;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery(); // ejecuta la consulta SQL
            while (mensajero.next()) {
                // Obtiene los valores de las columnas para crear un objeto VehiculoVO
                usuarioVO usuVO = new usuarioVO(mensajero.getString("idUsuario"), mensajero.getString("UsuDocumento"), mensajero.getString("UsuNombre"), mensajero.getString("UsuContraseña"), mensajero.getString("Usudireccion"), mensajero.getString("UsuTelefono"), mensajero.getString("UsuEstado"), mensajero.getString("IdRol"));
                usuarios.add(usuVO); // Agrega el vehículo a la lista
            }
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return usuarios;
    }

    @Override
    public boolean actualizar() {
        try {
            sql = "UPDATE `overtex`.`usuario` SET `UsuDocumento` = ?, `UsuNombre` = ?, `UsuContraseña` = ?, `Usudireccion` = ?, `UsuTelefono` = ?, `UsuEstado` = ?, `IdRol` = ? WHERE (`idUsuario` = ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, UsuDocumento);
            puente.setString(2, UsuNombre);
            puente.setString(3, UsuContrasena);
            puente.setString(4, Usudireccion);
            puente.setString(5, UsuTelefono);
            puente.setString(6, UsuEstado);
            puente.setString(7, IdRol);
            puente.setString(8, idUsuario);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;

    }
    
    public ArrayList<usuarioVO> listarPorId(String idUsuario) {
        ArrayList<usuarioVO> usuarios = new ArrayList<>(); // Crea una lista para almacenar los vehículos encontrados
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where idUsuario=? limit 1;";
            puente.setString(1, idUsuario);
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery(); // ejecuta la consulta SQL
            while (mensajero.next()) {
                // Obtiene los valores de las columnas para crear un objeto VehiculoVO
                usuarioVO usuVO = new usuarioVO(mensajero.getString("idUsuario"), mensajero.getString("UsuDocumento"), mensajero.getString("UsuNombre"), mensajero.getString("UsuContraseña"), mensajero.getString("Usudireccion"), mensajero.getString("UsuTelefono"), mensajero.getString("UsuEstado"), mensajero.getString("IdRol"));
                usuarios.add(usuVO); // Agrega el vehículo a la lista
            }
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return usuarios;
    }


    @Override
    public boolean borrar() {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql = "UPDATE usuario SET UsuEstado = '0' WHERE idUsuario= ? ;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, idUsuario);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();

            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    public ArrayList<usuarioVO> listarVendedor() {
        ArrayList<usuarioVO> usuarios = new ArrayList<>(); // Crea una lista para almacenar los vehículos encontrados
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where UsuEstado=1 and IdRol=5002;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery(); // ejecuta la consulta SQL
            while (mensajero.next()) {
                // Obtiene los valores de las columnas para crear un objeto VehiculoVO
                usuarioVO usuVO = new usuarioVO(mensajero.getString("idUsuario"), mensajero.getString("UsuDocumento"), mensajero.getString("UsuNombre"), mensajero.getString("UsuContraseña"), mensajero.getString("Usudireccion"), mensajero.getString("UsuTelefono"), mensajero.getString("UsuEstado"), mensajero.getString("IdRol"));
                usuarios.add(usuVO); // Agrega el vehículo a la lista
            }
        } catch (Exception e) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return usuarios;
    }

}
