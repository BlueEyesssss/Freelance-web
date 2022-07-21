/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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

import sample.hirer.HirerDTO;
import sample.seeker.SeekerDTO;
import sample.sendemail.SendEmailForHirer;
import sample.skill.SkillDTO;
import sample.user.UserDTO;

@WebServlet(name = "HirerVerifyController", urlPatterns = {"/HirerVerifyController"})
public class HirerVerifyController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            //create instance object of the SendEmail Class
            SendEmailForHirer sm = new SendEmailForHirer();
            //get the 6-digit code
            String code = sm.getRandom();
            //feth form value
            HirerDTO hirer = (HirerDTO) request.getAttribute("HIRER");
            //của seeker
            UserDTO user = null;
            List<SkillDTO> lisSkill = (List<SkillDTO>) session.getAttribute("LIST_SKILL");
            if (lisSkill != null) {
                user = (UserDTO) session.getAttribute("CREATE_USER_SEEKER");
                user.setCode(code);
                
                //cap nhat lai user co code verify email
                session.setAttribute("CREATE_USER_SEEKER", user);
                
                //combine suser in seeker
                SeekerDTO seeker = (SeekerDTO) session.getAttribute("CREATE_USER_SEEKER1");
                seeker.setUser(user);
                //cap nhat lai seeker len session
                session.setAttribute("CREATE_USER_SEEKER1", seeker);
                
                boolean test = sm.sendEmailSeeker(seeker);

                //check if the email send successfully
                if (test) {
                    //put seeker include user have code verify up session
                    session.setAttribute("authcodeSeeker", seeker);
                    request.getRequestDispatcher("verify1.jsp").forward(request, response);

                } else {
                    out.println("Failed to send verification email");
                }
            } else {
                hirer.getUser().setCode(code);

                HirerDTO newHirer = new HirerDTO(hirer.getUser(), hirer.getCompanyName()); //co them cai code

                //craete new user using all information
                //User user = new User(name,email,code);
                //call the send email method
                boolean test = sm.sendEmail(newHirer);

                //check if the email send successfully
                if (test) {
                    session.setAttribute("authcode", newHirer);
                    request.getRequestDispatcher("verify1.jsp").forward(request, response);

                } else {
                    out.println("Failed to send verification email");
                }
            }
            //end
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
