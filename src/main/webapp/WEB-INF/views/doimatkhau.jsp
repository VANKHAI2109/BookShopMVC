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
      <li class="breadcrumb-item">
        <a href="index.html">Trang chủ</a>
      </li>
      <li class="breadcrumb-item active">Đổi mật khẩu</li>
    </ol>
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
    <h2 style="text-align: center;">ĐỔI MẬT KHẨU</h2>
    <div class="alert alert-success" role="alert">
         ${Note}
     </div>
         <form action="xuly" method="post">
  <div class="form-group" >
    <label for="exampleInputEmail1">Mật khẩu hiện tại</label>
    <input type="text" class="form-control" required="true" aria-describedby="emailHelp" placeholder="Nhập mật khẩu" name="matkhauhientai">
  </div>
  <div class="form-group" >
    <label for="exampleInputPassword1">Mật khẩu mới</label>
    <input type="password" class="form-control" required="true" placeholder="Nhập mật khấu mới" name="matkhaumoi">
  </div>
  <div class="form-group" >
    <label for="exampleInputPassword1">Nhập lại mật khẩu</label>
    <input type="password" class="form-control" required="true" placeholder="Nhập lại mật khẩu" name="nhaplaimatkhau">
  </div>
  	<button type="submit" class="btn btn-primary btn-lg btn-block" style="width: 25%;margin-left: 35%">Đồng ý</button>
</form>
    </header>
  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>
	
</body>
</html>