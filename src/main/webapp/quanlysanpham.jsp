<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.KhachHang" %>
<%@ page import="model.Products" %>
<%@ page import="dal.Productsdal" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/31/2024
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>quanlysanpham</title>
    <style>body {
        background-color: hsl(0, 0%, 94%)
    }</style>
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
<%} else {
    Productsdal productsdal= new Productsdal();
    ArrayList<Products> products= productsdal.selectAll();
%>
    <a href="admin.jsp">Trang Quan Ly</a>
    <div class="container my-5">
        <div class="shadow-4 rounded-5 overflow-hidden">
            <table class="table align-middle mb-0 bg-white">
                <thead class="bg-light">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>ReleaseDate</th>
                    <th>Category</th>
                    <th>View&Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="<%=products%>">
                <tr>
                    <td>
                        <div class="d-flex align-items-center">
                            <img
                                    src="${pageContext.request.contextPath}/${product.image}"
                                    alt=""
                                    style="width: 45px; height: 45px"
                                    class="rounded-circle"
                            />
                            <div class="ms-3">
                                <p class="fw-bold mb-1">${product.id}</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p class="fw-bold mb-1">${product.name}</p>
                    </td>
                    <td>
                        <span class="badge badge-success rounded-pill">${product.price}</span>
                    </td>
                    <td>${product.date}</td>
                    <td>${product.cid}</td>
                    <td>
                        <a href="editsanpham.jsp?id=${product.id}" class="btn btn-link btn-sm btn-rounded">View&Edit</a>
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
