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
    private String description;
    private String complexity;
    private int hireID;
    private double paymentAmount;
    private int expectedDurationID;
    private String deadlineDate;

    public ProjectDTO(int projectID, String description, String complexity, int hireID, double paymentAmount, int expectedDurationID, String deadlineDate) {
        this.projectID = projectID;
        this.description = description;
        this.complexity = complexity;
        this.hireID = hireID;
        this.paymentAmount = paymentAmount;
        this.expectedDurationID = expectedDurationID;
        this.deadlineDate = deadlineDate;
    }

    public ProjectDTO() {
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
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

    public int getHireID() {
        return hireID;
    }

    public void setHireID(int hireID) {
        this.hireID = hireID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getExpectedDurationID() {
        return expectedDurationID;
    }

    public void setExpectedDurationID(int expectedDurationID) {
        this.expectedDurationID = expectedDurationID;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
    
    
}
