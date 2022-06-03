/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import sample.seeker.SeekerDTO;
import sample.skill.SkillDAO;
import sample.skill.SkillDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "NextChooseSkillController", urlPatterns = {"/NextChooseSkillController"})
public class NextChooseSkillController extends HttpServlet {

    private static final String ERROR = "createAccForSeeker.jsp";
    private static final String SUCCESS = "chooseSkillForSeeker.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            UserDAO dao = new UserDAO();
            SkillDAO daoSkill = new SkillDAO();

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String conform = request.getParameter("conform");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String location = request.getParameter("location");
            float balance = Float.parseFloat(request.getParameter("balance"));
            String registrationDate = java.time.LocalDate.now() + "";
            String overview = request.getParameter("overview");
            int moneyPerHour = Integer.parseInt(request.getParameter("moneyPerHour"));
            String education = request.getParameter("education");
            String titleBio = request.getParameter("titileBio");
            String major = request.getParameter("major");
            String degree = request.getParameter("degree");
            String avatar = request.getParameter("avatar");

            if (userName.trim().length() < 0 || userName.trim().length() > 32) {
                checkError = true;
                error.setUserName("must be 0 .. 32 character.");
            }
            if (dao.checkDuplicateUsername(userName)) {
                checkError = true;
                error.setDuplicate("Username already exists");
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
            if (!conform.equals(password)) {
                checkError = true;
                error.setConfirm("password and confirm not match.");
            }
            if (education.trim().length() < 0 || education.trim().length() > 255) {
                checkError = true;
                error.setLocation("must be 0 .. 255 character.");
            }
            if (dao.checkEmailExist(email) > 3) {
                checkError = true;
                error.setEmailExist("email linked to another account.");
            }
            if (major.trim().length() < 0 || major.trim().length() > 50) {
                checkError = true;
                error.setMajor("major must 0..50 character.");
            }
            if (!avatar.equals("")) {
                if(avatar.trim().length() < 4){
                    checkError = true;
                    error.setAvatar("format must start by https://... or must end by .jpg or .png");
                } else
                if (!avatar.equals(null)) {
                    if (avatar.substring(avatar.length() - 4, avatar.length()).equals(".jpg")
                            || avatar.substring(avatar.length() - 4, avatar.length()).equals(".png")
                            || avatar.substring(0, 8).equals("https://")) {
                        
                    } else{
                        checkError = true;
                        error.setAvatar("format must start by https://... or must end by .jpg or .png");
                    }
                }
            }

            if (checkError == false) {
                if (avatar.equals("")) {
                    avatar = "https://anhdepfree.com/wp-content/uploads/2019/01/avatar-facebook-mau-den_015640017.jpg";
                }
                //tạo user
                UserDTO user = new UserDTO(password, userName, fullName, email, phone, location, registrationDate, balance, avatar);
                //tạo seeker
                SeekerDTO seeker = new SeekerDTO(0, overview, titleBio, moneyPerHour, education, degree, major);

                //---------------------
                System.out.println("in NextChooseSkillController:");
                System.out.println(user.toString());
                System.out.println(seeker.toString());
                System.out.println("----------------------\n");
                //---------------------

                List<SkillDTO> listSkill = daoSkill.getListSkill();
                if (!listSkill.isEmpty()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LIST_SKILL", listSkill);
                    session.setAttribute("CREATE_USER_SEEKER", user);
                    session.setAttribute("CREATE_USER_SEEKER1", seeker);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR_CREATE", error);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                error.setDuplicate("Username already exists");
                request.setAttribute("ERROR_CREATE", error);
            }
            log("Error at NextChooseSkillController:" + e.toString());
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
