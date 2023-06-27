
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL,
  `CodigoBarras` varchar(45) DEFAULT NULL,
  `ProNombre` varchar(45) DEFAULT NULL,
  `ProStock` int(11) DEFAULT NULL,
  `PrecioUnidad` double DEFAULT NULL,
  `Estado` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 * @author gajop
 */
public class ProductoVO {
    private String idProductos,proNombre,proStock, precioUnidad , Estado;

    public ProductoVO(String idProductos, String proNombre, String proStock, String precioUnidad, String Estado) {
        this.idProductos = idProductos;
        this.proNombre = proNombre;
        this.proStock = proStock;
        this.precioUnidad = precioUnidad;
        this.Estado = Estado;
    }

    public ProductoVO() {
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(String idProductos) {
        this.idProductos = idProductos;
    }

    public String getProStock() {
        return proStock;
    }

    public void setProStock(String proStock) {
        this.proStock = proStock;
    }

    public String getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(String precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
