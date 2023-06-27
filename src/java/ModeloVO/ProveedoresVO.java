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
public class ProveedoresVO {
    private String idproveedores,Documento,ProvNombre,ProvApellido,NombreEmpresa,Telefono,Estado,conteo;

    public String getConteo() {
        return conteo;
    }

    public void setConteo(String conteo) {
        this.conteo = conteo;
    }

    public ProveedoresVO(String Documento, String NombreEmpresa, String Telefono, String conteo) {
        this.Documento = Documento;
        this.NombreEmpresa = NombreEmpresa;
        this.Telefono = Telefono;
        this.conteo = conteo;
    }

    public ProveedoresVO() {
    }

    public ProveedoresVO(String idproveedores, String Documento, String ProvNombre, String ProvApellido, String NombreEmpresa, String Telefono) {
        this.idproveedores = idproveedores;
        this.Documento = Documento;
        this.ProvNombre = ProvNombre;
        this.ProvApellido = ProvApellido;
        this.NombreEmpresa = NombreEmpresa;
        this.Telefono = Telefono;
    }

    public ProveedoresVO(String idproveedores, String Documento, String ProvNombre, String ProvApellido, String NombreEmpresa, String Telefono, String Estado) {
        this.idproveedores = idproveedores;
        this.Documento = Documento;
        this.ProvNombre = ProvNombre;
        this.ProvApellido = ProvApellido;
        this.NombreEmpresa = NombreEmpresa;
        this.Telefono = Telefono;
        this.Estado = Estado;
    }

    public String getIdproveedores() {
        return idproveedores;
    }

    public void setIdproveedores(String idproveedores) {
        this.idproveedores = idproveedores;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getProvNombre() {
        return ProvNombre;
    }

    public void setProvNombre(String ProvNombre) {
        this.ProvNombre = ProvNombre;
    }

    public String getProvApellido() {
        return ProvApellido;
    }

    public void setProvApellido(String ProvApellido) {
        this.ProvApellido = ProvApellido;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    
    
    
}