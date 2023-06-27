/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author APRENDIZ
 */
public class ClienteVO {
    
    private String idCliente, cliNombre,cliTelefono,Documento,conteo,cliEstado;

    public String getConteo() {
        return conteo;
    }

    public void setConteo(String conteo) {
        this.conteo = conteo;
    }

    public ClienteVO(String cliNombre, String cliTelefono, String Documento, String conteo) {
        this.cliNombre = cliNombre;
        this.cliTelefono = cliTelefono;
        this.Documento = Documento;
        this.conteo = conteo;
    }

    

    public ClienteVO() {
    }
    
    public ClienteVO(String idCliente,String cliNombre, String cliTelefono, String Documento, String cliEstado) {
        this.idCliente = idCliente;
        this.cliNombre = cliNombre;
        this.cliTelefono = cliTelefono;
        this.Documento = Documento;
        this.cliEstado = cliEstado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }
    
    
    
}
