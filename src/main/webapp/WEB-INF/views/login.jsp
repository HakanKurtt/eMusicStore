<%--
  Created by IntelliJ IDEA.
  User: Hakan
  Date: 12.10.2018
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="login-container">
        <div id="login-box">

            <h2>Kullanıcı adı ve parola ile giriş yapınız.</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value='/j_spring_security_check'/>" method="post">
                <div class="form-group">

                    <c:if test="${not empty error}">
                        <div class="error" style="color:#ff0000">${error}</div>
                    </c:if>

                    <label for="username">Kullanıcı: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Parola :</label>
                    <input type="text" id="password" name="password" class="form-control" />
                </div>

                <input type="submit" value="Submit" class="btn btn-default">

                <!-- bu olmadan submit işlemi gerçekleşmez. -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
