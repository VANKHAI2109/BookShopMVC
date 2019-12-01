<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Index</title>

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
      <li class="breadcrumb-item active">About</li>
    </ol>
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
    <h2 style="text-align: center;">ĐĂNG NHẬP</h2>
    <div class="alert alert-success" role="alert">
         ${Note}
     </div>
         <form action="xuly" method="post">
  <div class="form-group" >
    <label for="exampleInputEmail1">Email address</label>
    <input type="text" class="form-control" required="true" aria-describedby="emailHelp" placeholder="Enter email" name="name">
  </div>
  <div class="form-group" >
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" required="true" placeholder="Password" name="pass">
  </div>
  	<button type="submit" class="btn btn-primary btn-lg btn-block" style="width: 25%;margin-left: 35%">Đăng nhập</button>
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
