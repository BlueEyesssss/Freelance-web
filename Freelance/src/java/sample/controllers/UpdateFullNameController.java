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
@WebServlet(name = "UpdateFullNameController", urlPatterns = {"/UpdateFullNameController"})
public class UpdateFullNameController extends HttpServlet {

    private final static String ERROR = "seekerProfile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            String fullName = request.getParameter("fullName");
            String seekerID = request.getParameter("seekerID");
            UserDAO dao = new UserDAO();

            if (fullName.trim().length() < 6 || fullName.trim().length() > 50) {
                checkError = true;
                error.setFullName("must be 6 .. 50 character.");
            }
            for (int i = 0; i < fullName.length(); i++) {
                if ((int) fullName.charAt(i) >= 65 && (int) fullName.charAt(i) <= 90) {
                    //
                } else {
                    if ((int) fullName.charAt(i) >= 97 && (int) fullName.charAt(i) <= 122) {
                        //
                    } else {
                        if((int) fullName.charAt(i) == 32){
                            //
                        }else{
                            checkError = true;
                            error.setFullName("must be alphabet.");
                        }
                    }
                }
            }
            if (checkError == false) {
                if (dao.updateFullUser(seekerID, fullName)) {
                    //cập nhật lại session
                    HttpSession session = request.getSession();
                    SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                    seeker.setFullName(fullName);
                    session.setAttribute("USER_LOGIN", seeker);
                } else {
                    request.setAttribute("ERROR_UPDATE_FULLNAME", "some error, can't update.");
                }
            } else {
                request.setAttribute("ERROR_CREATE", error);
                request.setAttribute("ERROR_CREATE_NOTIFY_FULLNAME", "check again.");
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
