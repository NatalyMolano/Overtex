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
public class detalle_VentaVO {
    
    private String id_DetalleVenta,IdVenta,IdProducto,NomProducto, cantidad,PrecioUnitario,subtotal;

    
    
    public detalle_VentaVO(String IdProducto, String NomProducto, String cantidad, String PrecioUnitario, String subtotal) {
        this.IdProducto = IdProducto;
        this.NomProducto = NomProducto;
        this.cantidad = cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.subtotal = subtotal;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }

    public detalle_VentaVO() {
    }

    public String getId_DetalleVenta() {
        return id_DetalleVenta;
    }

    public void setId_DetalleVenta(String id_DetalleVenta) {
        this.id_DetalleVenta = id_DetalleVenta;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(String PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public detalle_VentaVO(String id_DetalleVenta, String IdProducto, String NomProducto, String cantidad, String PrecioUnitario, String subtotal) {
        this.id_DetalleVenta = id_DetalleVenta;
        this.IdProducto = IdProducto;
        this.NomProducto = NomProducto;
        this.cantidad = cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.subtotal = subtotal;
    }
    
}
