<jsp:include page="../include/header.jsp" />

<form:form modelAttribute="user" >

    Username : <form:input path="loginId"> </form:input>
    <br>
    Password : <form:input path="password"></form:input>
    <br>
    <button type="submit">Submit</button>
</form:form>


<jsp:include page="../include/footer.jsp" />