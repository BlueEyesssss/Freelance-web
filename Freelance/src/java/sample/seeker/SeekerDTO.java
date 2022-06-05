/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.seeker;

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
    private int hourPerWeek;

    @Override
    public String toString() {
        return "SeekerDTO{" + "seekerID=" + seekerID + ", overview=" + overview + ", titileBio=" + titileBio + ", moneyPerHour=" + moneyPerHour + ", education=" + education + ", degree=" + degree + ", major=" + major + '}';
    }

    public int getHourPerWeek() {
        return hourPerWeek;
    }

    public void setHourPerWeek(int hourPerWeek) {
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
        this.hourPerWeek = 0;
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
        this.hourPerWeek = 2;
    }

    public SeekerDTO(int seekerID, String overview, String titileBio, int moneyPerHour, String education, String degree, String major, int hourPerWeek) {
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
    
    
}
