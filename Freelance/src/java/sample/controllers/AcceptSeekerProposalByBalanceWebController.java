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
import javax.servlet.http.HttpSession;
import sample.contract.ContractDAO;
import sample.hirer.HirerDTO;
import sample.proposal.ProposalDAO;
import sample.user.UserDAO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "AcceptSeekerProposalByBalanceWebController", urlPatterns = {"/AcceptSeekerProposalByBalanceWebController"})
public class AcceptSeekerProposalByBalanceWebController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ERROR_PAY_BY_BALANCE = "confirmContract.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDAO daoUser = new UserDAO();

            HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
            String proposalID = (String) request.getParameter("proposalID");
            String projectID = (String) request.getParameter("projectID");
            int seekerid = Integer.parseInt(request.getParameter("seekerID"));
            float paymentAmount = Float.parseFloat(request.getParameter("paymentAmount"));

            //xét xem tài khoản balance hirer còn đủ tiền thanh toán ko
            if (daoUser.getBalanceUser(hirer.getUserID()) < paymentAmount) {
                request.setAttribute("NOT_ENOUGH_MONEY_TO_CASH", "not enough money to hire");
                url = "LoginController?userName=" + hirer.getUserName() + "&password=" + hirer.getPassword();
            } else {
                //trừ balance của hirer
                if (daoUser.minusBalanceHirer(hirer.getUserID(), paymentAmount)) {

                    ProposalDAO dao = new ProposalDAO();
                    //reject hết proposal của project này
                    boolean checkRejectProposal = dao.changeStatusProposalOfProject(Integer.parseInt(projectID), 3);
                    if (checkRejectProposal) {
                        //update lại status của seeker đc hire
                        boolean checkUpdateStatusProposal = dao.updateStatusProposal(seekerid, Integer.parseInt(projectID));
                        LocalDate startTime = LocalDate.now();
                        ContractDAO contractDao = new ContractDAO();
                        boolean checkInsertContract = contractDao.insertContract(Integer.parseInt(proposalID), paymentAmount,startTime);
                        
                        if (checkUpdateStatusProposal&&checkInsertContract) {
                            url = "LoginController?userName=" + hirer.getUserName() + "&password=" + hirer.getPassword();
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("error at AcceptSeekerProposalByBalanceWebController: " + e.getMessage());
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
