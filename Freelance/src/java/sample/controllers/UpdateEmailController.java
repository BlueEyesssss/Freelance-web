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
@WebServlet(name = "UpdateEmailController", urlPatterns = {"/UpdateEmailController"})
public class UpdateEmailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR_SEEKER = "seekerProfile.jsp";
    private static final String SUCCESS_SEEKER = "seekerProfile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_SEEKER;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            String email = request.getParameter("email");
            String Whodo = request.getParameter("Whodo");
            String userID = request.getParameter("userID");
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");

            if (!email.equals(seeker.getEmail())) {
                if (dao.checkEmailExist(email) > 0) {
                    checkError = true;
                    error.setEmailExist("\"" + email + "\" linked to another account.");
                }
            }

            if (checkError == false) {
                //format correct
                boolean checkUpdate = dao.updateEmail(email, userID);
                if (checkUpdate) {
                    if (Whodo.equals("seeker")) {
                        url = SUCCESS_SEEKER;
                        request.setAttribute("UPDATE_STATUS", "update email success");
                        //cap nhat lai seeker len session
                        seeker.setEmail(email);
                        session.setAttribute("USER_LOGIN", seeker);
                    }
                } else {
                    request.setAttribute("ERROR_UPDATE_EMAIL_SEEKER", "something wrong, check again.");
                }
            } else {
                request.setAttribute("ERROR_CREATE", error);
            }

        } catch (Exception e) {
            log("error at UpdateEmailController: " + e.getMessage());
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
