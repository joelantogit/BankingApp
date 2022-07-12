<%@ page import="com.ncs.bankingapp.model.Loan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ncs.bankingapp.model.Customer" %>
<html>
<head>
    <title>
        Banking App
    </title>

</head>
<body>
Loans pending approval
<table border="2px">
    <thead>
    <th colspan="5">Approve/reject below pending loans</th>
    <tr>
        <td>Username</td>
        <td>Amount</td>
        <td>Evaluation Result(pass/fail)</td>
        <td>Action</td>

    </tr>
    </thead>
    <tbody>

    <%
        List<Loan> loans =(List<Loan>) session.getAttribute("loans");
        for(int i=0;i<loans.size();i++){ %>
    <tr>
        <td><%=loans.get(i).getUserName()%></td>
        <td><%=loans.get(i).getAmount()%></td>
        <td>
            <%
                int amount = loans.get(i).getAmount();
                Customer customer = new Customer(loans.get(i).getUserName());
                customer.userNameExistsInDb();
                if(customer.getBalance()*10>amount){
            %>
            Pass
            <%
                }
                else{
            %>
            Fail
            <%
                }
            %>
        </td>
        <td>
            <table>
                <tbody>
                <form action="../admin-approve-reject-loan">
                    <tr>
                        <td>
                            <input type="text" hidden value="<%=loans.get(i).getUserName()%>" name="userName">
                            <input type="text" hidden value="<%=loans.get(i).getAmount()%>" name="amount">
                            <input type="submit" value="Accept" name="status" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" hidden value="<%=loans.get(i).getUserName()%>" name="userName">
                            <input type="text" hidden value="<%=loans.get(i).getAmount()%>" name="amount">
                            <input type="submit" value="Reject" name="status">
                        </td>
                    </tr>
                </form>
                </tbody>
            </table>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>

</table>
<a href="adminHomePage.jsp">Home</a>
</body>
</html>