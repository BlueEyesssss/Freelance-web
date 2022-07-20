/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "UpdateLocationController", urlPatterns = {"/UpdateLocationController"})
public class UpdateLocationController extends HttpServlet {
    private final static String ERROR = "seekerProfile.jsp";
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
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            String location = request.getParameter("location");
            String seekerID = request.getParameter("seekerID");
            UserDAO dao = new UserDAO();

            if (location.trim().length() < 6 || location.trim().length() > 50) {
                checkError = true;
                error.setLocation("must be 6 .. 50 character.");
            }
            if (checkError == false) {
                if (dao.updateLocationUser(seekerID, location)) {
                    //cập nhật lại session
                    HttpSession session = request.getSession();
                    SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                    seeker.setLocation(location);
                    session.setAttribute("USER_LOGIN", seeker);
                } else {
                    request.setAttribute("ERROR_UPDATE_LOCATION", "some error, can't update.");
                }
            }else{
                request.setAttribute("ERROR_CREATE", error);
                request.setAttribute("ERROR_CREATE_NOTIFY_LOCATION", "check again.");
            }

        } catch (Exception e) {
            log("error at UpdateFullNameController: " + e.getMessage());
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
