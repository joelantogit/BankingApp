<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>

</head>
<body>
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
    <tr>
        <td>
            <a href="transferMoney.jsp">Transfer Money</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="viewTransactions.jsp">View Transactions</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="applyLoan.jsp">Apply Loan</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
