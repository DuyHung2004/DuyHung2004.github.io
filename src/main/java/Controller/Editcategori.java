package Controller;

import dal.KhachHangdal;
import dal.Productsdal;
import model.KhachHang;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/editcategori")

public class Editcategori extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/editsanpham.jsp";
        float price= (float) Double.parseDouble(request.getParameter("price"));
        String name= request.getParameter("name");
        int cid= Integer.parseInt(request.getParameter("cid"));
        String date= request.getParameter("date");
        LocalDate date1= LocalDate.parse(date);
        Date date2= Date.valueOf(date1);
        String description= request.getParameter("description");
        int soluong= Integer.parseInt(request.getParameter("soluong"));
        String id= request.getParameter("id");
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        String baoloi="";
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null||!khachHang.getTendangnhap().equals("admin")){
            baoloi+="ban chua dang nhap";
        }if (baoloi.length()>0){
        } else {
            Productsdal productsdal = new Productsdal();
            Products products = productsdal.selectById(new Products(id));
            products.setPrice(price);
            products.setName(name);
            products.setCid(cid);
            products.setDate(date2);
            products.setDescription(description);
            products.setQuantity(soluong);
            productsdal.update(products);
        }
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
