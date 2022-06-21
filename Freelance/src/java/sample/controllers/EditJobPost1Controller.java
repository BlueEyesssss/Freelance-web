/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditJobPost1Controller", urlPatterns = {"/EditJobPost1Controller"})
public class EditJobPost1Controller extends HttpServlet {

    private static final String ERROR = "error.html";
    private static final String SUCCESS = "ViewHirerDashboardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {

            int projectID = Integer.parseInt(request.getParameter("projectID"));
            String projectName = request.getParameter("projectName");
            String description = request.getParameter("description");
            String complexity = request.getParameter("complexity");
            double budget = Double.parseDouble(request.getParameter("budget"));
            int durationID = Integer.parseInt(request.getParameter("durationID"));
            String deadline = request.getParameter("deadline");
            String location = request.getParameter("location");           
            int hourPerWeek = 0;
            String major = request.getParameter("major");
            String[] skillID = request.getParameterValues("skillID");
            
            ProjectDAO dao = new ProjectDAO();            
//            boolean checkUpdateEdit = dao.updateProject();
            
        } catch (Exception e) {
            log("Error at EditJobPost1Controller:" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
