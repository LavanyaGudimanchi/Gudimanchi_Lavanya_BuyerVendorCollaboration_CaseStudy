<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="row g-3"  action="/vendor/saveProduct" method="POST" modelAttribute="product" >
    <form:hidden path="id"></form:hidden>
    <div class="col-6">
        <label for="name" class="form-label">Product Name</label>
        <form:input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St"  path="productName" />
    </div>
    <div class="col-6">
        <label for="desciption" class="form-label">Product Description</label>
        <form:input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" path="productDescription" />
    </div>

    <div class="col-md-6">
        <label for="price" class="form-label">Price</label>
        <form:input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" path="price" />
    </div>
    <div class="col-md-6">
        <label for="category" class="form-label">Category</label>
        <br>
        <form:select path="category"  >
            <form:option  value="">--- Select an option ---</form:option>
            <form:options items="${categories}" />
        </form:select>
    </div>

    <div class="col-12">
            <form:radiobutton path="isAvailable" value="Y"/>Available
            <form:radiobutton path="isAvailable" value="N"/>Out of Stock
    </div>
    <div class="col-4">
        <form:button type="submit1" class="btn btn-primary" name="save">Add/Update</form:button>
    </div>
    <div class="col-8">
        <form:button type="submit2" class="btn btn-primary" name = "delete">Delete</form:button>
    </div>
</form:form>

<jsp:include page="../include/footer.jsp" />