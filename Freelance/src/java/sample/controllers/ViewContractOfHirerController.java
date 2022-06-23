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
import sample.hirer.HirerDTO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ViewContractOfHirerController", urlPatterns = {"/ViewContractOfHirerController"})
public class ViewContractOfHirerController extends HttpServlet {

    private static final String ERROR = "contractsPageHirer.jsp";
    private static final String SUCCESS = "contractsPageHirer.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            HirerDTO hirer = (HirerDTO)session.getAttribute("USER_LOGIN");
            int userID = hirer.getUserID();
            ProposalDAO dao = new ProposalDAO();
                        
            List<ProposalDTO> listActiveProposal = dao.getListActiveProposalOfHirer(userID);
            if (listActiveProposal.size() > 0) {
                request.setAttribute("LIST_ACTIVE_PROPOSAL", listActiveProposal);
                url = SUCCESS;
            }
            
            List<ProposalDTO> listDoneProposal = dao.getListDoneProposalOfHirer(userID);
            if (listDoneProposal.size() > 0) {
                request.setAttribute("LIST_DONE_PROPOSAL", listDoneProposal);
                url = SUCCESS;
            }
            
            
            List<ProposalDTO> listWaitingProposal = dao.getListWaitingProposalOfHirer(userID);
            if (listWaitingProposal.size() > 0) {
                request.setAttribute("LIST_WAITING_PROPOSAL", listWaitingProposal);
                url = SUCCESS;
            }
            
        } catch (Exception e) {
            log("Error at ViewContractOfHirerController : " + e.toString());
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
