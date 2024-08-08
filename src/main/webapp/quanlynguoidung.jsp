<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.KhachHang" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dal.KhachHangdal" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/30/2024
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>quanlynguoidung</title>
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
    KhachHangdal khachHangdal = new KhachHangdal();
    ArrayList<KhachHang> khachHangs = khachHangdal.selectAll();
%>
<body>
<a href="admin.jsp">Trang Quan Ly</a>
<div class="container my-5">
    <div class="shadow-4 rounded-5 overflow-hidden">
        <table class="table align-middle mb-0 bg-white">
            <thead class="bg-light">
            <tr>
                <th>Ma Khach Hang</th>
                <th>Ten Dang Nhap</th>
                <th>Ho Ten & gioi tinh</th>
                <th>Ngay Sinh</th>
                <th>Trang thai </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="khachhang" items="<%=khachHangs%>">
            <tr>
                <td>
                    <div class="d-flex align-items-center">
                        <img
                                src="images/img_4.png"
                                alt=""
                                style="width: 45px; height: 45px"
                                class="rounded-circle"
                        />
                        <div class="ms-3">
                            <p class="fw-bold mb-1">${khachhang.makhachhang}</p>
                            <p class="text-muted mb-0">${khachhang.email}</p>
                        </div>
                    </div>
                </td>
                <td>
                    <p class="fw-bold mb-1">${khachhang.tendangnhap}</p>
                </td>
                <td>
                    <span class="badge badge-success rounded-pill">${khachhang.hoten}</span>
                    <p class="text-muted mb-0">${khachhang.gioitinh}</p>
                </td>
                <td>${khachhang.ngaysinh}</td>
                <td>
                    <form action="xulytrangthai">
                        <input type="hidden" name="makhachhang" value="${khachhang.makhachhang}">
                    <button type="submit" class="btn btn-link btn-sm btn-rounded">
                            ${khachhang.trangthaixacthuc}
                    </button>
                    </form>
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
</html>
