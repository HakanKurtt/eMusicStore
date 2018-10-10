<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>Product Detail</h1>

            <p1 class="lead">Here is the detailed information about product!</p1>

            <div class="container">
                <div class="row">

                    <div class="col-md-5">
                        <img src="#" alt="image" style="width:100%; height:300px"/>
                    </div>

                    <div class="col-md-5">
                        <h3>${product.productName}</h3>
                        <p>${product.productDescription}</p>
                        <p>
                            <strong>Manufacturer</strong> : ${product.productManufacturer}
                        </p>
                        <p>
                            <strong>Category</strong> : ${product.productCategory}
                        </p>
                        <p>
                            <strong>Condition</strong> : ${product.productCondition}
                        </p>
                        <p>${product.productPrice} USD</p>
                    </div>

                </div>
            </div>

        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>