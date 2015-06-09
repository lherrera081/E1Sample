<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
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
            <h1>Welcome</h1>
            <p>This is a final project of Software Architecture.</p>
            <p>The pages of basic options are following:</p>
            <ul>
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
                <p>Luis Daniel Herrera</p>
                <p>Codigo 11141418950</p>
                <p>Ingeniería de sistemas - Distancia</p>
        </div>
    </body>
</html>