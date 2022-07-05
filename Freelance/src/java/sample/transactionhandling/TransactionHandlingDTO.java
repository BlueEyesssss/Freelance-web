/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.transactionhandling;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class TransactionHandlingDTO {
    private int transactionHandlingID;
    private int hirerID;
    private double amountMonney;
    private boolean status;
    private Date dateCreate;
    private Date dateDone;

    public TransactionHandlingDTO(int transactionHandlingID, int hirerID, double amountMonney, boolean status, Date dateCreate, Date dateDone) {
        this.transactionHandlingID = transactionHandlingID;
        this.hirerID = hirerID;
        this.amountMonney = amountMonney;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateDone = dateDone;
    }

    
    
    public TransactionHandlingDTO(int hirerID, double amountMonney, boolean status) {
        this.hirerID = hirerID;
        this.amountMonney = amountMonney;
        this.status = status;
    }

    public int getTransactionHandlingID() {
        return transactionHandlingID;
    }

    public void setTransactionHandlingID(int transactionHandlingID) {
        this.transactionHandlingID = transactionHandlingID;
    }

    public int getHirerID() {
        return hirerID;
    }

    public void setHirerID(int hirerID) {
        this.hirerID = hirerID;
    }

    public double getAmountMonney() {
        return amountMonney;
    }

    public void setAmountMonney(double amountMonney) {
        this.amountMonney = amountMonney;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateDone() {
        return dateDone;
    }

    public void setDateDone(Date dateDone) {
        this.dateDone = dateDone;
    }
    
    
}
