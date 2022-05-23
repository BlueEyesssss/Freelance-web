/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.hirer;

/**
 *
 * @author LENOVO
 */
public class HirerDTO {
    private int hirerID;
    private String conpanyName;

    public HirerDTO() {
        this.hirerID = 0;
        this.conpanyName = "";
    }

    public HirerDTO(int hirerID, String conpanyName) {
        this.hirerID = hirerID;
        this.conpanyName = conpanyName;
    }

    public int getHirerID() {
        return hirerID;
    }

    public void setHirerID(int hirerID) {
        this.hirerID = hirerID;
    }

    public String getConpanyName() {
        return conpanyName;
    }

    public void setConpanyName(String conpanyName) {
        this.conpanyName = conpanyName;
    }
    
    
}
