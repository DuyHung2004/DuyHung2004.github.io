<%@ page import="model.KhachHang" %>
<%@ page import="dal.ChiTietDonHangdal" %>
<%@ page import="model.ChiTietDonHang" %>
<%@ page import="model.Products" %>
<%@ page import="dal.DonHangdal" %>
<%@ page import="model.DonHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/31/2024
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>quanlydonhang</title>
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
    String madonhang= request.getParameter("madonhang");
    ChiTietDonHangdal chiTietDonHangdal= new ChiTietDonHangdal();
    ChiTietDonHang chiTietDonHang= chiTietDonHangdal.selectBymadonhang(madonhang);
    Products products= chiTietDonHang.getProducts();
    DonHangdal donHangdal= new DonHangdal();
    KhachHang khachHang1 = donHangdal.selectkhachhang(madonhang);
    DonHang donHang= new DonHang(madonhang);
    DonHang donHang1= donHangdal.selectById(donHang);
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
                    Ma chi tiet don hang: <%=chiTietDonHang.getMachitietdonhang()%>
                </p>
                <p class="fw-bold h1 mb-1"><%=chiTietDonHang.getTongTien()%></p>
                <p class="text-muted mb-0"><%=chiTietDonHang.getProducts().getId()%></p>
            </div>

            <hr style="background-color: hsl(0, 0%, 75%)" />

            <div class="card-body d-flex justify-content-around pt-2">
                <div class="card-body d-flex justify-content-around pt-2">
                    <span><%=products.getName()%></span>
                    <span>So luong: <%=chiTietDonHang.getSoluong()%></span>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Dia chi Nhan Hang:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=chiTietDonHang.getDiachinhanhang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Khach Hang:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=khachHang1.getHoten()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">So dien thoai:</p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=khachHang1.getSodienthoai()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Ngay Mua Hang: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHang1.getNgaydathang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Ngay Giao Hang Du Kien: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHang1.getNgaygiaohang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Trang Thai: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=donHang1.getTrangthai()%></p>
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
