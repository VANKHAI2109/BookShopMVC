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
<title>AdminLTE 3</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<jsp:include page="header.jsp" />
<body class="hold-transition sidebar-mini layout-fixed"
	style="text-align: center;">
	<div class=container>
		<jsp:include page="Menu.jsp"></jsp:include>
		<!--List Products -->
		<div class="card card-primary">
			<c:if test="${cart == null}">
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

					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>id</th>
								<th>Tên sách</th>
								<th>Sách</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<th>Tổng</th>
								<th colspan="2">Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="sum" value="0"></c:set>
							<c:forEach var="item" items="${cart}">
							<c:set var="sum" value="${sum+  item.quantity* item.sach.donGia}"></c:set>
								<tr>
									<td>${item.sach.idSach}</td>
									<td>${item.sach.tenSach}</td>
									<td><img src="img/${item.sach.hinhAnh}" height="50"
										width="50" /></td>
									<td><input value="${item.quantity}" /></td>
									<td>${item.sach.donGia}</td>
									<td>${ item.quantity* item.sach.donGia}</td>
									<td><a href="xoa?idSach=${item.sach.idSach}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a href="update.html"><i class="fas fa-edit"></i></a>
									</td>
								</tr>
								
							</c:forEach>
						</tbody>
						<tbody>
							<tr>
								<td>${sum}</td>
								<td></td>
								<td><a href="deleteShopCart.html">Xóa giỏ hàng</a></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>

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

