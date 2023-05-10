<%--
  Created by IntelliJ IDEA.
  User: byase
  Date: 08-05-23
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="
https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
" rel="stylesheet">
    <link rel="stylesheet" href="../../styles/style.css">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp" />
    <h1>Login</h1>
    <form method="post" action="login">
        <label for="login">Login : </label>
        <input type="text" id="login" name="login" value="${login}">
        <label for="password">Password : </label>
        <input type="password" id="password" name="password">
        <span style="color: red">${errorMessage}</span>
        <button type="submit">Connect</button>
    </form>

</body>
</html>





