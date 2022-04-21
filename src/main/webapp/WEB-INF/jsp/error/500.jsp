<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Errror Page</h1>


<c:if test="${not empty requestUrl}">
    <p>${requestUrl}</p>
</c:if>
<h3>Stack Trace</h3>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<c:if test="${not empty stackTrace}">
    <p>${stackTrace}</p>
</c:if>
<h3>Root Cause</h3>
<c:if test="${not empty rootcause}">
    <p>${rootcause}</p>
</c:if>
<c:if test="${not empty rootTrace}">
    <p>${roottrace}</p>
</c:if>
<div style="height: 30vh">

</div>

<jsp:include page="../include/footer.jsp"/>