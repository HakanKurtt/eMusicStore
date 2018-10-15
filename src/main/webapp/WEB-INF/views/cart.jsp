<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

    <div class="container-wrapper">
        <div class="container">
            <section>
                <div class="jumbotron">
                    <div class="container">
                        <h1>Cart</h1>

                        <p>Alışveriş sepetinizde seçili olan tüm ürünler</p>
                    </div>
                </div>
            </section>

            <section class="container">
                <div>
                    <a href="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove"></span>Sepeti Temizle</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr>
                        <td>productName</td>
                        <td>productPrice</td>
                        <td>quantity</td>
                        <td>totalPrice</td>
                        <td>remove button</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>grandTotal</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value='/productList'/>">Continue Shopping</a>
            </section>



        </div>

    </div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>
