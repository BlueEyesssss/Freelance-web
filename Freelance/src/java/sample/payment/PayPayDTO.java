/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

/**
 *
 * @author LENOVO
 */
public class PayPayDTO {
    private int userID;
    private String client_id;
    private String client_secret;

    public PayPayDTO(int userID, String client_id, String client_secret) {
        this.userID = userID;
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    public int getSeekerID() {
        return userID;
    }

    public void setSeekerID(int seekerID) {
        this.userID = seekerID;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }
    
}
