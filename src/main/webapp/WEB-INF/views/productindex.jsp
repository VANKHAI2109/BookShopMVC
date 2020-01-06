<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<jsp:include page="header.jsp" />
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#"><i class="fas fa-bars"></i></a></li>
			</ul>

			<!-- SEARCH FORM -->
			<form class="form-inline ml-3">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search"
						placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

		</nav>
		<!-- /. navbar -->
		<!-- Main Sidebar Container -->
		<jsp:include page="MainSidebar.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">QUẢN LÝ SẢN SÁCH</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6"></div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Thêm sách mới</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" action="xuLyThemSach" method="post" enctype="multipart/form-data">
							<div class="card-body">
								<div class="form-group">
									<label for="inputName">Tên sách</label> <input type="text"
										class="form-control" name="tensach" required
										placeholder="Nhập tên sách">
								</div>
								
								<div class="form-group">
									<label>Tac Giả</label>
									 <select class="custom-select" name="idtacgia">
										<c:forEach items="${list2}" var="list2">
											<option value="${list2.id }">${list2.tenTacGia }</option>
										</c:forEach>
									</select>								
								</div> 
																
								<div class="form-group">
									<label>Tên thể loại</label>
									 <select class="custom-select" name="idtheloai">
										<c:forEach items="${list}" var="list">
											<option value="${list.id }">${list.theLoai }</option>
										</c:forEach>
									</select>								
								</div> 

								<div class="form-group">
									<label for="inputFile">Hình ảnh</label>
									<div class="input-group">
										<div class="custom-file">
											<label>image</label>
											 <input type="file" name="image" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="inputPrice">Ghi chú</label> <input type="text"
										class="form-control" name="ghichu" required
										placeholder="Nhập ghi chú cho sách">
								</div>
								<div class="form-group">
									<label for="inputPrice">Đơn giá</label> <input type="text" required
										class="form-control" name="dongia" 
										placeholder="Giá">
								</div>
							</div>
							<!-- <div class="form-group">
                <label for="inputPrice">Ghi chú</label>
                <input type="text" class="form-control" id="inputPrice" placeholder="Ghi chú">
              </div> 
              <div class="form-group">
                <label for="inputPrice">Đơn giá</label>
                <input type="text" class="form-control" id="inputPrice" placeholder="Giá sản phẩm">
              </div>  -->
							<!-- /.card-body -->

							<div class="card-footer">
								<button type="submit" class="btn btn-primary">Thêm</button>
							</div>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->
				<!--List Products -->
				<div class="card card-primary">
			<div class="card-header">
				<h3 class="card-title" >Danh sách sản phẩm</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body" style="text-align: center;">
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Id Sách</th>
							<th>Tên Sách</th>
							<th>Tên tác giả</th>
							<th>Tên thể loại</th>
							<th>Hình ảnh</th>
							<th>Đơn giá</th>
							<th colspan="2">Chức năng</th>

						</tr>
					</thead>
					<tbody>
					<c:forEach items="${listsach}" var="listsach">
						<tr>
							<td name="id">${listsach.idSach}</td>
							<td>${listsach.tenSach}</td>
							<td>${listsach.tacGia.id}</td>
							<td>${listsach.theLoai.id}</td>
							<td><img src="img/${listsach.hinhAnh }" height="100px" width="100px" /></td>
							<td>${listsach.donGia } VNĐ</td>
							<td>
								<a href="delete?idSach=${listsach.idSach}" onclick="return confirm('Bạn có muốn xóa sách ${listsach.tenSach} này không?')" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
							</td>
							<td>
								<a href="update?idSach=${listsach.idSach}" class="btn btn-success"><i class="fas fa-edit"></i></a>
							</td>
						</tr>
					</c:forEach>
						
					</tbody>
				</table>
			</div>
			<!-- /.card-body -->
		</div>
				<!--end List Products -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<jsp:include page="footer.jsp" />
</body>
</html>

