<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2>Products List</h2>
<table>
    <tr>
<sec:authorize access="hasAuthority('BUYER')">
            <th>Select Items</th>
</sec:authorize>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Price</th>
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
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
<!-- Submit button -->
<sec:authorize access="hasAuthority('VENDOR')">
<form class="form-inline my-2 my-lg-0" action="/vendor/addProduct" method="GET">
    <button type="submit" class="btn btn-primary btn-block mb-4">Add new Product</button>
</form>
</sec:authorize>
<!-- Add to cart button -->
<sec:authorize access="hasAuthority('BUYER')">
<form class="form-inline my-2 my-lg-0" action="/buyer/addToCart" method="GET">
    <button type="submit" class="btn btn-primary btn-block mb-4">Add to Cart</button>
</form>
</sec:authorize>
<h3></h3>


<jsp:include page="../include/footer.jsp"/>