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
import sample.hirer.HirerDTO;
import sample.payment.PayPayDTO;
import sample.proposal.ProposalDAO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "UpdateProposalStatusController", urlPatterns = {"/UpdateProposalStatusController"})
public class UpdateProposalStatusController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ERROR_PAY_BY_BALANCE = "confirmContract.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            //thanh toán bằng paypal xong qua đây nè
            //lấy inf cần 
            String proposalID = (String) session.getAttribute("proposalID");
            String projectID = (String) session.getAttribute("projectID");
            PayPayDTO dto = (PayPayDTO) session.getAttribute("PAYPALDTO");
            int seekerid = dto.getSeekerID();

            ProposalDAO dao = new ProposalDAO();
            //reject hết proposal của project này
            boolean checkRejectProposal = dao.changeStatusProposalOfProject(Integer.parseInt(projectID), 3);
            if (checkRejectProposal) {
                //update lại status của seeker đc hire
                boolean checkUpdateStatusProposal = dao.updateStatusProposal(seekerid, Integer.parseInt(projectID));
                LocalDate startTime = LocalDate.now();
                        ContractDAO contractDao = new ContractDAO();
                        ProposalDAO proposalDAO = new ProposalDAO();
                        
                        float paymentAmount = (float) proposalDAO.getProposalByIDForAdminPage(Integer.parseInt(proposalID)).getPaymentAmount();
                        boolean checkInsertContract = contractDao.insertContract(Integer.parseInt(proposalID), paymentAmount,startTime);
                        
                if (checkUpdateStatusProposal&&checkInsertContract) {
                    HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
                    url = "LoginController?userName=" + hirer.getUserName() + "&password=" + hirer.getPassword();
                }
            }

        } catch (Exception e) {
            log("error at UpdateProposalStatusController: " + e.getMessage());
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
