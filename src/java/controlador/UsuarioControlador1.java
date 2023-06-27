/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO1;
import ModeloVO.UsuarioVO_1;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO_1;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario1"})
public class UsuarioControlador1 extends HttpServlet {

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
        //1.Resibir datos de las vistas , declarar los elmentos necesarios
        String usuId = request.getParameter("usuId");
        String usuLogin= request.getParameter("usuLogin");
        String usuPassword= request.getParameter("usuPassword");
                
        //recoger la opcion
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        //2. canal a que le voy a enviar los datos  que es el VO por el constructor
        UsuarioVO_1 UsuVO = new UsuarioVO_1(usuId,usuLogin,usuPassword);
        //3. Hacer las operaciones del DAO
        UsuarioDAO1 usuDAO = new UsuarioDAO1(UsuVO);//datos que esten en el VEO
        RolDAO rolDAO = new RolDAO();
        RolVO rolVO = new RolVO();
        //4.Administrar operaciones
        switch(opcion)
        {
            case 1://Agregar Registro
                if(usuDAO.agregar())
                {
                    request.setAttribute("MensajeExito", "El usuario se registro de manera correcta");
                    
                }else
                {
                    request.setAttribute("MensajeError", "El usuario no se registro correctamente");
                    
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
                
            case 2: //Actualizar Registro
                 if(usuDAO.actualizar())
                {
                    request.setAttribute("MensajeExito", "El usuario se actualizó de manera correcta");
                    
                }else
                {
                    request.setAttribute("MensajeError", "El usuario no se actualizó correctamente");
                    
                }
                //redireccionar
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;
            case 3: 
                if(usuDAO.borrar())
                {
                    request.setAttribute("Mensaje Exito", "El usuario se borró de manera correcta");

                }else
                {
                    request.setAttribute("Mensaje Error", "El usuario no se borró correctamente");

                }
                //redireccionar
                request.getRequestDispatcher("borrarUsuario.jsp").forward(request, response);
                break;
            case 4:
                if(usuDAO.iniciarSesion(usuLogin,usuPassword))
                {
                    HttpSession miSesion = request.getSession(true);
                    UsuVO = usuDAO.consultarIdUsuario(usuLogin);
                    miSesion.setAttribute("datosUsuario", UsuVO);
                    String idUsuario = UsuVO.getUsuId();
                    
                    ArrayList <RolVO> listaRoles = rolDAO.listar(idUsuario);
                    for(int i=0; i<listaRoles.size(); i++)
                    {
                         rolVO = listaRoles.get(i);
                         if(listaRoles.size()>1)
                         {
                             request.getRequestDispatcher("menu.jsp").forward(request, response);
                         }
                         if(rolVO.getROLID().equals("5000"))
                         {
                             request.getRequestDispatcher("Vista_Administrador.jsp").forward(request, response);
                
                         }
                         if(rolVO.getROLID().equals("5001"))
                         {
                             request.getRequestDispatcher("Vista_Gerente.jsp").forward(request, response);
                
                         }
                         if(rolVO.getROLID().equals("5002"))
                         {
                             request.getRequestDispatcher("Vista_Vendedor.jsp").forward(request, response);
                
                         }
                    }
                }else
                {
                    request.setAttribute("MensajeError", "Datos Incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                
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
