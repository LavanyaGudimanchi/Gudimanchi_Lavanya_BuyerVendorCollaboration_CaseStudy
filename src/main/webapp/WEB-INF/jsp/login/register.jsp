<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container" id="mainContent">
    <h2 >Register User</h2>
    <form:form action="registerSubmit" method="POST" modelAttribute="user">

        <div class="form-outline mb-4">
            <label class="form-label" for="loginid" >Login Id</label>
            <c:forEach items='${bindingResult.getFieldErrors("loginId")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
            <form:input type="loginId" id="loginid" class="form-control" name="loginId"  path="loginId"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="Password" >Password</label>
            <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
            <form:input type="password" id="password" class="form-control" name="password"  path="password"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="confirmpassword" >Confirm Password</label>
            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
            <form:input type="password" id="confirmpassword" class="form-control" name="confirmPassword"  path="confirmPassword"/>
        </div>

        <hr class="rounded">
        <h4 >Personal Information</h4>
        <div class="row mb-4">

            <div class="col justify-content-center">
                <label class="form-label" for="firstName" >First Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <form:input type="firstName" id="firstName" class="form-control" name="firstName"  path="firstName"/>
            </div>

            <div class="col justify-content-center">
                <label class="form-label" for="lastName">Last Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <form:input type="lastName" id="lastName" class="form-control" name="lastName" path="lastName"/>
            </div>

        </div>
        <div class="row mb-4">

            <div class="col justify-content-center">
                <label class="form-label" for="email" >Email</label>
                <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <form:input type="email" id="email" class="form-control" name="email"  path="email"/>
            </div>

            <div class="col justify-content-center">
                <label class="form-label" for="phonenumber" >Phone Number</label>
                <c:forEach items='${bindingResult.getFieldErrors("phoneNumber")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <form:input type="phoneNumber" id="phonenumber" class="form-control" name="phoneNumber"  path="phoneNumber"/>
            </div>

        </div>
        <hr class="rounded">
        <h4 >Company Information</h4>

        <div class="form-outline mb-4">
            <label class="form-label" for="companyname" >Company Name</label>
            <form:input type="companyName" id="companyname" class="form-control" name="companyName"  path="companyName"/>
        </div>

        <div class="row mb-4">
            <div class="col justify-content-center">
                <label class="form-label" for="addressline1" >Address Line1</label>
                <form:input type="addressLine1" id="addressline1" class="form-control" name="addressLine1"  path="addressLine1"/>
            </div>
            <div class="col justify-content-center">
                <label class="form-label" for="addressline2" >Address Line2</label>
                <form:input type="addressLine2" id="addressline2" class="form-control" name="addressLine2"  path="addressLine2"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col justify-content-center">
                <label class="form-label" for="city" >City</label>
                <form:input type="city" id="city" class="form-control" name="city"  path="city"/>
            </div>
            <div class="col justify-content-center">
                <label class="form-label" for="state" >State</label>
                <form:input type="state" id="state" class="form-control" name="state"  path="state"/>
            </div>
            <div class="col justify-content-center">
                <label class="form-label" for="zipcode" >Zipcode</label>
                <form:input type="zipcode" id="zipcode" class="form-control" name="zipcode"  path="zipcode"/>
            </div>
        </div>
        <div class="form-outline mb-4">
            <form:button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton" >Register</form:button>
        </div>

</form:form>
</div>
<jsp:include page="../include/footer.jsp"/>
