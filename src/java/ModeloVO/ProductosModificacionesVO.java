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
public class ProductosModificacionesVO {
    
     private String 
id_modificacion_producto,	
ProNombre	,
Antiguo_PrecioUnidad,	
Modificado_PrecioUnidad	,
Antiguo_ProStock	,
Modificado_ProStock,	
Accion	,
modificacion_fecha;

    public ProductosModificacionesVO() {
    }
     

    public ProductosModificacionesVO(String id_modificacion_producto, String ProNombre, String Antiguo_PrecioUnidad, String Modificado_PrecioUnidad, String Antiguo_ProStock, String Modificado_ProStock, String Accion, String modificacion_fecha) {
        this.id_modificacion_producto = id_modificacion_producto;
        this.ProNombre = ProNombre;
        this.Antiguo_PrecioUnidad = Antiguo_PrecioUnidad;
        this.Modificado_PrecioUnidad = Modificado_PrecioUnidad;
        this.Antiguo_ProStock = Antiguo_ProStock;
        this.Modificado_ProStock = Modificado_ProStock;
        this.Accion = Accion;
        this.modificacion_fecha = modificacion_fecha;
    }

    public ProductosModificacionesVO(String ProNombre, String Antiguo_PrecioUnidad, String Modificado_PrecioUnidad, String Antiguo_ProStock, String Modificado_ProStock, String Accion, String modificacion_fecha) {
        this.ProNombre = ProNombre;
        this.Antiguo_PrecioUnidad = Antiguo_PrecioUnidad;
        this.Modificado_PrecioUnidad = Modificado_PrecioUnidad;
        this.Antiguo_ProStock = Antiguo_ProStock;
        this.Modificado_ProStock = Modificado_ProStock;
        this.Accion = Accion;
        this.modificacion_fecha = modificacion_fecha;
    }

    public String getId_modificacion_producto() {
        return id_modificacion_producto;
    }

    public void setId_modificacion_producto(String id_modificacion_producto) {
        this.id_modificacion_producto = id_modificacion_producto;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getAntiguo_PrecioUnidad() {
        return Antiguo_PrecioUnidad;
    }

    public void setAntiguo_PrecioUnidad(String Antiguo_PrecioUnidad) {
        this.Antiguo_PrecioUnidad = Antiguo_PrecioUnidad;
    }

    public String getModificado_PrecioUnidad() {
        return Modificado_PrecioUnidad;
    }

    public void setModificado_PrecioUnidad(String Modificado_PrecioUnidad) {
        this.Modificado_PrecioUnidad = Modificado_PrecioUnidad;
    }

    public String getAntiguo_ProStock() {
        return Antiguo_ProStock;
    }

    public void setAntiguo_ProStock(String Antiguo_ProStock) {
        this.Antiguo_ProStock = Antiguo_ProStock;
    }

    public String getModificado_ProStock() {
        return Modificado_ProStock;
    }

    public void setModificado_ProStock(String Modificado_ProStock) {
        this.Modificado_ProStock = Modificado_ProStock;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    public String getModificacion_fecha() {
        return modificacion_fecha;
    }

    public void setModificacion_fecha(String modificacion_fecha) {
        this.modificacion_fecha = modificacion_fecha;
    }

    
    
    
}
