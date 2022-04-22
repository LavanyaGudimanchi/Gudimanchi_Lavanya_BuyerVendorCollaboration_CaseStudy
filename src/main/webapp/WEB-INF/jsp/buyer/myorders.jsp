<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" >
    <h2 >My Orders</h2>
    <form action="/buyer/payment" method="GET">
        <table>
            <tr>
                <th>Order Id</th>
                <th>Order Date</th>
                <th>Order Total</th>
                <th>Order Status</th>
            </tr>
            <c:forEach items="${orders}" var="order" varStatus="tagStatus">
                <tr>
                    <td>
                        <input type="checkbox" name="orderId" value="${order.id}"> &nbsp &nbsp${order.id}
                    </td>
                    <td>${order.createDate}</td>
                    <td>${order.orderTotal}</td>
                    <td>${order.status}</td>
                </tr>
            </c:forEach>
        </table>
            <button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton" >Make a Payment</button>
    </form>
</div>
<jsp:include page="../include/footer.jsp"/>