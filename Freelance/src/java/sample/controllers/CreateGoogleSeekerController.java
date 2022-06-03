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
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErrorDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "CreateGoogleSeekerController", urlPatterns = {"/CreateGoogleSeekerController"})
public class CreateGoogleSeekerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
     
    private static final String ERROR = "createAccForSeeker.jsp";
    private static final String SUCCESS = "seekerDashboard.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkError = false;
        UserErrorDTO error = new UserErrorDTO();
        try {
            UserDAO dao = new UserDAO();
            
            String userName = request.getParameter("userName");
            
           
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String location = request.getParameter("location");
            float balance = Float.parseFloat(request.getParameter("balance"));
            String registrationDate = java.time.LocalDate.now() + "";
            
            String overview = request.getParameter("overview");
            String titileBio = request.getParameter("titileBio");
            int moneyPerHour = Integer.parseInt(request.getParameter("moneyPerHour"));
            String education = request.getParameter("education");
            
            if(userName.trim().length() < 0 || userName.trim().length() > 32){
                checkError = true;
                error.setUserName("must be 0 .. 32 character.");
            }
            
            if(fullName.trim().length() < 0 || fullName.trim().length() > 32){
                checkError = true;
                error.setFullName("must be 0 .. 32 character.");
            }
            if(email.trim().length() < 10 || email.trim().length() > 128){
                checkError = true;
                error.setEmail("format must be ...@gmail.com and length must be 10 .. 128 character.");
            }else if(!email.substring(email.length() - 10, email.length()).equals("@gmail.com")){
                checkError = true;
                error.setEmail("format must be ...@gmail.com.");
            }
            if(phone.trim().length() < 0 || phone.trim().length() > 10){
                checkError = true;
                error.setPhone("must be 0 .. 10 character.");
            }
            if(location.trim().length() < 0 || location.trim().length() > 255){
                checkError = true;
                error.setLocation("must be 0 .. 255 character.");
            }
            
            if(titileBio.trim().length() < 0 || titileBio.trim().length() > 255){
                checkError = true;
                error.setLocation("must be 0 .. 255 character.");
            }
            if(education.trim().length() < 0 || education.trim().length() > 255){
                checkError = true;
                error.setLocation("must be 0 .. 255 character.");
            }
            if(dao.checkEmailExist(email) > 3){
                checkError = true;
                error.setEmailExist("email linked to another account.");
            }
            
            
            if(checkError == false){
                //tạo user
                UserDTO user = new UserDTO("12345798", userName, fullName, email, phone, location, registrationDate, balance, null);

                boolean checkCreateAcc = dao.createUser(user);
                if(checkCreateAcc){
                    //tạo seeker
                    int seekerID = dao.getUser(userName, "12345798").getUserID();
                    SeekerDTO seeker = new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education, null, null);

                    boolean checkCreateSeeker = dao.createSeeker(seeker);
                    if(checkCreateSeeker){
                        url = SUCCESS;
                    }
                }
            }else{
               request.setAttribute("ERROR_CREATE", error); 
            }
            
        } catch (Exception e) {
            if(e.toString().contains("duplicate")){
                error.setDuplicate("Username already exists");
                request.setAttribute("ERROR_CREATE", error);
            }
            log("error at CreateHirerController: " + e.getMessage());
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
