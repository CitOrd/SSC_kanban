/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import Control.PreparatoriaControl;
import Dominio.Preparatoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Citlali Orduño
 */
public class AgregarPreparatoria extends HttpServlet {

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
          RequestDispatcher rd= null;
       
       if(request.getParameter("boton").equals("Cancelar")){
           rd= request.getRequestDispatcher("RegistrarEscuela.jsp");
       }else{
          Preparatoria preparatoria= new Preparatoria();
           
          HttpSession session= request.getSession();
          
          
          preparatoria.setNombre(request.getParameter("nombre"));
          preparatoria.setClave(request.getParameter("clave"));
          preparatoria.setResponsable(request.getParameter("responsable"));
          preparatoria.setImagen(request.getParameter("imagen"));
          
          PreparatoriaControl ctrlPreparatoria= new PreparatoriaControl();
          ctrlPreparatoria.agregar(preparatoria);
          
          session.setAttribute("tareaSel", "RegistrarEscuela");
          
          rd= request.getRequestDispatcher("RegistrarEscuela");
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
