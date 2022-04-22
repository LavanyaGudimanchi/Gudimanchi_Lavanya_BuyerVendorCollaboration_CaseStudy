<jsp:include page="../include/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container" id="mainContent">
    <h2 >Product Information</h2>

    <c:if test="${bindingResult.hasErrors()}">
        <br>
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <div style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
    </c:if>

    <form:form action="/vendor/saveProduct" method="POST" modelAttribute="product">
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
            <form:select path="category" class="form-control">
            <form:option  value="">--- Select an option ---</form:option>
            <form:options items="${categories}" />
            </form:select>
        </div>
        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col justify-content-center">
                <!-- Radio button -->
                <div class="form-check">
                    <form:radiobutton path="isAvailable" value="Y" class="form-check-input"/> Available
                </div>
            </div>
            <div class="col justify-content-center">
               <!-- Radio button -->
               <div class="form-check">
                    <form:radiobutton path="isAvailable" value="N" class="form-check-input"/> Out of Stock
               </div>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col justify-content-center">
                <form:button type="submit1" class="btn btn-primary btn-block mb-4" name="save" id="mybutton">Add/Update</form:button>
            </div>
            <div class="col justify-content-center">
                <form:button type="submit2" class="btn btn-primary btn-block mb-4" name = "delete" id="mybutton">Delete</form:button>
            </div>
        </div>

    </form:form>


</div>
<jsp:include page="../include/footer.jsp" />