/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import sample.hirer.HirerDTO;
import sample.payment.PaymentDAO;
import sample.seeker.SeekerDTO;
import sample.transactionhandling.TransactionHandlingDAO;
import sample.user.UserDAO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CashOutHirerController", urlPatterns = {"/CashOutHirerController"})
public class CashOutHirerController extends HttpServlet {

    private final String ERROR = "error.html";
    private final String ERROR_NOT_ENOUGH_MONEY = "ViewBalanceHirerSeekerController";
    private static final String ERROR_NOT_HAVE_BALANCE_KEY = "ViewHirerProfileController";
    private final String SUCCESS = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (request.getParameter("role") == null) {

                //check xem balance key của seeker có chưa
                //  1.lấy seeker
                HirerDTO hirer1 = (HirerDTO) session.getAttribute("USER_LOGIN");
                //  2.check balance key
                PaymentDAO paymentDAO = new PaymentDAO();
                String client_id = paymentDAO.getClientID(hirer1.getUserID());
                String client_secret = paymentDAO.getClientSecret(hirer1.getUserID());
                if (client_id == null || client_secret == null) {
                    request.setAttribute("UNKNOWN_BALANCE_KEY", "please update your PayPal key (id, secret) and then you can do this previous action");
                    //request.getRequestDispatcher("ViewSeekerProfileController").forward(request, response);
                    url = ERROR_NOT_HAVE_BALANCE_KEY;
                } else {
                    HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
                    int moneyCashout = Integer.parseInt(request.getParameter("moneyCashout"));

                    //check xem money rút có lớn hơn balance hiện có trong web ko
                    UserDAO daoUser = new UserDAO();
                    if (moneyCashout > daoUser.getBalanceUser(hirer.getUserID())) {
                        request.setAttribute("ERROR_NOT_ENOUGH_MONEY", "Not enough money to withdraw.");
                        url = ERROR_NOT_ENOUGH_MONEY;
                    } else {
                        //tạo 1 record của transaction handling
                        TransactionHandlingDAO dao = new TransactionHandlingDAO();
                        if (dao.createHirerCashOut(hirer.getUserID(), moneyCashout)) {
                            //tru tien trong tai khoang web cua hirer di
                            if (daoUser.UpdateBalanceAfterCashOutH(hirer.getUserID(), moneyCashout + "")) {
                                url = "LoginController?userName=" + hirer.getUserName() + "&password=" + hirer.getPassword();
                            }
                        }
                    }
                }
            } else if (request.getParameter("role").equals("seeker")) {

                SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                int moneyCashout = Integer.parseInt(request.getParameter("moneyCashout"));

                //check xem money rút có lớn hơn balance hiện có trong web ko
                UserDAO daoUser = new UserDAO();
                if (moneyCashout > daoUser.getBalanceUser(seeker.getUserID())) {
                    request.setAttribute("ERROR_NOT_ENOUGH_MONEY", "Not enough money to withdraw.");
                    url = ERROR_NOT_ENOUGH_MONEY;
                } else {
                    //tạo 1 record của transaction handling
                    TransactionHandlingDAO dao = new TransactionHandlingDAO();
                    if (dao.createHirerCashOut(seeker.getUserID(), moneyCashout)) { //hàm createHirerCashOut() dùng luôn cho seeker cũng đc
                        //tru tien trong tai khoang web cua seeker di

                        if (daoUser.UpdateBalanceAfterCashOutH(seeker.getUserID(), moneyCashout + "")) {
                            url = "LoginController?userName=" + seeker.getUserName() + "&password=" + seeker.getPassword();
                        }
                    }
                }
            }

        } catch (Exception e) {
            log("Error at CashOutHirerController: " + e.toString());
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
