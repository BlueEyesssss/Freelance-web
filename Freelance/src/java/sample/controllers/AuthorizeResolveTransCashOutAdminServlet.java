/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.hirer.HirerDTO;
import sample.payment.OrderDetail;
import sample.payment.PayPayDTO;
import sample.payment.PaymentDAO;
import sample.payment.PaymentServices;
import sample.transactionhandling.TransactionHandlingDTO;
import sample.user.UserDAO;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "AuthorizeResolveTransCashOutAdminServlet", urlPatterns = {"/AuthorizeResolveTransCashOutAdminServlet"})
public class AuthorizeResolveTransCashOutAdminServlet extends HttpServlet {
    private static final String ERROR = "error.jsp";
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthorizeRechargeHirerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthorizeRechargeHirerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            HttpSession session = request.getSession();
            int transactionHandlingID = Integer.parseInt(request.getParameter("transactionHandlingID"));
            int userID = Integer.parseInt(request.getParameter("userID"));
            float amountMonney = Float.parseFloat(request.getParameter("amountMonney"));
            Date dateCreate = Date.valueOf(request.getParameter("dateCreate")) ;
            String fullname = request.getParameter("fullname");
            
            String projectName = "withdraw " + amountMonney + " $ money of " + fullname;
            String paymentAmount = amountMonney + "";

            //take client-id, secret of từ userID
            PaymentDAO dao = new PaymentDAO();
            String client_id = dao.getClientID(userID);
            String client_secret = dao.getClientSecret(userID);

            //tạo dto và đưa lên session nhằm cho servlet sau
            PayPayDTO dto = new PayPayDTO(userID, client_id, client_secret);
            TransactionHandlingDTO transInf = new TransactionHandlingDTO(transactionHandlingID, userID, amountMonney, false, dateCreate, null);
            session.setAttribute("PAYPALDTO", dto);
            session.setAttribute("TRANS_INF", transInf);
            session.setAttribute("WITHDRAW", "WITHDRAW");
            session.setAttribute("WITHDRAW_MONEY", paymentAmount);
            

            String product = projectName;
            String subtotal = paymentAmount;
            String shipping = "0";
            String tax = "0";
            String total = paymentAmount;   //total = subtotal + tax + shipping = paymentAmount

            OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);

            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail, client_id, client_secret);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "invalid payment detail");
            request.getRequestDispatcher(ERROR).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
