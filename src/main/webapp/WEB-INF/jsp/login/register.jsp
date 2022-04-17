<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="row g-3" action="registerUser" method="POST" modelAttribute="user">
    <div><h1>User Registaration Form</h1></div>
    <div class="container">
        <div class="row">
            <div class="col-10">
                <label for="fname">First Name:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="fname" name="firstname" placeholder="Enter your first name"
                            path="firstName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="lname">Last Name:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="lname" name="lastname" placeholder="Enter your last name" path="lastName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="email">Email:</label>
            </div>
            <div class="col-90">
                <form:input type="email" id="email" name="email" placeholder="it should contain @,." path="email"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="password">Password:</label>
            </div>
            <div class="col-90">
                <form:input type="password" id="password" name="password" maxlength="8" path="password"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="password">Confirm Password:</label>
            </div>
            <div class="col-90">
                <form:input type="password" id="cpassword" name="cpassword" maxlength="8" path="confirmPassword"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="mobile">Mobile:</label>
            </div>
            <div class="col-90">
                <form:input type="tel" id="mobile" name="mobile" placeholder="only 10 digits are allowed" path="phoneNumber"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="cname">Company Name:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="cname" name="companyname" placeholder="Enter your Company name" path="companyName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="uname">User Name:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="uname" name="username" placeholder="Enter your User name" path="loginId"/>
            </div>
        </div>

        <div class="row">
            <div class="col-10">
                <label for="fname">Address Line1:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="addressline1" name="addressline1" placeholder="Address Line1" path="addressLine1"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="fname">Address Line2:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="addressline2" name="addressline2" placeholder="Address Line2" path="addressLine2"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="city">City:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="city" name="city" maxlength="10" path="city"/>
            </div>
        </div>

        <div class="row">
            <div class="col-10">
                <label for="state">State:</label>
            </div>
            <div class="col-90">
                <form:input type="text" id="state" name="state" path="state"/>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="pin">Area PIN:</label>
            </div>
            <div class="col-90">
                <form:input type="number" id="pin" name="pin" maxlength="6" path="zipcode"/>
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Registered">
        </div>
    </div>
</form:form>

<jsp:include page="../include/footer.jsp"/>
