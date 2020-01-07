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
<title>Giỏ hàng</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<jsp:include page="header.jsp" />
<body class="hold-transition sidebar-mini layout-fixed"
	style="text-align: center;">
	<div class=container>
		<jsp:include page="Menu.jsp"></jsp:include>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Trang chủ</a>
			</li>
			<li class="breadcrumb-item active">Giỏ hàng</li>
			</ol>
			<!--List Products -->
			<div class="card card-primary">
				<c:if test="${cart == null}">
					<div>${kq}</div>
					<div class="card-header">
						<h3 class="card-title">Chưa có sản phẩm nào trong giỏ hàng</h3>
						<a href="muaHang.html">Tiếp tục mua hàng</a>
					</div>
				</c:if>
				<c:if test="${cart != null}">
					<div class="card-header">
						<h3 class="card-title">Danh sách sản phẩm</h3>

					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<div style="margin-bottom: 10px;">
							<a href="deleteShopCart.html" class="btn btn-danger"
								style="float: right; margin-top: 10px;">Xóa giỏ</a>
						</div>
						<form method="get" action="updateShopcart">
							<div>
								<button type="submit" class="btn btn-success" value="Update"
									style="margin-left: 875px; margin-bottom: 10px;">Cập
									nhật</button>
							</div>
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>id</th>
										<th>Tên sách</th>
										<th>Sách</th>
										<th>Số lượng</th>
										<th>Giá</th>
										<th>Tổng</th>
										<th>Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="sum" value="0"></c:set>
									<c:forEach var="item" items="${cart}">
										<c:set var="sum"
											value="${sum+  item.quantity* item.sach.donGia}"></c:set>
										<tr>
											<td>${item.sach.idSach}</td>
											<td>${item.sach.tenSach}</td>
											<td><img src="img/${item.sach.hinhAnh}" height="50"
												width="50" /></td>
											<td><input value="${item.quantity}" name="quantity"
												style="width: 50px; text-align: center;" /></td>
											<td>${item.sach.donGia}VNĐ</td>
											<td>${ item.quantity* item.sach.donGia}VNĐ</td>
											<td><a href="xoa?idSach=${item.sach.idSach}"
												class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
										</tr>

									</c:forEach>
								</tbody>

							</table>
						</form>
						<div style="margin-top: 20px;">
							<b><a href="index.html" style="float: left;"> <u>Tiếp tục mua hàng</u></a></b> <a href="thanhtoan.html" class="btn btn-danger"
								style="float: right;"><i class="fas fa-dollar-sign"></i>
								Thanh toán</a> <b>Tổng tiền:</b> <input type="text"
								value="${sum} VNĐ" readonly
								style="width: 150px; text-align: center;">
						</div>
					</div>
				</c:if>
				<!-- /.card-body -->
			</div>

			<!--end List Products -->
			<!-- /.content-wrapper -->

			<!-- Control Sidebar -->
			<aside class="control-sidebar control-sidebar-dark">
				<!-- Control sidebar content goes here -->
			</aside>
			<!-- /.control-sidebar -->
			<!-- ./wrapper -->

			<!-- jQuery -->
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>

