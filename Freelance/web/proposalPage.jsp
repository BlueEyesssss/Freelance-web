<%-- 
    Document   : proposalPage
    Created on : May 31, 2022, 12:30:24 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="sample.proposal.ProposalDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proposal Page</title>
    </head>
    <body>
        proposal list
        <%            List<ProposalDTO> listProposal = (List<ProposalDTO>) request.getAttribute("LIST_PROPOSAL");
            if (listProposal != null) {
                if (listProposal.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>

                    <th>proposalID</th>
                    <th>projectID ID</th>
                    <th>seekerID</th>
                    <th>paymentAmount</th>
                    <th>proposalStatusName</th>
                    <th>clientGrade</th>
                    <th>clientComment</th>
                    <th>seekerGrade</th>

                </tr>
            </thead>
            <tbody>
                <%
                    
                    for (ProposalDTO proposal : listProposal) {
                %>
                <tr>
                    
                    <td><%= proposal.getProposalID()%></td>
                    <td><%= proposal.getProjectID()%></td>
                    <td><%= proposal.getSeekerID()%></td>
                    <td><%= proposal.getPaymentAmount()%></td>
                    <td><%= proposal.getProposalStatusName()%></td>
                    <td><%= proposal.getClientGrade()%></td>
                    <td><%= proposal.getClientComment()%></td>
                    <td><%= proposal.getSeekerGrade()%></td>




                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
                }
            }
        %>
    </body>
</html>
