<%--
  Created by IntelliJ IDEA.
  User: johney
  Date: 15. 6. 8.
  Time: 오후 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title></title>
</head>
<body>
<div>
  <p>This is Login Page.</p>
  <form:form name="f" action="/signup/createUser" method="post">
    <fieldset>
      <legend>Please Login</legend>
      <c:if test="${param.error}">
        <div class="alert alert-error">
          Invalid username and password.
        </div>
      </c:if>
      <c:if test="${param.logout}">
        <div class="alert alert-success">
          You have been logged out.
        </div>
      </c:if>

      <label for="username">Username</label>
      <input type="text" id="username" name="username"/>
      <label for="password">Password</label>
      <input type="password" id="password" name="password"/>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <div class="form-actions">
        <button type="submit" class="btn">Signup</button>
      </div>
    </fieldset>
  </form:form>
</div>
</body>
</html>
