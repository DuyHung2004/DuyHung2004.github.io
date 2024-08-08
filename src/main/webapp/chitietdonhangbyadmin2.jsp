<%@ page import="model.KhachHang" %>
<%@ page import="dal.DonHangGuestdal" %>
<%@ page import="model.DonHangGuest" %>
<%@ page import="model.Products" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/31/2024
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chitietdonhang</title>
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
        background-color: hsl(0, 0%, 94%)
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
%>
<h1>Ban chua Dang Nhap</h1>
<%
} else {
    int madonhang= Integer.parseInt(request.getParameter("madonhang"));
    DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
    DonHangGuest donHangGuest= donHangGuestdal.selectById(new DonHangGuest(madonhang));
    Products products= donHangGuest.getProducts();
%>
<div class="container mt-5">
    <div class="d-flex justify-content-center">
        <div class="card" style="width: 400px">
            <img
                    src="${pageContext.request.contextPath}/<%=products.getImage()%>"
                    class="card-img-top"
                    alt="..."
            />

            <div class="card-body pb-2">
                <p class="fw-bold text-muted small text-uppercase mb-1">
                    Ma don hang: <%=donHangGuest.getMadonhang()%>
                </p>
                <p class="fw-bold h1 mb-1"><%=donHangGuest.getSotienthanhtoan()%></p>
                <p class="text-muted mb-0"><%=donHangGuest.getProducts().getId()%></p>
            </div>

            <hr style="background-color: hsl(0, 0%, 75%)" />

            <div class="card-body d-flex justify-content-around pt-2">
                <div class="card-body d-flex justify-content-around pt-2">
                    <span><%=products.getName()%></span>
                    <span>So luong: <%=donHangGuest.getSoluong()%></span>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Dia chi Nhan Hang:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getDiachinhanhang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Khach Hang:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getHovaten()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">So dien thoai:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getSodienthoai()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Ngay dat hang:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getNgaydathang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Ngay giao hang du kien:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getNgaygiaohang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Trang Thai: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHangGuest.getTrangthai()%></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
