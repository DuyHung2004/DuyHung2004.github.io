<%@ page import="model.KhachHang" %>
<%@ page import="dal.ChiTietDonHangdal" %>
<%@ page import="model.ChiTietDonHang" %>
<%@ page import="model.Products" %>
<%@ page import="dal.DonHangdal" %>
<%@ page import="model.DonHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/30/2024
  Time: 2:40 PM
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
    <title>Chi tiet don hang</title>
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
    if(khachHang==null){
%>
<h1>Ban chua Dang Nhap</h1>
<%
} else {
    String baoloi= request.getAttribute("baoloi")+"";
    String madonhang= request.getParameter("madonhang");
    DonHangdal donHangdal= new DonHangdal();
    DonHang donHang= new DonHang(madonhang);
    DonHang donHang1= donHangdal.selectById(donHang);
    ChiTietDonHangdal chiTietDonHangdal= new ChiTietDonHangdal();
    ChiTietDonHang chiTietDonHang= chiTietDonHangdal.selectBymadonhang(madonhang);
    Products products= chiTietDonHang.getProducts();
%>

<form action="huydonhang">
    <input type="hidden" value="<%=madonhang%>" name="madonhang">
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
                <p class="fw-bold h1 mb-1">Thanh Toan: <%=chiTietDonHang.getTongTien()%></p>
                <p class="text-muted mb-0">ID: <%=chiTietDonHang.getProducts().getId()%></p>
            </div>

            <hr style="background-color: hsl(0, 0%, 75%)" />

            <div class="card-body d-flex justify-content-around pt-2">
                <span><%=products.getName()%></span>
                <span>So luong: <%=chiTietDonHang.getSoluong()%></span>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Dia chi Nhan Hang: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=chiTietDonHang.getDiachinhanhang()%></p>
                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold">Khach Hang: </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <p class="fw-bold mb-1"><%=khachHang.getHoten()%></p>
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
                        <p style="color: <%= donHang1.getTrangthai().equals("da huy") ? "red" : "chartreuse" %>;" class="fw-bold mb-1">
                            <%= donHang1.getTrangthai() %>
                        </p>

                    </div>
                </div>
            </div>
            <div class="card-body bg-light">
                <p class="text-uppercase text-muted small fw-bold"> </p>
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1 ms-3">
                        <%
                            if (donHang1.getTrangthai().equals("xet duyet")){
                        %>
                        <button type="submit">Huy Don Hang</button>
                        <%
                            }
                        %>
                        <%
                            if (donHang1.getTrangthai().equals("da huy")){
                        %>
                        <a href="datmua2.jsp?id=<%=products.getId()%>">DAT LAI</a>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<%
    }
%>

</body>
</html>
