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
import sample.transactionhandling.TransactionHandlingDAO;
import sample.user.UserDAO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CashOutHirerController", urlPatterns = {"/CashOutHirerController"})
public class CashOutHirerController extends HttpServlet {

    private final String ERROR = "error.html";
    private final String SUCCESS = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
            int moneyCashout = Integer.parseInt(request.getParameter("moneyCashout"));

            //tạo 1 record của transaction handling
            TransactionHandlingDAO dao = new TransactionHandlingDAO();
            if (dao.createHirerCashOut(hirer.getUserID(), moneyCashout)) {
                //tru tien trong tai khoang web cua hirer di
                UserDAO daoUser = new UserDAO();
                if (daoUser.UpdateBalanceAfterCashOutH(hirer.getUserID(), moneyCashout+"")) {
                    url = "LoginController?userName=" + hirer.getUserName() + "&password=" + hirer.getPassword();
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
