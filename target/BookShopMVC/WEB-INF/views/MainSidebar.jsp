<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <!--Quan ly san pham -->
          <li class="nav-item has-treeview menu-open">
            <a href="../index.html" class="nav-link">
              <p>
                Dashboard
              </p>
            </a>
          </li>
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <p>
                Quản lý
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="productindex" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Quản lý sản phẩm</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="nhacungcap" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Quản lý nhà cung cấp</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="customerindex" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Quản lý khách hàng</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="quanlyphieunhap" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Quản lý phiếu nhập</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="quanlyphieuxuat" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Quản lý phiếu xuất</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <!--Quan ly san pham -->
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link">
              <p>
                Thống kê
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="thongke" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Thống kê tồn kho</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <!--Quan ly san pham -->
          <li class="nav-item has-treeview menu-open">
            <a href="account" class="nav-link">
              <p>
                Quản lý tài khoản
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="account" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Đổi mật khẩu</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="login" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Đăng xuất</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
