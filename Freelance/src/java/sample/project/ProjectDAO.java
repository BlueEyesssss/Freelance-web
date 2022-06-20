/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sample.proposal.ProposalDTO;
import sample.seeker.SeekerDTO;

import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class ProjectDAO {

    private static final String VIEW_ALL_PROJECT = "SELECT projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek\n"
            + "FROM Project P, ExpectedDuration E\n"
            + "WHERE P.expectedDurationID = E.expectedDurationID";
    private static final String CREATE_NEW_FAVORITE_PROJECT = "INSERT INTO FavoriteProject(projectID, seekerID) VALUES(?,?)";
    private static final String VIEW_FAVORITE_PROJECT = "SELECT FavoriteProject.projectID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, hirerID, Project.major, createdDate, location, hoursPerWeek \n"
            + "FROM FavoriteProject, Project, Seeker, ExpectedDuration \n"
            + "WHERE FavoriteProject.projectID = Project.projectID \n"
            + "and FavoriteProject.seekerID = Seeker.seekerID \n"
            + "and ExpectedDuration.expectedDurationID = Project.expectedDurationID \n"
            + "and FavoriteProject.seekerID = ?";
    private static final String WIEW_BEST_MATCH_PROJECT = "SELECT P.projectID, P.hirerID, projectName, description, complexity, paymentAmount, E.durationText, deadlineDate, major, createdDate, hoursPerWeek,location"
            + " FROM Project P,Hirer H, ExpectedDuration E,"
            + " (SELECT N.projectID, COUNT(N.skillID)AS matchSkill"
            + " FROM NeededSkills N,HasSkill H"
            + " WHERE H.seekerID = ? AND N.skillID = H.skillID"
            + " GROUP BY N.projectID) Q"
            + " WHERE P.projectID = Q.projectID AND P.hirerID = H.hirerID AND E.expectedDurationID = P.expectedDurationID"
            + " ORDER BY matchSkill DESC";
    private static final String WIEW_LIST_PROJECT_BASE_ON_NAME = "SELECT projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek"
            + " FROM Project P, ExpectedDuration E"
            + " WHERE P.projectName LIKE ? AND P.expectedDurationID = E.expectedDurationID";

    private static final String CHECK_DUPLICATE = "SELECT projectID, seekerID\n"
            + "FROM FavoriteProject\n"
            + "WHERE projectID = ? and seekerID = ?";
    private static final String DELETE_FAVORITE_PROJECT = "DELETE FROM FavoriteProject\n"
            + "WHERE projectID = ? and seekerID = ?";
    private static final String DELETE_PROJECT = "DELETE FROM Project WHERE projectID = ?";
    private static final String DELETE_FAVORITE_PROJECT_WITH_PROJECTID = "DELETE FROM FavoriteProject WHERE projectID = ?";

    private static final String GET_SKILL_NEED_PROJECT = "SELECT nd.projectID, s.skillName FROM NeededSkills nd, Skill s WHERE nd.skillID = s.skillID AND nd.projectID = ?";

    private static final String SELECT_PROJECT_CURRENT = "SELECT P.*,E.durationText,H.companyName FROM Project P, ExpectedDuration E, Hirer H WHERE P.projectID=? AND P.expectedDurationID=E.expectedDurationID AND P.hirerID=H.hirerID ";

    private static final String GET_HIRERID_BY_PROJECTID = "select hirerID\n"
            + "from Project\n"
            + "where projectID = ?";

    private static final String GET_PROJECT_BY_ID = "SELECT p.projectID, p.projectName, p.description, p.complexity, p.hirerID\n"
            + "	, p.paymentAmount, p.deadlineDate, p.location, p.createdDate, p.hoursPerWeek\n"
            + "	, p.major, e.durationText\n"
            + "FROM Project p, ExpectedDuration e\n"
            + "WHERE p.expectedDurationID = e.expectedDurationID\n"
            + "AND p.projectID = ?";

    private static final String GET_PAYMENT_DURATION_PROPOSAL = "SELECT p.paymentAmount, e.durationText\n"
            + "FROM Proposal p, ExpectedDuration e\n"
            + "WHERE p.expectedDurationID = e.expectedDurationID\n"
            + "AND p.proposalID = ?";

    private static final String GET_DURATION_ID_BY_NAME = "SELECT expectedDurationID\n"
            + "FROM ExpectedDuration\n"
            + "WHERE durationText = ?";

    private static final String UPDATE_PROPOSAL_DETAIL = "UPDATE Proposal\n"
            + "SET paymentAmount = ?, expectedDurationID = ?\n"
            + "WHERE proposalID = ?";

    private static final String VIEW_UNACTIVE_PROJECT = "SELECT projectID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, hirerID, major, createdDate, location, hoursPerWeek " +
"	FROM Project A, ExpectedDuration B" +
"	WHERE A.hirerID=? AND A.projectID NOT IN (SELECT projectID FROM Proposal" +
"	WHERE proposalStatusID in (4,5,6,7)) AND A.expectedDurationID=B.expectedDurationID";

    private static final String CREATE_PROJECT ="INSERT INTO Project(projectName,description,complexity,hirerID,paymentAmount,expectedDurationID,deadlineDate,location)" +
" VALUES(?,?,?,?,?,?,?,?)";
    
    private static final String POST_A_PROJECT ="INSERT INTO Project(projectName, description, complexity, hirerID\n" +
", paymentAmount, expectedDurationID, deadlineDate, location, createdDate, hoursPerWeek, major)\n" +
"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
   
    
    
    public boolean postAJob(ProjectDTO project) throws SQLException, ClassNotFoundException {
        //LocalDate.parse(rs.getString("createdDate"))
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(POST_A_PROJECT);
                ptm.setString(1, project.getProjectName());
                ptm.setString(2, project.getDescription());
                ptm.setString(3, project.getComplexity());
                ptm.setInt(4, project.getHirerID());
                ptm.setDouble(5, project.getPaymentAmount());
                ptm.setInt(6, Integer.parseInt(project.getExpectedDurationID()) );
                ptm.setString(7,project.getDeadlineDate());
                ptm.setString(8, project.getLocation());
                ptm.setString(9, project.getCreatedDate1());
                ptm.setInt(10, project.getHoursPerWeek());
                ptm.setString(11, project.getMajor());
                
                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateProposalDetail(int proposalID, double paymentAmount, int durationTextID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PROPOSAL_DETAIL);
                ptm.setDouble(1, paymentAmount);
                ptm.setInt(2, durationTextID);
                ptm.setInt(3, proposalID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getExpectedDurationIDByName(String durationText) throws SQLException {
        int num = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_DURATION_ID_BY_NAME);
                ptm.setString(1, durationText);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    num = Integer.parseInt(rs.getString("expectedDurationID"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return num;
    }

    public ProposalDTO getProposalPaymentAndDuration(int proposalid) throws SQLException {
        ProposalDTO proposal = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PAYMENT_DURATION_PROPOSAL);
                ptm.setInt(1, proposalid);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String durationText = rs.getString("durationText");
                    proposal = new ProposalDTO(proposalid, paymentAmount, durationText);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return proposal;
    }

    public ProjectDTO getProjectByID(int projectid) throws SQLException {
        ProjectDTO project = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROJECT_BY_ID);
                ptm.setInt(1, projectid);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hirerID = Integer.parseInt(rs.getString("hirerID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String deadlineDate = rs.getString("deadlineDate");
                    String location = rs.getString("location");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String major = rs.getString("major");
                    String durationText = rs.getString("durationText");
                    int hoursPerWeek = Integer.parseInt(rs.getString("hoursPerWeek"));
                    project = new ProjectDTO(projectID, hirerID, projectName, description,
                            complexity, major, paymentAmount, deadlineDate, createdDate,
                            location, hoursPerWeek, durationText);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return project;
    }

    public int getHirerIdFromProjectId(int projectId) throws SQLException {
        int hirerid = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_HIRERID_BY_PROJECTID);
                ptm.setInt(1, projectId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    hirerid = rs.getInt("hirerID");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return hirerid;
    }

    public List<String> getSkillNeedOfProject(int projectID) throws SQLException {
        List<String> skillNeed = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SKILL_NEED_PROJECT);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String skillName = rs.getString("skillName");
                    //if(rs.next()){
                    skillNeed.add(skillName);
//                    }else{
//                        skillNeed += skillName;
//                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return skillNeed;
    }

    public boolean checkDuplicate(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return check;
    }

    public boolean deleteFavoriteProject(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_FAVORITE_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                check = ptm.executeUpdate() > 0;
                if (check) {
                    check = true;
                }
//                if (rs.next()) {
//                    check = true;
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }

    public List<ProjectDTO> getListFavoriteProject(int seekerID) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_FAVORITE_PROJECT);
                ptm.setInt(1, seekerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    int hirerID = rs.getInt("hirerID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");
                    String major = rs.getString("major");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String location = rs.getString("location");
                    int hoursPerWeek = rs.getInt("hoursPerWeek");

                    list.add(new ProjectDTO(projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProjectDTO> getListAllProject() throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_ALL_PROJECT);

                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    int hirerID = rs.getInt("hirerID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");
                    String major = rs.getString("major");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String location = rs.getString("location");
                    int hoursPerWeek = rs.getInt("hoursPerWeek");

                    list.add(new ProjectDTO(projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean createNewFavoriteProject(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ProjectDTO project = new ProjectDTO();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_NEW_FAVORITE_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<ProjectDTO> getListProjectByName(String search) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = WIEW_LIST_PROJECT_BASE_ON_NAME;
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    int hirerID = rs.getInt("hirerID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");
                    String major = rs.getString("major");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String location = rs.getString("location");
                    int hoursPerWeek = rs.getInt("hoursPerWeek");

                    list.add(new ProjectDTO(projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<ProjectDTO> getListProjectBestMatch(int seekerID) throws SQLException {
        //Base on skill match
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = WIEW_BEST_MATCH_PROJECT;

                stm = conn.prepareStatement(sql);
                stm.setInt(1, seekerID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    int hirerID = rs.getInt("hirerID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");
                    String major = rs.getString("major");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String location = rs.getString("location");
                    int hoursPerWeek = rs.getInt("hoursPerWeek");

                    list.add(new ProjectDTO(projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek));
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

    public List<ProjectDTO> getListProjectByHirerName(List<ProjectDTO> listBeforeFilter, String company) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();

        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getHirer().contains(company)) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectBaseOnPrice(List<ProjectDTO> listBeforeFilter, int price1, int price2) throws SQLException {
        //price1 < price2 
        List<ProjectDTO> list = new ArrayList<>();
        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getPaymentAmount() >= price1 && project.getPaymentAmount() <= price2) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectByExperienceLevel(List<ProjectDTO> listBeforeFilter, String experienceLevel) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getComplexity().equalsIgnoreCase(experienceLevel)) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProjectDTO getProjectCurrent(int projectID) throws SQLException {
        ProjectDTO project = new ProjectDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = SELECT_PROJECT_CURRENT;
                stm = conn.prepareStatement(sql);
                stm.setInt(1, projectID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String description = rs.getString("description");
                    String projectName = rs.getString("projectName");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("companyName");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String durationText = rs.getString("durationText");
                    String location = rs.getString("location");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String deadlineDate = rs.getString("deadlineDate");
                    int hoursPerWeek = Integer.parseInt(rs.getString("hoursPerWeek"));
                    String major = rs.getString("major");
                    project = new ProjectDTO(projectID, projectID, projectName, description, complexity, major, paymentAmount, durationText, deadlineDate, createdDate, location, hoursPerWeek);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return project;
    }

    public List<ProjectDTO> getListProjectByDuration(List<ProjectDTO> listBeforeFilter, String duration) {
        List<ProjectDTO> list = new ArrayList<>();

        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getExpectedDurationID().trim().equalsIgnoreCase(duration.trim())) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectBySkill(List<ProjectDTO> listBeforeFilter, String skill) {
        List<ProjectDTO> list = new ArrayList<>();

        try {
            for (ProjectDTO project : listBeforeFilter) {
                List<String> skillNeed = project.getSkillneed();
                for (String elem : skillNeed) {
                    if (elem.equalsIgnoreCase(skill)) {
                        list.add(project);
                        break;
                    }
                }

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectUnactive(int userID) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_UNACTIVE_PROJECT);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    int hirerID = rs.getInt("hirerID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");
                    String major = rs.getString("major");
                    LocalDate createdDate = LocalDate.parse(rs.getString("createdDate"));
                    String location = rs.getString("location");
                    int hoursPerWeek = rs.getInt("hoursPerWeek");

                    list.add(new ProjectDTO(projectID, hirerID, description, complexity, projectName, paymentAmount, durationText, deadlineDate, major, createdDate, location, hoursPerWeek));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean CreateProject(String projectName, String description, String complexity, int hireID, double budget, int durationID, String deadline, String location) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_PROJECT);
                ptm.setString(1, projectName);
                ptm.setString(2, description);
                ptm.setString(3, complexity);
                ptm.setInt(4, hireID);
                ptm.setDouble(5, budget);
                ptm.setInt(6, durationID);
                ptm.setString(7, deadline);
                ptm.setString(8, location);
                check = ptm.executeUpdate() > 0;               
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }

    private final String GET_PROJECTID = "SELECT projectID\n" +
"FROM Project\n" +
"WHERE projectName = ? \n" +
" AND complexity = ?\n" +
"AND paymentAmount = ?\n" +
"AND hoursPerWeek = ?\n" +
"AND hirerID = ?\n" +
"AND major = ?";
    
    public int getProject(ProjectDTO project) throws SQLException {
        int id = -1;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROJECTID);
                ptm.setString(1, project.getProjectName());
                ptm.setString(2, project.getComplexity());
                ptm.setDouble(3, project.getPaymentAmount());
                ptm.setInt(4, project.getHoursPerWeek());
                ptm.setInt(5, project.getHirerID());
                ptm.setString(6, project.getMajor());
                
                rs = ptm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("projectID");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return  id;
    }
    private final String CREATE_SKILL_PROJECT ="INSERT INTO NeededSkills(projectID, skillID)\n" +
"VALUES(?,?)";
    public boolean createSkillProjectNeed(int projectID, int parseInt) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_SKILL_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, parseInt);
                check = ptm.executeUpdate() > 0?true:false;               
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }

    public boolean deleteFavoriteProject(int projectID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_FAVORITE_PROJECT_WITH_PROJECTID);
                ptm.setInt(1, projectID);
                
                check = ptm.executeUpdate() > 0;
                if (check) {
                    check = true;
                }
//                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }
    
    public boolean deleteProject(int projectID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PROJECT);
                ptm.setInt(1, projectID);
                
                check = ptm.executeUpdate() > 0;
                if (check) {
                    check = true;
                }
//                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }

    

    

}
