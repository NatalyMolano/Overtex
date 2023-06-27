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
public class CompraVO 
{ 

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }
    
    private String id,idProveedor,idproductos,idGerente,Numserie,Descripcion,Fecha;
    private String cantidad;  
    private String precio;
    private String Monto;
    private String Estado,SubTotal,Mes;

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }
    
    
    public CompraVO(String id, String idProveedor, String idGerente, String Monto, String Estado) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.idGerente = idGerente;
        this.Monto = Monto;
        this.Estado = Estado;
    }
    public CompraVO(String id, String idproductos, String cantidad, String precio) {
        this.id = id;
        this.idproductos = idproductos;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getMes() {
        return Mes;
    }

    public CompraVO(String Mes) {
        this.Mes = Mes;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(String idproductos) {
        this.idproductos = idproductos;
    }

    public String getNumserie() {
        return Numserie;
    }

    public void setNumserie(String Numserie) {
        this.Numserie = Numserie;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMonto() {
        return Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    

    public CompraVO() 
    {
        
    }

    public CompraVO(String id, String idProveedor, String idGerente, String Fecha, String Monto, String Estado) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.idGerente = idGerente;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Estado = Estado;
    }
   

    
   

    
    

    
    

    
    
}
