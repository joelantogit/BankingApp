<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 12/7/22
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>
</head>
<body>
Balance = <%= session.getAttribute("balance")%>
<br>
<br>
<table>
    <thead>
    <th>Welcome <%=session.getAttribute("userName")%></th>
    </thead>
    <tbody>
    <tr>
        <td>
            <a href="changePassword.jsp">Change Password</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="../view-balance">View Balance</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
