/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.transactionhandling;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class TransactionHandlingDAO {

    private final String GET_LIST_TRAN_HISTORY = "SELECT transactionHandlingID, userID, amountMonney, status, dateCreate, dateDone\n" +
"FROM TransactionHandling\n" +
"WHERE userID = ?";

    private final String CREATE_HIRER_CASH_OUT = "INSERT INTO TransactionHandling(userID, amountMonney, status) VALUES (?, ?, 0)";
    
    public boolean createHirerCashOut(int userID, int moneyCashout) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(CREATE_HIRER_CASH_OUT);
                ptm.setInt(1, userID);
                ptm.setInt(2, moneyCashout);
                check = ptm.executeUpdate() > 0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ptm != null){
                ptm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return check;
    }
    
    public List<TransactionHandlingDTO> getListTranHistory(int hirerIDd) throws SQLException {
        List<TransactionHandlingDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(GET_LIST_TRAN_HISTORY);
                ptm.setInt(1, hirerIDd);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    int transactionHandlingID = rs.getInt("transactionHandlingID");
                    int userID = rs.getInt("userID");
                    double amountMonney = rs.getInt("amountMonney");
                    boolean status = rs.getBoolean("status");
                    Date dateCreate = rs.getDate("dateCreate");
                    Date dateDone = null;
                    if(status == true){
                        dateDone = rs.getDate("dateDone");
                    }
                    list.add(new TransactionHandlingDTO(transactionHandlingID, userID, amountMonney, status, dateCreate, dateDone));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                rs.close();
            }
            if(ptm != null){
                ptm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return list;
    }

    
    
}
