/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import sample.contract.ContractDAO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.seeker.SeekerDAO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "PayMoneyController", urlPatterns = {"/PayMoneyController"})
public class PayMoneyController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "ViewHirerDashboardController";
    private static final String ERROR = "error.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            int proposalID = Integer.parseInt(request.getParameter("proposalID"));
            
            ProposalDAO proposalDAO = new ProposalDAO();
            ProposalDTO proposal = proposalDAO.getProposalByIDReturnSeekerID(proposalID);
            
            
            UserDAO userDAO = new UserDAO();
            UserDTO user = userDAO.getUserByID(proposal.getSeekerID());
            float currentBalance = user.getBalance();
            
            boolean check = userDAO.addMoneyToUserByUserID(currentBalance + proposal.getPaymentAmount(), proposal.getSeekerID());
            if (check) {
                boolean checkChangeStatusProposal = proposalDAO.changeStatusProposal(proposalID, 7);
                ContractDAO contractDao = new ContractDAO();
                LocalDate endTime = LocalDate.now();
                boolean updateEndTimeContract = contractDao.updateEndTimeContract(proposalID,endTime);
                if(checkChangeStatusProposal&&updateEndTimeContract){
                    url = SUCCESS;
                }                 
            }
                    
        } catch (Exception e) {
            log("error at PayMoneyController: " + e.getMessage());
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
