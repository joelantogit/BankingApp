<%--
  Created by IntelliJ IDEA.
  User: jo
  Date: 11/7/22
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<form action="../register-servlet">
    <table>
        <thead>
        <th colspan="2">Enter details below</th>
        </thead>
        <tbody>
        <tr>
            <td><label>Name : </label></td>
            <td><input type="text" placeholder="Name" name="name"></td>
        </tr>
        <tr>
            <td><label>User Name :  </label></td>
            <td><input type="text" placeholder="UserName" name="userName"></td>
        </tr>
        <tr>
            <td><label>Password :  </label></td>
            <td><input type="text" placeholder="password" name="password"></td>
        </tr>
        <tr>

            <td colspan="2"><input type="submit" value="Register"></td>
        </tr>
        </tbody>
    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
