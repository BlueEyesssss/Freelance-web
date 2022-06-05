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
import sample.seeker.SeekerDAO;
import sample.seeker.SeekerDTO;
import sample.skill.SkillDAO;
import sample.skill.SkillDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "SaveSkillController", urlPatterns = {"/SaveSkillController"})
public class SaveSkillController extends HttpServlet {
    private static final String ERROR = "seekerProfile.jsp";
    private static final String SUCCESS = "seekerProfile.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession(false);
            if(session != null){
                SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                SkillDAO daoSkill = new SkillDAO();
                //clear skill current
                daoSkill.clearSkillSeeker(seeker.getSeekerID());
                    //lay list skill name checked
                    String[] listSkillIDToSave = request.getParameterValues("skillID");
                    for (String skill : listSkillIDToSave) {
                            System.out.println(skill);
                        }
                        boolean checkWrongCreateSkillSeeker = false;
                        for (String skillID : listSkillIDToSave) {
                            boolean checkCreateSkillSeeker = daoSkill.createSkillSeekerHas(Integer.parseInt(skillID), seeker.getSeekerID());
                            if(!checkCreateSkillSeeker){
                                checkWrongCreateSkillSeeker = true;
                                break;
                            }
                        }
                        if(checkWrongCreateSkillSeeker){
                            request.setAttribute("CREATE_SKILL_SEEKER_HAS", "OOps, something wrong went create skill for seeker.");
                        }else{
                            //reload listID các skill của seeker
                            List<SkillDTO> listSkillSeeker = daoSkill.getListSkillIDOfSeeker(seeker.getSeekerID());
                            session.setAttribute("LIST_SKILL_OF_SEEKER", listSkillSeeker);
                            url = SUCCESS;
                        }
            }
        } catch (Exception e) {
            log("Error at SaveSkillController:" + e.toString());
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
