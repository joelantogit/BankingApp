<%@ page import="com.ncs.bankingapp.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Baking App</title>
</head>
<body>
<%
    List<Customer> customerList = (List<Customer>) session.getAttribute("customers");
    for(Customer customer: customerList){
        %>
    <tr>
        <td><%=customer.getName()%></td>
        <td><%=customer.getUserName()%></td>
        <td><%=customer.getBalance()%></td>
    </tr>
        <%
    }
%>

</body>
</html>
