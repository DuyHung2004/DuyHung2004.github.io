<%@ page import="model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/29/2024
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doimatkhau</title>
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
    if(khachHang==null){
%>
<h1>Ban chua Dang Nhap</h1>
<%
} else {
    String baoloimk= request.getAttribute("baoloi")+"";
    if (baoloimk.equals("null")){
        baoloimk="";
    }
%>
<section class="vh-100" style="background-color: #eee;">
    <a class="navbar-brand" href="index.jsp">
        <img src="images/img_3.png" alt="Bootstrap" width="100" height="100">
    </a>
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="index.jsp">Trang Chủ</a>
        </li>
    </ul>
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Doi mat khau</p>

                                <form class="mx-1 mx-md-4" action="doimatkhau" method="post">
                                    <span style="color: red"><%=baoloimk%></span>
                                    <span style="color: red" id="msg"></span>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <input type="password" id="form3Example1c" class="form-control" name="matkhauhientai" />
                                            <label class="form-label" for="form3Example1c" >current password</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <input type="password" id="matkhau" class="form-control" name="matkhaumoi" />
                                            <label class="form-label" for="matkhau">A new password</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <input type="password" id="matkhaunhaplai" class="form-control" onkeyup="kiemtramatkhau()" name="matkhaunhaplai" />
                                            <label class="form-label" for="matkhaunhaplai">Repeat your password</label>
                                        </div>
                                    </div>


                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg">Save</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%
    }
%>
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
