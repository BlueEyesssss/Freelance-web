/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.seeker;

import java.sql.SQLException;
import java.util.List;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
public class SeekerDTO extends UserDTO{
    private int seekerID;
    private String overview;
    private String titileBio;
    private int moneyPerHour;
    private String education;
    private String degree;
    private String major;
    private String hourPerWeek;
    private int reviewGrade;
    private UserDTO user;
    private List<String> hasSkill;

    public List<String> getHasSkill() {
        return hasSkill;
    }

    public void setHasSkill(List<String> hasSkill) {
        this.hasSkill = hasSkill;
    }
    
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    
    
    public int getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(int reviewGrade) {
        this.reviewGrade = reviewGrade;
        
    }
    

    @Override
    public String toString() {
        return "SeekerDTO{" + "seekerID=" + seekerID + ", overview=" + overview + ", titileBio=" + titileBio + ", moneyPerHour=" + moneyPerHour + ", education=" + education + ", degree=" + degree + ", major=" + major + '}';
    }

    public String getHourPerWeek() {
        return hourPerWeek;
    }

    public void setHourPerWeek(String hourPerWeek) {
        this.hourPerWeek = hourPerWeek;
    }

    
    
    public SeekerDTO() {
        this.seekerID = 0;
        this.overview = "";
        this.titileBio = "";
        this.moneyPerHour = 0;
        this.education = "";
        this.degree = "";
        this.major = "";
        this.hourPerWeek = "None";
    }
    //thiếu hourPerWeek argument
    public SeekerDTO(int seekerID, String overview, String titileBio, int moneyPerHour, String education, String degree, String major) {
        this.seekerID = seekerID;
        this.overview = overview;
        this.titileBio = titileBio;
        this.moneyPerHour = moneyPerHour;
        this.education = education;
        this.degree = degree;
        this.major = major;
        this.hourPerWeek = "None";
    }

    public SeekerDTO(int seekerID, String overview, String titileBio, int moneyPerHour, String education, String degree, String major, String hourPerWeek) {
        this.seekerID = seekerID;
        this.overview = overview;
        this.titileBio = titileBio;
        this.moneyPerHour = moneyPerHour;
        this.education = education;
        this.degree = degree;
        this.major = major;
        this.hourPerWeek = hourPerWeek;
    }

    
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
            
    public int getSeekerID() {
        return seekerID;
    }

    public void setSeekerID(int seekerID) {
        this.seekerID = seekerID;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitileBio() {
        return titileBio;
    }

    public void setTitileBio(String titileBio) {
        this.titileBio = titileBio;
    }

    public int getMoneyPerHour() {
        return moneyPerHour;
    }

    public void setMoneyPerHour(int moneyPerHour) {
        this.moneyPerHour = moneyPerHour;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
   
    public List<String> getListSkill() throws SQLException {
        SeekerDAO dao = new SeekerDAO();
        return dao.getSkillSeekerHave(this.seekerID);
    }
    
}
