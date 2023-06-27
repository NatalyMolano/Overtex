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
public class CompraVO1 
{ 
    private String idcompra,idProveedor,idGerente,ComFecha,Monto,Estado;

    public CompraVO1() {
    }

    public CompraVO1(String idcompra, String idProveedor, String idGerente, String ComFecha, String Monto, String Estado) {
        this.idcompra = idcompra;
        this.idProveedor = idProveedor;
        this.idGerente = idGerente;
        this.ComFecha = ComFecha;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(String idGerente) {
        this.idGerente = idGerente;
    }

    public String getComFecha() {
        return ComFecha;
    }

    public void setComFecha(String ComFecha) {
        this.ComFecha = ComFecha;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    
    

    
    
}
