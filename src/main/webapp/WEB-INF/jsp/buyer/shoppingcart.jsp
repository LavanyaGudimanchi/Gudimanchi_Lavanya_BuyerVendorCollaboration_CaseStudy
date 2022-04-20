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
                                <p><span class="text-muted"><b>Description:</b> ${orderLine.product.productName}</span>
                            </div>
                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                <button class="btn btn-link px-2"
                                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                    <i class="fas fa-minus"></i>
                                </button>

                                <input id="form1" min="0" name="quantity" value="${orderLine.quantity}" type="number"
                                       class="form-control form-control-sm" > </input>

                                <button class="btn btn-link px-2"
                                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                    <i class="fas fa-plus"></i>
                                </button>
                            </div>
                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                <h5 class="mb-0"><b>$ ${orderLine.product.price}</b></h5>
                            </div>
                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                <a href="#!" class="text-danger"><i class="fas fa-trash fa-lg"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
</c:forEach>
                 <div class="card">
                    <div class="card-body">
                        <button type="button" class="btn btn-warning btn-block btn-lg">Place Your Order</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>