<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="row g-3" action="saveProduct" method="POST" modelAttribute="product" >
    <div class="col-6">
        <label for="inputAddress" class="form-label">Product Name</label>
        <form:input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St"  path="productName" />
    </div>
    <div class="col-6">
        <label for="inputAddress2" class="form-label">Product Description</label>
        <form:input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" path="productDescription" />
    </div>

    <div class="col-md-6">
        <label for="price" class="form-label">Price</label>
        <form:input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" path="price" />
    </div>
    <div class="col-md-4">
        <label for="inputState" class="form-label">Category</label>
        <form:select id="inputState" class="form-select" path="category">
            <option selected path="category">Choose...</option>
            <c:forEach items="${categories}" var="category" varStatus="tagStatus">
                <option>${category}</option>
            </c:forEach>
        </form:select>

    </div>
    <div class="col-12">
            <form:radiobutton path="isAvailable" value="Y"/>Available
            <form:radiobutton path="isAvailable" value="N"/>Out of Stock
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
</form:form>

<jsp:include page="../include/footer.jsp" />