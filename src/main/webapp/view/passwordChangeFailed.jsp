<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Banking App</title>
</head>
<body>
Password update Failed, Please retry.
<form action="../change-password">
    <table>
        <thead>
        <th>Change Password</th>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="currentPassword" placeholder="Current Password"></td>
        </tr>
        <tr>
            <td><input type="text" name="newPassword" placeholder="New Password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
