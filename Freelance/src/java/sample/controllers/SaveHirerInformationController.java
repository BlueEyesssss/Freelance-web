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
import sample.user.UserDAO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "SaveHirerInformationController", urlPatterns = {"/SaveHirerInformationController"})
public class SaveHirerInformationController extends HttpServlet {

    private static final String ERROR = "hirerProfile.jsp";
    private static final String SUCCESS = "hirerProfile.jsp";

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
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            HttpSession session = request.getSession(false);
            UserDAO dao = new UserDAO();
            if (session != null) {
                HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
                String fullName = request.getParameter("fullName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String location = request.getParameter("location");
                //check fullname
                if (fullName.trim().length() < 6 || fullName.trim().length() > 50) {
                    checkError = true;
                    error.setFullName("must be 6 .. 50 character.");
                }
                //check email
                if (email.trim().length() < 10 || email.trim().length() > 128) {
                    checkError = true;
                    error.setEmail("\""+email+"\" must be ...@gmail.com and length must be 10 .. 128 character.");
                } else if (!email.substring(email.length() - 10, email.length()).equals("@gmail.com")) {
                    checkError = true;
                    error.setEmail("\""+email+"\" must be ...@gmail.com.");
                }
                if (email.equals(hirer.getEmail())) {

                } else {
                    if (dao.checkEmailExist(email) > 0) {
                        checkError = true;
                        error.setEmailExist("\""+email+"\" linked to another account.");
                    }
                }

                //check phone
                if (phone.trim().length() != 10) {
                    checkError = true;
                    error.setPhone("\""+phone+"\" must be 10 numbers.");
                }
                try {
                    Integer.parseInt(phone.trim());
                } catch (NumberFormatException e) {
                    checkError = true;
                    error.setPhone("\""+phone+"\" must be 10 numbers.");
                }
                if (phone.equals(hirer.getPhone())) {

                } else {
                    if (dao.checkPhone(phone) > 0) {
                        checkError = true;
                        error.setPhone("\""+phone+"\" linked to another account.");
                    }
                }

                //check location
                if (location.trim().length() < 6 || location.trim().length() > 50) {
                    checkError = true;
                    error.setLocation("\""+location+"\" must be 6 .. 50 character.");
                }
                if (checkError == false) {
                    //đúng hết format rồi
                    //cập nhật lại hirer
                    hirer.setFullName(fullName);
                    hirer.setEmail(email);
                    hirer.setPhone(phone);
                    hirer.setLocation(location);
                    if (dao.UpdateUserProfile1(hirer)) {
                        //cập nhật lại hire rlen6 session
                        session.setAttribute("USER_LOGIN", hirer);
                        request.setAttribute("UPDATE_INF_HIRER_1", "update success");
                        url = SUCCESS;
                    } else {
                        request.setAttribute("UPDATE_INF_HIRER_1_FAIL", "update fail");
                    }
                } else {
                    request.setAttribute("ERROR_UPDATE_INF_HIRER_1", error);
                    request.setAttribute("ERROR_UPDATE_INF_HIRER_FORMAT_1", "check format again.");
                }
            }
        } catch (Exception e) {
            log("Error at SaveHirerInformationController:" + e.toString());
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
