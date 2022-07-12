<%@ page import="com.ncs.bankingapp.model.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 12/7/22
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>
</head>
<body>
<%
    List<Transaction> transactionList;
    transactionList = (List<Transaction>) session.getAttribute("transactionList");
    for(int i = 0; i<transactionList.size(); i+=1) {
%>
<tr>
    <td><%=transactionList.get(i).getUserName()%></td>
    <td><%=transactionList.get(i).getAmount()%></td>
    <td><%=transactionList.get(i).getType()%></td>
    <td><%=transactionList.get(i).getDate()%></td>
    <br>
</tr>
<% } %>

<form action="homePage.jsp">
    <input type="submit" value="Home">
</form>
</body>
</html>
