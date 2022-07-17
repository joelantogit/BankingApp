<%@ page import="com.ncs.bankingapp.model.Loan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ncs.bankingapp.model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>!DBS (Admin)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="css.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- Navbar -->
<div id="header" >
    <div id="state">
        <nav class="navbar navbar-expand-lg  sticky-top bg-transparent " style="padding: 2px;" >
            <div class="container-fluid">
                <a class="navbar-brand" href="#home"><img src="images/logo.png" width="43" height="28" alt="logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse position-relative" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="#home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active " aria-current="page"  href="../admin-view-loans">Loan Applicatons</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../admin-get-customer-details">Customer info</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 position-absolute  end-0">
                        <li class="nav-item ">
                            <a class="nav-link btn btn-outline-danger " href="../logout">Logout</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar -->


<div id="intro" class="bg-image shadow-2-strong" >
    <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0, 0, 0, 0);">
        <div class="container" style="max-height: 90%">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-md-8"style="width: auto;">
                    <div class="  rounded-5 shadow-5-strong p-5 " id="frosted-glass">
                        <div class="  rounded-5 shadow-5-strong p-5 frosted-glass-2" style="max-height: 400px; overflow-y: scroll">
                            <center style="padding: 10px;"><h1><div class="text-black ">Pending Action</div></h1></center>
                            <table class="table container vertical-scrollable" style="overflow-y: scroll"  >
                                <thead>
                                <%
                                    List<Loan> allLoans =(List<Loan>) session.getAttribute("allLoans");
                                    List<Loan> pendingLoans =(List<Loan>) session.getAttribute("pendingLoans");
                                    if(null!=pendingLoans){
                                %>
                                    <tr >
                                        <th scope="col">#</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Amount</th>
                                        <th scope="col">Evaluation Result</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                <%
                                        for(int i=0;i<pendingLoans.size();i++){
                                %>

                                        <th scope="row "><%=i+1%></th>
                                        <td><%=pendingLoans.get(i).getUserName()%></td>
                                        <td><%=pendingLoans.get(i).getAmount()%></td>
                                        <td>
                                            <%
                                                int amount = pendingLoans.get(i).getAmount();
                                                Customer customer = new Customer(pendingLoans.get(i).getUserName());
                                                customer.userNameExistsInDb();
                                                if(customer.getBalance()*10>amount){
                                            %>Pass
                                            <%}
                                            else{
                                            %>Fail
                                            <%}%>
                                        </td>
                                        <td class="row">
                                            <form action="../admin-approve-reject-loan">
                                                <input type="text" hidden value="<%=pendingLoans.get(i).getUserName()%>" name="userName">
                                                <input type="text" hidden value="<%=pendingLoans.get(i).getAmount()%>" name="amount">
                                                <input type="submit" value="Accept" name="status" class=" col-md-6 btn" style="width: 80px;background-color: #87bcdd" >
                                                <input type="submit" value="Reject" name="status" class="col-md-6 btn  btn-secondary" style="width: 80px;">
                                            </form>
                                        </td>
                                    </tr>
                                <% }
                                    }
                                    else {
                                        %>
                                <center style="padding: 10px;"><h3><div class="text-secondary ">No pending applications</div></h3></center>
                                <%
                                }%>
                                </tbody>
                            </table>
                        </div>
                        <div class="  rounded-5 shadow-5-strong p-5 frosted-glass-3 "  style="max-height: 400px;overflow-y: scroll">
                            <center style="padding: 10px;"><h1><div class="text-black ">All Loans</div></h1></center>
                            <table class="table container vertical-scrollable" style="overflow-y: scroll" >
                                <thead>
                                <%
                                    if(null!=allLoans){
                                %>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Amount</th>
                                    <th scope="col">Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%

                                        for(int i=0;i<allLoans.size();i++){
                                %>
                                    <tr>
                                        <th scope="row "><%=i+1%></th>
                                        <td><%=allLoans.get(i).getUserName()%></td>
                                        <td><%=allLoans.get(i).getAmount()%></td>
                                        <td><%=allLoans.get(i).getStatus()%></td>
                                    </tr>
                                <% }
                                }
                                    else {
                                        %>
                                <center style="padding: 10px;"><h3><div class="text-secondary ">No applications found.</div></h3></center>
                                <%
                                }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>

