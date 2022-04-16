<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
    <tr>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="tagStatus">
        <tr>
            <td>${product.productName}</td>
            <td>${product.productDescription}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />