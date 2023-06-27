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
public class VentaModificacionesVO {
    
     private String idVenta,new_PrecioUnidad,new_Cantidad,new_VenFecha,IdProductos,idVendedor,comisiones;

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getComisiones() {
        return comisiones;
    }

    public void setComisiones(String comisiones) {
        this.comisiones = comisiones;
    }

    public VentaModificacionesVO() {
    }

    public VentaModificacionesVO(String new_Cantidad, String new_VenFecha, String idVendedor, String comisiones) {
        this.new_Cantidad = new_Cantidad;
        this.new_VenFecha = new_VenFecha;
        this.idVendedor = idVendedor;
        this.comisiones = comisiones;
    }

    public VentaModificacionesVO(String idVenta, String new_PrecioUnidad, String new_Cantidad, String new_VenFecha, String IdProductos) {
        this.idVenta = idVenta;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.new_Cantidad = new_Cantidad;
        this.new_VenFecha = new_VenFecha;
        this.IdProductos = IdProductos;
        
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getNew_PrecioUnidad() {
        return new_PrecioUnidad;
    }

    public void setNew_PrecioUnidad(String new_PrecioUnidad) {
        this.new_PrecioUnidad = new_PrecioUnidad;
    }

    public String getNew_Cantidad() {
        return new_Cantidad;
    }

    public void setNew_Cantidad(String new_Cantidad) {
        this.new_Cantidad = new_Cantidad;
    }

    public String getNew_VenFecha() {
        return new_VenFecha;
    }

    public void setNew_VenFecha(String new_VenFecha) {
        this.new_VenFecha = new_VenFecha;
    }

    public String getIdProductos() {
        return IdProductos;
    }

    public void setIdProductos(String IdProductos) {
        this.IdProductos = IdProductos;
    }

    
    
}
