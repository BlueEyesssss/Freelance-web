/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.hirer;

import java.time.LocalDate;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
public class HirerDTO extends UserDTO{
    private int hirerID;
    private String companyName;
    private int reviewGrade;
    private int jobPosted;
    private int openJob;
    private int totalSpent;

    public HirerDTO(int hirerID, String companyName, int reviewGrade, int jobPosted, int openJob, int totalSpent, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar) {
        super(password, userName, fullName, email, phone, location, registrationDate, balance, avatar);
        this.hirerID = hirerID;
        this.companyName = companyName;
        this.reviewGrade = reviewGrade;
        this.jobPosted = jobPosted;
        this.openJob = openJob;
        this.totalSpent = totalSpent;
    }

    public HirerDTO(int hirerID, String companyName, int reviewGrade, int jobPosted, int openJob, int totalSpent, int userID, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar) {
        super(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar);
        this.hirerID = hirerID;
        this.companyName = companyName;
        this.reviewGrade = reviewGrade;
        this.jobPosted = jobPosted;
        this.openJob = openJob;
        this.totalSpent = totalSpent;
    }

    public HirerDTO(int hirerID, String companyName, int reviewGrade, int jobPosted, int openJob, int totalSpent, int userID, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar, String language, String languagelv) {
        super(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar, language, languagelv);
        this.hirerID = hirerID;
        this.companyName = companyName;
        this.reviewGrade = reviewGrade;
        this.jobPosted = jobPosted;
        this.openJob = openJob;
        this.totalSpent = totalSpent;
    }

    public HirerDTO(int hirerID, String companyName, int reviewGrade, int jobPosted, int openJob, int totalSpent) {
        this.hirerID = hirerID;
        this.companyName = companyName;
        this.reviewGrade = reviewGrade;
        this.jobPosted = jobPosted;
        this.openJob = openJob;
        this.totalSpent = totalSpent;
    }

    
    

    public int getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(int reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public int getJobPosted() {
        return jobPosted;
    }

    public void setJobPosted(int jobPosted) {
        this.jobPosted = jobPosted;
    }

    public int getOpenJob() {
        return openJob;
    }

    public void setOpenJob(int openJob) {
        this.openJob = openJob;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }
    

    public HirerDTO() {
        this.hirerID = 0;
        this.companyName = "";
    }

    public HirerDTO(int hirerID, String companyName) {
        this.hirerID = hirerID;
        this.companyName = companyName;
    }

    public int getHirerID() {
        return hirerID;
    }

    public void setHirerID(int hirerID) {
        this.hirerID = hirerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    
}
