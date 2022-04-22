<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form style="margin: auto; width: 400px; margin-top: 5rem;" action="/login/loginSubmit" method="POST">
<h2 align="center">Login</h2>
    <c:if test="${param.error != null}">
        <div style="color:red;">
            Invalid username and password.
        </div>
    </c:if>
    <!-- Email input -->
      <div class="form-outline mb-4">
      <input type="username" id="form2Example1" class="form-control" name="username" value="${username}"/>
      <label class="form-label" for="form2Example1" >Login Id</label>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
      <input type="password" id="form2Example2" class="form-control" name="password" value="${password}" />
      <label class="form-label" for="form2Example2">Password</label>
    </div>

    <!-- 2 column grid layout for inline styling -->
    <div class="row mb-4">
      <div class="col d-flex justify-content-center">
        <!-- Checkbox -->
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
          <label class="form-check-label" for="form2Example31"> Remember me </label>
        </div>
      </div>

      <div class="col">
        <!-- Simple link -->
        <a href="#!">Forgot password?</a>
      </div>
    </div>

    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton">Sign in</button>


  </form>

<jsp:include page="../include/footer.jsp" />