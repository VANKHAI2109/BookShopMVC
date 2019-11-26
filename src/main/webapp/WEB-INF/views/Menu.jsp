<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>BookShop</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">

<!-- all css here -->
<!-- bootstrap v3.3.6 css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate css -->
<link rel="stylesheet" href="css/animate.css">
<!-- meanmenu css -->
<link rel="stylesheet" href="css/meanmenu.min.css">
<!-- owl.carousel css -->
<link rel="stylesheet" href="css/owl.carousel.css">
<!-- font-awesome css -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- flexslider.css-->
<link rel="stylesheet" href="css/flexslider.css">
<!-- chosen.min.css-->
<link rel="stylesheet" href="css/chosen.min.css">
<!-- style css -->
<link rel="stylesheet" href="style.css">
<!-- responsive css -->
<link rel="stylesheet" href="css/responsive.css">
<!-- modernizr css -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>

</head>
<body>
	<div class="main-menu-area hidden-sm hidden-xs sticky-header-1"
		id="header-sticky">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="menu-area">
						<nav>
							<ul>
								<li class="active"><a href="index">Trang chủ<i
										class="fa fa-angle-down"></i></a></li>

								<li><a href="product-details.html">Thể loại<i
										class="fa fa-angle-down"></i></a>
									<div class="mega-menu mega-menu-2">
										<c:forEach items="${list}" var="list">
											<span> <a href="#" class="title">${list.theLoai}</a>
											</span>
									</div> 
									</c:forEach>
									</li>
								<li><a href="#">Tác giả<i class="fa fa-angle-down"></i></a>
									<div class="sub-menu sub-menu-2">
										<ul>
											<li><a href="blog.html">blog</a></li>
											<li><a href="blog-details.html">blog-details</a></li>
										</ul>
									</div></li>
								<li><a href="#">pages<i class="fa fa-angle-down"></i></a>
									<div class="sub-menu sub-menu-2">
										<ul>
											<li><a href="shop.html">shop</a></li>
											<li><a href="product-details.html">product-details</a></li>
											<li><a href="blog.html">blog</a></li>
											<li><a href="blog-details.html">blog-details</a></li>
											<li><a href="contact.html">contact</a></li>
											<li><a href="about.html">about</a></li>
											<li><a href="login.html">login</a></li>
											<li><a href="register.html">register</a></li>
											<li><a href="cart.html">cart</a></li>
											<li><a href="checkout.html">checkout</a></li>
											<li><a href="wishlist.html">wishlist</a></li>
											<li><a href="404.html">404 Page</a></li>
										</ul>
									</div></li>
							</ul>
						</nav>
					</div>
					<div class="safe-area">
						<a href="product-details.html">sales off</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/vendor/jquery-1.12.0.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- owl.carousel js -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- meanmenu js -->
	<script src="js/jquery.meanmenu.js"></script>
	<!-- wow js -->
	<script src="js/wow.min.js"></script>
	<!-- jquery.parallax-1.1.3.js -->
	<script src="js/jquery.parallax-1.1.3.js"></script>
	<!-- jquery.countdown.min.js -->
	<script src="js/jquery.countdown.min.js"></script>
	<!-- jquery.flexslider.js -->
	<script src="js/jquery.flexslider.js"></script>
	<!-- chosen.jquery.min.js -->
	<script src="js/chosen.jquery.min.js"></script>
	<!-- jquery.counterup.min.js -->
	<script src="js/jquery.counterup.min.js"></script>
	<!-- waypoints.min.js -->
	<script src="js/waypoints.min.js"></script>
	<!-- plugins js -->
	<script src="js/plugins.js"></script>
	<!-- main js -->
	<script src="js/main.js"></script>
</body>
</html>