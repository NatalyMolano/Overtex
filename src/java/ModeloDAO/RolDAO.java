/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModeloVO.RolVO;
import util.ConexionBD;

/**
 *
 * @author APRENDIZ
 */
public class RolDAO extends ConexionBD{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion = false;
    private String sql;//se almacenan las peticiones sql
    
    public ArrayList<RolVO> listar(String IdUsuario)
    {
        ArrayList<RolVO> listaRoles = new ArrayList<>();/*se creo el objeto*/
        
        try {
            conexion = this.obtenerConexion();
            sql = "select IdRol,idUsuario from usuario where idUsuario=?";
            
            puente = conexion.prepareStatement(sql);
            puente.setString(1, IdUsuario);
            //remplazar los interrogantes
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                
                RolVO rolVO = new RolVO(mensajero.getString(1),mensajero.getString(2));
                listaRoles.add(rolVO);
            }
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRoles;
    }

    
}
