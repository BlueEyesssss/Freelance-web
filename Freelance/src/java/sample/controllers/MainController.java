/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.html";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH_JOB_BY_NAME = "Search Job By Name";
    private static final String SEARCH_JOB_BY_NAME_CONTROLLER = "SearchJobByNameController";
    private static final String SEARCH_JOB_BY_COMPANY = "Search Job By Company";
    private static final String SEARCH_JOB_BY_COMPANY_CONTROLLER = "SearchJobByCompanyController";
    private static final String VIEW_ALL_PROJECT = "ViewAllProject";
    private static final String VIEW_ALL_PROJECT_CONTROLLER = "ViewAllProjectController";
    private static final String VIEW_FAVORITE_PROJECT = "ViewFavoriteProject";
    private static final String VIEW_FAVORITE_PROJECT_CONTROLLER = "ViewFavoriteProjectController";
    private static final String VIEW_BEST_MATCH_PROJECT = "ViewBestMatchProject";
    private static final String VIEW_BEST_MATCH_PROJECT_CONTROLLER = "ViewBestMatchProjectController";
    private static final String CREATE_ACC_HIRER = "Create Hirer";
    private static final String CREATE_ACC_HIRER_CONTROLLER = "CreateHirerController";
    private static final String CREATE_ACC_SEEKER = "Create Seeker";
    private static final String CREATE_ACC_SEEKER_CONTROLLER = "CreateSeekerController";
    private static final String FILTER_HIRER = "FilterHirer";
    private static final String FILTER_HIRER_CONTROLLER = "FilterHirerController";
    private static final String FILTER_PRICE = "FilterPrice";
    private static final String FILTER_PRICE_CONTROLLER = "FilterPriceController";
    private static final String FILTER_DURATION = "FilterDuration";
    private static final String FILTER_DURATION_CONTROLLER = "FilterDurationController";
    private static final String FILTER_LEVEL = "FilterLevel";
    private static final String FILTER_LEVEL_CONTROLLER = "FilterLevelController";
    private static final String CREATE_FAVORITE_PROJECT = "CreateFavoriteProject";
    private static final String CREATE_FAVORITE_PROJECT_CONTROLLER = "CreateFavoriteProjectController";
    private static final String VIEW_PROPOSAL = "ViewProposal";
    private static final String VIEW_PROPOSAL_CONTROLLER = "ViewProposalController";
    private static final String UPDATE_PROFILE_SEEKER = "Update Profile";
    private static final String UPDATE_PROFILE_SEEKER_CONTROLLER = "UpdateSeekerProfileController";
    private static final String CREATE_GOOGLE_SEEKER = "CreateGoogleSeeker";
    private static final String CREATE_GOOGLE_SEEKER_CONTROLLER = "CreateGoogleSeekerController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String NEXT_CHOOSE_SKILL = "Next";
    private static final String NEXT_CHOOSE_SKILL_CONTROLLER = "NextChooseSkillController";
    private static final String VIEW_SEEKER_DASHBOARD = "ViewSeekerDashboard";
    private static final String VIEW_SEEKER_DASHBOARD_CONTROLLER = "ViewSeekerDashboardController";
    private static final String SAVE_HOUR_PER_WEEK = "Save Hour Per Week";
    private static final String SAVE_HOUR_PER_WEEK_CONTROLLER = "SaveHourPerWeekController";
    private static final String SAVE_LANG_LV = "Save Language Level";
    private static final String SAVE_LANG_LV_CONTROLLER = "SaveLanguageLevelController";
    private static final String SAVE_ACADEMIC_LV = "Save Academic level";
    private static final String SAVE_ACADEMIC_LV_CONTROLLER = "SaveAcademicLevelController";
    private static final String SAVE_PASSWORD = "Save Password";
    private static final String SAVE_PASSWORD_CONTROLLER = "SavePasswordController";
    private static final String SAVE_TITLE = "Save Title";
    private static final String SAVE_TITLE_CONTROLLER = "SaveTitleController";
    private static final String SAVE_HOUR_RATE = "Save Hour Rate";
    private static final String SAVE_HOUR_RATE_CONTROLLER = "SaveHourRateController";
    private static final String SAVE_OVERVIEW = "Save Overview";
    private static final String SAVE_OVERVIEW_CONTROLLER = "SaveOverviewController";
    private static final String SAVE_SKILL = "Save Skill";
    private static final String SAVE_SKILL_CONTROLLER = "SaveSkillController";
    private static final String VIEW_SEEKER_PROFILE = "ViewSeekerProfile";
    private static final String VIEW_SEEKER_PROFILE_CONTROLLER = "ViewSeekerProfileController";
    private static final String FORM_SENT_PROPOSAL = "FormSentProposal";
    private static final String FORM_SENT_PROPOSAL_CONTROLLER = "FormSentProposalController";    
    private static final String SUBMIT_A_PROPOSAL = "SubmitAProposal";
    private static final String SUBMIT_A_PROPOSAL_CONTROLLER = "SubmitAProposalController";
    private static final String VIEW_CONTRACT = "ViewContract";
    private static final String VIEW_CONTRACT_CONTROLLER = "ViewContractController";
    private static final String VIEW_MY_JOB = "ViewMyJob";
    private static final String VIEW_MY_JOB_CONTROLLER = "ViewMyJobController";
    private static final String PROPOSAL_DETAIL = "ProposalDetail";
    private static final String PROPOSAL_DETAIL_CONTROLLER = "ProposalDetailController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;

            } else if (SEARCH_JOB_BY_NAME.equals(action)) {
                url = SEARCH_JOB_BY_NAME_CONTROLLER;
                
            } else if (SEARCH_JOB_BY_COMPANY.equals(action)) {
                url = SEARCH_JOB_BY_COMPANY_CONTROLLER;

            } else if (VIEW_ALL_PROJECT.equals(action)) {
                url = VIEW_ALL_PROJECT_CONTROLLER;

            } else if (VIEW_FAVORITE_PROJECT.equals(action)) {
                url = VIEW_FAVORITE_PROJECT_CONTROLLER;

            } else if (VIEW_BEST_MATCH_PROJECT.equals(action)) {
                url = VIEW_BEST_MATCH_PROJECT_CONTROLLER;

            } else if (CREATE_ACC_HIRER.equals(action)) {
                url = CREATE_ACC_HIRER_CONTROLLER;

            } else if (CREATE_ACC_SEEKER.equals(action)) {
                url = CREATE_ACC_SEEKER_CONTROLLER;

            } else if (FILTER_HIRER.equals(action)) {
                url = FILTER_HIRER_CONTROLLER;

            } else if (FILTER_PRICE.equals(action)) {
                url = FILTER_PRICE_CONTROLLER;
                
            } else if (FILTER_DURATION.equals(action)) {
                url = FILTER_DURATION_CONTROLLER;

            } else if (FILTER_LEVEL.equals(action)) {
                url = FILTER_LEVEL_CONTROLLER;
                
            } else if (CREATE_FAVORITE_PROJECT.equals(action)) {
                url = CREATE_FAVORITE_PROJECT_CONTROLLER;
                
            } else if (VIEW_PROPOSAL.equals(action)) {
                url = VIEW_PROPOSAL_CONTROLLER;

            } else if (UPDATE_PROFILE_SEEKER.equals(action)) {
                url = UPDATE_PROFILE_SEEKER_CONTROLLER;
                
            } else if (CREATE_GOOGLE_SEEKER.equals(action)) {
                url = CREATE_GOOGLE_SEEKER_CONTROLLER;
    
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
    
            } else if (NEXT_CHOOSE_SKILL.equals(action)) {
                url = NEXT_CHOOSE_SKILL_CONTROLLER;
             
            } else if (VIEW_SEEKER_DASHBOARD.equals(action)) {
                url = VIEW_SEEKER_DASHBOARD_CONTROLLER;
    
            } else if (SAVE_HOUR_PER_WEEK.equals(action)) {
                url = SAVE_HOUR_PER_WEEK_CONTROLLER;
    
            } else if (SAVE_LANG_LV.equals(action)) {
                url = SAVE_LANG_LV_CONTROLLER;
    
            } else if (SAVE_ACADEMIC_LV.equals(action)) {
                url = SAVE_ACADEMIC_LV_CONTROLLER;
    
            } else if (SAVE_PASSWORD.equals(action)) {
                url = SAVE_PASSWORD_CONTROLLER;
    
            } else if (SAVE_TITLE.equals(action)) {
                url = SAVE_TITLE_CONTROLLER;
    
            } else if (SAVE_HOUR_RATE.equals(action)) {
                url = SAVE_HOUR_RATE_CONTROLLER;
    
            } else if (SAVE_OVERVIEW.equals(action)) {
                url = SAVE_OVERVIEW_CONTROLLER;
    
            } else if (SAVE_SKILL.equals(action)) {
                url = SAVE_SKILL_CONTROLLER;
                
            } else if (VIEW_SEEKER_PROFILE.equals(action)) {
                url = VIEW_SEEKER_PROFILE_CONTROLLER;
                
            } else if (FORM_SENT_PROPOSAL.equals(action)) {
                url = FORM_SENT_PROPOSAL_CONTROLLER;
                
            } else if (SUBMIT_A_PROPOSAL.equals(action)) {
                url = SUBMIT_A_PROPOSAL_CONTROLLER;
                
            } else if (VIEW_CONTRACT.equals(action)) {
                url = VIEW_CONTRACT_CONTROLLER;
                
            } else if (VIEW_MY_JOB.equals(action)) {
                url = VIEW_MY_JOB_CONTROLLER;
    
            } else if (PROPOSAL_DETAIL.equals(action)) {
                url = PROPOSAL_DETAIL_CONTROLLER;
    
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "function is not avaiable!");
            }
        } catch (Exception e) {
            log("Error at MainController:" + e.toString());
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
