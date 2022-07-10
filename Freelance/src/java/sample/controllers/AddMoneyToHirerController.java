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
import javax.servlet.http.HttpSession;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddMoneyToHirerController", urlPatterns = {"/AddMoneyToHirerController"})
public class AddMoneyToHirerController extends HttpServlet {

    private final static String ERROR = "error.html";
    private final static String SUCCESS = "index.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String proposalID = request.getParameter("proposalID");
            ProposalDAO dao = new ProposalDAO();
            ProposalDTO proposal = dao.getProposal(Integer.parseInt(proposalID));
            int hireID = proposal.getHirerID();
            UserDAO userDao = new UserDAO();
            UserDTO hirer = userDao.getUserByID(hireID);
            
            boolean checkUpdateBalance = userDao.addMoneyToUserByUserID(proposal.getPaymentAmount()+hirer.getBalance(), hirer.getUserID());
            if(checkUpdateBalance){
                url = SUCCESS;
            }
            } catch (Exception e) {
            log("Error at AddMoneyToHirerController: " + e.toString());
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
