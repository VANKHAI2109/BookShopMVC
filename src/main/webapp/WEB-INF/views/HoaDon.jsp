<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
			<li class="breadcrumb-item active">Đổi mật khẩu</li>
		</ol>
		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h2 style="text-align: center;">ĐỔI MẬT KHẨU</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>Tên sách</th>
						<th>Sách</th>
						<th>Số lượng</th>
						<th>Giá</th>
						<th>Tổng</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${thongtin.name}</td>
						<td></td>
						<td><img src="img/" height="50" width="50" /></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

				</tbody>

			</table>
		</header>
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