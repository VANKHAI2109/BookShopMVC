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
<style type="text/css">
.fix {
	width: 600px;
	height: 700px;
	margin-left: 200px;
}

#fix {
	height: 400px;
}
</style>
<title>Thanh toán</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<jsp:include page="header.jsp" />
<body class="hold-transition sidebar-mini layout-fixed"
	style="text-align: center;">
	<div class=container>
	<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="giohang.html">Giỏ hàng</a>
      </li>
      <li class="breadcrumb-item active">Thanh toán</li>
    </ol>
		<jsp:include page="Menu.jsp"></jsp:include>
		<header class="jumbotron my-4" id="fix">
			<h2 style="text-align: center;">Thông tin khách hàng</h2>
			<form action="dongy" method="post" class="fix">
				<div class="form-group">
					<label for="exampleInputEmail1" style="float: left;">Tên
						khách hàng</label> <input type="text" class="form-control" maxlength="15"
						pattern="^[a-zA-Z0-9_.-]*$" required aria-describedby="emailHelp"
						placeholder="Họ và tên" name="name">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" style="float: left;">Địa
						chỉ</label> <input type="text" class="form-control" maxlength="15"
						required placeholder="Địa chỉ" name="address">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" style="float: left;">Số
						điện thoại</label> <input type="text" class="form-control" maxlength="15"
						required placeholder="SĐT" name="sdt">
				</div>
				<button type="submit" class="btn btn-success btn-lg btn-block"
					style="width: 25%; margin-left: 35%">Đồng ý</button>
			</form>
		</header>
	</div>
	  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

</body>
</html>

