<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <form:form style="margin: auto; width: 400px; margin-top: 3rem;" action="/vendor/saveProduct" method="POST" modelAttribute="product">
    <form:hidden path="id"></form:hidden>
        <div class="form-outline mb-4">
            <label class="form-label" for="productName" >Product Name</label>
            <form:input type="productName" id="productName" class="form-control" name="productName"  path="productName"/>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="productDescription" >Product Description</label>
            <form:input type="productDescription" id="productDescription" class="form-control" name="productDescription"  path="productDescription"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="price" >Price</label>
            <form:input type="price" id="price" class="form-control" name="price"  path="price"/>
        </div>


    <div class="form-outline mb-4">
        <label for="category" class="form-label">Category</label>
        <br>
        <form:select path="category"  >
            <form:option  value="">--- Select an option ---</form:option>
            <form:options items="${categories}" />
        </form:select>
    </div>

    <div  class="form-outline mb-4">
            <form:radiobutton path="isAvailable" value="Y"/> Available
            <form:radiobutton path="isAvailable" value="N"/> Out of Stock
    </div>
    <div class="col-8">
        <form:button type="submit1" class="btn btn-primary btn-block mb-4" name="save">Add/Update</form:button>
    </div>
    <div class="col-8">
        <form:button type="submit2" class="btn btn-primary btn-block mb-4" name = "delete">Delete</form:button>
    </div>
</form:form>

<jsp:include page="../include/footer.jsp" />