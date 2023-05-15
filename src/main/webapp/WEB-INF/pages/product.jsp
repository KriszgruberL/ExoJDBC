<%@ page import="bstorm.be.demoservletjava23.domain.dtos.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="bstorm.be.demoservletjava23.repositories.ProductRepository" %>
<%@ page import="bstorm.be.demoservletjava23.repositories.ProductRepositoryImpl" %><%--
  Created by IntelliJ IDEA.
  User: studentdev02
  Date: 10-05-23
  Time: 09:40
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
    <link rel="stylesheet" href="../../styles/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <button class="btn btn-dark" type="button" data-bs-toggle="modal"
            data-bs-target="#addModal">
        <a href=""
        Add a product
    </button>
    <br>
    <br>
    <div class="row gy-3">
        <c:forEach items="${product}" var="product">
            <div class="col-md-3">
                <div class="card mb-3 border-dark-subtle h-100">
                    <div class="card-body">
                        <h3 class="card-title">${product.nameProduct}
                        </h3>
                        <h5 class="card-text">${product.type}
                        </h5>
                        <p class="card-text">${product.description.length() > 50 ? product.description.substring(0,50).concat("...") : product.description}
                        </p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item border-dark-subtle">
                            <div class="d-grid gap-2 d-md-block text-center ">
                                <button class="btn btn-danger" type="button" data-bs-toggle="modal"
                                        data-bs-target="#delModal">Delete
                                </button>
                                <button class="btn btn-dark" type="button" data-bs-toggle="modal"
                                        data-bs-target="#modifyModal">Modify
                                </button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<div class="modal fade" id="delModal" tabindex="-1" aria-labelledby="delModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="delModalLabel">Delete a product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h3 class="text-center"> Are you sure ?</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">No </button>
                <button type="button" class="btn btn-dark">Yes !</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="modifyModal" tabindex="-1" aria-labelledby="modifyModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="modifyModalLabel">Modify a product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="modify-product-name" class="col-form-label">Name : </label>
                        <input type="text" class="form-control" id="modify-product-name">
                    </div>
                    <div class="mb-3">
                        <label for="modify-product-type" class="col-form-label">Type :</label>
                        <input type="text" class="form-control" id="modify-product-type">
                    </div>
                    <div class="mb-3">
                        <label for="modify-product-quantity" class="col-form-label">Quantity :</label>
                        <input type="text" class="form-control" id="modify-product-quantity">
                    </div>
                </form>
                <label for="modify-product-description" class="col-form-label">Description : </label>
                <textarea class="form-control" id="modify-product-description"></textarea>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-dark">Save</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addModalLabel">Add a product</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="product-name" class="col-form-label">Name : </label>
                        <input type="text" class="form-control" id="product-name">
                    </div>
                    <div class="mb-3">
                        <label for="product-type" class="col-form-label">Type :</label>
                        <input type="text" class="form-control" id="product-type">
                    </div>
                    <div class="mb-3">
                        <label for="product-quantity" class="col-form-label">Quantity :</label>
                        <input type="text" class="form-control" id="product-quantity">
                    </div>
                </form>
                <label for="product-description" class="col-form-label">Description : </label>
                <textarea class="form-control" id="product-description"></textarea>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-dark">Save</button>
            </div>
        </div>
    </div>
</div>


</body>

<script src="../../js/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>