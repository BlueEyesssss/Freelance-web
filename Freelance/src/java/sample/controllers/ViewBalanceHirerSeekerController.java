/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import sample.seeker.SeekerDTO;
import sample.transactionhandling.TransactionHandlingDAO;
import sample.transactionhandling.TransactionHandlingDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ViewBalanceHirerSeekerController", urlPatterns = {"/ViewBalanceHirerSeekerController"})
public class ViewBalanceHirerSeekerController extends HttpServlet {

    private final String ERROR = "error.html";
    private final String SUCCESS_HIRER = "balancePageHIrer.jsp";
    private final String SUCCESS_SEEKER = "balancePageSeeker.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();

            //balance cua hirer
            if (request.getParameter("role") == null) {
                HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");

                TransactionHandlingDAO dao = new TransactionHandlingDAO();
                //lấy list history transaction của rút tiền
                List<TransactionHandlingDTO> listTransactionHistory = dao.getListTranHistory(hirer.getHirerID());

                request.setAttribute("LIST_TRANSACTION_HITORY", listTransactionHistory);

                url = SUCCESS_HIRER;
                
                //balance cua seeker
            }else if(request.getParameter("role").equals("seeker")){
                SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                
                TransactionHandlingDAO dao = new TransactionHandlingDAO();
                //lấy list history transaction của rút tiền
                List<TransactionHandlingDTO> listTransactionHistory = dao.getListTranHistory(seeker.getSeekerID());

                request.setAttribute("LIST_TRANSACTION_HITORY", listTransactionHistory);

                url = SUCCESS_SEEKER;
            }

        } catch (Exception e) {
            log("Error at ViewBalanceHirerSeekerController: " + e.toString());
            e.printStackTrace();
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
