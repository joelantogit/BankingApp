<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>!DBS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="css.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- Navbar -->
<div id="header" >
    <div id="state">
        <nav class="navbar navbar-expand-lg  sticky-top bg-transparent" style="padding: 2px;" >
            <div class="container-fluid">
                <a class="navbar-brand" href="homePage.jsp"><img src="images/logo.png" width="43" height="28" alt="logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse position-relative" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active " aria-current="page"  href="homePage.jsp"><b>Home</b></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Account
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="changePassword.jsp">Change Password</a></li>
                                <li><a class="dropdown-item" href="../view-balance">Check Balance</a></li>
                                <li><a class="dropdown-item" href="viewTransactions.jsp">View Transactions</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="transferMoney.jsp">Transfer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="applyLoan.jsp">Loan</a>
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
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-md-8">
                    <form class="bg-gradient rounded-5 shadow-5-strong p-5 " id="frosted-glass">
                        <center><h1><div class="  ">Loan Application Submitted!</div></h1></center>
                        <center><div><h3 class="text-secondary">Experience the power of seamless Banking.</h3></div></center>
                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>