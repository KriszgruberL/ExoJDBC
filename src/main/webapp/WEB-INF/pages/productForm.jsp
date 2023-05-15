<%--
  Created by IntelliJ IDEA.
  User: studentdev02
  Date: 15-05-23
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>productForm</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="AddProduct">
  <fieldset>
    <label for="name"> Name:</label>
    <input type="text" id="name" name="name">

    <select id="typeId" name="typeId">
      <c:forEach items="${types}" var="type">
        <option value="${type.id}"> ${type.name}</option>
      </c:forEach>
    </select>
  </fieldset>
  <fieldset class="hidden">
    <label for="typeName">Type : </label>
      <input type="text" id="typeName" name="typeName">
  </fieldset>
    <button type="submit">Add</button>
</form>

</body>
</html>