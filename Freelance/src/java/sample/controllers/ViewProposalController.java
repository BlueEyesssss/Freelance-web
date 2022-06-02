/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.seeker.SeekerDTO;


/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewProposalController", urlPatterns = {"/ViewProposalController"})
public class ViewProposalController extends HttpServlet {

    private static final String ERROR = "proposalPage.jsp";
    private static final String SUCCESS = "proposalPage.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            SeekerDTO seeker = (SeekerDTO)session.getAttribute("USER_LOGIN");
            int userID = seeker.getUserID();
            ProposalDAO dao = new ProposalDAO();
            
            List<ProposalDTO> listOfferProposal = dao.getListOfferProposal(userID);
            if (listOfferProposal.size() > 0) {
                request.setAttribute("LIST_OFFER_PROPOSAL", listOfferProposal);
                url = SUCCESS;
            }
            
            List<ProposalDTO> listInvitationProposal = dao.getListInvitationProposal(userID);
            if (listInvitationProposal.size() > 0) {
                request.setAttribute("LIST_INVITATIONS_PROPOSAL", listInvitationProposal);
                url = SUCCESS;
            }
            
            List<ProposalDTO> listActiveProposal = dao.getListActiveProposal(userID);
            if (listActiveProposal.size() > 0) {
                request.setAttribute("LIST_ACTIVE_PROPOSAL", listActiveProposal);
                url = SUCCESS;
            }
            
            List<ProposalDTO> listSubmittedProposal = dao.getListSubmittedProposal(userID);
            if (listSubmittedProposal.size() > 0) {
                request.setAttribute("LIST_SUBMITTED_PROPOSAL", listSubmittedProposal);
                url = SUCCESS;
            }
            
        } catch (Exception e) {
            log("Error at SearchCOntroller: " + e.toString());
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
