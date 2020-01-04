<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Index</title>
  <style type="text/css">
  	.fix{
  		width:600px;
  		height:600px;
  		margin-left: 200px;
  	}
  	#fix{
  		height: 450px;
  	}
  </style>
</head>
<body>
	<!-- Star Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	<!-- End Menu --> 
  <!-- Page Content -->
  <div class="container">
<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">Đăng ký</li>
    </ol>
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4" id="fix">
    <h2 style="text-align: center;">ĐĂNG KÝ</h2>
    <%
    	if(session.getAttribute("erro")!=null){
    			
    %>
    <div class="alert alert-success" role="alert">
        <%=session.getAttribute("erro") %>
     </div>
     
     <%}else{ }%>
         <form action="saveUser" method="post" class="fix" >
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Tên đăng nhập</label>
      <input type="text" class="form-control" required placeholder="Tên đăng nhập" name="username">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Email</label>
      <input type="email" class="form-control" required placeholder="Email" name="email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Mật khẩu</label>
    <input type="password" class="form-control" minlength="6" maxlength="10" required placeholder="Mật khẩu" name="password">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Nhập lại mật khẩu</label>
    <input type="password" class="form-control" minlength="4" maxlength="10" required placeholder="Nhập lại mật khẩu" name="password2">
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
