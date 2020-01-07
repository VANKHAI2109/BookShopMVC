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
							<h3 class="card-title">Sửa thông tin sách</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" action="xuLySua" method="post" enctype="multipart/form-data">
							<div class="card-body">
								<div class="form-group">
									<label for="inputName">Tên sách</label> <input type="text" value="${list.tenSach }"
										class="form-control" name="tensach"
										placeholder="Nhập tên sách">
								</div>
								
								<div class="form-group">
									<label>Tac Giả</label>
									 <select class="custom-select" name="idtacgia">
									 	<c:set var="tgSach" value="${tacGia.tenTacGia}"/>
									 	<c:forEach items="${allTacGia}" var="tgia">
									 		<c:set var="tg" value="${tgia.tenTacGia}"/>
											<c:if test="${tgSach != tg}">
												<option value="${tgia.id}">${tgia.tenTacGia}</option>
											</c:if>
											<c:if test="${tgSach eq tg}">
												<option value="${tacGia.id}" selected>${tgSach}</option>
											</c:if>
										</c:forEach>	
									</select>											
								</div> 
								
								<div class="form-group">
									<label>Thể loại</label>
									 <select class="custom-select" name="idtheloai">
									 	<c:set var="tlSach" value="${theLoai.theLoai}"/>
									 	<c:forEach items="${allTheLoai}" var="thLoai">
									 		<c:set var="tl" value="${thLoai.theLoai}"/>
											<c:if test="${tlSach != tl}">
												<option value="${thLoai.id}">${thLoai.theLoai}</option>
											</c:if>
											<c:if test="${tlSach eq thLoai}">
												<option value="${thLoai.id}" selected>${tlSach}</option>
											</c:if>
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
										class="form-control" name="ghichu" value="${list.ghiChu }"
										placeholder="Giá">
								</div>
								<div class="form-group">
									<label for="inputPrice">Đơn giá</label> <input type="text"
										class="form-control" name="dongia" value="${list.donGia }"
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
								<button type="submit" class="btn btn-primary">Sửa</button>
							</div>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->
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

