package Controller;

import dal.Categoriesdal;
import dal.KhachHangdal;
import dal.Productsdal;
import model.Categories;
import model.KhachHang;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/xulyhangmuc")
public class XuLyHangMuc extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/index.jsp";
       int cid= Integer.parseInt(request.getParameter("cid"));
        Categoriesdal categoriesdal= new Categoriesdal();
        Productsdal productsdal = new Productsdal();
        ArrayList<Products> productss = productsdal.selectcid(cid);
        request.setAttribute("productss",productss);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
