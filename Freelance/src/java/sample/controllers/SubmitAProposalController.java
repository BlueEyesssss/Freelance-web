/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.proposal.ProposalDAO;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubmitAProposalController", urlPatterns = {"/SubmitAProposalController"})
public class SubmitAProposalController extends HttpServlet {

    private static final String ERROR = "ViewSeekerDashboardController";
    private static final String SUCCESS = "ViewSeekerDashboardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER_LOGIN");
            int projectID = Integer.parseInt(request.getParameter("projectID"));
            double paymentAmount = Double.parseDouble(request.getParameter("paymentAmount"));
            int durationID = Integer.parseInt(request.getParameter("durationID"));
            String coverLetter = request.getParameter("coverLetter");
            String attachment = request.getParameter("attachment");
            ProposalDAO dao = new ProposalDAO();
            boolean checkIsActiveProposal = dao.isActiveProposal(projectID);
            boolean checkAlreadySubmitProposal = dao.alreadySubmitProposal(projectID,user.getUserID());
            if (!checkIsActiveProposal || !checkAlreadySubmitProposal) {
                boolean checkSubmitProposal = dao.submitProposal(projectID, user.getUserID(), paymentAmount,durationID, coverLetter, attachment);
                if (checkSubmitProposal) {
                    url = SUCCESS;
                }
            }else{
                request.setAttribute("ERROR_MESSAGE", "Job invalid");//hien o dau?
            }

        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
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
