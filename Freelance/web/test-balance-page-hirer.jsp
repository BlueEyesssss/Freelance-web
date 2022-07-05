<%-- 
    Document   : test-balance-page-hirer
    Created on : Jul 5, 2022, 10:53:29 PM
    Author     : LENOVO
--%>

<%@page import="sample.transactionhandling.TransactionHandlingDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.hirer.HirerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blance hirer Page</title>
    </head>
    <body>
        <%
            HirerDTO hirer = (HirerDTO)session.getAttribute("USER_LOGIN");
            List<TransactionHandlingDTO> listTranHis = (List<TransactionHandlingDTO>)request.getAttribute("LIST_TRANSACTION_HITORY");
        %>
        <h1>Hello <%= hirer.getFullName() %></h1>
        <form action="MainController">
            your balance: <input type="text" name="balance" value="<%= hirer.getBalance() %>" readonly=""/>
            <input type="submit" value="Recharge" name="action" />
            <input type="submit" value="Cash out" name="action" />
        </form>
            <table border="1">
                    <thead>
                        <tr>
                            <th>transaction id</th>
                            <th>name hirer - money cash out - date create</th>
                            <th>status</th>
                        </tr>
                    </thead>
                    <tbody>
            <%
                if(listTranHis != null){
                for (TransactionHandlingDTO elem : listTranHis) {
                %>
                        <tr>
                            <td><%= elem.getTransactionHandlingID() %></td>
                            <td><%=hirer.getFullName() %> - <%= elem.getAmountMonney()%>$ - <%= elem.getDateCreate()%></td>
                            <td>
                                <%
                                    if(elem.getStatus() == false){
                                    %>
                                    Processing...
                                <%
                                    }else{
                                     %>
                                     Done
                                    <%
                                    }
                                %>
                            </td>
                        </tr>
        <%
                    }
                }
            %>
                 </tbody>
            </table>

    </body>
</html>
