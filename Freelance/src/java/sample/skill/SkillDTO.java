/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.skill;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class SkillDTO implements Serializable{
    private int skillID;
    private String skillName;

    public SkillDTO() {
        this.skillID = 0;
        this.skillName = "";
    }
    
    public SkillDTO(int skillID, String skillName) {
        this.skillID = skillID;
        this.skillName = skillName;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
