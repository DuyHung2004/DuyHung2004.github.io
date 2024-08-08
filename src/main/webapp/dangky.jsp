<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 6/3/2024
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dang Ky</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <style>
        .red {
            color: red;
        }
    </style>
</head>
<body>
<%
    String baoloi= (request.getAttribute("baoloi")+"");
    baoloi= (baoloi.equals("null"))?"":baoloi;
    String tendangnhap=(request.getAttribute("tendangnhap")+"");
    tendangnhap=(tendangnhap.equals("null")?"":tendangnhap);
    String hovaten=(request.getAttribute("hovaten")+"");
    hovaten=(hovaten.equals("null")?"":hovaten);
    String gioitinh=(request.getAttribute("gioitinh")+"");
    gioitinh=(gioitinh.equals("null")?"":gioitinh);
    String ngaysinh=(request.getAttribute("ngaysinh")+"");
    ngaysinh=(ngaysinh.equals("null")?"":ngaysinh);
    String diachi=(request.getAttribute("diachi")+"");
    diachi=(diachi.equals("null")?"":diachi);
    String sodienthoai=(request.getAttribute("spdienthoai")+"");
    sodienthoai=(diachi.equals("null")?"":sodienthoai);
    String email=(request.getAttribute("email")+"");
    email=(diachi.equals("null")?"":email);
%>
<div class="container">
    <div class="text-center"><h1>Dang Ky Tai Khoan</h1></div>
    <div class="red" id="baoloi">
        <%=
        baoloi
        %>
    </div>
<form class="form" action="dangky" method="post">
    <h3>Tai Khoan</h3>
    <div class="mb-3">
        <label for="tendangnhap" class="form-label">Ten Dang Nhap<span class="red">*</span></label>
        <input type="text" class="form-control" id="tendangnhap" name="tendangnhap" required="required" value="<%=tendangnhap %>">
    </div>
    <div class="mb-3">
        <label for="matkhau" class="form-label">Mat Khau<span class="red">*</span></label>
        <input type="password" class="form-control" id="matkhau" name="matkhau" required="required">
    </div>
    <div class="mb-3">
        <label for="matkhaunhaplai" class="form-label">Nhap Lai Mat Khau<span class="red">*</span><span style="color: red" id="msg"></span></label>
        <input type="password" class="form-control" id="matkhaunhaplai" name="matkhaunhaplai" required="required" onkeyup="kiemtramatkhau()">
    </div>
    <h3>Thong Tin Khach Hang</h3>
    <div class="mb-3">
        <label for="hovaten" class="form-label">Ho va Ten</label>
        <input type="text" class="form-control" id="hovaten" name="hovaten" required="required" value="<%=hovaten %>">
    </div>
    <div class="mb-3">
        <label for="gioitinh" class="form-label">Gioi tinh</label>
        <select name="gioitinh" id="gioitinh">
            <option value="Nam">Nam</option>
            <option value="Nu">Nu</option>
            <option value="khac">khac</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="ngaysinh" class="form-label">Ngay Sinh</label>
        <input type="date" class="form-control" id="ngaysinh" name="ngaysinh" required="required" value="<%=ngaysinh%>">
    </div>
    <div class="mb-3">
        <label for="diachi" class="form-label">dia chi</label>
        <input type="text" class="form-control" id="diachi" name="diachi" value="<%=diachi%>">
    </div>
    <div class="mb-3">
        <label for="sodienthoai" class="form-label">So Dien Thoai</label>
        <input type="tel" class="form-control" id="sodienthoai" name="sodienthoai" required="required" value="<%=sodienthoai%>">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" value="<%=email%>">
    </div>
    <input class="btn btn-primary" type="submit" value="Dang Ky" name="submit" id="submit" >
</form>
</div>
</body>
<script>
     function kiemtramatkhau(){
         matkhau= document.getElementById("matkhau").value;
         matkhaunhaplai= document.getElementById("matkhaunhaplai").value;
         if(matkhau!=matkhaunhaplai){
             document.getElementById("msg").innerText="Mat khau khong khop";
             return false;
         } else {
             document.getElementById("msg").innerText="";
             return true;
         }
     }
</script>
</html>
