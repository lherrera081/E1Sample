<%-- 
    Document   : insertCustomer
    Created on : 8/06/2015, 05:13:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Edit customer</title>
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
            <h1>Customer</h1>
            <form action="${pageContext.request.contextPath}/editCustomer.do" method="post">
                <div class="form">
                    <div class="form-item">
                        <div class="form-label">
                            Customer id: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="customerId" value="${customer.customerId}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            Name: 
                        </div>
                        <div class="form-input">
                            <input type="text" name="name" value="${customer.name}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            Last name:
                        </div>
                        <div class="form-input">
                            <input type="text" name="lastName" value="${customer.lastName}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            City:
                        </div>
                        <div class="form-input">
                            <input class="button" type="text" name="cityId" value="${customer.cityId}">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="form-label">
                            State:
                        </div>
                        <div class="form-input">
                            <input class="button" type="text" name="stateId" value="${customer.stateId}">
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
