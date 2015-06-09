<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Products</title>
    </head>
    <body>
        <div class="header">
            <img src="http://www.uan.edu.co/images/admin/Logo1200.png">
        </div>
        <div class="menu">
            <ul>
                
                <li>
                    <a href="${pageContext.request.contextPath}/home.do"/>Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/listProducts.do"/>Products</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/listCustomers.do"/>Customers</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/listCategories.do"/>Categories</a>
                </li>
            </ul>
        </div>
        <div class="body-page">
            <h1>Products</h1>
            <div class="toolbar">
                <a href="${pageContext.request.contextPath}/insertProduct.do" class="button">Insertar</a>
            </div>
        <table>
            <thead>
                <tr>
                    <th>Product name</th>
                    <th>Price</th>
                    <th></th>                    
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <!-- Here the productList variable used in items is the same name 
                used when storing the result in the ListProducts command class-->
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <!-- Here we use the product variable defined in the for each loop-->
                        <td><c:out value="${product.name}"></c:out></td>
                        <td><c:out value="${product.price}"></c:out></td>
                        <td><a href="${pageContext.request.contextPath}/insertProduct.do?productId=${product.productId}"/>Editar</a></td>
                        <td><a href="${pageContext.request.contextPath}/deleteProduct.do?productId=${product.productId}"/>Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
