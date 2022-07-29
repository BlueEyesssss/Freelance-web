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
import sample.sendemail.SendEmailForHirer;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "sendEmailToSeekerNotifyAproveReportController", urlPatterns = {"/sendEmailToSeekerNotifyAproveReportController"})
public class sendEmailToSeekerNotifyAproveReportController extends HttpServlet {

   private static final String SUCCESS = "index.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            UserDTO seeker = (UserDTO) request.getAttribute("SEEKER");
            String projectName = (String) request.getAttribute("PROJECT_NAME");
            SendEmailForHirer sm = new SendEmailForHirer();
            boolean test = sm.sendEmailToSeekerNotifyAproveReport(seeker, projectName);

            //check if the email send successfully
            if (test) {
                request.getRequestDispatcher(SUCCESS).forward(request, response);
            } else {
                request.getRequestDispatcher(SUCCESS).forward(request, response);
            }
        } catch (Exception e) {
                        log("error at sendEmailToSeekerNotifyAproveReportController: " + e.getMessage());

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
