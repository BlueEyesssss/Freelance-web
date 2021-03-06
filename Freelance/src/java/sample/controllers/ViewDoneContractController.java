/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewDoneContractController", urlPatterns = {"/ViewDoneContractController"})
public class ViewDoneContractController extends HttpServlet {

    private static final String ERROR = "error.html";
    private static final String SUCCESS = "feedbackOfSeekerBeauti.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int proposalID = Integer.parseInt(request.getParameter("proposalID"));
            String error = (String)request.getAttribute("ERROR_MESSAGE");
            ProposalDAO dao = new ProposalDAO();
            boolean checkAlreadlyFeedback = dao.checkFeedbackOfSeeker(proposalID);
            ProposalDTO proposal = dao.getProposalByID(proposalID);
            LocalDate endDate = LocalDate.parse(dao.getEndDateOfContract(proposalID));            
            if(proposal!= null){
                request.setAttribute("PROPOSAL", proposal);
                request.setAttribute("END_DATE", endDate);
                request.setAttribute("CHECK_FEEDBACK_ALREADY", checkAlreadlyFeedback);
                request.setAttribute("ERROR_MESSAGE", error);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at ViewDoneContractController: " + e.toString());
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
