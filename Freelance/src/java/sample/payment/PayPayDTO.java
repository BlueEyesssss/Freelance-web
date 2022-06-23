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
    private int seekerID;
    private String client_id;
    private String client_secret;

    public PayPayDTO(int seekerID, String client_id, String client_secret) {
        this.seekerID = seekerID;
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    public int getSeekerID() {
        return seekerID;
    }

    public void setSeekerID(int seekerID) {
        this.seekerID = seekerID;
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
