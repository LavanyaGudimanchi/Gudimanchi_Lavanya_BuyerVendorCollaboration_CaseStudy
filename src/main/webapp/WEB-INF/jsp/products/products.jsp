<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container" >
    <h2 >Products</h2>
<form action="/buyer/addToCart" method="POST">


    <c:if test="${not empty category}">
        <h5 style="color: mediumvioletred">Search Results Found ${products.size()}</h5>
        <br>
    </c:if>

<table>
    <tr>
<sec:authorize access="hasAuthority('BUYER')">
            <th>Select Items</th>
</sec:authorize>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Category</th>
        <th>Price</th>
        <th>Availability</th>
<sec:authorize access="hasAuthority('BUYER')">
        <th>Vendor</th>
</sec:authorize>
<sec:authorize access="hasAuthority('VENDOR')">
    <th>Update</th>
</sec:authorize>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="tagStatus">
        <tr>
            <sec:authorize access="hasAuthority('BUYER')">
                <c:if test="${product.isAvailable == 'Y'.charAt(0)}">
                    <td>
                        <input type="checkbox" name="productId" value="${product.id}" >
                    </td>
                </c:if>
                <c:if test="${product.isAvailable == 'N'.charAt(0)}">
                    <td>
                        <input type="checkbox"  name="productId" value="${product.id}" disabled="true" >
                    </td>
                </c:if>
            </sec:authorize>
            <td>${product.productName}</td>
            <td>${product.productDescription}</td>
            <td>${product.category}</td>
            <td>${product.price}</td>
            <c:if test="${product.isAvailable == 'Y'.charAt(0)}">
                <td style="color: #008000"><b>Available</b></td>
            </c:if>
            <c:if test="${product.isAvailable == 'N'.charAt(0)}">
                <td style="color: red" ><b>Out of Stock</b></td>
            </c:if>
            <sec:authorize access="hasAuthority('BUYER')">
            <td >${product.vendor.firstName}</td>
            </sec:authorize>
            <sec:authorize access="hasAuthority('VENDOR')">
                <td>
                    <a href="/vendor/addProduct/${product.id}" value="${product.id}">Edit/Delete</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<!-- Add to cart button -->
<sec:authorize access="hasAuthority('BUYER')">
    <button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton" >Add to Cart</button>
</sec:authorize>
</form>
<form style="margin: auto; width: 400px; margin-top: 3rem;" action="/vendor/addProduct" method="GET" >
<!-- Submit button -->
<sec:authorize access="hasAuthority('VENDOR')">

        <button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton">Add new Product</button>

</sec:authorize>
<h3></h3>
</form>
</div>
<jsp:include page="../include/footer.jsp"/>