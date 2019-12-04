<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<title>Index</title>



</head>
<body>
	<!-- Star Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	<!-- End Menu -->
	<!-- Page Content -->
	
	  <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('http://nobita.vn/stores/banners/thoi-gian-vun-vo.jpg.pagespeed.ce.i9qq3b4EeY.jpg">
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('http://nobita.vn/stores/banners/luc-xu-qc.jpg.pagespeed.ce.Fh8rmcjDRA.jpg">
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('http://nobita.vn/stores/banners/artemis.jpg.pagespeed.ce.aNxIg7rU7U.jpg">
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </header>
	<div class="container">
	<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Sản phẩm</li>
    </ol>
<h1 class="my-4" style="text-align: center;">Sản phẩm</h1>
		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach items="${list}" var="list">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top" src="img/${list.hinhAnh}" style="width: 255px;height: 255px;">
						<div class="card-body">
							<h4 class="card-title">${list.tenSach}</h4>
							Số lượng
							<select>
								<option>1</option>
								<option>1</option>
							</select>
						</div>
							
							<h5 class="card-title" style="color: red;	"> Giá: ${list.donGia} VNĐ </h5>
						<div class="card-footer">
							<a href="#" class="btn btn-primary"><i class="fas fa-cart-arrow-down"></i> Mua ngay</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>


	
</body>

</html>
