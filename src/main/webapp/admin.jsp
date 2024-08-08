<%@ page import="model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/30/2024
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
            rel="stylesheet"
    />
    <title>Title</title>
    <style>body {
        background-color: hsl(0, 0%, 94%)
    }
    label {
        width: 100%;
    }

    .card-input-element {
        display: none;
    }

    .card-input:hover {
        cursor: pointer;
        background-color: hsl(144, 60%, 95.9%);
        -webkit-transition: 0.5s;
        -o-transition: 0.5s;
        transition: 0.5s;
    }

    .card-input-element:checked + .card-input {
        border: 1px solid hsl(144, 100%, 35.9%);
    }</style>
</head>
<body>
<%
    Object object= session.getAttribute("khachHang");
    KhachHang khachHang= null;
    if(object!=null){
        khachHang= (KhachHang) object;
    }
    if(khachHang==null||!khachHang.getTendangnhap().equals("admin")){
%>  <%} else {
%>
<div class="container my-5">
    <div >
    <p class="h4">Trang Quan Ly</p>
    <a class="dropdown-item" href="dangxuat">Dang Xuat</a>
    </div>
    <hr class="my-5" style="background-color: hsl(0, 0%, 65%)" />
    <div class="row gx-lg-5">
        <div class="col-md-3 mb-4">
            <label for="quanlynguoidung">
                <div class="card card-input">
                    <div class="card-body">
                        <a id="quanlynguoidung" href="quanlynguoidung.jsp">Quan Ly Nguoi Dung</a>
                    </div>
                </div>
            </label>
        </div>
        <div class="col-md-3 mb-4" >
            <label for="quanlydonhang">
                <div class="card card-input">
                    <div class="card-body">
                        <a id="quanlydonhang" href="quanlydonhang.jsp">Quan Ly Don Hang</a>
                    </div>
                </div>
            </label>
        </div>
        <div class="col-md-3 mb-4">
            <label for="quanlysanpham">
                <div class="card card-input">
                    <div class="card-body">
                        <a id="quanlysanpham" href="quanlysanpham.jsp">Quan Ly San Pham</a>
                    </div>
                </div>
            </label>
        </div>
        <div class="col-md-3 mb-4">
            <label for="quanlyhangmuc">
                <div class="card card-input">
                    <div class="card-body">
                        <a id="quanlyhangmuc" href="quanlyhangmuc.jsp">Quan Ly Hang Muc</a>
                    </div>
                </div>
            </label>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
