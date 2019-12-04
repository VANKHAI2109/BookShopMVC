<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<body class="hold-transition sidebar-mini layout-fixed" style="text-align: center;">
	<div class=container>
		<jsp:include page="Menu.jsp"></jsp:include>
		<!--List Products -->
		<div class="card card-primary">
			<div class="card-header">
				<h3 class="card-title" >Danh sách sản phẩm</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Tên Sách</th>
							<th>Ảnh</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th colspan="2">Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Súng AK47</td>
							<td>
								<img src="../dist/img/SungAK.jpg" height="50" width="50" />
							</td>
							<td>
								<select style="width: 50px;text-align: center;">
										<option>1</option>
								</select>
							</td>
							<td>2000</td>
							<td>
								<a href="update.html"><i class="fas fa-trash-alt"></i></a>
							</td>
							<td>
								<a href="update.html"><i class="fas fa-edit"></i></a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
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

