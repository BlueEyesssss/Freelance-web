/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.project.ProjectDAO;

import sample.seeker.SeekerDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "CreateFavoriteProjectController", urlPatterns = {"/CreateFavoriteProjectController"})
public class CreateFavoriteProjectController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String ERROR = "ViewSeekerDashboardController";
    private static final String SUCCESS = "ViewSeekerDashboardController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        try {
            //String search = request.getParameter("search");
            int projectID = Integer.parseInt(request.getParameter("projectID"));
            ProjectDAO dao = new ProjectDAO();   
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
            int seekerID = seeker.getSeekerID();
            
            //check coi co duplicate khong
            boolean checkForDuplicate = dao.checkDuplicate(projectID, seekerID);
            if (checkForDuplicate) {
                //bi trung -> xoa 1 favorite
                boolean checkForDeleteFavorite = dao.deleteFavoriteProject(projectID, seekerID);
                if (checkForDeleteFavorite)
                    url = SUCCESS;
                
            } else {
                //truong hop ko bi duplicate -> tao moi favorite
                boolean checkForCreateFavorite = dao.createNewFavoriteProject(projectID, seekerID);
                if (checkForCreateFavorite)
                    url = SUCCESS;
            }
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
            log("Error at CreateFavoriteProjectController: " + e.toString());
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
