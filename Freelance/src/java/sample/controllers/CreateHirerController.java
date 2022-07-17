/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sample.hirer.HirerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@MultipartConfig
@WebServlet(name = "CreateHirerController", urlPatterns = {"/CreateHirerController"})
public class CreateHirerController extends HttpServlet {

    private static final String ERROR = "createAccForHirer.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            UserDAO dao = new UserDAO();

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String conform = request.getParameter("conform");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String location = request.getParameter("location");
            float balance = 0;
            String registrationDate = java.time.LocalDate.now() + "";
            //String avatar = request.getParameter("avatar");

            String conpanyName = request.getParameter("conpanyName");

            String uploadFolder = getServletContext().getRealPath("/uploads");
            Path uploadPath = Paths.get(uploadFolder);
            String filename = "";
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Part photoPart = request.getPart("avatar");
            if (photoPart != null) {
                if (photoPart.getSize() > (1024 * 1024 * 8)) {
                    checkError = true;
                    error.setAvatar("format must must end by .jpg or .png and <8MB");
                }
                filename = photoPart.getSubmittedFileName();
                if (!filename.equals("")) {
                    if (filename.trim().length() < 4) {
                        checkError = true;
                        error.setAvatar("format must must end by .jpg or .png and <8MB");
                    } else if (!filename.equals(null)) {
                        if (filename.substring(filename.length() - 4, filename.length()).equals(".jpg")
                                || filename.substring(filename.length() - 4, filename.length()).equals(".png")) {

                        } else {
                            checkError = true;
                            error.setAvatar("format must must end by .jpg or .png and <8MB");
                        }
                    }
                }
            }

            if (userName.trim().length() < 6 || userName.trim().length() > 20) {
                checkError = true;
                error.setUserName("must be 6 .. 20 character.");
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                checkError = true;
                error.setPassword("must be 6 .. 20 character.");
            }
            if (fullName.trim().length() < 6 || fullName.trim().length() > 50) {
                checkError = true;
                error.setFullName("must be 6 .. 50 character.");
            }
            if (email.trim().length() < 10 || email.trim().length() > 128) {
                checkError = true;
                error.setEmail("format must be ...@gmail.com and length must be 10 .. 128 character.");
            } else if (!email.substring(email.length() - 10, email.length()).equals("@gmail.com")) {
                checkError = true;
                error.setEmail("format must be ...@gmail.com.");
            }
            if (dao.checkEmailExist(email) > 3) {
                checkError = true;
                error.setEmailExist("email linked to another account.");
            }
            if (phone.trim().length() != 10) {
                checkError = true;
                error.setPhone("must be 10 numbers.");
            }
            try {
                Integer.parseInt(phone.trim());
            } catch (NumberFormatException e) {
                checkError = true;
                error.setPhone("must be 10 numbers.");
            }
            if (location.trim().length() < 6 || location.trim().length() > 50) {
                checkError = true;
                error.setLocation("must be 6 .. 50 character.");
            }
            if (!conform.equals(password)) {
                checkError = true;
                error.setConfirm("password and confirm not match.");
            }
            if (conpanyName.trim().length() < 6 || conpanyName.trim().length() > 50) {
                checkError = true;
                error.setConpanyName("must be 6 .. 50 character.");
            }
            if (checkError == false) {
                //tạo user
                UserDTO user = new UserDTO(password, userName, fullName, email, phone, location, registrationDate, balance, filename);

                boolean checkCreateAcc = dao.createUser(user);
                if (checkCreateAcc) {
                    //tạo hirer
                    int hirerID = dao.getUser(userName, password).getUserID();
                    HirerDTO hirer = new HirerDTO(hirerID, conpanyName);

                    boolean checkCreateHirer = dao.createHirer(hirer);
                    if (checkCreateHirer) {
                        photoPart.write(Paths.get(uploadPath.toString(), filename).toString());
                        url = SUCCESS;
                    }
                }
            } else {
                request.setAttribute("ERROR_CREATE", error);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                error.setDuplicate("Username already exists");
                request.setAttribute("ERROR_CREATE", error);
            }
            log("error at CreateHirerController: " + e.getMessage());
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
