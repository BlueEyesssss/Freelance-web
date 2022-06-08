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
    private String seekerComment;
    private String coverLetter;
    private String attachment;
    private String createdDate;
    private String expectedDurationID;
    private String projectName;

   

    public ProposalDTO(int proposalID, int projectID, int seekerID, double paymentAmount, String proposalStatusName, double clientGrade, String clientComment, double seekerGrade, String seekerComment, String coverLetter, String attachment, String createdDate, String expectedDurationID, String projectName) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.seekerID = seekerID;
        this.paymentAmount = paymentAmount;
        this.proposalStatusName = proposalStatusName;
        this.clientGrade = clientGrade;
        this.clientComment = clientComment;
        this.seekerGrade = seekerGrade;
        this.seekerComment = seekerComment;
        this.coverLetter = coverLetter;
        this.attachment = attachment;
        this.createdDate = createdDate;
        this.expectedDurationID = expectedDurationID;
        this.projectName = projectName;
    }

    public ProposalDTO() {
    }

    ProposalDTO(String projectName, String createdDate) {
        this.projectName = projectName;
        this.createdDate = createdDate;
    }

    public String getSeekerComment() {
        return seekerComment;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setSeekerComment(String seekerComment) {
        this.seekerComment = seekerComment;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpectedDurationID() {
        return expectedDurationID;
    }

    public void setExpectedDurationID(String expectedDurationID) {
        this.expectedDurationID = expectedDurationID;
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
