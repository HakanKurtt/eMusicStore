<%--
  Created by IntelliJ IDEA.
  User: Hakan
  Date: 10.10.2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>Administrator Page</h1>

            <p1 class="lead">Welcome Admin!</p1>
        </div>

        <h3>
            <a href="<c:url value='/admin/productInventory'/>">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>
