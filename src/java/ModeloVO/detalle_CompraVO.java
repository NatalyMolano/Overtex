package ModeloVO;

/**
 *
 * @author natal
 */
public class detalle_CompraVO 
{
    private String id_DetalleCompra,IdCompra,IdProducto,NomProducto, cantidad,PrecioUnitario,subtotal;

    public detalle_CompraVO(String IdProducto, String NomProducto, String cantidad, String PrecioUnitario, String subtotal) {
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

    public detalle_CompraVO() {
    }

    public String getId_DetalleCompra() {
        return id_DetalleCompra;
    }

    public void setId_DetalleCompra(String id_DetalleCompra) {
        this.id_DetalleCompra = id_DetalleCompra;
    }

    public String getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(String IdCompra) {
        this.IdCompra = IdCompra;
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

    public detalle_CompraVO(String id_DetalleCompra, String IdProducto, String NomProducto, String cantidad, String PrecioUnitario, String subtotal) {
        this.id_DetalleCompra = id_DetalleCompra;
        this.IdProducto = IdProducto;
        this.NomProducto = NomProducto;
        this.cantidad = cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.subtotal = subtotal;
    }

    

    

    
    
    
}
