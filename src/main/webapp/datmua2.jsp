<%@ page import="dal.Productsdal" %>
<%@ page import="model.Products" %>
<%@ page import="model.KhachHang" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DAT HANG</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="lib/slick/slick.css" rel="stylesheet">
    <link href="lib/slick/slick-theme.css" rel="stylesheet">

    <link href="css/style.css" rel="stylesheet">
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
%>
<form action="muaHang2" method="post">
    <div>
        <%
            String productId = request.getParameter("id");
            Productsdal productsdal = new Productsdal();
            Products products= new Products(productId);
            Products product = productsdal.selectById(products);
            if (product != null) {
        %>
        <input type="hidden" name="id" value="<%= productId %>">
        <%
        } else {
        %>
        <p>Sản phẩm không tồn tại.</p>
        <%
            }
        %>
        <div class="nav">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                    <a href="index.jsp" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="index.jsp" class="nav-item nav-link">Home</a>
                        </div>
                        <div class="navbar-nav ml-auto">
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <div class="product-detail">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8">
                    <div class="product-detail-top">
                        <div class="row align-items-center">
                            <div class="col-md-5">
                                <div class="product-slider-single normal-slider">
                                    <img src="<%= request.getContextPath() + "/" + product.getImage() %>" alt="Product Image">

                                </div>
                                <div class="product-slider-single-nav normal-slider">
                                    <div class="slider-nav-img"><img src="<%= request.getContextPath() + "/" + product.getImage() %>" alt="Product Image"></div>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="product-content">
                                    <div class="title"><h2><%= product.getName() %></h2></div>
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="price">
                                        <h4>Price:</h4>
                                        <p><%= product.getPrice() %> </p>
                                    </div>
                                    <div class="quantity">
                                        <h4>Quantity:</h4>
                                        <div class="qty">
                                            <input name="soluong" type="number" value="1">
                                        </div>
                                    </div>
                                    <div class="p-size">
                                        <h4>Dia CHi:</h4>
                                        <div class="btn-group btn-group-sm">
                                            <input type="text" class="form-control" id="diachi" name="diachinhanhang" required>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="hinhthucthanhtoan" class="form-label">Hinh thuc thanh toan</label>
                                        <select name="hinhthucthanhtoan" id="hinhthucthanhtoan">
                                            <option value="chuyenkhoan"> chuyen khoan</option>
                                            <option value="thanhtoankhinhanhang">thanh toan khi nhan hang</option>
                                        </select>
                                    </div>
                                    <div class="action">
                                        <button class="btn" type="submit"><i class="fa fa-shopping-cart"></i>Mua</button>
                                    </div>
                                </div>
                            </div>
                            <div id="description" class="container tab-pane active">
                                <h4>Descrition</h4>
                                <p> <%= product.getDescription() %></p>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- Side Bar End -->
            </div>
        </div>
    </div>
</form>
<%
    }
%>
</body>
</html>
