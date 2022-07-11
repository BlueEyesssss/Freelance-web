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
import javax.servlet.http.HttpSession;
import sample.contract.ContractDAO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddMoneyToSeekerController", urlPatterns = {"/AddMoneyToSeekerController"})
public class AddMoneyToSeekerController extends HttpServlet {

    private final static String ERROR = "error.html";
    private final static String SUCCESS = "index.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {           
            int proposalID = Integer.parseInt(request.getParameter("proposalID"));
            ProposalDAO proposalDao = new ProposalDAO();
            ProposalDTO proposal = proposalDao.getProposalByIDForAdminPage(proposalID);
            int seekerID = proposal.getSeekerID();
            UserDAO userDao = new UserDAO();
            UserDTO seeker = userDao.getUserByID(seekerID);
            
            boolean checkUpdateBalance = userDao.addMoneyToUserByUserID(proposal.getPaymentAmount()+seeker.getBalance(), seeker.getUserID());
            if(checkUpdateBalance){
                boolean checkChangeStatusProposal = proposalDao.changeStatusProposal(proposalID, 7); 
                ContractDAO contractDao = new ContractDAO();
                LocalDate endTime = LocalDate.now();
                boolean updateEndTimeContract = contractDao.updateEndTimeContract(proposalID,endTime);
                if(checkChangeStatusProposal&&updateEndTimeContract){
                    url = SUCCESS;
                }             
            }
          
        } catch (Exception e) {
            log("Error at AddMoneyToSeekerController: " + e.toString());
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
