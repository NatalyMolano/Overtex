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
public class VentaVO {
    

    public VentaVO() {
    }

    
     public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    private String idVenta, idCliente, idproductos, idUsuario, Numserie, Descripcion, VenFecha;

    private String cantidad;
    private String precio;
    private String Monto;
    private String Estado, SubTotal, Mes;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public VentaVO(String idVenta, String idCliente, String idUsuario, String Monto, String Estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public VentaVO(String idVenta, String idproductos, String cantidad, String precio) {
        this.idVenta = idVenta;
        this.idproductos = idproductos;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getMes() {
        return Mes;
    }

    public VentaVO(String Mes) {
        this.Mes = Mes;
    }

    public String getidVenta() {
        return idVenta;
    }

    public void setidVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdidCliente() {
        return idCliente;
    }

    public void setidCliente(String idCliente) {
        this.idCliente = idCliente;
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
        return VenFecha;
    }

    public void setVenFecha(String VenFecha) {
        this.VenFecha = VenFecha;
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

    

    public VentaVO(String idVenta, String idCliente, String idUsuario, String VenFecha, String Monto, String Estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.VenFecha = VenFecha;
        this.Monto = Monto;
        this.Estado = Estado;
    }
    
    
}
