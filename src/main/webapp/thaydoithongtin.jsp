<%@ page import="model.KhachHang" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/30/2024
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>thaydoithongtin</title>
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
    <style>.card-registration .select-input.form-control [readonly]:not([disabled]) {
        font-size: 1rem;
        line-height: 2.15;
        padding-left: .75em;
        padding-right: .75em;
    }
    .card-registration .select-arrow {
        top: 13px;
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
    if (baoloi.equals("null")){
        baoloi="";
    }
    String gioitinh= khachHang.getGioitinh();
%>
<section class="h-100 bg-dark">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                        </div>
                        <div class="col-xl-6">
                            <form action="thaydoithongtin" method="get">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase">THAY DOI THONG TIN</h3>
                                <span><%=baoloi%></span>
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="text" id="form3Example1m" class="form-control form-control-lg" name="hoten" value="<%=khachHang.getHoten()%>" />
                                            <label class="form-label" for="form3Example1m">Ho Ten</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="text" id="form3Example1n" class="form-control form-control-lg" name="diachi" value="<%=khachHang.getDiachi()%>"/>
                                            <label class="form-label" for="form3Example1n">Dia Chi</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="date" id="form3Example1m1" class="form-control form-control-lg" name="ngaysinh" value="<%=khachHang.getNgaysinh()%>" />
                                            <label class="form-label" for="form3Example1m1">Ngay Sinh</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="text" id="form3Example1n1" class="form-control form-control-lg" name="sodienthoai" value="<%=khachHang.getSodienthoai()%>" />
                                            <label class="form-label" for="form3Example1n1">So dien thoai</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-md-flex justify-content-start align-items-center mb-4 py-2" >

                                    <h6 class="mb-0 me-4">Gioi tinh: </h6>


                                    <div class="col-md-6 mb-4">
                                        <select data-mdb-select-init name="gioitinh" >
                                            <option value="nam" <%= "nam".equals(gioitinh) ? "selected" : "" %>>nam</option>
                                            <option value="nu" <%= "nu".equals(gioitinh) ? "selected" : "" %>>nu</option>
                                            <option value="khac" <%= "khac".equals(gioitinh) ? "selected" : "" %>>khác</option>
                                        </select>

                                    </div>
                                </div>
                                <div class="d-flex justify-content-end pt-3">
                                    <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-warning btn-lg ms-2">Submit</button>
                                </div>
                            </div>
                            </form>
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
</html>
