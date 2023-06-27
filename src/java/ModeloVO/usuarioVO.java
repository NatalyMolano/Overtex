/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Janus
 */
public class usuarioVO {
    
    public usuarioVO() {
    }

    private String idUsuario,UsuDocumento,UsuNombre,UsuContrasena,Usudireccion,UsuTelefono,UsuEstado,IdRol;
     
    public usuarioVO(String idUsuario, String UsuDocumento, String UsuNombre, String UsuContrasena, String Usudireccion, String UsuTelefono, String UsuEstado, String IdRol) {
        this.idUsuario = idUsuario;
        this.UsuDocumento = UsuDocumento;
        this.UsuNombre = UsuNombre;
        this.UsuContrasena = UsuContrasena;
        this.Usudireccion = Usudireccion;
        this.UsuTelefono = UsuTelefono;
        this.UsuEstado = UsuEstado;
        this.IdRol = IdRol;
        
    }

    public usuarioVO(String idUsuario, String UsuNombre, String UsuContrasena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuDocumento() {
        return UsuDocumento;
    }

    public void setUsuDocumento(String UsuDocumento) {
        this.UsuDocumento = UsuDocumento;
    }

    public String getUsuNombre() {
        return UsuNombre;
    }

    public void setUsuNombre(String UsuNombre) {
        this.UsuNombre = UsuNombre;
    }

    public String getUsuContrasena() {
        return UsuContrasena;
    }

    public void setUsuContraseña(String UsuContrasena) {
        this.UsuContrasena = UsuContrasena;
    }

    public String getUsudireccion() {
        return Usudireccion;
    }

    public void setUsudireccion(String Usudireccion) {
        this.Usudireccion = Usudireccion;
    }

    public String getUsuTelefono() {
        return UsuTelefono;
    }

    public void setUsuTelefono(String UsuTelefono) {
        this.UsuTelefono = UsuTelefono;
    }

    public String getUsuEstado() {
        return UsuEstado;
    }

    public void setUsuEstado(String UsuEstado) {
        this.UsuEstado = UsuEstado;
    }

    public String getIdRol() {
        return IdRol;
    }

    public void setIdRol(String IdRol) {
        this.IdRol = IdRol;
    }
    
}
