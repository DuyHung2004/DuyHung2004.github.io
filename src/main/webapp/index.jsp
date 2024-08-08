<%@ page import="model.KhachHang" %>
<%@ page import="dal.Productsdal" %>
<%@ page import="model.Products" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dal.Categoriesdal" %>
<%@ page import="model.Categories" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <style>
        .product {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
        }
        .product img {
            max-width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
<%
    Productsdal productDal = new Productsdal();
    ArrayList<Products> productList = productDal.selectAll();
    Categoriesdal categoriesdal= new Categoriesdal();
    ArrayList<Categories> categories= categoriesdal.selectAll();
    ArrayList<Products> products= (ArrayList<Products>) request.getAttribute("productss");
    if (products!=null){
        productList=products;
    }
    ArrayList<Products> products1= (ArrayList<Products>) request.getAttribute("products1");
    if (products1!=null){
        productList=products1;
    }
%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/img_3.png" alt="Bootstrap" width="100" height="100">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Trang Chủ</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Hang Muc
                    </a>
                    <ul class="dropdown-menu">
                        <c:forEach var="categori" items="<%=categories%>">
                        <li><a name="${categori.name}" class="dropdown-item" href="xulyhangmuc?cid=${categori.id}" >${categori.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <div class="d-flex" >
                <form action="xulytimkiem" method="get">
                <input name="timkiem" class="form-control me-2" type="search" placeholder="Nội dung" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Tìm Kiếm</button>
                </form>
                <%
                    Object object= session.getAttribute("khachHang");
                    KhachHang khachHang= null;
                    if(object!=null){
                        khachHang= (KhachHang) object;
                    }
                    if(khachHang==null){
                %>
                <a class="btn btn-primary" style="white-space: nowrap" href="dangky.jsp">Dang Ky</a>
                <a class="btn btn-primary" style="white-space: nowrap" href="dangnhap.jsp">Dang Nhap</a>
                <%} else {
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        KH: <%= khachHang.getHoten()%>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="donhang.jsp">Don Hang Cua Toi</a></li>
                        <li><a class="dropdown-item" href="thaydoithongtin.jsp">Thay Doi Thong Tin</a></li>
                        <li><a class="dropdown-item" href="doimatkhau.jsp">Doi Mat Khau</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="dangxuat">Dang Xuat</a></li>
                    </ul>
                </li>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</nav>
<!-- page content -->
<div class="container">
    <div class="row">

        <div class="col-lg-9">
            <div id="carouselExampleIndicators" class="carousel slide">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img width="300" height="400" src="images/img.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img width="300" height="400" src="images/img_1.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img width="300" height="400" src="images/img_2.png" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                    <a href=""></a>
                </button>
            </div>
            <div class="row">
            <c:forEach var="product" items="<%=productList%>">
                <div class="col-4 ">
                    <h3>${product.name}</h3>
                    <p>Price: ${product.price}</p>
                    <p>Quantity: ${product.quantity}</p>
                    <p>Description: ${product.description}</p>
                    <img src="${pageContext.request.contextPath}/${product.image}" alt="${product.name}" width="200" height="200"/>
                    <a class="btn btn-primary" style="white-space: nowrap"
                            <% if(khachHang == null) { %>
                       href="datmua.jsp?id=${product.id}"
                            <% } else { %>
                       href="datmua2.jsp?id=${product.id}"
                            <% } %>> Mua ngay</a>
                </div>
            </c:forEach>
        </div>
        </div>
    </div>
</div>
</body>
</html>