<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <form:form style="margin: auto; width: 400px; margin-top: 3rem;" action="registerSubmit" method="POST" modelAttribute="user">
        <h2 align="center">User Register Form</h2>
        <div class="form-outline mb-4">
            <label class="form-label" for="firstName" >First Name</label>
            <form:input type="firstName" id="firstName" class="form-control" name="firstName"  path="firstName"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="lastName">Last Name</label>
            <form:input type="lastName" id="lastName" class="form-control" name="username" path="lastName"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="email" >Email</label>
            <form:input type="email" id="email" class="form-control" name="email"  path="email"/>
        </div>


        <div class="form-outline mb-4">
            <label class="form-label" for="Password" >Password</label>
            <form:input type="password" id="password" class="form-control" name="confirmPassword"  path="password"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="confirmpassword" >Confirm Password</label>
            <form:input type="password" id="confirmpassword" class="form-control" name="confirmpassword"  path="confirmPassword"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="phonenumber" >Phone Number</label>
            <form:input type="phoneNumber" id="phonenumber" class="form-control" name="phoneNumber"  path="phoneNumber"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="companyname" >Company Name</label>
            <form:input type="companyName" id="companyname" class="form-control" name="companyName"  path="companyName"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="loginid" >Login Id</label>
            <form:input type="loginId" id="loginid" class="form-control" name="loginId"  path="loginId"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="addressline1" >Address Line1</label>
            <form:input type="addressLine1" id="addressline1" class="form-control" name="addressLine1"  path="addressLine1"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="addressline2" >Address Line2</label>
            <form:input type="addressLine2" id="addressline2" class="form-control" name="addressLine2"  path="addressLine2"/>
        </div>


        <div class="form-outline mb-4">
            <label class="form-label" for="city" >City</label>
            <form:input type="city" id="city" class="form-control" name="city"  path="city"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="state" >State</label>
            <form:input type="state" id="state" class="form-control" name="state"  path="state"/>
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="zipcode" >Zipcode</label>
            <form:input type="zipcode" id="zipcode" class="form-control" name="zipcode"  path="zipcode"/>
        </div>

        <form:button type="submit" class="btn btn-primary btn-block mb-4">Register</form:button>


</form:form>

<jsp:include page="../include/footer.jsp"/>
