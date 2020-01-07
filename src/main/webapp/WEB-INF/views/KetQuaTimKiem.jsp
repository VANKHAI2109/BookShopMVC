<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<title>Search</title>

</head>
<body>
	<!-- Star Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	<!-- End Menu -->
	<!-- Page Content -->

	<header> </header>
	<div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Home</a></li>
			<li class="breadcrumb-item active">Kết quả tìm kiếm</li>
		</ol>
		<h1 class="my-4" style="text-align: center;">Sản phẩm</h1>
		<!-- Page Features -->
		<h5>${Null}</h5>
		
		<div class="row text-center">
				<c:forEach items="${kq}" var="kq">
					<div class="col-lg-3 col-md-6 mb-4">
						<div class="card h-100">
							<a href="xemchitiet.html?idSach=${list.idSach}"><img class="card-img-top" src="img/${kq.hinhAnh}" style="width: 255px;height: 255px;"></a>
							<div class="card-body">
								<h4 class="card-title">${kq.tenSach}</h4>
							</div>
								
								<h5 class="card-title" style="color: red;	"> Giá: ${kq.donGia} VNĐ </h5>
							<div class="card-footer">
								<a href="muahang?idSach=${kq.idSach}" class="btn btn-warning"><i class="fas fa-cart-arrow-down"></i> Thêm vào giỏ</a>
							</div>
						</div>
					</div>
				</c:forEach>
			
		</div>
		
	</div>
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
		</div>
	</footer>



</body>

</html>
