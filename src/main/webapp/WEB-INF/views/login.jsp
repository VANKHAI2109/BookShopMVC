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
	<style type="text/css">
  	.fix{
  		width:600px;
  		height:600px;
  		margin-left: 200px;
  	}
  	#fix{
  		height: 400px;
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
      <li class="breadcrumb-item active">Đăng nhập</li>
    </ol>
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4" id="fix">
    <h2 style="text-align: center;">ĐĂNG NHẬP</h2>
    <%
    	if(session.getAttribute("erro")!=null){
    			
    %>
    <div class="alert alert-success" role="alert">
        <%=session.getAttribute("erro") %>
     </div>
     
     <%}else{ }%>
         <form action="xuly" method="post" class="fix">
  <div class="form-group" >
    <label for="exampleInputEmail1">Tên đăng nhập</label>
    <input type="text" class="form-control" maxlength="15" pattern="^[a-zA-Z0-9_.-]*$"  required aria-describedby="emailHelp" placeholder="Nhập tên đăng nhập" name="name">
  </div>
  <div class="form-group" >
    <label for="exampleInputPassword1">Mật khẩu</label>
    <input type="password" class="form-control" maxlength="15" required placeholder="Nhập mật khẩu" name="pass">
  </div>
  	<button type="submit" class="btn btn-success btn-lg btn-block" style="width: 25%;margin-left: 35%">Đăng nhập</button>
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
