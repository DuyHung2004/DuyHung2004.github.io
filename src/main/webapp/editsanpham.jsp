<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Products" %>
<%@ page import="dal.Productsdal" %>
<%@ page import="dal.Categoriesdal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Categories" %>
<%@ page import="model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/31/2024
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Edit</title>
    <style>
    body {
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
    String id= request.getParameter("id");
    Productsdal productsdal= new Productsdal();
    Products products= productsdal.selectById(new Products(id));
    Categoriesdal categoriesdal= new Categoriesdal();
    ArrayList<Categories> categories= categoriesdal.selectAll();
    request.setAttribute("cid",products.getCid());
%>
<div class="container mt-5">
    <div class="d-flex justify-content-center">
        <div class="card" style="width: 400px">
            <img
                    src="${pageContext.request.contextPath}/<%=products.getImage()%>"
                    class="card-img-top"
                    alt="..."
            />
            <form action="upload" method="post" enctype="multipart/form-data">
                <input type="hidden" name="idproduct" value="<%=products.getId()%>">
                <label for="file">Chọn file ảnh:</label>
                <input type="file" id="file" name="file">
                <input type="submit" value="Upload">
            </form>
            <form action="editcategori">
                <input type="hidden" name="id" value="<%=products.getId()%>">
            <div class="card-body pb-2">
                <p class="fw-bold text-muted small text-uppercase mb-1">
                    <%=products.getId()%>
                </p>
                <p>gia:</p>
                <input name="price" type="text" class="fw-bold h1 mb-1" value="<%=products.getPrice()%>"  >
                <p>name:</p>
                <input name="name" type="text" class="text-muted mb-0" value="<%=products.getName()%>" >
            </div>

            <hr style="background-color: hsl(0, 0%, 75%)" />

            <div class="card-body d-flex justify-content-around pt-2">
            <span
            >
                <p>cid:</p>
              <select name="cid" id="cid" class="me-1">
                <c:forEach var="categori" items="<%=categories%>">
                  <option ${categori.id == cid ? 'selected' : ''} value="${categori.id}"  >${categori.name}</option>
                </c:forEach>
              </select>
                </span>
                <span><i class="fas fa-bath me-2 text-muted"></i>
                    <p>date</p>
                <input name="date" type="date" lass="me-1" value="<%=products.getDate()%>">
                </span>
            </div>
            <div class="card-body bg-light">
                <p>So luong:</p>
                <input name="soluong" type="text" class="text-uppercase text-muted small fw-bold" value="<%=products.getQuantity()%>">

            </div>
            <div class="card-body bg-light">
                <p>Description:</p>
                <input name="description" type="text" class="text-uppercase text-muted small fw-bold" value="<%=products.getDescription()%>">
            </div>
                <button type="submit">Luu</button>
                <div class="card-body bg-light">
                    <a  href="xoasanpham?id=<%=products.getId()%>"> Xoa San Pham</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
