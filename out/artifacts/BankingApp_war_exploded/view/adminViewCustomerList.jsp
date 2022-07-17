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
                            <a class="nav-link"  href="#home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../admin-view-loans">Loan Applicatons</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active " aria-current="page" href="../admin-get-customer-details">Customer info</a>
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
                <div class="col-xl-5 col-md-8" style="width: auto">
                    <div class="  rounded-5 shadow-5-strong p-5 " id="frosted-glass" style="max-height: inherit">
                        <center style="padding: 10px;"><h1><div class="text-secondary ">Customer Details</div></h1></center>
                        <table class="table container vertical-scrollable" style="overflow-y: scroll" >
                            <thead>
                            <%
                                List<Customer> customers =(List<Customer>) session.getAttribute("customers");
                                if(null!=customers){
                            %>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Username</th>
                                <th scope="col">Balance</th>
                                <th scope="col">Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%

                                for(int i=0;i<customers.size();i++){
                            %>
                            <tr>
                                <th scope="row "><%=i+1%></th>
                                <td><%=customers.get(i).getName()%></td>
                                <td><%=customers.get(i).getUserName()%></td>
                                <td><%=customers.get(i).getBalance()%></td>
                                <td><%=customers.get(i).getEmail()%></td>
                            </tr>
                            <% }
                            }
                            else {
                            %>
                            <center style="padding: 10px;"><h3><div class="text-secondary ">No users found.</div></h3></center>
                            <%
                                }
                            %>
                            </tbody>
                        </table>

                        <!-- Pills content -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>

