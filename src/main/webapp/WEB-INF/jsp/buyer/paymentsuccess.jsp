<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="height: 50vh" class="container" id="mainContent">
    <h1 align="center" style="color: #32a336" > <c:out value="${user.firstName} "/> ,Your Payment is Successful! </h1>
</div>
<jsp:include page="../include/footer.jsp"/>