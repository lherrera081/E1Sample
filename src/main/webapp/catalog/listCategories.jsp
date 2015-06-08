<%-- 
    Document   : listCategories
    Created on : 8/06/2015, 05:33:49 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Categories</title>
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
                    <a href="${pageContext.request.contextPath}/listOrders.do"/>Orders</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/listCategories.do"/>Categories</a>
                </li>
            </ul>
        </div>
        <div class="body-page">
            <h1>Categories</h1>
            <div class="toolbar">
                <a href="${pageContext.request.contextPath}/insertCategory.do" class="button">Insertar</a>
            </div>
        <table>
            <thead>
                <tr>
                    <th>Category name</th>
                    <th></th>                    
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categoryList}" var="category">
                    <tr>
                        <td><c:out value="${category.name}"></c:out></td>
                        <td><a href="${pageContext.request.contextPath}/insertCategory.do?categoryId=${category.categoryId}"/>Editar</a></td>
                        <td><a href="${pageContext.request.contextPath}/deleteCategory.do?categoryId=${category.categoryId}"/>Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
