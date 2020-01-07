<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<style type="text/css">

	table{
	
		margin-left: 50px;
		margin-top:25px;
		font-size: 18;
	}
	.range{

		float:left;
	}
	
	.range1{
		
		text-align: left;
	}

	h5{
		font-weight: bold;
		text-transform: uppercase;
		margin-bottom: 29px;
		margin-left: 60px;
	}
</style>
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

		<div><h5 style="font-family: 'Roboto',sans-serif !important;margin-right: 100px;">THÔNG TIN CHI TIẾT SÁCH<h5></h5></div>
		<div class="card mb-3" style="max-width: 800px;">
			<div class="row no-gutters">
				<div class="col-md-4">
					<img src="img/${xemchitiet.hinhAnh }" class="card-img" alt="...">
				</div>
				
				<div class="col-md-8">
					
					<table>
						<tr>
							<td colspan="2"><h5><b>${xemchitiet.tenSach}</b></h5></td>
						</tr>
						<tr>
							<td class="range">Tác giả:</td>
							<td class="range1">${tacGia.tenTacGia}</td>
						</tr>
						<tr>
							<td class="range">Thể loại:</td>
							<td class="range1">${theloai.theLoai}</td>
						</tr>
						<tr>
							<td colspan="2"><small class="text-muted">${xemchitiet.ghiChu }</small></td>
						</tr>
						<tr>
							<td class="range">Giá: </td>
							<td class="range1"><u><b>${xemchitiet.donGia} VNĐ</b></u></td>
						</tr>
						<tr>
							<td colspan="2"><a href="muahang?idSach=${xemchitiet.idSach}"
							class="btn btn-warning"
							style="width: 300px; margin-top: 20px;"><i
							class="fas fa-cart-arrow-down"></i> Thêm vào giỏ</a></td>
						</tr>
					</table>
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

