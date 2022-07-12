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
import sample.payment.PayPayDTO;
import sample.payment.PaymentDAO;
import sample.seeker.SeekerDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "UpdateClientIDSecretOfSeekerController", urlPatterns = {"/UpdateClientIDSecretOfSeekerController"})
public class UpdateClientIDSecretOfSeekerController extends HttpServlet {

    private static final String ERROR = "seekerDashboard.jsp";
    private static final String SUCCESS = "ViewSeekerDashboardController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
            String client_id = request.getParameter("client_id");
            String client_secret = request.getParameter("client_secret");

            PaymentDAO dao = new PaymentDAO();
            //check xem đã có client id và key trc đó chưa
            if (dao.getClientID(seeker.getUserID()) != null && dao.getClientID(seeker.getUserID()) != null) {
                //co roi thi update lai moi
                if (dao.updateClientIdSecretOfSeeker(seeker.getUserID(), client_id, client_secret)) {
                    //cap nhat lai tren session
                    PayPayDTO paypalInf = new PayPayDTO(seeker.getUserID(), client_id, client_secret);
                    session.setAttribute("PAYPAL_INF", paypalInf);
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR_UPDATE_PAYPAL_INF_SEEKER", "can't update balance key");
                }
            }else{
                //chua co thi insert moi vao
                if(dao.createPayPalInf(new PayPayDTO(seeker.getUserID(), client_id, client_secret))){
                    //cap nhat lai tren session
                    PayPayDTO paypalInf = new PayPayDTO(seeker.getUserID(), client_id, client_secret);
                    session.setAttribute("PAYPAL_INF", paypalInf);
                   url = SUCCESS;
                } else {
                    request.setAttribute("ERROR_UPDATE_PAYPAL_INF_SEEKER", "can't update balance key");
                }
            }

        } catch (Exception e) {
            log("error at UpdateClientIDSecretOfSeekerController: " + e.getMessage());
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
