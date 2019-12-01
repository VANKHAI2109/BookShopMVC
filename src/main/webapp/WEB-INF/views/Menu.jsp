<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">	
	
	  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">
  
  <link href="style.css" rel="stylesheet">
  <link href="update.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" id="color" href="index">Trang chủ
					</a></li>
					<li class="nav-item"><a class="nav-link" id="color" href="#">Sản phẩm</a></li>
					
					<li class="nav-item dropdown" >
					    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" id="color">Thể loại</a>
					    <div class="dropdown-menu">
					    <c:forEach items="${list2}" var="list2">
					    	<a class="dropdown-item" href="#">${list2.theLoai}</a>
					    </c:forEach>
					      
					    </div>
					  </li>
					<li class="nav-item"><a class="nav-link" id="color" href="diachi">Địa chỉ</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" style="margin-right: 90px;">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Nhập tên sản phẩm..." aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
				</form>
				<ul class="nav justify-content-end">
					<%
						if (session.getAttribute("user") != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="#" ><i class="fas fa-shopping-cart"></i>   Giỏ hàng</a>
					
					<li class="nav-item"><a class="nav-link" href="thongtinuser"><i class="fas fa-user-alt"></i>  <%=session.getAttribute("user")%></a>
					
					<li class="nav-item"><a class="nav-link" href="login"><i class="fas fa-sign-out-alt"></i>  Đăng xuất</a>
					 <%
 						} else {					
					 %>
					 <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i>   Giỏ hàng</a>
					<li class="nav-item"><a class="nav-link" href="login"><i class="fas fa-sign-in-alt"></i>  Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="register"><i class="fas fa-registered"></i>  Đăng ký</a>
					 <%
 						}
						%>
				</ul>
			</div>
		</div>
	</nav>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>