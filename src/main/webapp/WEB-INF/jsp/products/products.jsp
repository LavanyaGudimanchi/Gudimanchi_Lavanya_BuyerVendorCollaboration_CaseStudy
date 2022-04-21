<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2>Products List</h2>
<form class="form-inline my-2 my-lg-0" action="/buyer/addToCart" method="POST">
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
<sec:authorize access="hasAuthority('VENDOR')">
    <th>Update</th>
</sec:authorize>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="tagStatus">
        <tr>
            <sec:authorize access="hasAuthority('BUYER')">
            <td>
                <input type="checkbox" name="productId" value="${product.id}">
            </td>
            </sec:authorize>
            <td>${product.productName}</td>
            <td>${product.productDescription}</td>
            <td>${product.category}</td>
            <td>${product.price}</td>
            <td >${product.isAvailable}</td>
            <sec:authorize access="hasAuthority('VENDOR')">
                <td>
                    <a href="/vendor/addProduct/${product.id}" value="${product.id}">Eidt/Delete</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<!-- Add to cart button -->
<sec:authorize access="hasAuthority('BUYER')">
    <button type="submit" class="btn btn-primary btn-block mb-4">Add to Cart</button>
</sec:authorize>
</form>
<form class="form-inline my-2 my-lg-0" action="/vendor/addProduct" method="GET">
<!-- Submit button -->
<sec:authorize access="hasAuthority('VENDOR')">

        <button type="submit" class="btn btn-primary btn-block mb-4">Add new Product</button>

</sec:authorize>
<h3></h3>
</form>
<jsp:include page="../include/footer.jsp"/>