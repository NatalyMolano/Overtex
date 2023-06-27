/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author chiri
 */
public class Mod_VentaVO {
    
    private String idVenta,new_PrecioUnidad,old_PrecioUnidad,new_Cantidad,old_Cantidad,new_VenFecha,old_VenFecha,idVendedor,idCliente,Estado,IdProductos,operacionv;

    public Mod_VentaVO() {
    }

    public Mod_VentaVO(String idVenta, String new_PrecioUnidad, String old_PrecioUnidad, String new_Cantidad, String old_Cantidad, String new_VenFecha, String old_VenFecha, String idVendedor, String idCliente, String Estado, String IdProductos, String operacionv) {
        this.idVenta = idVenta;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.old_PrecioUnidad = old_PrecioUnidad;
        this.new_Cantidad = new_Cantidad;
        this.old_Cantidad = old_Cantidad;
        this.new_VenFecha = new_VenFecha;
        this.old_VenFecha = old_VenFecha;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.Estado = Estado;
        this.IdProductos = IdProductos;
        this.operacionv = operacionv;
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

    public String getOld_PrecioUnidad() {
        return old_PrecioUnidad;
    }

    public void setOld_PrecioUnidad(String old_PrecioUnidad) {
        this.old_PrecioUnidad = old_PrecioUnidad;
    }

    public String getNew_Cantidad() {
        return new_Cantidad;
    }

    public void setNew_Cantidad(String new_Cantidad) {
        this.new_Cantidad = new_Cantidad;
    }

    public String getOld_Cantidad() {
        return old_Cantidad;
    }

    public void setOld_Cantidad(String old_Cantidad) {
        this.old_Cantidad = old_Cantidad;
    }

    public String getNew_VenFecha() {
        return new_VenFecha;
    }

    public void setNew_VenFecha(String new_VenFecha) {
        this.new_VenFecha = new_VenFecha;
    }

    public String getOld_VenFecha() {
        return old_VenFecha;
    }

    public void setOld_VenFecha(String old_VenFecha) {
        this.old_VenFecha = old_VenFecha;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getIdProductos() {
        return IdProductos;
    }

    public void setIdProductos(String IdProductos) {
        this.IdProductos = IdProductos;
    }

    public String getOperacionv() {
        return operacionv;
    }

    public void setOperacion(String operacion) {
        this.operacionv = operacion;
    }
    
    
}
