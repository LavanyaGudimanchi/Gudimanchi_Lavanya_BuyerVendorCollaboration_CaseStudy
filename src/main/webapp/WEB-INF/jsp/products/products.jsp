<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Products List</h2>
<table>
    <tr>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Price</th>
        <th>Select Items</th>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="tagStatus">

        <tr>
            <td>
                <input type="checkbox" name="productId" value="${product.productId}">
            </td>
            <td>${product.productName}</td>
            <td>${product.productDescription}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
<!-- Submit button -->
<form class="form-inline my-2 my-lg-0" action="/user/addProduct" method="GET">
    <button type="submit" class="btn btn-primary btn-block mb-4">Add new Product</button>
</form>
<!-- Add to cart button -->
<form class="form-inline my-2 my-lg-0" action="products/addtoCart" method="GET">
    <button type="submit" class="btn btn-primary btn-block mb-4">Add new Product</button>
</form>

<h3></h3>


<jsp:include page="../include/footer.jsp"/>