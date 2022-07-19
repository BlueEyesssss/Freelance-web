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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sample.seeker.SeekerDTO;
import sample.skill.SkillDAO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErrorDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CreateSeekerController", urlPatterns = {"/CreateSeekerController"})
public class CreateSeekerController extends HttpServlet {

    private static final String ERROR = "chooseSkillForSeeker.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDAO dao = new UserDAO();
            SkillDAO daoSkill = new SkillDAO();

            UserDTO user = (UserDTO) session.getAttribute("CREATE_USER_SEEKER");
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("CREATE_USER_SEEKER1");
            //Part avatar = (Part) session.getAttribute("AVATAR_SEEKER");
            //String pathSaveAvatar = (String) session.getAttribute("PATH_SAVE_AVATAR_SEEKER");

            System.out.println(user.toString());
            System.out.println(seeker.toString());

            //tạo user
            boolean checkCreateAcc = dao.createUser(user);
            if (checkCreateAcc) {
                //tạo seeker
                int seekerID = dao.getUser(user.getUserName(), user.getPassword()).getUserID();
                seeker.setSeekerID(seekerID);

                boolean checkCreateSeeker = dao.createSeeker(seeker);
                if (checkCreateSeeker) {

                    //lấy skill name
                    String[] listSkillID = request.getParameterValues("skillID");
                    if (listSkillID == null) {
                        //nếu ko chn5 skill nào

                        //avatar.write(pathSaveAvatar);
                        //xóa session giữ list skill đi
                        session.invalidate();
                        url = SUCCESS;
                    } else {
                        //nếu có chọn skill
                        for (String skill : listSkillID) {
                            System.out.println(skill);
                        }
                        boolean checkWrongCreateSkillSeeker = false;
                        for (String skillID : listSkillID) {
                            boolean checkCreateSkillSeeker = daoSkill.createSkillSeekerHas(Integer.parseInt(skillID), seekerID);
                            if (!checkCreateSkillSeeker) {
                                checkWrongCreateSkillSeeker = true;
                                break;
                            }
                        }
                        if (checkWrongCreateSkillSeeker) {
                            request.setAttribute("CREATE_SKILL_SEEKER_HAS", "OOps, something wrong went create skill for seeker.");
                        } else {
                            //avatar.write(pathSaveAvatar);
                            //xóa session giữ list skill đi
                            session.invalidate();
                            url = SUCCESS;
                        }
                    }

                }
            }

        } catch (Exception e) {
            log("error at CreateSeekerController: " + e.getMessage());
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
