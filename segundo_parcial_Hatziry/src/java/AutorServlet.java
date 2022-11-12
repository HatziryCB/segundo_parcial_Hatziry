/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import JavaClass.Autor;
import JavaClass.Libro;
import JavaClass.RegistroAutor;
import JavaClass.RegistroLibro;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hatziry Chacón
 */
@WebServlet(urlPatterns = {"/AutorServlet"})
public class AutorServlet extends HttpServlet {
    Autor autor;
    RegistroAutor registroAutor;
    StringBuffer objetoRespuesta = new StringBuffer();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            try ( PrintWriter respuesta = response.getWriter()) {
             registroAutor = new RegistroAutor();
            String control = request.getParameter("control");

            if (control.toUpperCase().equals("GUARDAR")) {
                autor = new Autor(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("nombre"),
                    request.getParameter("genero"),
                    request.getParameter("origen"),
                    request.getParameter("fecha"));

                registroAutor.guardarLibroBD(autor);//Almacenar en BD

            } else if (control.toUpperCase().equals("ELIMINAR")) {
                int codigoEliminar = Integer.parseInt(request.getParameter("codigo_autor"));//Nombre de encabezado de tabla Mysql con not null
                registroAutor.eliminarLibro(codigoEliminar);
            }

            registroAutor.getClientes2(objetoRespuesta);//consultar registro cliente en el BD
            respuesta.write(objetoRespuesta.toString());
        }
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
