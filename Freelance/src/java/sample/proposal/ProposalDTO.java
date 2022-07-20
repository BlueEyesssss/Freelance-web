/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.proposal;

import sample.seeker.SeekerDTO;

/**
 *
 * @author LENOVO
 */
public class ProposalDTO {

    private int proposalID;
    private int projectID;
    private int seekerID;
    private double paymentAmount;
    private int proposalStatusID;
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
    private String projectDescription;
    private String durationText;
    private int hirerID;
    private SeekerDTO seeker;
    private String link;
    private String message;
    private String fileName;
    private String path;

    ProposalDTO(int proposalID, int projectID, int seekerID, double paymentAmount, int proposalStatusID, String proposalStatusName, String coverLetter, String attachment, String createdDate, String expectedDurationID, String projectName, String durationText) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.seekerID = seekerID;
        this.paymentAmount = paymentAmount;
        this.proposalStatusID = proposalStatusID;
        this.proposalStatusName = proposalStatusName;
        this.coverLetter = coverLetter;
        this.attachment = attachment;
        this.createdDate = createdDate;
        this.expectedDurationID = expectedDurationID;
        this.projectName = projectName;
        this.durationText = durationText;
    }

    ProposalDTO(int proposalID, int seekerID, int projectID, int proposalStatusID, double paymentAmount, String coverLetter, String attachment, String expectedDurationText, SeekerDTO seeker) {
        this.proposalID = proposalID;
        this.seekerID = seekerID;
        this.projectID = projectID;
        this.proposalStatusID = proposalStatusID;
        this.paymentAmount = paymentAmount;
        this.coverLetter = coverLetter;
        this.attachment = attachment;
        this.durationText = expectedDurationText;
        this.seeker = seeker;
    }

    ProposalDTO(String projectName,String projectDescription, String createdDate, String link, String message, String fileName, String path, int proposalID, double paymentAmount) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.createdDate = createdDate;
        this.link = link;
        this.message = message;
        this.fileName = fileName;
        this.path = path;
        this.proposalID = proposalID;
        this.paymentAmount = paymentAmount;
        
    }

    ProposalDTO(int hirerID, int proposalID, int projectID, int seekerID, double paymentAmount, int proposalStatusID, String createdDate) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.seekerID = seekerID;
        this.hirerID = hirerID;
        this.paymentAmount = paymentAmount;
        this.proposalStatusID = proposalStatusID;
        this.createdDate = createdDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    ProposalDTO(int proposalID, int seekerID, int proposalStatusID, double paymentAmount, String coverLetter, String attachment, String expectedDurationText) {
        this.proposalID = proposalID;
        this.seekerID = seekerID;
        this.proposalStatusID = proposalStatusID;
        this.paymentAmount = paymentAmount;
        this.coverLetter = coverLetter;
        this.attachment = attachment;
        this.durationText = expectedDurationText;
    }

    ProposalDTO(int proposalID, int seekerID, int proposalStatusID, double paymentAmount, String coverLetter, String attachment, String expectedDurationText, SeekerDTO seeker) {
        this.proposalID = proposalID;
        this.seekerID = seekerID;
        this.proposalStatusID = proposalStatusID;
        this.paymentAmount = paymentAmount;
        this.coverLetter = coverLetter;
        this.attachment = attachment;
        this.durationText = expectedDurationText;
        this.seeker = seeker;
    }

    ProposalDTO(int projectID, String projectName, String createdDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.createdDate = createdDate;
    }

    ProposalDTO(String projectName_1, String createdDate, int proposalID) {
        this.proposalID = proposalID;
        this.projectName = projectName_1;
        this.createdDate = createdDate;
    }

    ProposalDTO(int proposalID, int projectID, String projectName, String createdDate) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.projectName = projectName;
        this.createdDate = createdDate;
    }

    public ProposalDTO(String link, String message, String fileName, String path, int proposalid, double paymentAmount, String durationText) {
        this.link = link;
        this.message = message;
        this.fileName = fileName;
        this.path = path;
        this.proposalID = proposalid;
        this.paymentAmount = paymentAmount;
        this.durationText = durationText;
    }

    public SeekerDTO getSeeker() {
        return seeker;
    }

    public void setSeeker(SeekerDTO seeker) {
        this.seeker = seeker;
    }

    public int getHirerID() {
        return hirerID;
    }

    public void setHirerID(int hirerID) {
        this.hirerID = hirerID;
    }

    public ProposalDTO(int proposalID, double paymentAmount, String durationText) {
        this.proposalID = proposalID;
        this.paymentAmount = paymentAmount;
        this.durationText = durationText;
    }

    public String getDurationText() {
        return durationText;
    }

    public int getProposalStatusID() {
        return proposalStatusID;
    }

    public void setProposalStatusID(int proposalStatusID) {
        this.proposalStatusID = proposalStatusID;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
    }

    //full
    public ProposalDTO(int hirerID, int proposalID, int projectID, int seekerID, double paymentAmount, int proposalStatusID, String proposalStatusName, double clientGrade, String clientComment, double seekerGrade, String seekerComment, String coverLetter, String attachment, String createdDate, String expectedDurationID, String projectName, String durationText) {
        this.proposalID = proposalID;
        this.projectID = projectID;
        this.seekerID = seekerID;
        this.hirerID = hirerID;
        this.paymentAmount = paymentAmount;
        this.proposalStatusID = proposalStatusID;
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
        this.durationText = durationText;
    }

    //thiếu durationText đầu vào
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
    
        public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }


}
