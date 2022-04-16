<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap and fontawesome CSS -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />

    <!-- Our Custom CSS style sheet -->
    <link rel="stylesheet" href="../../../pub/css/header.css">
    <link rel="stylesheet" href="../../../pub/css/productlink.css">

</head>

<body>
<header id="header">
        <div class="navbar navbar-dark navbar-expand-lg" style="background-color: maroon">
                <a  href="">
                    <img src="../../../pub/images/logoheader.png"  alt="">
                </a>
                <button data-toggle="collapse" data-target="#navbarToggler" type="button" class="navbar-toggler"><span
                        class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarToggler">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About Us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Testimonials</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact Us</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" >Categories</a>
                            <div class="dropdown-menu">
                                <c:forEach items="${categories}" var="category" varStatus="tagStatus">
                                    <a class="dropdown-item" href="../admin/products/${category}">${category}</a>
                                </c:forEach>
                            </div>
                        </li>
                        <li class="nav-item">
                            <button style="background-color: #bc987e; font-style: italic; border: none; border-radius: 25px; color: #333; /* Dark grey */ padding: 5px 22px">Logout</button>
                        </li>
                    </ul>
                </div>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-50" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
</header>
