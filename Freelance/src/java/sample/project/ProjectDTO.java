/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project;

/**
 *
 * @author LENOVO
 */
public class ProjectDTO {

    private int projectID;
    private String projectName;
    private String description;
    private String complexity;
    private String hirer;
    private double paymentAmount;
    private String expectedDurationID;
    private String deadlineDate;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectID, String projectName, String description, String complexity, String hirer, double paymentAmount, String expectedDurationID, String deadlineDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;
        this.complexity = complexity;
        this.hirer = hirer;
        this.paymentAmount = paymentAmount;
        this.expectedDurationID = expectedDurationID;
        this.deadlineDate = deadlineDate;
    }
    
    public ProjectDTO(int projectID, String projectName, String description, String complexity, double paymentAmount, String expectedDurationID, String deadlineDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;
        this.complexity = complexity;
        this.paymentAmount = paymentAmount;
        this.expectedDurationID = expectedDurationID;
        this.deadlineDate = deadlineDate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getHirer() {
        return hirer;
    }

    public void setHirer(String hirer) {
        this.hirer = hirer;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getExpectedDurationID() {
        return expectedDurationID;
    }

    public void setExpectedDurationID(String expectedDurationID) {
        this.expectedDurationID = expectedDurationID;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

}
