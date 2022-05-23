/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project;

import java.sql.Connection;
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
public class ProjectDAO {
    public List<ProjectDTO> getListProjectByName(String search) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM dbo.Project "
                        + " WHERE projectName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");
                    
                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
