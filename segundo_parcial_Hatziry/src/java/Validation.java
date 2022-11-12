/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import JavaClass.User;
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
@WebServlet(urlPatterns = {"/Validation"})
public class Validation extends HttpServlet {

    User usuario;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            usuario = new User();
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if (user.equals("") || pass.equals("")) {
                request.setAttribute("success", 0);
                request.setAttribute("mensaje", "Campo usuario y contraseña son requeridos");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

            String usuarioConsultado = usuario.validarUsuario(request.getParameter("user"), request.getParameter("pass"));
            if (usuarioConsultado.equals(request.getParameter("user"))) {
                request.getSession().setAttribute("user", request.getParameter("user"));
                request.getSession().setAttribute("pass", request.getParameter("pass"));
                response.sendRedirect(request.getContextPath() + "/UserController");
            } else {
                request.setAttribute("success", 0);
                request.setAttribute("mensaje", "Usuario y/o contraseña no encontrado");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
