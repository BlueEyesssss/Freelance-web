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
import sample.sendemail.SendEmailForHirer;
import sample.user.UserDTO;




@WebServlet(name = "HirerVerifyController", urlPatterns = {"/HirerVerifyController"})
public class HirerVerifyController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //feth form value
           HirerDTO hirer = (HirerDTO) request.getAttribute("HIRER");
           
      		//create instance object of the SendEmail Class
           SendEmailForHirer sm = new SendEmailForHirer();
      		//get the 6-digit code
           String code = sm.getRandom();
           
           hirer.getUser().setCode(code);
           
           HirerDTO newHirer = new HirerDTO( hirer.getUser(), hirer.getCompanyName()); //co them cai code
           
      		//craete new user using all information
           //User user = new User(name,email,code);
           
           //call the send email method
           boolean test = sm.sendEmail(newHirer);
           
      		//check if the email send successfully
           if(test){
               HttpSession session  = request.getSession();
               
               session.setAttribute("authcode", newHirer);
               request.getRequestDispatcher("verify1.jsp").forward(request, response);
              
           }else{
      		  out.println("Failed to send verification email");
      	   }
           
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
