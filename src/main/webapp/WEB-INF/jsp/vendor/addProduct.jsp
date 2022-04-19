<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="row g-3"  action="/vendor/saveProduct" method="POST" modelAttribute="product" >
    <form:hidden path="id"></form:hidden>
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
    <div class="col-md-6">
        <label for="inputState" class="form-label">Category</label>
        <br>
       <form:select id="inputState" class="form-select" path="category" >
            <option selected path="category">Choose...</option>
            <c:forEach items="${categories}" var="thiscategory" varStatus="tagStatus">
                <c:choose>
                    <c:when test="${thiscategory == category}">
                        <option selected >${thiscategory}</option>
                    </c:when>
                    <c:otherwise>
                        <option >${thiscategory}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>

    <div class="col-12">
            <form:radiobutton path="isAvailable" value="Y"/>Available
            <form:radiobutton path="isAvailable" value="N"/>Out of Stock
    </div>
    <div class="col-4">
        <form:button type="submit1" class="btn btn-primary">Add/Update</form:button>
    </div>
    <div class="col-8">
        <form:button type="submit2" class="btn btn-primary">Delete</form:button>
    </div>
</form:form>

<jsp:include page="../include/footer.jsp" />