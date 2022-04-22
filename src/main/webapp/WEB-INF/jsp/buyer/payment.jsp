<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" id="mainContent">
    <h3 > Payment Total: <c:out value="${paymentTotal} "/></h3>
    <h3 > Payment Form</h3>
    <form action="/buyer/paymentSubmit" method="GET">
        <c:forEach items="${orderIds}" var="orderId" varStatus="tagStatus">
            <tr>
                <td>
                    <input type="hidden" name="orderId" value="${orderId}">
                </td>

            </tr>
        </c:forEach>
        <div class="form-outline mb-4">
            <label >
                <h6>Card Owner</h6>
            </label>
            <input type="text" name="username" placeholder="Card Owner Name"  class="form-control "/>
        </div>
        <div class="form-outline mb-4">
            <label >
                <h6>Card number</h6>
            </label>
            <input type="text" name="username" placeholder="Card Number"  class="form-control "/>
        </div>

        <div class="row mb-4">
            <div class="col justify-content-center">
                <label><span class="hidden-xs">
                                                    <h6>Expiration Date</h6>
                                                </span></label>
                <div class="input-group">
                    <input type="number" placeholder="MM" name="" class="form-control" />
                    <input type="number" placeholder="YY" name="" class="form-control" />
                </div>
            <div class="col justify-content-center">
                <label  title="Three digit CV code on the back of your card">
                    <h6>CVV <i class="fa fa-question-circle d-inline"></i></h6>
                </label> <input type="text"  class="form-control">
            </div>
        </div>
        </div>
            <button type="submit" class="btn btn-primary btn-block mb-4" id="mybutton">Confirm Payment</button>

    </form>
</div>

<jsp:include page="../include/footer.jsp" />

