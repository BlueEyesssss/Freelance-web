/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.payment.PayPayDTO;
import sample.payment.PaymentServices;
import sample.transactionhandling.TransactionHandlingDAO;
import sample.transactionhandling.TransactionHandlingDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ExecutePaymentServlet", urlPatterns = {"/ExecutePaymentServlet"})
public class ExecutePaymentServlet extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "UpdateProposalStatusController";//
    private static final String SUCCESS_RECHARGE_HIRER = "UpdateBalnceAfterRechargeOfHirerController";//
    private static final String SUCCESS_WITHDRAW = "LoginController?userName=admin&password=1";//
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExecutePaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExecutePaymentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //Làm ở doPost
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
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        String url = ERROR;
        try {
            HttpSession session  =request.getSession();
            PayPayDTO dto = (PayPayDTO) session.getAttribute("PAYPALDTO");
            String recharge = (String) session.getAttribute("RECHRAGE_HIRER");  //nạp tiền vào balance web
            String withdraw = (String) session.getAttribute("WITHDRAW");    //rút từ balance web ra paypal
            if(withdraw != null){
                TransactionHandlingDAO dao = new TransactionHandlingDAO();
                TransactionHandlingDTO tran = (TransactionHandlingDTO) session.getAttribute("TRANS_INF");
                //set status lại cho trans thành 1
                if(dao.updateStatusTransTo1(tran)){
                    //cập nhật date resolve cái transaction ấy
                    dao.updateDateDone(tran.getTransactionHandlingID());
                    url = SUCCESS_WITHDRAW;
                }
            }else if(recharge != null){
                url = SUCCESS_RECHARGE_HIRER;
            }else{
                url = SUCCESS;
            }
           
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId, dto.getClient_id(), dto.getClient_secret());   
            
            request.getRequestDispatcher(url).forward(request, response);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", "could not execure payment");
            ex.printStackTrace();
            request.getRequestDispatcher(ERROR).forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("errorMessage", "could not execure payment - sql exception");
            ex.printStackTrace();
            request.getRequestDispatcher(ERROR).forward(request, response);
        } 

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
