<%-- 
    Document   : insertProduct
    Created on : 6/06/2015, 09:42:03 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Edit product</title>
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
            <h1>Product</h1>
            <form action="${pageContext.request.contextPath}/editProduct.do" method="post">
                <div class="form">
                    <div class="form-item">
                        <div class="form-label">
                            Product id: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="productId" value="${product.productId}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            Product name: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="productName" value="${product.name}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            Price:
                        </div>
                        <div class="form-input">
                            <input class="button" type="text" name="productPrice" value="${product.price}">
                        </div>
                    </div>

                    <div class="toolbar">
                        <input type="submit" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
