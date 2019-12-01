<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Index</title>
</head>
<body>
	<!-- Star Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	<!-- End Menu --> 
  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
    <h2 style="text-align: center;">ĐĂNG KÝ</h2>
    <div class="alert alert-success" role="alert">
         ${NOTE}
     </div>
         <form action="saveUser" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Tên đăng nhập</label>
      <input type="text" class="form-control" required="true" placeholder="Tên đăng nhập" name="username">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Email</label>
      <input type="email" class="form-control" required="true" placeholder="Email" name="email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Mật khẩu</label>
    <input type="password" class="form-control" required="true" placeholder="Mật khẩu" name="password">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Nhập lại mật khẩu</label>
    <input type="password" class="form-control" required="true" placeholder="Nhập lại mật khẩu" name="password2">
  </div>
 
  <button type="submit" class="btn btn-primary btn-lg btn-block" style="width: 25%;margin-left: 35%">Đăng ký</button>
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
