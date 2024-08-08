<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.KhachHang" %>
<%@ page import="dal.DonHangdal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DonHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/30/2024
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <style>body {
        background-color: hsl(0, 0%, 80%)
    }</style>
</head>
<body>
<%
    Object object= session.getAttribute("khachHang");
    KhachHang khachHang= null;
    if(object!=null){
        khachHang= (KhachHang) object;
    }
    if(khachHang==null){
%>
<h1>Ban chua Dang Nhap</h1>
<%
} else {
    String baoloi= request.getAttribute("baoloi")+"";
    DonHangdal donHangdal= new DonHangdal();
    ArrayList<DonHang> donHangs= (ArrayList<DonHang>) request.getAttribute("donhangs");
    if (donHangs==null){
         donHangs= donHangdal.selectAllbyid(khachHang.getMakhachhang());
    }
%>
<form action="filterOrders" method="post">
    <label for="fromDate">From Date:</label>
    <input type="date" id="fromDate" name="fromDate" >
    <br>
    <label for="toDate">To Date:</label>
    <input type="date" id="toDate" name="toDate">
    <br>
    <input type="submit" value="Filter">
</form>

<c:forEach var="donhang" items="<%=donHangs%>">
<div class="container-fluid my-5">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded-5" style="margin-top: 220px">
        <!-- Container wrapper -->
        <div class="container-fluid  d-flex align-items-center">
            <!-- Navbar brand -->
            <a class="navbar-brand me-2" href="https://mdbgo.com/">
                <img
                        src="https://easy-data.mdbgo.io/img/logo.png"
                        height="27"
                        alt=""
                        loading="lazy"
                        style="margin-top: -1px"
                />
            </a>

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link mt-1" href="#"><strong>Ma Don Hang:</strong><u>${donhang.madonhang}</u></a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <button type="button" class="btn btn-link px-3 me-1">
                        ${donhang.trangthai}
                </button>
                <button type="button" class="btn btn-link px-3 me-1">
                        ${donhang.hinhthucthanhtoan}
                </button>
                <button type="button" class="btn btn-link px-3 me-1">
                        ${donhang.sotienthanhtoan}
                </button>
                <button type="button" class="btn btn-link px-3 me-1">
                        ${donhang.ngaydathang}
                </button>
                <button type="button" class="btn btn-link px-3 me-1">
                        ${donhang.ngaygiaohang}
                </button>

                <a href="chitietdonhang.jsp?madonhang=${donhang.madonhang}">Chi Tiet</a>

            </div>

            <!-- Collapsible wrapper -->
        </div>
        <!-- Container wrapper -->
    </nav>
</div>
</c:forEach>
<%
    }
%>
</body>
</html>
