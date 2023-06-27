/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ClienteDAO;
import ModeloDAO.CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedoresDAO;
import ModeloDAO.VentaDAO;
import ModeloDAO.detalle_CompraDAO;
import ModeloDAO.detalle_VentaDAO;
import ModeloVO.ClienteVO;
import ModeloVO.CompraVO;
import ModeloVO.ProductoVO;
import ModeloVO.ProveedoresVO;
import ModeloVO.VentaVO;
import ModeloVO.detalle_CompraVO;
import ModeloVO.detalle_VentaVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gajop
 */
@WebServlet(name = "productoControlador", urlPatterns = {"/Producto"})
public class productoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //producto
        String Opcion = request.getParameter("opcion");
        String idProductos = request.getParameter("idPro");
        String ProNombre = request.getParameter("ProNombre");
        String ProStock = request.getParameter("ProStock");
        String Estado = request.getParameter("Estado");

        //proveedor
        String Documento = request.getParameter("Documento");
        String ProvNombre = request.getParameter("ProvNombre");
        String ProvApellido = request.getParameter("ProvApellido");
        String NombreEmpresa = request.getParameter("NombreEmpresa");
        String Telefono = request.getParameter("Telefono");

        //compra
        String idCompra = request.getParameter("IdCompra");
        String idproveedores = request.getParameter("idproveedores");
        String idGerente = request.getParameter("idGerente");
        String MontoCompra = request.getParameter("MontoCompra");
        String Mes = request.getParameter("Mes");

        //detalle compra
        String idDetalleCompra = request.getParameter("IdDetalleCompra");
        String idProductoParaCompra = request.getParameter("idProducto");
        String precioCompra = request.getParameter("PrecioUnidad");
        String cantidad = request.getParameter("Cantidad");
        String subtotal = request.getParameter("subtotal");

        //Intancia Proveedores
        ProveedoresVO ProVO = new ProveedoresVO(idproveedores, Documento, ProvNombre, ProvApellido, NombreEmpresa, Telefono);
        ProveedoresDAO ProDAO = new ProveedoresDAO(ProVO);//datos que esten en el VO

        //Intacia de PRoducto
        ProductoVO proVO = new ProductoVO(idProductos, ProNombre, ProStock, precioCompra, Estado);
        ProductoDAO proDAO = new ProductoDAO(proVO);

        //Intacia Compra con diferentes parametros para el VO
        CompraVO comVO = new CompraVO(idCompra, idproveedores, idGerente, MontoCompra, Estado);
        CompraVO ComVO = new CompraVO(idCompra, idProductoParaCompra, cantidad, precioCompra);
        
        CompraVO comMes = new CompraVO(Mes);

        CompraDAO comDAO = new CompraDAO(comVO);
        CompraDAO ComDAO = new CompraDAO(ComVO);
        CompraDAO comDAOMes = new CompraDAO(comMes);
        
        //cliente
        String TelefonoCli = request.getParameter("TelefonoCli");
        String CliNombre = request.getParameter("CliNombre");

        //venta
        String idVenta = request.getParameter("IdVenta");
        String idCliente = request.getParameter("idCliente");
        String idUsuario = request.getParameter("idUsuario");
        String MontoVenta = request.getParameter("MontoVenta");
        String cantidadVenta = request.getParameter("cantidadVenta");

        //detalle venta
        String idDetalleVenta = request.getParameter("IdDetalleVenta");
        String idProductoParaVenta = request.getParameter("idProducto");
        String precioVenta = request.getParameter("precioVenta");
         String subtotalVenta = request.getParameter("subtotalVenta");

        //Intancia cliente
        ClienteVO cliVO = new ClienteVO(idCliente, CliNombre, TelefonoCli, Documento, Estado);
        ClienteDAO cliDAO = new ClienteDAO(cliVO);
        
        
        //Intacia Compra con diferentes parametros para el VO
        VentaVO venVO = new VentaVO(idVenta, idCliente, idUsuario, MontoVenta, Estado);
        VentaVO venVO1 = new  VentaVO(idVenta, idProductoParaVenta, cantidadVenta, precioVenta);
        
        VentaVO venMes = new VentaVO(Mes);
        
        VentaDAO venDAO = new  VentaDAO(venVO);
        VentaDAO venDAO1 = new  VentaDAO(venVO1);
        VentaDAO venDAOMes = new VentaDAO(venMes);

        //Intancia detalle compra
        detalle_VentaVO deVenVO = new detalle_VentaVO(idDetalleVenta, idVenta, idProductos, cantidadVenta, precioVenta, subtotal);
        detalle_VentaDAO deVenDAO = new detalle_VentaDAO(deVenVO);
        
         
        detalle_CompraVO deComVO = new detalle_CompraVO(idDetalleCompra, idCompra, idProductos, cantidad, precioCompra, subtotal);
        detalle_CompraDAO deComDAO = new detalle_CompraDAO(deComVO);
        switch (Opcion) {

            case "registrarVenta"://Agregar Registro
                //clienteEncontrado y producto encontrado
                
                if (venDAO.agregar()) {
                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;

            case "registrarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO1.agregarDetalleVenta()) {

                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;

            case "registrarCliente"://Agregar Registro
                if (cliDAO.agregar()) {
                    request.setAttribute("MensajeExito", "El clinte se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "El cliente no se registro correctamente");

                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;

            case "agregarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO1.agregarDetalleVenta()) {

                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;

            case "agregarProducto"://Agregar registro
                if (proDAO.agregar()) {
                    request.setAttribute("mensajeExito", "El producto se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse registro correctamente");
                }
                request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                break;

            case "actualizar"://actualizar registro

                if (proDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse actualizo correctamente");
                }
                request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                break;
                
               case "actualizarCliente":
                
                if (cliDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "El cliente se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El cliente  no se actualizo correctamente");
                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;
                
            case "actualizarVenta"://actualizar registro
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "la venta se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "La venta NOse actualizo correctamente");
                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;
                
            case "borrar"://eliminar registro b¿vamos aqui              

                if (proDAO.borrar()) {
                    request.setAttribute("mensajeExito", "El producto se elimino correctamente");
                } else {
                   request.setAttribute("mensajeError", "El producto NOse elimino correctamente");
                }
                request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                break;
              
            case "borrarCliente"://eliminar registro
               
                if (cliDAO.borrar()) {
                    request.setAttribute("mensajeExito", "El cliente se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El clinte NOse elimino correctamente");
                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;
                
            case "borrarventa"://eliminar registro

                if (venDAO.borrar()) {
                    request.setAttribute("mensajeExito", "La venta se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "La venta NO se elimino correctamente");
                }
                request.getRequestDispatcher("AdministradorListarCompra.jsp").forward(request, response);
                break;

            case "borrarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (deVenDAO.borrarDetalleVenta()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;
                
            case "borrarDetalleVenta1":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (deVenDAO.borrarDetalleVenta()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;   
            case "consultarVentaMensual":
                venMes = venDAOMes.consultarPorMes(Mes);
                if (venMes != null) {
                    request.setAttribute("Ventaencontrado", venMes);
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "la venta no existe");
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                }
                break;

            case "consultarCliente":
                cliVO = cliDAO.consultarPorDocumento(Documento);/*recibir el VO*/
                if (cliVO != null) {

                    request.setAttribute("clienteEncontrado", cliVO);
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El cliente no existe");
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);

                }
                //redireccionar
                break;

            case "consultarCliente1":
                cliVO = cliDAO.consultarPoridCliente(Documento);/*recibir el VO*/
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                if (cliVO != null) {
                    
                    request.setAttribute("clienteEncontrado", cliVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El cliente no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);

                }
                //redireccionar
                break;

            case "consultarcodigoVenta":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("clinteEncontrado", cliVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                }
                break;

            case "consultarcodigoVenta1":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("ventaparaconsultar", venVO);
                    request.setAttribute("clinteEncontrado", cliVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                }
                break;

            case "consultarPorVenta":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (venVO != null) {

                    request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("AdministradorListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("AdministradorListarVenta.jsp").forward(request, response);
                }
                break;

            case "consultarPorVenta1":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (venVO != null) {
                    request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                }
                break;

            case "consultarPorVentaActualizar":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (venVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                   request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                }
                break;

        

            case "registrarCompra"://Agregar Registro
                request.setAttribute("proveedorEncontrado", ProVO);
                request.setAttribute("productoencontrado", proVO);
                if (comDAO.agregar()) {
                    request.setAttribute("MensajeExito", "La compra se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La compra no se registro correctamente");

                }
                request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);
                break;

            case "registrarDetalleCompra":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("proveedorEncontrado", ProVO);
                if (ComDAO.agregarDetalleCompra()) {

                    request.setAttribute("MensajeExito", "La compra se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La compra no se registro correctamente");

                }
                request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);
                break;

            

            case "agregarDetalleCompra":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("compraparaconsultar", comVO);
                request.setAttribute("proveedorEncontrado", ProVO);
                if (ComDAO.agregarDetalleCompra()) {

                    request.setAttribute("MensajeExito", "La compra se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La compra no se registro correctamente");

                }
                request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                break;

            
                
               

            case "actualizarCompra"://actualizar registro
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("compraparaconsultar", comVO);
                request.setAttribute("proveedorEncontrado", ProVO);
                if (comDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse actualizo correctamente");
                }
                request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                break;

            
                
            

            case "borrarcompra"://eliminar registro

                if (comDAO.borrar()) {
                    request.setAttribute("mensajeExito", "El producto se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse elimino correctamente");
                }
                request.getRequestDispatcher("AdministradorListarCompra.jsp").forward(request, response);
                break;

            case "borrarDetalleCompra":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("proveedorEncontrado", ProVO);
                if (deComDAO.borrarDetalleCompra()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);
                break;

            case "borrarDetalleCompra1":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("compraparaconsultar", comVO);
                request.setAttribute("proveedorEncontrado", ProVO);
                if (deComDAO.borrarDetalleCompra()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                break;

            case "consultarcodigo":
                proVO = proDAO.consultarporCodigo(idProductos);
                if (proVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                }
                break;

            case "consultaractualizar":
                proVO = proDAO.consultarporCodigo(idProductos);
                if (proVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
                }
                break;
                
                
            case "consultarCrompraMensual":
                comMes = comDAOMes.consultarPorMes(Mes);
                if (comMes != null) {
                    request.setAttribute("compraencontrado", comMes);
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                }
                break;

            case "consultarProveedor":
                ProVO = ProDAO.consultarPorProveedor(Documento);/*recibir el VO*/
                if (ProVO != null) {

                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);

                }
                //redireccionar
                break;

            case "consultarProveedor1":
                ProVO = ProDAO.consultarPorProveedor(Documento);/*recibir el VO*/
                request.setAttribute("productoencontrado", proVO);
                    request.setAttribute("compraparaconsultar", comVO);
                if (ProVO != null) {
                    
                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);

                }
                //redireccionar
                break;

            case "consultarcodigoCompra":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);
                }
                break;

            case "consultarcodigoCompra1":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("compraparaconsultar", comVO);
                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                }
                break;

            case "consultarPorCompra":
                comVO = comDAO.consultarPorCompra(idCompra);
                if (comVO != null) {

                    request.setAttribute("compraparaconsultar", comVO);
                    request.getRequestDispatcher("AdministradorListarCompra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("AdministradorListarCompra.jsp").forward(request, response);
                }
                break;

            case "consultarPorCompra1":
                comVO = comDAO.consultarPorCompra(idCompra);
                if (comVO != null) {

                    request.setAttribute("compraparaconsultar", comVO);
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                }
                break;

            case "consultarPorCompraActualizar":
                comVO = comDAO.consultarPorCompra(idCompra);
                if (comVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                    request.setAttribute("compraparaconsultar", comVO);
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Compra.jsp").forward(request, response);
                }
                break;
                
            case "consultarcomisiones": 
               venVO =venDAO.consultarPoridVendedor(Mes,idUsuario);
                if(venVO != null)
                {
                    request.setAttribute("comisionEncontrada", venVO);
                    request.getRequestDispatcher("Venta_Comisiones.jsp").forward(request, response);

                }else
                {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Venta_Comisiones.jsp").forward(request, response);

                }
                //redireccionar
                break;

        }
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
