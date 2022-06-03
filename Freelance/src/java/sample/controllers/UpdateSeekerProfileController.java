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
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "UpdateSeekerProfileController", urlPatterns = {"/UpdateSeekerProfileController"})
public class UpdateSeekerProfileController extends HttpServlet {

    private static final String ERROR = "seekerProfile.jsp";
    private static final String SUCCESS = "seekerProfile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                SeekerDTO user_login = (SeekerDTO) session.getAttribute("USER_LOGIN");
                UserDAO dao = new UserDAO();
                int userID = Integer.parseInt(request.getParameter("userID"));
                int seekerID = Integer.parseInt(request.getParameter("seekerID"));
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                String fullName = request.getParameter("fullName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String location = request.getParameter("location");
                String registrationDate = request.getParameter("registrationDate");
                float balance = Float.parseFloat(request.getParameter("balance"));
                String avatar = request.getParameter("avatar");

                String overview = request.getParameter("overview");
                String titileBio = request.getParameter("titileBio");
                int moneyPerHour = Integer.parseInt(request.getParameter("moneyPerHour"));
                String education = request.getParameter("education");
                String major = request.getParameter("major");
                String degree = request.getParameter("degree");

                UserDTO user = new UserDTO(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar);

                if (userName.trim().length() < 0 || userName.trim().length() > 32) {
                    checkError = true;
                    error.setUserName("must be 0 .. 32 character.");
                }
                if (password.trim().length() < 0 || password.trim().length() > 32) {
                    checkError = true;
                    error.setPassword("must be 0 .. 32 character.");
                }
                if (fullName.trim().length() < 0 || fullName.trim().length() > 32) {
                    checkError = true;
                    error.setFullName("must be 0 .. 32 character.");
                }
                if (email.trim().length() < 10 || email.trim().length() > 128) {
                    checkError = true;
                    error.setEmail("format must be ...@gmail.com and length must be 10 .. 128 character.");
                } else if (!email.substring(email.length() - 10, email.length()).equals("@gmail.com")) {
                    checkError = true;
                    error.setEmail("format must be ...@gmail.com.");
                }
                if (phone.trim().length() < 0 || phone.trim().length() > 10) {
                    checkError = true;
                    error.setPhone("must be 0 .. 10 character.");
                }
                if (location.trim().length() < 0 || location.trim().length() > 255) {
                    checkError = true;
                    error.setLocation("must be 0 .. 255 character.");
                }
                if (titileBio.trim().length() < 0 || titileBio.trim().length() > 255) {
                    checkError = true;
                    error.setLocation("must be 0 .. 255 character.");
                }
                if (education.trim().length() < 0 || education.trim().length() > 255) {
                    checkError = true;
                    error.setLocation("must be 0 .. 255 character.");
                }
                if (!email.equals(user_login.getEmail())) {
                    if (dao.checkEmailExist(email) > 3) {
                        checkError = true;
                        error.setEmailExist("email linked to another account.");
                    }
                }
                if (!avatar.equals(null)) {
                    if (!avatar.substring(avatar.length() - 4, avatar.length()).equals(".jpg")
                            || !avatar.substring(avatar.length() - 4, avatar.length()).equals(".png")
                            || !avatar.substring(0, 8).equals("https://")) {
                        checkError = true;
                        error.setAvatar("format must start by https://... or must end by .jpg or .png");
                    }
                }
                if (major.trim().length() < 0 || major.trim().length() > 50) {
                    checkError = true;
                    error.setMajor("major must 0..50 character.");
                }

                if (checkError == false) {
                    boolean checkUpdateUser = dao.UpdateUserProfile(user);
                    if (checkUpdateUser) {
                        SeekerDTO seeker = new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education, degree, major);
                        boolean checkUpdateSeeker = dao.UpdateSeekerProfile(seeker);
                        if (checkUpdateSeeker) {
                            //cập nhật lại USER_LOGIN

                            UserDTO userAfterUpdate = dao.getUser(userName, password);

                            SeekerDTO seekerAfterUpdate = dao.checkAccSeeker(seekerID);
                            seekerAfterUpdate.setUserID(user.getUserID());
                            seekerAfterUpdate.setPassword(user.getPassword());
                            seekerAfterUpdate.setUserName(user.getUserName());
                            seekerAfterUpdate.setFullName(user.getFullName());
                            seekerAfterUpdate.setEmail(user.getEmail());
                            seekerAfterUpdate.setPhone(user.getPhone());
                            seekerAfterUpdate.setLocation(user.getLocation());
                            seekerAfterUpdate.setRegistrationDate(user.getRegistrationDate());
                            seekerAfterUpdate.setBalance(user.getBalance());

                            session.setAttribute("USER_LOGIN", seekerAfterUpdate);

                            request.setAttribute("UPDATE_STATUS", "Update successfully.");

                            url = SUCCESS;

                        } else {
                            request.setAttribute("UPDATE_STATUS", "Update error.");
                        }
                    } else {
                        request.setAttribute("UPDATE_STATUS", "Update error.");
                    }
                } else {
                    request.setAttribute("ERROR_UPDATE", error);
                }
            }
        } catch (Exception e) {
            log("error at UpdateSeekerProfileController: " + e.getMessage());
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
