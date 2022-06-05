/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.hirer.HirerDTO;
import sample.seeker.SeekerDTO;
import sample.skill.SkillDAO;
import sample.skill.SkillDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String SEEKER_PAGE = "ViewSeekerDashboardController";
    private static final String HIRER_PAGE = "hirerDashboard.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            SkillDAO daoSkill = new SkillDAO();
            UserDTO user = new UserDTO();
            SeekerDTO seeker = new SeekerDTO();
            HirerDTO hirer = new HirerDTO();
            user = dao.getUser(username, password);
            if(user != null){
                HttpSession session = request.getSession();
                
                //check xem nó có phải seeker hay ko
                    //1.lấy seeker ra
                seeker = dao.checkAccSeeker(user.getUserID());
                    //2.check null
                if(seeker != null){
                    seeker.setUserID(user.getUserID());
                    seeker.setPassword(user.getPassword());
                    seeker.setUserName(user.getUserName());
                    seeker.setFullName(user.getFullName());
                    seeker.setEmail(user.getEmail());
                    seeker.setPhone(user.getPhone());
                    seeker.setLocation(user.getLocation());
                    seeker.setRegistrationDate(user.getRegistrationDate());
                    seeker.setBalance(user.getBalance());
                    seeker.setAvatar(user.getAvatar());
                    seeker.setLanguage(user.getLanguage());
                    seeker.setLanguagelv(user.getLanguagelv());
                    
                    session.setAttribute("USER_LOGIN", seeker);
                    
                    //lấy listID các skill của seeker
                    List<SkillDTO> listSkillSeeker = daoSkill.getListSkillIDOfSeeker(seeker.getSeekerID());
                    session.setAttribute("LIST_SKILL_OF_SEEKER", listSkillSeeker);
                    
                    //lấy list skill trong Skill
                    List<SkillDTO> listSkillAll = daoSkill.getListSkill();
                    session.setAttribute("LIST_SKILL_ALL", listSkillAll);
                    
                    url = SEEKER_PAGE;
                } else{ //tương tự vs Hirer
                            //1.lấy hirer
                    hirer = dao.checkAccHirer(user.getUserID()); 
                            //2.check hirer
                    if(hirer != null){ 
                        hirer.setUserID(user.getUserID());
                        hirer.setPassword(user.getPassword());
                        hirer.setUserName(user.getUserName());
                        hirer.setFullName(user.getFullName());
                        hirer.setEmail(user.getEmail());
                        hirer.setPhone(user.getPhone());
                        hirer.setLocation(user.getLocation());
                        hirer.setRegistrationDate(user.getRegistrationDate());
                        hirer.setBalance(user.getBalance());
                        hirer.setAvatar(user.getAvatar());
                        hirer.setLanguage(user.getLanguage());
                        hirer.setLanguagelv(user.getLanguagelv());

                        session.setAttribute("USER_LOGIN", hirer);
                        url = HIRER_PAGE;
                    }
                }
            }else{
                request.setAttribute("LOGIN_ERROR", "username or password don't correct");
            }
        } catch (Exception e) {
            log("error at LoginController: " + e.getMessage());
        }finally{
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
