/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author natal
 */
public class CompraMVO {
    private String gastos_mensuales,mes,cantidad_productos,total_compra;
    private String id,idcompra,idGerente,NomProducto,new_PrecioUnidad,old_PrecioUnidad,new_cantidad,old_cantidad,new_ComFecha,old_ComFecha,Estado,Operacion;

    public CompraMVO(String id, String idcompra, String idGerente, String NomProducto, String new_PrecioUnidad, String old_PrecioUnidad, String new_cantidad, String old_cantidad, String new_ComFecha, String old_ComFecha, String Estado, String Operacion) {
        this.id = id;
        this.idcompra = idcompra;
        this.idGerente = idGerente;
        this.NomProducto = NomProducto;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.old_PrecioUnidad = old_PrecioUnidad;
        this.new_cantidad = new_cantidad;
        this.old_cantidad = old_cantidad;
        this.new_ComFecha = new_ComFecha;
        this.old_ComFecha = old_ComFecha;
        this.Estado = Estado;
        this.Operacion = Operacion;
    }
    public CompraMVO(String idcompra, String idGerente, String NomProducto, String new_PrecioUnidad, String old_PrecioUnidad, String new_cantidad, String old_cantidad, String new_ComFecha, String old_ComFecha) {
        this.idcompra = idcompra;
        this.idGerente = idGerente;
        this.NomProducto = NomProducto;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.old_PrecioUnidad = old_PrecioUnidad;
        this.new_cantidad = new_cantidad;
        this.old_cantidad = old_cantidad;
        this.new_ComFecha = new_ComFecha;
        this.old_ComFecha = old_ComFecha;
    }

    public String getOld_PrecioUnidad() {
        return old_PrecioUnidad;
    }

    public void setOld_PrecioUnidad(String old_PrecioUnidad) {
        this.old_PrecioUnidad = old_PrecioUnidad;
    }

    public String getOld_cantidad() {
        return old_cantidad;
    }

    public void setOld_cantidad(String old_cantidad) {
        this.old_cantidad = old_cantidad;
    }

    public String getOld_ComFecha() {
        return old_ComFecha;
    }

    public void setOld_ComFecha(String old_ComFecha) {
        this.old_ComFecha = old_ComFecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }
    



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CompraMVO(String id, String idcompra, String idGerente, String NomProducto, String new_PrecioUnidad, String new_cantidad, String total_compra, String new_ComFecha) {
        this.id = id;
        this.idcompra = idcompra;
        this.idGerente = idGerente;
        this.NomProducto = NomProducto;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.new_cantidad = new_cantidad;
        this.total_compra = total_compra;
        this.new_ComFecha = new_ComFecha;
    }
    
    
    public CompraMVO(String id, String idcompra, String idGerente, String NomProducto, String new_PrecioUnidad, String new_cantidad, String total_compra) {
        this.id = id;
        this.idcompra = idcompra;
        this.idGerente = idGerente;
        this.NomProducto = NomProducto;
        this.new_PrecioUnidad = new_PrecioUnidad;
        this.new_cantidad = new_cantidad;
        this.total_compra = total_compra;
        
    }

   
    
    
    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public String getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(String idGerente) {
        this.idGerente = idGerente;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }

    public String getNew_PrecioUnidad() {
        return new_PrecioUnidad;
    }

    public void setNew_PrecioUnidad(String new_PrecioUnidad) {
        this.new_PrecioUnidad = new_PrecioUnidad;
    }

    public String getNew_cantidad() {
        return new_cantidad;
    }

    public void setNew_cantidad(String new_cantidad) {
        this.new_cantidad = new_cantidad;
    }

    public String getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(String total_compra) {
        this.total_compra = total_compra;
    }

    public String getNew_ComFecha() {
        return new_ComFecha;
    }

    public void setNew_ComFecha(String new_ComFecha) {
        this.new_ComFecha = new_ComFecha;
    }
    

    public CompraMVO() {
    }

    public CompraMVO(String gastos_mensuales, String mes, String cantidad_productos) {
        this.gastos_mensuales = gastos_mensuales;
        this.mes = mes;
        this.cantidad_productos = cantidad_productos;
    }

    public String getGastos_mensuales() {
        return gastos_mensuales;
    }

    public void setGastos_mensuales(String gastos_mensuales) {
        this.gastos_mensuales = gastos_mensuales;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(String cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    
    
}
