<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Xem chi tiết</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<jsp:include page="header.jsp" />
<body class="hold-transition sidebar-mini layout-fixed"
	style="text-align: center;">
	<div class=container>
		<jsp:include page="Menu.jsp"></jsp:include>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
			<li class="breadcrumb-item active">Xem chi tiết</li>
		</ol>
		<!--List Products -->

		<%-- <div class="card mb-3" style="width: 100%;">
			<div class="row no-gutters" style="background-color: #E9ECEF;">
				<div class="col-md-4">
					<img src="img/${xemchitiet.hinhAnh }" class="card-img"
						style="width: 300px; height: 300px; float: left;">
				</div>
				<div style="margin-top: 75px;">
					<div>
						<h4>${xemchitiet.tenSach}</h4>
					</div>					
					<div style="margin-right: 85px;color: #218838;">Giá:${xemchitiet.donGia} VNĐ</div>
					<p class="card-text">${xemchitiet.ghiChu }</p>
					<a href="muahang?idSach=${xemchitiet.idSach}"class="btn btn-warning" style="width: 300px;margin-top: 20px;margin-right: -105px;"><i class="fas fa-cart-arrow-down" ></i> Thêm vào giỏ</a>
				</div>
			</div>
		</div> --%>
		<div>THÔNG TIN CHI TIẾT SÁCH</div>
		<div class="card mb-3" style="max-width: 800px;">
			<div class="row no-gutters">
				<div class="col-md-4">
					<img src="img/${xemchitiet.hinhAnh }" class="card-img" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title" style="margin-left: 145px;">${xemchitiet.tenSach}</h5>

						<p class="card-text">
							<small class="text-muted">${xemchitiet.ghiChu }</small>
						</p>
						<p class="card-text" style="margin-right: 60px; color: #088c55;">Đơn
							giá: ${xemchitiet.donGia} VNĐ</p>
						<a href="muahang?idSach=${xemchitiet.idSach}"
							class="btn btn-warning"
							style="width: 300px; margin-top: 20px;"><i
							class="fas fa-cart-arrow-down"></i> Thêm vào giỏ</a>

					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
	</footer>
</body>
</html>

