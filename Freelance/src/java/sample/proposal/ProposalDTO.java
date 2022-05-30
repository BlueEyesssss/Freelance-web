/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.proposal;

/**
 *
 * @author LENOVO
 */
public class ProposalDTO {
    private int proposalID;
    private int projectID;
    private int seekerID;
    private double paymentAmount;
    private String proposalStatusName;
    private double clientGrade;
    private String clientComment;
    private double seekerGrade;

    public ProposalDTO() {
    }

    public ProposalDTO(int proposalID, int projectID, int seekerID, double paymentAmount, String proposalStatusName, double clientGrade, String clientComment, double seekerGrade) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.seekerID = seekerID;
        this.paymentAmount = paymentAmount;
        this.proposalStatusName = proposalStatusName;
        this.clientGrade = clientGrade;
        this.clientComment = clientComment;
        this.seekerGrade = seekerGrade;
    }

    public int getProposalID() {
        return proposalID;
    }

    public void setProposalID(int proposalID) {
        this.proposalID = proposalID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getSeekerID() {
        return seekerID;
    }

    public void setSeekerID(int seekerID) {
        this.seekerID = seekerID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getProposalStatusName() {
        return proposalStatusName;
    }

    public void setProposalStatusName(String proposalStatusName) {
        this.proposalStatusName = proposalStatusName;
    }

    public double getClientGrade() {
        return clientGrade;
    }

    public void setClientGrade(double clientGrade) {
        this.clientGrade = clientGrade;
    }

    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    public double getSeekerGrade() {
        return seekerGrade;
    }

    public void setSeekerGrade(double seekerGrade) {
        this.seekerGrade = seekerGrade;
    }
    
    
}
