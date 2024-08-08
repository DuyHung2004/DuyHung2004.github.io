<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.KhachHang" %>
<%@ page import="dal.KhachHangdal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dal.DonHangdal" %>
<%@ page import="model.DonHang" %>
<%@ page import="dal.DonHangGuestdal" %>
<%@ page import="model.DonHangGuest" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/31/2024
  Time: 12:00 AM
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
<a href="admin.jsp">Trang Quan Ly</a>
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
    DonHangdal donHangdal= new DonHangdal();
    ArrayList<DonHang> donHangs=donHangdal.selectAll();
     ArrayList<DonHang>donHangs1=(ArrayList<DonHang>) request.getAttribute("donhangs");
   if (donHangs1==null){
   } else {
       donHangs.removeAll(donHangs1);
   }
    DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
    ArrayList<DonHangGuest> donHangGuests= donHangGuestdal.selectAll();
    ArrayList<DonHangGuest> donHangGuests1=(ArrayList<DonHangGuest>) request.getAttribute("donHangGuests");
        if (donHangGuests1==null){
        } else {
            donHangGuests.removeAll(donHangGuests1);
        }
    String baoloi = (String) request.getAttribute("baoloi");
    if (baoloi == null || baoloi.equals("null")) {
        baoloi = "";
    }
%>
<form action="filterOrders2" method="post">
    <label for="fromDate">From Date:</label>
    <input type="date" id="fromDate" name="fromDate" >
    <br>
    <label for="toDate">To Date:</label>
    <input type="date" id="toDate" name="toDate">
    <br>
    <label for="makhachhang">Ma Khach Hang</label>
    <input type="text" id="makhachhang" name="makhachhang">
    <input type="submit" value="Filter">
</form>
<div class="container my-5">
    <span style="color: red"><%=baoloi%></span>
    <div class="shadow-4 rounded-5 overflow-hidden">
        <table class="table align-middle mb-0 bg-white">
            <thead class="bg-light">
            <tr>
                <th>Ma Don Hang</th>
                <th>Khach Hang</th>
                <th>Trang Thai</th>
                <th>Tien Thanh Toan</th>
                <th>Chi Tiet</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="donhang" items="<%=donHangs%>">
            <tr>
                <td>
                    <div class="d-flex align-items-center">
                        <img
                                src="images/img_5.png"
                                alt=""
                                style="width: 45px; height: 45px"
                                class="rounded-circle"
                        />
                        <div class="ms-3">
                            <p class="fw-bold mb-1">${donhang.madonhang}</p>
                        </div>
                    </div>
                </td>
                <td>
                    <p class="fw-bold mb-1">${donhang.khachHang.makhachhang}</p>
                    <p class="text-muted mb-0">${donhang.khachHang.hoten}</p>
                </td>
                <td>
                    <select name="trangthai" id="trangthai" onchange="updateTrangThai(this.value, ${donhang.madonhang})">
                        <option value="xet duyet" <c:if test="${donhang.trangthai == 'xet duyet'}">selected</c:if>>xet duyet</option>
                        <option value="van chuyen" <c:if test="${donhang.trangthai == 'van chuyen'}">selected</c:if>>van chuyen</option>
                        <option value="da huy" <c:if test="${donhang.trangthai == 'da huy'}">selected</c:if>>da huy</option>
                        <option value="giao thanh cong" <c:if test="${donhang.trangthai == 'giao thanh cong'}">selected</c:if>>giao thanh cong</option>
                    </select>
                </td>
                <td>${donhang.sotienthanhtoan}</td>
                <td>
                    <a href="chitietdonhangbyadmin.jsp?madonhang=${donhang.madonhang}">Chi Tiet</a>
                </td>
            </tr>
            </c:forEach>
            <c:forEach var="donhang2" items="<%=donHangGuests%>">
                <tr>
                    <td>
                        <div class="d-flex align-items-center">
                            <img
                                    src="images/img_5.png"
                                    alt=""
                                    style="width: 45px; height: 45px"
                                    class="rounded-circle"
                            />
                            <div class="ms-3">
                                <p class="fw-bold mb-1">${donhang2.madonhang}</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p class="fw-bold mb-1">${donhang2.hovaten}</p>
                    </td>
                    <td>
                        <select name="trangthai2" id="trangthai2" onchange="updateTrangThai2(this.value, ${donhang2.madonhang})">
                            <option value="xet duyet" <c:if test="${donhang2.trangthai == 'xet duyet'}">selected</c:if>>xet duyet</option>
                            <option value="van chuyen" <c:if test="${donhang2.trangthai == 'van chuyen'}">selected</c:if>>van chuyen</option>
                            <option value="da huy" <c:if test="${donhang2.trangthai == 'da huy'}">selected</c:if>>da huy</option>
                            <option value="giao thanh cong" <c:if test="${donhang2.trangthai == 'giao thanh cong'}">selected</c:if>>giao thanh cong</option>
                        </select>
                    </td>
                    <td>${donhang2.sotienthanhtoan}</td>
                    <td>
                        <a href="chitietdonhangbyadmin2.jsp?madonhang=${donhang2.madonhang}">Chi Tiet</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%
    }
%>
</body>

<script>
    function updateTrangThai(trangthai, donHangId) {
        window.location.href = 'updateTrangThai?donHangId='+ donHangId +'&trangthai='+trangthai;
    }
    function updateTrangThai2(trangthai, donHangId) {
        window.location.href = 'updateTrangThai2?donHangId='+ donHangId +'&trangthai='+trangthai;
    }
</script>
</html>
