/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sample.hirer.HirerDTO;
import sample.user.UserDAO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@MultipartConfig
@WebServlet(name = "UpdateAvatarController", urlPatterns = {"/UpdateAvatarController"})
public class UpdateAvatarController extends HttpServlet {
    private static final  String ERROR = "hirerProfile.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            String hirerID = request.getParameter("hirerID");
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
            if (checkError == false) {
                UserDAO dao = new UserDAO();
                
                if(dao.updateAvatarUser(hirerID, filename)){
                    photoPart.write(Paths.get(uploadPath.toString(), filename).toString());
                    //cập nhật lại session
                    HttpSession session  =request.getSession();
                    HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
                    hirer.setAvatar(filename);
                    session.setAttribute("USER_LOGIN", hirer);
                }
            } else {
                request.setAttribute("ERROR_CREATE", error);
                request.setAttribute("ERROR_CREATE_NOTIFY_AVATAR", "can't update, check again.");
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(ERROR).forward(request, response);
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
