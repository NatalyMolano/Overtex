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
import ModeloVO.UsuarioVO_1;
import util.Crud;
import util.ConexionBD;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioDAO1 extends ConexionBD implements Crud// se autocompleta importar
{
    //1.declarar variables u objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    //declarar una variable
    private boolean operacion= false;
    private String sql;//se almacenan las peticiones sql
    private String usuId="",usulogin="",usupassword="";
    //2.metodos principal le paso los datos de VO
    public UsuarioDAO1(UsuarioVO_1 usuVO)
    {
        super();//heredar atributos de otra clase
        try {
            //3. conectar la base de datos
            conexion = this.obtenerConexion();
            //4. traer los datos de VO al DAO
            usuId= usuVO.getUsuId();
            usulogin = usuVO.getUsulogin();
            usupassword = usuVO.getUsupassword();
        } catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
        }
        //llamar un metodo abstracto
        //llamar un metodo abstracto
        //llamar un metodo abstracto
        //llamar un metodo abstracto
        
    }

    @Override
    public boolean agregar() 
    {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql="insert into usuario(USULOGIN,USUPASSWORD) values (?,?) ";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, usulogin );
            puente.setString(2, usupassword);
            puente.executeUpdate();
            operacion= true;
            
        } catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
        }
        finally
        {
            try 
            {
                this.cerrarConextion();
            } 
            catch (Exception e) 
            {
                Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        
        return operacion;
    }

    @Override
    public boolean actualizar() 
    {
       try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql="update usuario set USULOGI =?,USUPASSWORD=? WHERE USUID=?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, usulogin );
            puente.setString(2, usupassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion= true;
            
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
        }
        finally
        {
            try {
                this.cerrarConextion();
            } 
            catch (Exception e) 
            {
                Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
  

    @Override
    public boolean borrar() 
    {
        try {
            //uso de base de datos
            //definir la setencia,hacer el quary
            sql="DELETE FROM usuario WHERE  USUID = ?";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, usuId);
            puente.executeUpdate();
            operacion= true;
            
        } 
        catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
        }
        finally
        {
            try {
                this.cerrarConextion();
            } 
            catch (Exception e) 
            {
                Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    //metodos propios
    public boolean iniciarSesion(String usuario, String contraseña)
    {
        try {
            //diferente con los metodos genericos
            conexion = this.obtenerConexion();
            sql= "SELECT UsuNombre,UsuContraseña FROM overtex.usuario where UsuNombre=? and UsuContraseña =? ;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, usuario);
            puente.setString(2, contraseña);
            mensajero = puente.executeQuery();
            if(mensajero.next())
            {
                operacion= true;
            }
            
        } catch (Exception e) 
        {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
        }
        finally
        {
            try {
                //this.cerrarConexion();
            } 
            catch (Exception e) 
            {
                Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    
    public UsuarioVO_1 consultarIdUsuario(String usuario)/*retorna el VO se usa */ {
        UsuarioVO_1 usuVO = null;/*se declara tipo nulo*/
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT idUsuario,UsuNombre,UsuContraseña FROM overtex.usuario where UsuNombre=? ;";
            puente = conexion.prepareStatement(sql);
            //remplazar los interrogantes
            puente.setString(1, usuario);/*va lo que recibe en el parametro;
            */
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                usuVO = new UsuarioVO_1(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConextion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO1.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }
    
    
    
}
