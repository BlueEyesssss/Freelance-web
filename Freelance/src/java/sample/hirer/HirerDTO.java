/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.hirer;

import java.io.Serializable;
import java.nio.file.Path;
import javax.servlet.http.Part;

import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
public class HirerDTO extends UserDTO implements Serializable{
    private int hirerID;
    private String companyName;
    private int reviewGrade;
    private int jobPosted;
    private int openJob;
    private int totalSpent;
    private UserDTO user; // chua chac can coi lai


    public HirerDTO(UserDTO user, String companyName, String code) {
        this.user = user;
        this.companyName = companyName;
        
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

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

    public HirerDTO(String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar, String conpanyName) {
        this.user.setPassword(password);
        this.user.setUserName(userName);
        this.user.setFullName(fullName);
        this.user.setEmail(email);
        this.user.setPhone(phone);
        this.user.setLocation(location);
        this.user.setRegistrationDate(registrationDate);
        this.user.setBalance(balance);
        this.user.setAvatar(avatar);
        this.companyName = conpanyName;
        
    }
    
    public HirerDTO(String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar, String conpanyName, String code) {
        this.user.setPassword(password);
        this.user.setUserName(userName);
        this.user.setFullName(fullName);
        this.user.setEmail(email);
        this.user.setPhone(phone);
        this.user.setLocation(location);
        this.user.setRegistrationDate(registrationDate);
        this.user.setBalance(balance);
        this.user.setAvatar(avatar);
        this.companyName = conpanyName;
        this.user.setCode(code);
        
    }

    public HirerDTO(UserDTO user, String conpanyName) {
        this.user = user;
        this.companyName = conpanyName;
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
