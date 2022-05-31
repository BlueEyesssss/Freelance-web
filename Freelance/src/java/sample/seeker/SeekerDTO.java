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

    public SeekerDTO() {
        this.seekerID = 0;
        this.overview = "";
        this.titileBio = "";
        this.moneyPerHour = 0;
        this.education = "";
    }

    public SeekerDTO(int seekerID, String overview, String titileBio, int moneyPerHour, String education) {
        this.seekerID = seekerID;
        this.overview = overview;
        this.titileBio = titileBio;
        this.moneyPerHour = moneyPerHour;
        this.education = education;
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
