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
        <nav class="navbar navbar-expand-lg  sticky-top bg-transparent " style="padding: 2px; pointer-events: none" >
            <div class="container-fluid">
                <a class="navbar-brand" href="#home"><img src="images/logo.png" width="43" height="28" alt="logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse position-relative" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active " aria-current="page"  href="#home">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Account
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Change Password</a></li>
                                <li><a class="dropdown-item" href="#">Check Balance</a></li>
                                <li><a class="dropdown-item" href="#">View Transactions</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Transfer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Loan</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 position-absolute  end-0">
                        <li class="nav-item ">
                            <a class="nav-link btn btn-outline-danger " href="#">Logout</a>
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
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-md-8">
                    <div class="bg-white  rounded-5 shadow-5-strong p-5 ">
                        <center style="padding: 10px;"><h1><div class="text-secondary ">Welcome User!</div></h1></center>
                        <center style="padding: 10px;"><h3><div class="text-success ">Password Updated, Check email for new Password</div></h3></center>

                        <!-- Pills navs -->
                        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="landingPage.jsp" role="tab"
                                   aria-controls="pills-login" aria-selected="true">Login</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" id="tab-register" data-mdb-toggle="pill" href="registerCustomer.jsp" role="tab"
                                   aria-controls="pills-register" aria-selected="false">Register</a>
                            </li>
                        </ul>
                        <!-- Pills navs -->

                        <!-- Pills content -->
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                                <form action="../login-servlet">

                                    <!-- userName input -->
                                    <div class="form-outline mb-4">
                                        <input type="text" id="loginName" class="form-control" name="userName" required />
                                        <label class="form-label" for="loginName">Username</label>
                                    </div>

                                    <!-- Password input -->
                                    <div class="form-outline mb-4">
                                        <input type="password" id="loginPassword" class="form-control" name="password" required />
                                        <label class="form-label" for="loginPassword">Password</label>
                                    </div>

                                    <!-- Submit button -->
                                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Sign in">
                                </form>
                                <div class="row justify-content-center">
                                    <a href="forgotPassword.jsp" >Forgot Password?</a>
                                </div>
                            </div>
                        </div>
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