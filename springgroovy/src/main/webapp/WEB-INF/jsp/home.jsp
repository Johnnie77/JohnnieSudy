<%--
  Created by IntelliJ IDEA.
  User: johney
  Date: 15. 6. 8.
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
  <title>Home</title>
  <link rel="stylesheet"
        href='<spring:url value="/resources/bootstrap/css/bootstrap.min.css"/>' />
  <link rel="stylesheet"
        href='<spring:url value="/resources/css/custom.css"/>' />
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">DEVJAV</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="active"><a href="<spring:url value="/logout.do"/>">Logout</a></li>
      </ul>
    </div>
    <!--/.nav-collapse -->
  </div>
</div>
<div class="container">
  <div class="starter-template">
    <h1>User View</h1>
    <p class="lead">This is user home page</p>
  </div>
</div><!-- /.container -->
</body>
</html>
