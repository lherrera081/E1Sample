<%-- 
    Document   : insertCategory
    Created on : 8/06/2015, 05:42:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Category</title>
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
            <h1>Category</h1>
            <form action="${pageContext.request.contextPath}/editCategory.do" method="post">
                <div class="form">
                    <div class="form-item">
                        <div class="form-label">
                            Category id: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="categoryId" value="${category.categoryId}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            Product name: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="name" value="${category.name}">
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
