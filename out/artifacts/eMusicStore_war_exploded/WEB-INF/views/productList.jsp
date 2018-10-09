<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>All Products</h1>

            <p1 class="lead">Checkout all the awesome products available now!</p1>

            <table class="table table-striped table-hover">
                <thead>
                    <tr class="bg-success">
                        <th>Photo Thumb</th>
                        <th>Product Name</th>
                        <th>Category</th>
                        <th>Condition</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td><img src="#" alt="image" /></td>
                        <td>${product.productName}</td>
                        <td>${product.productCategory}</td>
                        <td>${product.productCondition}</td>
                        <td>${product.productPrice} USD</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>