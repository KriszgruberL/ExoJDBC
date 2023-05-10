<%@ page import="bstorm.be.demoservletjava23.domain.dtos.ProductDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: studentdev02
  Date: 10-05-23
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../styles/style.css">
    <link href="
https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
" rel="stylesheet">
    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row gy-3">
        <% for (ProductDTO p : (List<ProductDTO>) request.getAttribute("product")) { %>
        <div class="col-md-3">
            <div class="card mb-3 border-dark-subtle h-100">
                <div class="card-body">
                    <h3 class="card-title"><%=p.getNameProduct()%>
                    </h3>
                    <h5 class="card-text"><%=p.getType()%>
                    </h5>
                    <p class="card-text"><%=p.getDescription()%>
                    </p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item border-dark-subtle">
                        <div class="d-grid gap-2 d-md-block ">
                            <button class="btn btn-dark" type="button">Delete</button>
                            <button class="btn btn-dark" type="button">Modify</button>
                        </div>
                    </li>
                </ul>


            </div>
        </div>
        <% } %>
    </div>
    <button type="submit">Add</button>
</div>


</body>
</html>