<jsp:include page="../include/header.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="h-100" style="background-color: #eee;">
    <div class="container h-100 py-5">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-10">

                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
                    <div>
                        <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">price <i
                                class="fas fa-angle-down mt-1"></i></a></p>
                    </div>
                </div>

<c:forEach items="${orderLines}" var="orderLine" varStatus="tagStatus">
                  <div class="card rounded-3 mb-4">
                    <div class="card-body p-4">
                        <div class="row d-flex justify-content-between align-items-center">
                            <div class="col-md-3 col-lg-3 col-xl-3">
                                <p class="lead fw-normal mb-2"><b>Product: </b>${orderLine.product.productName}</p>
                                <p><span class="text-muted"><b>Description:</b> ${orderLine.product.productDescription}</span>

                            </div>
                            <div class="col-md-3 col-lg-3 col-xl-3">
                                <p class="lead fw-normal mb-2"><b>Price: </b>${orderLine.product.price}</p>
                                <p><span class="text-muted"><b>Qty:</b> ${orderLine.quantity}</span>
                            </div>
                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                <h5 class="mb-0"><b>$ ${orderLine.quantity * orderLine.product.price}</b></h5>
                            </div>
                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                <a href="#!" class="text-danger"><i class="fas fa-trash fa-lg"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
</c:forEach>
                 <div class="card">
                     <div align="center">
                         <h5 class="mb-0"><b>Grand Total : $ ${order.orderTotal}</b></h5>
                     </div>
                    <div class="card-body">
                        <a type="button" class="btn btn-warning btn-block btn-lg" href="/buyer/placeOrder" >Place Your Order</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>