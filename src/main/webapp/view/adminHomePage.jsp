<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 12/7/22
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>
</head>
<body>
Welcome <%=session.getAttribute("userName")%>
<form>
    <table>
        <thead>
        <th>Menu</th>
        </thead>
        <tbody>
        <tr>
            <td>
                <a href="../admin-view-loans">Approve/Reject Loans</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
