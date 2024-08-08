<%@ page import="dal.Categoriesdal" %>
<%@ page import="model.Categories" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 8/1/2024
  Time: 4:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edithangmuc</title>
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
<%
    int id= Integer.parseInt(request.getParameter("id"));
    Categoriesdal categoriesdal= new Categoriesdal();
    Categories categories= categoriesdal.selectById(new Categories(id));
%>
<div class="container mt-5">
    <div class="d-flex justify-content-center">
        <div class="card" style="width: 400px">
            <div class="card-body pb-2">
                <form action="luuhangmuc">
                <p class="fw-bold text-muted small text-uppercase mb-1">
                    ID: <%=categories.getId()%>
                </p>
                <input name="id" type="hidden" class="fw-bold text-muted small text-uppercase mb-1" value="<%=categories.getId()%>">
                <p class="text-muted mb-0">name:</p>
                <input name="name" type="text" class="text-muted mb-0" value="<%=categories.getName()%>">
                <p class="text-muted mb-0">descrip:</p>
                <input name="descrip" type="text" class="text-muted mb-0" value="<%=categories.getDescription()%>">
                <button  class="text-muted mb-0" type="submit">Luu</button>
                    <a href="xoahangmuc?id=<%=categories.getId()%>">Xoa</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
