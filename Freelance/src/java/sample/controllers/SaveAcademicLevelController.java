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
import sample.seeker.SeekerDAO;
import sample.seeker.SeekerDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "SaveAcademicLevelController", urlPatterns = {"/SaveAcademicLevelController"})
public class SaveAcademicLevelController extends HttpServlet {
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
                String education = request.getParameter("education");
                String degree = request.getParameter("degree");
                String major = request.getParameter("major");
                SeekerDAO daoSeeker = new SeekerDAO();
                if(daoSeeker.UpdateEducation(seeker.getSeekerID(), education)
                        && daoSeeker.UpdateDegree(seeker.getSeekerID(), degree)
                        && daoSeeker.UpdateMajor(seeker.getSeekerID(), major)){
                    //cập nhật lại seeker
                    seeker.setEducation(education);
                    seeker.setDegree(degree);
                    seeker.setMajor(major);
                    session.setAttribute("USER_LOGIN", seeker);
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR_UPDATE_INF_SEEKER", "update academic level fail.");
                }
            }
            
        } catch (Exception e) {
            log("Error at SaveAcademicLevelController:" + e.toString());
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
